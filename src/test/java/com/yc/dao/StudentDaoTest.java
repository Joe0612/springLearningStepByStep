package com.yc.dao;

import com.yc.biz.StudentBizImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoTest extends TestCase {
    private StudentDao studentDao;
    private StudentBizImpl studentBizimpl;


    @Before
    public void setUp() throws Exception {
        //1.能否自动完成  实例化对象  ->IOC 控制反转  ->由容器实例化对象，由容器来完成
       studentDao=new StudentDaoJpaImpl();

       studentBizimpl=new StudentBizImpl(studentDao);

       //2.能否自动完成 装配过程  ->DI 依赖注入 ->由容器装配对象
        //studentBizimpl.setStudentDao(studentDao);
    }

    @Test
    public void add() {
        studentDao.add("张三");
    }

    @Test
    public void update() {
        studentDao.update("张三");
    }

    @Test
    public void testBizAdd(){
        studentBizimpl.add("张三");
    }
}