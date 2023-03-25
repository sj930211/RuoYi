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
import com.ruoyi.system.domain.TQuality;
import com.ruoyi.system.service.ITQualityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 质量管理Controller
 *
 * @author ruoyi
 * @date 2023-03-23
 */
@Controller
@RequestMapping("/system/quality")
public class TQualityController extends BaseController
{
    private String prefix = "system/quality";

    @Autowired
    private ITQualityService tQualityService;

    @RequiresPermissions("system:quality:view")
    @GetMapping()
    public String quality()
    {
        return prefix + "/quality";
    }

    /**
     * 查询质量管理列表
     */
    @RequiresPermissions("system:quality:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TQuality tQuality)
    {
        startPage();
        List<TQuality> list = tQualityService.selectTQualityList(tQuality);
        return getDataTable(list);
    }

    /**
     * 导出质量管理列表
     */
    @RequiresPermissions("system:quality:export")
    @Log(title = "质量管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TQuality tQuality)
    {
        List<TQuality> list = tQualityService.selectTQualityList(tQuality);
        ExcelUtil<TQuality> util = new ExcelUtil<TQuality>(TQuality.class);
        return util.exportExcel(list, "质量管理数据");
    }

    /**
     * 新增质量管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存质量管理
     */
    @RequiresPermissions("system:quality:add")
    @Log(title = "质量管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TQuality tQuality)
    {
        return toAjax(tQualityService.insertTQuality(tQuality));
    }

    /**
     * 修改质量管理
     */
    @RequiresPermissions("system:quality:edit")
    @GetMapping("/edit/{qualityId}")
    public String edit(@PathVariable("qualityId") String qualityId, ModelMap mmap)
    {
        TQuality tQuality = tQualityService.selectTQualityByQualityId(qualityId);
        mmap.put("tQuality", tQuality);
        return prefix + "/edit";
    }

    /**
     * 修改保存质量管理
     */
    @RequiresPermissions("system:quality:edit")
    @Log(title = "质量管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TQuality tQuality)
    {
        return toAjax(tQualityService.updateTQuality(tQuality));
    }

    /**
     * 删除质量管理
     */
    @RequiresPermissions("system:quality:remove")
    @Log(title = "质量管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tQualityService.deleteTQualityByQualityIds(ids));
    }
}
