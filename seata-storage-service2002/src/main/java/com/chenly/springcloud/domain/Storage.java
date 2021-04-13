package com.chenly.springcloud.domain;

import lombok.Data;

/**
 * @author: chenly
 * @date: 2021-04-12 16:12
 * @description:
 * @version: 1.0
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}


