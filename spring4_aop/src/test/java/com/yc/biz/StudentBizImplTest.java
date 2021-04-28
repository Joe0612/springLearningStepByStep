package com.yc.biz;

import com.yc.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentBizImplTest {
    @Autowired
    //按类型注入 如有多个同类托管bean，则报错， 要不就要加入@qualifer来约定注入bean
    //@Resource  //先按名字注入  如果没有同名的 就按类型注入,此时也不能同时出现多个类型的bean，如果有要指定name
    private StudentBiz sbi;


    @Test
    public void testadd() {
        sbi.add("张三");
    }

    @Test
    public void testupdate() {
        sbi.update("张三");
    }

    @Test
    public void testfind(){
        sbi.find("张三");
    }
}