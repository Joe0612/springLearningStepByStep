package com.yc.tx;

import com.yc.tx.Dao.AccountsDao;
import com.yc.tx.bean.Accounts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccountsDao accountsDao;

    @Test
    public void testDataScource() throws SQLException {
        Assert.assertNotNull(dataSource);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testAccountsDaoImpl() throws SQLException {
        Assert.assertNotNull(accountsDao);
    }

    @Test
    public void testOpenAccounts() throws SQLException {
        Accounts a=new Accounts();
        a.setBalance(10.0);
        int accountid=accountsDao.saveAccount(   a  );
        System.out.println("开户成功，新开户头为："+accountid);
    }

    @Test
    public void testFindAll() throws SQLException {
        List<Accounts> list=this.accountsDao.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindByID() throws SQLException {
        Accounts a=this.accountsDao.findAccount(3);
        System.out.println(a);
    }
}