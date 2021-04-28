package com.yc.tx.controllers;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpTypes;
import com.yc.tx.service.AccountService;
import com.yc.tx.vo.AccountVO;
import com.yc.tx.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-24 20:53
 */
@Controller
@Slf4j
@Api(value = "银行账户操作接口",tags = {"账户操作接口","控制层"})
public class AccountsController {

    @Autowired
    private AccountService accountService;



    @RequestMapping(value = "/openAccounts",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value = "开户", notes = "根据金额来完成开户操作，注意此时的金额表示要开户的金额")
    @ApiImplicitParams({@ApiImplicitParam(name = "money", value = "开户金额", required = true, dataType = "java.lang.Double")})
    public @ResponseBody ResultVO openAccounts(AccountVO accountVO ){
        log.debug("用户请求开户，存入"+accountVO.getMoney());
        ResultVO rv=new ResultVO();
        try{
            Accounts a=new Accounts();
            double money=1;
            if(accountVO.getMoney()!=null && accountVO.getMoney()>0){
                money=accountVO.getMoney();
            }
            Integer id=accountService.openAccount(a,accountVO.getMoney());
            a.setAccountId( id );
            a.setBalance(money);
            rv.setCode(1);
            rv.setData(a);
        }catch (Exception e){
            e.printStackTrace();
            rv.setCode(0);
            rv.setMsg(e.getMessage());
        }
        return rv;
    }


    @RequestMapping(value = "/deposite", method = RequestMethod.POST)
    @ApiOperation(value = "存钱", notes = "根据账户编号及金额, 金额来完成存钱操作，注意此时的金额表示要存进的金额")
    @ApiImplicitParams({@ApiImplicitParam(name = "accountId", value = "自己账户编号", required = true, dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "money", value = "存钱金额", required = true, dataType = "java.lang.Double")})
    public @ResponseBody ResultVO<Accounts> deposite(AccountVO accountVO){
        ResultVO<Accounts> rv=new ResultVO<>();
        Accounts a=new Accounts();
        a.setAccountId(accountVO.getAccountId());
        Accounts aa=accountService.deposite(a,accountVO.getMoney(), OpTypes.desposite.getName(),null);
        try {
            rv.setData(aa);
            rv.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            rv.setCode(0);
            rv.setMsg(e.getMessage());
        }
        return rv;
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    @ApiOperation(value = "取钱", notes = "根据账户编号及金额完成取钱操作，注意此时的金额表示要取的金额")
    @ApiImplicitParams({@ApiImplicitParam(name = "accountId", value = "自己账户编号", required = true, dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "money", value = "取钱金额", required = true, dataType = "java.lang.Double")})
    public @ResponseBody ResultVO<Accounts> withdraw(AccountVO accountVO){
        Accounts a=new Accounts();
        a.setAccountId(accountVO.getAccountId());
        Accounts aa=accountService.withdraw(a,accountVO.getMoney(),OpTypes.withdraw.getName(),null);
        ResultVO<Accounts> rv=new ResultVO<>();
        try {
            rv.setData(aa);
            rv.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            rv.setCode(0);
            rv.setMsg(e.getMessage());
        }
        return rv;
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    @ApiOperation(value = "转账", notes = "根据账户编号及金额, 对方接收账号来完成转账操作，注意此时的金额表示要取的金额")
    @ApiImplicitParams({@ApiImplicitParam(name = "accountId", value = "自己账户编号", required = true, dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "money", value = "转账金额", required = true, dataType = "java.lang.Double"),
            @ApiImplicitParam(name = "inAccountId", value = "对方接收账号", required = true, dataType = "java.lang.Integer")})
    public @ResponseBody
    ResultVO<Accounts> transfer(AccountVO accountVO) {
        Accounts inAccount = new Accounts();
        inAccount.setAccountId(accountVO.getInAccountId());
        Accounts outAccount = new Accounts();
        outAccount.setAccountId(accountVO.getAccountId());
        ResultVO<Accounts> rv = new ResultVO();
        try {
            Accounts a = accountService.transfer(inAccount, outAccount, accountVO.getMoney());
            rv.setCode(1);
            rv.setData(a);
        } catch (Exception ex) {
            ex.printStackTrace();
            rv.setCode(0);
            rv.setMsg(ex.getMessage());
        }
        return rv;
    }

    @RequestMapping(value = "/showBalance",method = RequestMethod.POST)
    @ApiOperation(value = "查询", notes = "根据id来完成查询操作")
    @ApiImplicitParams({@ApiImplicitParam(name = "accountId", value = "自己账户编号", required = true, dataType = "java.lang.Integer")})
    public @ResponseBody ResultVO<Accounts> showBalance(AccountVO accountVO){
        Accounts a=new Accounts();
        a.setAccountId(accountVO.getAccountId());
        Accounts aa=accountService.showBalance(a);
        ResultVO<Accounts> rv=new ResultVO<>();
        try{
            rv.setData(aa);
            rv.setCode(1);
        }catch (Exception e){
            e.printStackTrace();
            rv.setCode(0);
            rv.setMsg(e.getMessage());
        }
        return rv;
    }
}
