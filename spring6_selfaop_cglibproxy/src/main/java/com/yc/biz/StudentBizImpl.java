package com.yc.biz;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-10 19:19
 */
public class StudentBizImpl {

    public int add(String name) {
        System.out.println("调用了studentBizImpl中的add===="+name);
        return 100;
    }


    public void update(String name) {
        System.out.println("调用了studentBizImpl中的update===="+name);
    }


    public String find(String name) {
        System.out.println("调用了studentBizImpl中的find===="+name);
        return name+"======";
    }
}
