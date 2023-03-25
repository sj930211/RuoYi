package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TQuality;

/**
 * 质量管理Service接口
 *
 * @author ruoyi
 * @date 2023-03-23
 */
public interface ITQualityService
{
    /**
     * 查询质量管理
     *
     * @param qualityId 质量管理主键
     * @return 质量管理
     */
    public TQuality selectTQualityByQualityId(String qualityId);

    /**
     * 查询质量管理列表
     *
     * @param tQuality 质量管理
     * @return 质量管理集合
     */
    public List<TQuality> selectTQualityList(TQuality tQuality);

    /**
     * 新增质量管理
     *
     * @param tQuality 质量管理
     * @return 结果
     */
    public int insertTQuality(TQuality tQuality);

    /**
     * 修改质量管理
     *
     * @param tQuality 质量管理
     * @return 结果
     */
    public int updateTQuality(TQuality tQuality);

    /**
     * 批量删除质量管理
     *
     * @param qualityIds 需要删除的质量管理主键集合
     * @return 结果
     */
    public int deleteTQualityByQualityIds(String qualityIds);

    /**
     * 删除质量管理信息
     *
     * @param qualityId 质量管理主键
     * @return 结果
     */
    public int deleteTQualityByQualityId(String qualityId);
}
