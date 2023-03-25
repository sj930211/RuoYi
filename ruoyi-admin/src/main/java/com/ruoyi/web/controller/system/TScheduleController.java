package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TSchedule;
import com.ruoyi.system.service.ITScheduleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 计划进度Controller
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
@Controller
@RequestMapping("/system/schedule")
public class TScheduleController extends BaseController
{
    private String prefix = "system/schedule";

    @Autowired
    private ITScheduleService tScheduleService;

    @RequiresPermissions("system:schedule:view")
    @GetMapping()
    public String schedule()
    {
        return prefix + "/schedule";
    }

    /**
     * 查询计划进度列表
     */
    @RequiresPermissions("system:schedule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TSchedule tSchedule)
    {
        startPage();
        List<TSchedule> list = tScheduleService.selectTScheduleList(tSchedule);
        return getDataTable(list);
    }

    /**
     * 导出计划进度列表
     */
    @RequiresPermissions("system:schedule:export")
    @Log(title = "计划进度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TSchedule tSchedule)
    {
        List<TSchedule> list = tScheduleService.selectTScheduleList(tSchedule);
        ExcelUtil<TSchedule> util = new ExcelUtil<TSchedule>(TSchedule.class);
        return util.exportExcel(list, "计划进度数据");
    }

    /**
     * 新增计划进度
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存计划进度
     */
    @RequiresPermissions("system:schedule:add")
    @Log(title = "计划进度", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TSchedule tSchedule)
    {
        return toAjax(tScheduleService.insertTSchedule(tSchedule));
    }

    /**
     * 修改计划进度
     */
    @RequiresPermissions("system:schedule:edit")
    @GetMapping("/edit/{scheduleId}")
    public String edit(@PathVariable("scheduleId") String scheduleId, ModelMap mmap)
    {
        TSchedule tSchedule = tScheduleService.selectTScheduleByScheduleId(scheduleId);
        mmap.put("tSchedule", tSchedule);
        return prefix + "/edit";
    }

    /**
     * 修改保存计划进度
     */
    @RequiresPermissions("system:schedule:edit")
    @Log(title = "计划进度", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSchedule tSchedule)
    {
        return toAjax(tScheduleService.updateTSchedule(tSchedule));
    }

    /**
     * 删除计划进度
     */
    @RequiresPermissions("system:schedule:remove")
    @Log(title = "计划进度", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tScheduleService.deleteTScheduleByScheduleIds(ids));
    }
}
