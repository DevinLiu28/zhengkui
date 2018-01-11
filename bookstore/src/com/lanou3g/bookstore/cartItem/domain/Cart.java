package com.lanou3g.bookstore.cartItem.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String,CartItem> carts = new HashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cart=" + carts +
                '}';
    }

    public Map<String, CartItem> getCart() {
        return carts;
    }

    public void setCart(Map<String, CartItem> cart) {
        this.carts = cart;
    }

    public Cart() {

    }

    public Cart(Map<String, CartItem> cart) {

        this.carts = cart;
    }
}
