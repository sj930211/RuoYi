package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TChange;

/**
 * 变更管理Service接口
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public interface ITChangeService 
{
    /**
     * 查询变更管理
     * 
     * @param changeId 变更管理主键
     * @return 变更管理
     */
    public TChange selectTChangeByChangeId(String changeId);

    /**
     * 查询变更管理列表
     * 
     * @param tChange 变更管理
     * @return 变更管理集合
     */
    public List<TChange> selectTChangeList(TChange tChange);

    /**
     * 新增变更管理
     * 
     * @param tChange 变更管理
     * @return 结果
     */
    public int insertTChange(TChange tChange);

    /**
     * 修改变更管理
     * 
     * @param tChange 变更管理
     * @return 结果
     */
    public int updateTChange(TChange tChange);

    /**
     * 批量删除变更管理
     * 
     * @param changeIds 需要删除的变更管理主键集合
     * @return 结果
     */
    public int deleteTChangeByChangeIds(String changeIds);

    /**
     * 删除变更管理信息
     * 
     * @param changeId 变更管理主键
     * @return 结果
     */
    public int deleteTChangeByChangeId(String changeId);
}
