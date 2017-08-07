package com.chinasofti.lexian.manager.privilege.dao;

import com.chinasofti.lexian.manager.privilege.vo.WalletRecord;

public interface WalletRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WalletRecord record);

    int insertSelective(WalletRecord record);

    WalletRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WalletRecord record);

    int updateByPrimaryKey(WalletRecord record);
}