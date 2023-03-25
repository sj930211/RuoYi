package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计划进度对象 t_schedule
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public class TSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 进度编号 */
    @Excel(name = "进度编号")
    private String scheduleId;

    /** 开工项目 */
    @Excel(name = "开工项目")
    private String project;

    /** 负责人 */
    @Excel(name = "负责人")
    private String manager;

    /** 申请开工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请开工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyStartDate;

    /** 计划完工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划完工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planEndDate;

    public void setScheduleId(String scheduleId) 
    {
        this.scheduleId = scheduleId;
    }

    public String getScheduleId() 
    {
        return scheduleId;
    }
    public void setProject(String project) 
    {
        this.project = project;
    }

    public String getProject() 
    {
        return project;
    }
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }
    public void setApplyStartDate(Date applyStartDate) 
    {
        this.applyStartDate = applyStartDate;
    }

    public Date getApplyStartDate() 
    {
        return applyStartDate;
    }
    public void setPlanEndDate(Date planEndDate) 
    {
        this.planEndDate = planEndDate;
    }

    public Date getPlanEndDate() 
    {
        return planEndDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scheduleId", getScheduleId())
            .append("project", getProject())
            .append("manager", getManager())
            .append("applyStartDate", getApplyStartDate())
            .append("planEndDate", getPlanEndDate())
            .toString();
    }
}
