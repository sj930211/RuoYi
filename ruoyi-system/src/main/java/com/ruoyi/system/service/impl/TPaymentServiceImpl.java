package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TPaymentMapper;
import com.ruoyi.system.domain.TPayment;
import com.ruoyi.system.service.ITPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 计量支付Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-23
 */
@Service
public class TPaymentServiceImpl implements ITPaymentService
{
    @Autowired
    private TPaymentMapper tPaymentMapper;

    /**
     * 查询计量支付
     *
     * @param paymentId 计量支付主键
     * @return 计量支付
     */
    @Override
    public TPayment selectTPaymentByPaymentId(String paymentId)
    {
        return tPaymentMapper.selectTPaymentByPaymentId(paymentId);
    }

    /**
     * 查询计量支付列表
     *
     * @param tPayment 计量支付
     * @return 计量支付
     */
    @Override
    public List<TPayment> selectTPaymentList(TPayment tPayment)
    {
        return tPaymentMapper.selectTPaymentList(tPayment);
    }

    /**
     * 新增计量支付
     *
     * @param tPayment 计量支付
     * @return 结果
     */
    @Override
    public int insertTPayment(TPayment tPayment)
    {
        return tPaymentMapper.insertTPayment(tPayment);
    }

    /**
     * 修改计量支付
     *
     * @param tPayment 计量支付
     * @return 结果
     */
    @Override
    public int updateTPayment(TPayment tPayment)
    {
        return tPaymentMapper.updateTPayment(tPayment);
    }

    /**
     * 批量删除计量支付
     *
     * @param paymentIds 需要删除的计量支付主键
     * @return 结果
     */
    @Override
    public int deleteTPaymentByPaymentIds(String paymentIds)
    {
        return tPaymentMapper.deleteTPaymentByPaymentIds(Convert.toStrArray(paymentIds));
    }

    /**
     * 删除计量支付信息
     *
     * @param paymentId 计量支付主键
     * @return 结果
     */
    @Override
    public int deleteTPaymentByPaymentId(String paymentId)
    {
        return tPaymentMapper.deleteTPaymentByPaymentId(paymentId);
    }
}
