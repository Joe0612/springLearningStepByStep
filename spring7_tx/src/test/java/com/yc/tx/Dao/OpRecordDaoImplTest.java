package com.yc.tx.Dao;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.bean.OpTypes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OpRecordDaoImplTest {
    @Autowired
    private OpRecordDao opRecordDao;

    @Test
    public void testsaveOpRecord() {
        OpRecord opRecord=new OpRecord();
        opRecord.setAccountID(2);
        opRecord.setOpmoney(1.0);
        opRecord.setOptype(OpTypes.withdraw.getName());
        opRecord.setOptime(new Timestamp(new Date().getTime()));
        opRecord.setTransferid(" ");
        opRecordDao.saveOpRecord(opRecord);
    }

    @Test
    public void testfindAll() {
        List<OpRecord> list= opRecordDao.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void testfindByAccountid() {
        List<OpRecord> list= opRecordDao.findByAccountid(1);
        Assert.assertNotEquals(0,list.size());
    }
}