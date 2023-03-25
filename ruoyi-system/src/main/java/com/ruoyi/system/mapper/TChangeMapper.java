package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TChange;

/**
 * 变更管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public interface TChangeMapper 
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
     * 删除变更管理
     * 
     * @param changeId 变更管理主键
     * @return 结果
     */
    public int deleteTChangeByChangeId(String changeId);

    /**
     * 批量删除变更管理
     * 
     * @param changeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTChangeByChangeIds(String[] changeIds);
}
