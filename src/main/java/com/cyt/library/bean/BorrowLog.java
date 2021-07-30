package com.cyt.library.bean;

import java.sql.Timestamp;
import java.util.Date;

public class BorrowLog {
    private int borrow_id;
    private int user_id;
    private int book_id;
    private String borrow_date;
    private String state;
    private String back_date;

    public BorrowLog(int borrow_id, int user_id, int book_id, String borrow_date, String state, String back_date) {
        this.borrow_id = borrow_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.state = state;
        this.back_date = back_date;
    }

    public String getBack_date() {
        return back_date;
    }

    public void setBack_date(String back_date) {
        this.back_date = back_date;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BorrowLog{" +
                "borrow_id=" + borrow_id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", borrow_date='" + borrow_date + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
