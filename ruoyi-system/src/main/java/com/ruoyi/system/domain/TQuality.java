package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 质量管理对象 t_quality
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public class TQuality extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 清单主键 */
    @Excel(name = "清单主键")
    private String qualityId;

    /** 清单编号 */
    @Excel(name = "清单编号")
    private String qualityNo;

    /** 清单名称 */
    @Excel(name = "清单名称")
    private String name;

    /** 清单类型 */
    @Excel(name = "清单类型")
    private String type;

    public void setQualityNo(String qualityNo) 
    {
        this.qualityNo = qualityNo;
    }

    public String getQualityNo() 
    {
        return qualityNo;
    }
    public void setQualityId(String qualityId) 
    {
        this.qualityId = qualityId;
    }

    public String getQualityId() 
    {
        return qualityId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("qualityNo", getQualityNo())
            .append("qualityId", getQualityId())
            .append("name", getName())
            .append("type", getType())
            .append("remark", getRemark())
            .toString();
    }
}
