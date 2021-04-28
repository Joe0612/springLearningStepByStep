package com.yc.springboot.helloworld.tx.controller;

import com.yc.springboot.helloworld.tx.bean.Accounts;
import com.yc.springboot.helloworld.tx.bean.OpTypes;
import com.yc.springboot.helloworld.tx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-25 21:11
 */
@RestController
@RequestMapping
public class Controller {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/open")
    public void OpenAccount() {
        Integer accountid = accountService.openAccount(new Accounts(), 1);
        System.out.println(accountid);
    }

    @RequestMapping("/depo")
    public void Deposite(@RequestParam("accountid")int accountid, @RequestParam("money")Double money) {
        Accounts a = new Accounts();
        a.setAccountId(accountid);
        Accounts aa = accountService.deposite(a, money, OpTypes.desposite.getName(), null);
        System.out.println(aa);
    }

    @RequestMapping("/with")
    public void Withdraw(@RequestParam("accountid")int accountid, @RequestParam("money")Double money) {
        Accounts a = new Accounts();
        a.setAccountId(accountid);
        Accounts aa = accountService.withdraw(a, money, OpTypes.withdraw.getName(), null);
        System.out.println(aa);
    }

    @RequestMapping("/tran")
    public void Transfer() {
        Accounts out = new Accounts();
        out.setAccountId(6);

        Accounts inA = new Accounts();
        inA.setAccountId(7);

        this.accountService.transfer(inA, out, 5);
    }

    @RequestMapping("/show")
    public void ShowBalance() {
        Accounts a = new Accounts();
        a.setAccountId(6);
        a = this.accountService.showBalance(a);
        System.out.println(a);
    }

    @RequestMapping("/find")
    public void FindById() {
    }
}
