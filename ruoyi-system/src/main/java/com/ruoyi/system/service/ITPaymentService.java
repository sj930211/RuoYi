package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TPayment;

/**
 * 计量支付Service接口
 *
 * @author ruoyi
 * @date 2023-03-23
 */
public interface ITPaymentService
{
    /**
     * 查询计量支付
     *
     * @param paymentId 计量支付主键
     * @return 计量支付
     */
    public TPayment selectTPaymentByPaymentId(String paymentId);

    /**
     * 查询计量支付列表
     *
     * @param tPayment 计量支付
     * @return 计量支付集合
     */
    public List<TPayment> selectTPaymentList(TPayment tPayment);

    /**
     * 新增计量支付
     *
     * @param tPayment 计量支付
     * @return 结果
     */
    public int insertTPayment(TPayment tPayment);

    /**
     * 修改计量支付
     *
     * @param tPayment 计量支付
     * @return 结果
     */
    public int updateTPayment(TPayment tPayment);

    /**
     * 批量删除计量支付
     *
     * @param paymentIds 需要删除的计量支付主键集合
     * @return 结果
     */
    public int deleteTPaymentByPaymentIds(String paymentIds);

    /**
     * 删除计量支付信息
     *
     * @param paymentId 计量支付主键
     * @return 结果
     */
    public int deleteTPaymentByPaymentId(String paymentId);
}
