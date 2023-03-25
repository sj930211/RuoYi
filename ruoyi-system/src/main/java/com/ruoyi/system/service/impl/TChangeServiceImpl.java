package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TChangeMapper;
import com.ruoyi.system.domain.TChange;
import com.ruoyi.system.service.ITChangeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 变更管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
@Service
public class TChangeServiceImpl implements ITChangeService 
{
    @Autowired
    private TChangeMapper tChangeMapper;

    /**
     * 查询变更管理
     * 
     * @param changeId 变更管理主键
     * @return 变更管理
     */
    @Override
    public TChange selectTChangeByChangeId(String changeId)
    {
        return tChangeMapper.selectTChangeByChangeId(changeId);
    }

    /**
     * 查询变更管理列表
     * 
     * @param tChange 变更管理
     * @return 变更管理
     */
    @Override
    public List<TChange> selectTChangeList(TChange tChange)
    {
        return tChangeMapper.selectTChangeList(tChange);
    }

    /**
     * 新增变更管理
     * 
     * @param tChange 变更管理
     * @return 结果
     */
    @Override
    public int insertTChange(TChange tChange)
    {
        return tChangeMapper.insertTChange(tChange);
    }

    /**
     * 修改变更管理
     * 
     * @param tChange 变更管理
     * @return 结果
     */
    @Override
    public int updateTChange(TChange tChange)
    {
        return tChangeMapper.updateTChange(tChange);
    }

    /**
     * 批量删除变更管理
     * 
     * @param changeIds 需要删除的变更管理主键
     * @return 结果
     */
    @Override
    public int deleteTChangeByChangeIds(String changeIds)
    {
        return tChangeMapper.deleteTChangeByChangeIds(Convert.toStrArray(changeIds));
    }

    /**
     * 删除变更管理信息
     * 
     * @param changeId 变更管理主键
     * @return 结果
     */
    @Override
    public int deleteTChangeByChangeId(String changeId)
    {
        return tChangeMapper.deleteTChangeByChangeId(changeId);
    }
}
