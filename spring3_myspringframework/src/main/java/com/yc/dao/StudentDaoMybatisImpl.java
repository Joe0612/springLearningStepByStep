package com.yc.dao;

import com.yc.springframework.stereotype.MyRepository;

import java.util.Random;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-04 14:44
 */
@MyRepository
public class StudentDaoMybatisImpl implements StudentDao{
    @Override
    public int add(String name) {
        System.out.println("Mybatis添加学生："+name);
        Random r=new Random();
        return r.nextInt();
    }

    @Override
    public void update(String name) {
        System.out.println("Mybatis更新学生："+name);
    }
}
