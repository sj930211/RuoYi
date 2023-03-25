package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TContractMapper;
import com.ruoyi.system.domain.TContract;
import com.ruoyi.system.service.ITContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合同管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
@Service
public class TContractServiceImpl implements ITContractService 
{
    @Autowired
    private TContractMapper tContractMapper;

    /**
     * 查询合同管理
     * 
     * @param contractId 合同管理主键
     * @return 合同管理
     */
    @Override
    public TContract selectTContractByContractId(String contractId)
    {
        return tContractMapper.selectTContractByContractId(contractId);
    }

    /**
     * 查询合同管理列表
     * 
     * @param tContract 合同管理
     * @return 合同管理
     */
    @Override
    public List<TContract> selectTContractList(TContract tContract)
    {
        return tContractMapper.selectTContractList(tContract);
    }

    /**
     * 新增合同管理
     * 
     * @param tContract 合同管理
     * @return 结果
     */
    @Override
    public int insertTContract(TContract tContract)
    {
        return tContractMapper.insertTContract(tContract);
    }

    /**
     * 修改合同管理
     * 
     * @param tContract 合同管理
     * @return 结果
     */
    @Override
    public int updateTContract(TContract tContract)
    {
        return tContractMapper.updateTContract(tContract);
    }

    /**
     * 批量删除合同管理
     * 
     * @param contractIds 需要删除的合同管理主键
     * @return 结果
     */
    @Override
    public int deleteTContractByContractIds(String contractIds)
    {
        return tContractMapper.deleteTContractByContractIds(Convert.toStrArray(contractIds));
    }

    /**
     * 删除合同管理信息
     * 
     * @param contractId 合同管理主键
     * @return 结果
     */
    @Override
    public int deleteTContractByContractId(String contractId)
    {
        return tContractMapper.deleteTContractByContractId(contractId);
    }
}
