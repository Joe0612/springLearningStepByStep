package com.yc.springboot.helloworld.tx.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-17 12:36
 */
@Data
public class OpRecord {
    private Integer id;
    private Integer accountID;
    private Double opmoney;
    private Timestamp optime;   //todo:
    private String optype;      //todo:
    private String transferid;
}
