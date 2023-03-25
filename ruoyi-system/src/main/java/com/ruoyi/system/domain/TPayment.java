package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计量支付对象 t_payment
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public class TPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 总量编号 */
    @Excel(name = "总量编号")
    private String paymentNo;

    /** 总量编号 */
    @Excel(name = "总量编号")
    private String paymentId;

    /** 计划项名称 */
    @Excel(name = "计划项名称")
    private String planName;

    /** 开工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 设计工程量 */
    @Excel(name = "设计工程量")
    private BigDecimal designQty;

    public void setPaymentNo(String paymentNo) 
    {
        this.paymentNo = paymentNo;
    }

    public String getPaymentNo() 
    {
        return paymentNo;
    }
    public void setPaymentId(String paymentId) 
    {
        this.paymentId = paymentId;
    }

    public String getPaymentId() 
    {
        return paymentId;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setDesignQty(BigDecimal designQty) 
    {
        this.designQty = designQty;
    }

    public BigDecimal getDesignQty() 
    {
        return designQty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("paymentNo", getPaymentNo())
            .append("paymentId", getPaymentId())
            .append("planName", getPlanName())
            .append("startDate", getStartDate())
            .append("designQty", getDesignQty())
            .toString();
    }
}
