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
import com.ruoyi.system.domain.TChange;
import com.ruoyi.system.service.ITChangeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 变更管理Controller
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
@Controller
@RequestMapping("/system/change")
public class TChangeController extends BaseController
{
    private String prefix = "system/change";

    @Autowired
    private ITChangeService tChangeService;

    @RequiresPermissions("system:change:view")
    @GetMapping()
    public String change()
    {
        return prefix + "/change";
    }

    /**
     * 查询变更管理列表
     */
    @RequiresPermissions("system:change:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TChange tChange)
    {
        startPage();
        List<TChange> list = tChangeService.selectTChangeList(tChange);
        return getDataTable(list);
    }

    /**
     * 导出变更管理列表
     */
    @RequiresPermissions("system:change:export")
    @Log(title = "变更管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TChange tChange)
    {
        List<TChange> list = tChangeService.selectTChangeList(tChange);
        ExcelUtil<TChange> util = new ExcelUtil<TChange>(TChange.class);
        return util.exportExcel(list, "变更管理数据");
    }

    /**
     * 新增变更管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存变更管理
     */
    @RequiresPermissions("system:change:add")
    @Log(title = "变更管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TChange tChange)
    {
        return toAjax(tChangeService.insertTChange(tChange));
    }

    /**
     * 修改变更管理
     */
    @RequiresPermissions("system:change:edit")
    @GetMapping("/edit/{changeId}")
    public String edit(@PathVariable("changeId") String changeId, ModelMap mmap)
    {
        TChange tChange = tChangeService.selectTChangeByChangeId(changeId);
        mmap.put("tChange", tChange);
        return prefix + "/edit";
    }

    /**
     * 修改保存变更管理
     */
    @RequiresPermissions("system:change:edit")
    @Log(title = "变更管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TChange tChange)
    {
        return toAjax(tChangeService.updateTChange(tChange));
    }

    /**
     * 删除变更管理
     */
    @RequiresPermissions("system:change:remove")
    @Log(title = "变更管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tChangeService.deleteTChangeByChangeIds(ids));
    }
}
