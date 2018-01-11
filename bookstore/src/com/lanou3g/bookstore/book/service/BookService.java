package com.lanou3g.bookstore.book.service;

import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();
    public List<Book> findAll(){
        List<Book> books = bookDao.findAll();
        return books;
    }

    public Book findBybid(String bid) {
        Book book = bookDao.findBybid(bid);
        return book;
    }

    public List<Book> findBycid(String cid) {
        List<Book> books = bookDao.findBycid(cid);
        return books;
    }
}
