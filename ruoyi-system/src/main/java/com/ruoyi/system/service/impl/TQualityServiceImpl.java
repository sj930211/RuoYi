package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TQualityMapper;
import com.ruoyi.system.domain.TQuality;
import com.ruoyi.system.service.ITQualityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 质量管理Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-23
 */
@Service
public class TQualityServiceImpl implements ITQualityService
{
    @Autowired
    private TQualityMapper tQualityMapper;

    /**
     * 查询质量管理
     *
     * @param qualityId 质量管理主键
     * @return 质量管理
     */
    @Override
    public TQuality selectTQualityByQualityId(String qualityId)
    {
        return tQualityMapper.selectTQualityByQualityId(qualityId);
    }

    /**
     * 查询质量管理列表
     *
     * @param tQuality 质量管理
     * @return 质量管理
     */
    @Override
    public List<TQuality> selectTQualityList(TQuality tQuality)
    {
        return tQualityMapper.selectTQualityList(tQuality);
    }

    /**
     * 新增质量管理
     *
     * @param tQuality 质量管理
     * @return 结果
     */
    @Override
    public int insertTQuality(TQuality tQuality)
    {
        return tQualityMapper.insertTQuality(tQuality);
    }

    /**
     * 修改质量管理
     *
     * @param tQuality 质量管理
     * @return 结果
     */
    @Override
    public int updateTQuality(TQuality tQuality)
    {
        return tQualityMapper.updateTQuality(tQuality);
    }

    /**
     * 批量删除质量管理
     *
     * @param qualityIds 需要删除的质量管理主键
     * @return 结果
     */
    @Override
    public int deleteTQualityByQualityIds(String qualityIds)
    {
        return tQualityMapper.deleteTQualityByQualityIds(Convert.toStrArray(qualityIds));
    }

    /**
     * 删除质量管理信息
     *
     * @param qualityId 质量管理主键
     * @return 结果
     */
    @Override
    public int deleteTQualityByQualityId(String qualityId)
    {
        return tQualityMapper.deleteTQualityByQualityId(qualityId);
    }
}
