package com.yc.springboot.helloworld.tx.Dao;

import com.yc.springboot.helloworld.tx.bean.OpRecord;

import java.util.List;

public interface OpRecordDao {
    public void saveOpRecord(OpRecord opRecord);

    public List<OpRecord> findAll();

    public List<OpRecord> findByAccountid(int accountID);
}
