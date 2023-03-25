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
import com.ruoyi.system.domain.TContract;
import com.ruoyi.system.service.ITContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同管理Controller
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
@Controller
@RequestMapping("/system/contract")
public class TContractController extends BaseController
{
    private String prefix = "system/contract";

    @Autowired
    private ITContractService tContractService;

    @RequiresPermissions("system:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }

    /**
     * 查询合同管理列表
     */
    @RequiresPermissions("system:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TContract tContract)
    {
        startPage();
        List<TContract> list = tContractService.selectTContractList(tContract);
        return getDataTable(list);
    }

    /**
     * 导出合同管理列表
     */
    @RequiresPermissions("system:contract:export")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TContract tContract)
    {
        List<TContract> list = tContractService.selectTContractList(tContract);
        ExcelUtil<TContract> util = new ExcelUtil<TContract>(TContract.class);
        return util.exportExcel(list, "合同管理数据");
    }

    /**
     * 新增合同管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存合同管理
     */
    @RequiresPermissions("system:contract:add")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TContract tContract)
    {
        return toAjax(tContractService.insertTContract(tContract));
    }

    /**
     * 修改合同管理
     */
    @RequiresPermissions("system:contract:edit")
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") String contractId, ModelMap mmap)
    {
        TContract tContract = tContractService.selectTContractByContractId(contractId);
        mmap.put("tContract", tContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存合同管理
     */
    @RequiresPermissions("system:contract:edit")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TContract tContract)
    {
        return toAjax(tContractService.updateTContract(tContract));
    }

    /**
     * 删除合同管理
     */
    @RequiresPermissions("system:contract:remove")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tContractService.deleteTContractByContractIds(ids));
    }
}
