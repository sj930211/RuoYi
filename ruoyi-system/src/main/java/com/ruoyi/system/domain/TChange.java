package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 变更管理对象 t_change
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public class TChange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 变更编号 */
    @Excel(name = "变更编号")
    private String changeId;

    /** 变更项目 */
    @Excel(name = "变更项目")
    private String project;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 申请单位 */
    @Excel(name = "申请单位")
    private String applyUnit;

    /** 负责人 */
    @Excel(name = "负责人")
    private String manager;

    public void setChangeId(String changeId) 
    {
        this.changeId = changeId;
    }

    public String getChangeId() 
    {
        return changeId;
    }
    public void setProject(String project) 
    {
        this.project = project;
    }

    public String getProject() 
    {
        return project;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setApplyUnit(String applyUnit) 
    {
        this.applyUnit = applyUnit;
    }

    public String getApplyUnit() 
    {
        return applyUnit;
    }
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("changeId", getChangeId())
            .append("project", getProject())
            .append("applyTime", getApplyTime())
            .append("applyUnit", getApplyUnit())
            .append("manager", getManager())
            .toString();
    }
}
