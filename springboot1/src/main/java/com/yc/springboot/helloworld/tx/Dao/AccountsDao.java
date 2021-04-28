package com.yc.springboot.helloworld.tx.Dao;

import com.yc.springboot.helloworld.tx.bean.Accounts;

import java.util.List;

public interface AccountsDao {

    public Integer saveAccount(Accounts account);

    public Accounts updateAccount(Accounts account);

    public Accounts findAccount(int accountID);

    public List<Accounts> findAll();

    public void delete(int accountid);
}
