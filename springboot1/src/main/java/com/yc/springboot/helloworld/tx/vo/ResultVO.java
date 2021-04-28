package com.yc.springboot.helloworld.tx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: testspring
 * @description:
 * @author: Joe
 * @create: 2021-04-24 20:40
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -847695270863652993L;
    private Integer code;
    private T data;
    private String msg;

}
