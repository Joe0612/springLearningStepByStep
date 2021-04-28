package com.yc.biz;

import com.yc.LogAspect;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-20 20:45
 */
public class Test {
    public static void main(String[] args) {
        StudentBiz biz=new StudentBizImpl();

        LogAspect log=new LogAspect(biz);

        Object obj=log.createProxy();

        System.out.println(obj.toString());

        if(obj instanceof StudentBiz){
            StudentBiz s= (StudentBiz) obj;

            s.find("乔龙");
            s.update("乔龙");
            s.add("乔龙");
        }
    }
}
