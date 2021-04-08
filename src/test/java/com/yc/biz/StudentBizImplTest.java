package com.yc.biz;

import com.yc.AppConfig;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class StudentBizImplTest extends TestCase {

    //容器
    ApplicationContext ac;
    private StudentBizImpl studentBiz;

    @Before
    public void setUp() throws Exception {
        ac=new AnnotationConfigApplicationContext(AppConfig.class);
        studentBiz= (StudentBizImpl) ac.getBean("studentBizImpl");
    }

    @Test
    public void testadd() {
        studentBiz.add("李四");
    }

    @Test
    public void testupdate() {
        studentBiz.update("李四");
    }
}