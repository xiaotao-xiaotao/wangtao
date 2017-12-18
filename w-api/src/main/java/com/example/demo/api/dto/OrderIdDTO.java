package com.example.demo.api.dto;

import java.io.Serializable;

/**
 * 订单表主键id
 * Created by Raytine on 2017/10/13.
 */
public class OrderIdDTO implements Serializable{

    private static final long serialVersionUID = 6759272506987258059L;

    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
