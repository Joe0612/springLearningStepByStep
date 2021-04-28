package com.yc.tx.service;

import com.yc.tx.Dao.AccountsDao;
import com.yc.tx.Dao.OpRecordDao;
import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.bean.OpTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-17 16:41
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        readOnly = false,
        timeout = 100,
        rollbackForClassName = {"RuntimeException"})
public class AccountServiceImpl implements AccountService{

    @Autowired
    private OpRecordDao opRecordDao;
    @Autowired
    private AccountsDao accountsDao;

    @Override
    public Integer openAccount(Accounts account, double money) {
        account.setBalance(money);
        return accountsDao.saveAccount(account);
    }

    @Override
    public Accounts deposite(Accounts account, double money,String optype,String transferid) {
        Accounts a=this.showBalance(account);

        OpRecord opRecord=new OpRecord();
        opRecord.setAccountID(a.getAccountId());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);  //用枚举做这个值（约束值），不容易出错
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));  //这里是一个Timestamp  new Date().getTime()取得一个long
        if(transferid==null){
            opRecord.setTransferid(null);
        }else{
            opRecord.setTransferid(transferid);
        }
        opRecordDao.saveOpRecord(opRecord);

        a.setBalance(a.getBalance() + money);
        accountsDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts withdraw(Accounts account, double money,String optype,String transferid) {
        Accounts a=this.showBalance(account);

        OpRecord opRecord=new OpRecord();
        opRecord.setAccountID(a.getAccountId());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);  //用枚举做这个值（约束值），不容易出错
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));  //这里是一个Timestamp  new Date().getTime()取得一个long
        if(transferid==null){
            opRecord.setTransferid(null);
        }else{
            opRecord.setTransferid(transferid);
        }
        opRecordDao.saveOpRecord(opRecord);

        a.setBalance(a.getBalance() - money);
        accountsDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts transfer(Accounts inAccount, Accounts outAccount, double money) {
        String uid= UUID.randomUUID().toString(); //转账流水
        this.deposite(inAccount,money, OpTypes.transfer.getName(),uid);
        Accounts newAccounts=this.withdraw(outAccount,money,OpTypes.transfer.getName(),uid);
        return newAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Accounts showBalance(Accounts account) {
        return accountsDao.findAccount(account.getAccountId());
    }

    @Override
    public List<OpRecord> findById(Accounts account) {
        return opRecordDao.findByAccountid(account.getAccountId());
    }
}
