package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TScheduleMapper;
import com.ruoyi.system.domain.TSchedule;
import com.ruoyi.system.service.ITScheduleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 计划进度Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
@Service
public class TScheduleServiceImpl implements ITScheduleService 
{
    @Autowired
    private TScheduleMapper tScheduleMapper;

    /**
     * 查询计划进度
     * 
     * @param scheduleId 计划进度主键
     * @return 计划进度
     */
    @Override
    public TSchedule selectTScheduleByScheduleId(String scheduleId)
    {
        return tScheduleMapper.selectTScheduleByScheduleId(scheduleId);
    }

    /**
     * 查询计划进度列表
     * 
     * @param tSchedule 计划进度
     * @return 计划进度
     */
    @Override
    public List<TSchedule> selectTScheduleList(TSchedule tSchedule)
    {
        return tScheduleMapper.selectTScheduleList(tSchedule);
    }

    /**
     * 新增计划进度
     * 
     * @param tSchedule 计划进度
     * @return 结果
     */
    @Override
    public int insertTSchedule(TSchedule tSchedule)
    {
        return tScheduleMapper.insertTSchedule(tSchedule);
    }

    /**
     * 修改计划进度
     * 
     * @param tSchedule 计划进度
     * @return 结果
     */
    @Override
    public int updateTSchedule(TSchedule tSchedule)
    {
        return tScheduleMapper.updateTSchedule(tSchedule);
    }

    /**
     * 批量删除计划进度
     * 
     * @param scheduleIds 需要删除的计划进度主键
     * @return 结果
     */
    @Override
    public int deleteTScheduleByScheduleIds(String scheduleIds)
    {
        return tScheduleMapper.deleteTScheduleByScheduleIds(Convert.toStrArray(scheduleIds));
    }

    /**
     * 删除计划进度信息
     * 
     * @param scheduleId 计划进度主键
     * @return 结果
     */
    @Override
    public int deleteTScheduleByScheduleId(String scheduleId)
    {
        return tScheduleMapper.deleteTScheduleByScheduleId(scheduleId);
    }
}
