package com.lanou3g.bean;

public class Book {
    private String bookName;
    private String Writer;
    private int money;

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", Writer='" + Writer + '\'' +
                ", money=" + money +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Book(String bookName, String writer, int money) {

        this.bookName = bookName;
        Writer = writer;
        this.money = money;
    }

    public Book() {

    }
}
