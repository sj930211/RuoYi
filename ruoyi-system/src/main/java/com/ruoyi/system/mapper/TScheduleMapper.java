package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TSchedule;

/**
 * 计划进度Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public interface TScheduleMapper 
{
    /**
     * 查询计划进度
     * 
     * @param scheduleId 计划进度主键
     * @return 计划进度
     */
    public TSchedule selectTScheduleByScheduleId(String scheduleId);

    /**
     * 查询计划进度列表
     * 
     * @param tSchedule 计划进度
     * @return 计划进度集合
     */
    public List<TSchedule> selectTScheduleList(TSchedule tSchedule);

    /**
     * 新增计划进度
     * 
     * @param tSchedule 计划进度
     * @return 结果
     */
    public int insertTSchedule(TSchedule tSchedule);

    /**
     * 修改计划进度
     * 
     * @param tSchedule 计划进度
     * @return 结果
     */
    public int updateTSchedule(TSchedule tSchedule);

    /**
     * 删除计划进度
     * 
     * @param scheduleId 计划进度主键
     * @return 结果
     */
    public int deleteTScheduleByScheduleId(String scheduleId);

    /**
     * 批量删除计划进度
     * 
     * @param scheduleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTScheduleByScheduleIds(String[] scheduleIds);
}
