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
import com.ruoyi.system.domain.TPayment;
import com.ruoyi.system.service.ITPaymentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 计量支付Controller
 *
 * @author ruoyi
 * @date 2023-03-23
 */
@Controller
@RequestMapping("/system/payment")
public class TPaymentController extends BaseController
{
    private String prefix = "system/payment";

    @Autowired
    private ITPaymentService tPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询计量支付列表
     */
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPayment tPayment)
    {
        startPage();
        List<TPayment> list = tPaymentService.selectTPaymentList(tPayment);
        return getDataTable(list);
    }

    /**
     * 导出计量支付列表
     */
    @RequiresPermissions("system:payment:export")
    @Log(title = "计量支付", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TPayment tPayment)
    {
        List<TPayment> list = tPaymentService.selectTPaymentList(tPayment);
        ExcelUtil<TPayment> util = new ExcelUtil<TPayment>(TPayment.class);
        return util.exportExcel(list, "计量支付数据");
    }

    /**
     * 新增计量支付
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存计量支付
     */
    @RequiresPermissions("system:payment:add")
    @Log(title = "计量支付", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPayment tPayment)
    {
        return toAjax(tPaymentService.insertTPayment(tPayment));
    }

    /**
     * 修改计量支付
     */
    @RequiresPermissions("system:payment:edit")
    @GetMapping("/edit/{paymentId}")
    public String edit(@PathVariable("paymentId") String paymentId, ModelMap mmap)
    {
        TPayment tPayment = tPaymentService.selectTPaymentByPaymentId(paymentId);
        mmap.put("tPayment", tPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存计量支付
     */
    @RequiresPermissions("system:payment:edit")
    @Log(title = "计量支付", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPayment tPayment)
    {
        return toAjax(tPaymentService.updateTPayment(tPayment));
    }

    /**
     * 删除计量支付
     */
    @RequiresPermissions("system:payment:remove")
    @Log(title = "计量支付", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPaymentService.deleteTPaymentByPaymentIds(ids));
    }
}

