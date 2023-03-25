package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TContract;

/**
 * 合同管理Service接口
 * 
 * @author ruoyi
 * @date 2023-03-23
 */
public interface ITContractService 
{
    /**
     * 查询合同管理
     * 
     * @param contractId 合同管理主键
     * @return 合同管理
     */
    public TContract selectTContractByContractId(String contractId);

    /**
     * 查询合同管理列表
     * 
     * @param tContract 合同管理
     * @return 合同管理集合
     */
    public List<TContract> selectTContractList(TContract tContract);

    /**
     * 新增合同管理
     * 
     * @param tContract 合同管理
     * @return 结果
     */
    public int insertTContract(TContract tContract);

    /**
     * 修改合同管理
     * 
     * @param tContract 合同管理
     * @return 结果
     */
    public int updateTContract(TContract tContract);

    /**
     * 批量删除合同管理
     * 
     * @param contractIds 需要删除的合同管理主键集合
     * @return 结果
     */
    public int deleteTContractByContractIds(String contractIds);

    /**
     * 删除合同管理信息
     * 
     * @param contractId 合同管理主键
     * @return 结果
     */
    public int deleteTContractByContractId(String contractId);
}
