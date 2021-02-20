package com.cwnu.base.basedata;

public class Obk {
    private String name;
    private Long orderId;

    public Obk(String name, Long orderId) {
        this.name = name;
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
