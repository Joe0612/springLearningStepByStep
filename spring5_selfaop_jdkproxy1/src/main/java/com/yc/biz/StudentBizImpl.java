package com.yc.biz;

import java.util.Random;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-20 20:34
 */
public class StudentBizImpl implements StudentBiz{

    @Override
    public int add(String name) {
        Random rd=new Random(10);
        System.out.println("调用了studentbizimpl的add======");
        return rd.nextInt();
    }

    @Override
    public String find(String name) {
        System.out.println("调用了studentbizimpl的find======");
        return "调用了studentbizimpl的find======";
    }

    @Override
    public void update(String name) {
        System.out.println("调用了studentbizimpl的update======");
    }
}
