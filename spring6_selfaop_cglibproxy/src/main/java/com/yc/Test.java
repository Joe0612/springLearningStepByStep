package com.yc;

import com.yc.biz.StudentBizImpl;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-12 19:27
 */
public class Test {
    public static void main(String[] args) {
        StudentBizImpl sbi=new StudentBizImpl();

        LogAspectCglib lc=new LogAspectCglib(sbi);

        Object obj=lc.createProxy();
        System.out.println(obj);
        if(obj instanceof StudentBizImpl){
            StudentBizImpl s= (StudentBizImpl) obj;

            s.find("张三");
            s.add("王五");
            s.update("李四");
        }
    }
}
