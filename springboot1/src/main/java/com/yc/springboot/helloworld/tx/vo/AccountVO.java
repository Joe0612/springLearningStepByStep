package com.yc.springboot.helloworld.tx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-24 20:38
 */
@Data
public class AccountVO implements Serializable {

    private static final long serialVersionUID = 6845856180708527688L;

    private Integer accountId;
    private Double money;
    private Integer inAccountId;
}
