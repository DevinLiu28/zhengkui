package com.lanou3g.bookstore.order.domain;

import java.math.BigDecimal;

public class Order {
    private String oid;
    private String orderTime;
    private BigDecimal total;
    private int state;
    private String uid;
    private String address;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", orderTime=" + orderTime +
                ", total=" + total +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order() {
    }

    public Order(String oid, String orderTime, BigDecimal total, int state, String uid, String address) {

        this.oid = oid;
        this.orderTime = orderTime;
        this.total = total;
        this.state = state;
        this.uid = uid;
        this.address = address;
    }
}
