package com.yc.biz;

import com.yc.AppConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class HelloWorldTest2 extends TestCase { //测试用例
    @Autowired
   private HelloWorld hw;



    @Test
    public void testhello() {
        System.out.println("aaa");
    }
}