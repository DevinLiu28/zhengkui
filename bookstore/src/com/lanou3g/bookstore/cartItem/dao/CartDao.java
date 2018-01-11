package com.lanou3g.bookstore.cartItem.dao;

import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.service.BookService;
import com.lanou3g.bookstore.cartItem.domain.Cart;
import com.lanou3g.bookstore.cartItem.domain.CartItem;

import java.util.Iterator;
import java.util.Map;

public class CartDao {
    public void delete(Cart cart, String bid) {
        Map<String, CartItem> map = cart.getCart();
        Iterator<Map.Entry<String, CartItem>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            if (iterator.next().getKey().equals(bid)){
                iterator.remove();
            }

        }



    }



    public void clear(Cart cart) {
        Map<String, CartItem> map = cart.getCart();

        map.clear();
    }
}
