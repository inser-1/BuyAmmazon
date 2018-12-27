package com.oaec.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

     private Map<String,ShopCart> carts = new HashMap<String, ShopCart>();

     private double total;


    public Map<String, ShopCart> getCarts() {
        return carts;
    }

    public void setCarts(Map<String, ShopCart> carts) {
        this.carts = carts;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
