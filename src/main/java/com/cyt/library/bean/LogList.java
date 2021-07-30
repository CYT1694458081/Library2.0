package com.cyt.library.bean;

import java.sql.Timestamp;
import java.util.Date;

public class LogList {
    private int log_id;
    private int user_id;
    private String user_name;
    private int book_id;
    private String book_name;
    private String date;
    private String state;
    private String next_date;

    public LogList(int log_id, int user_id, String user_name, int book_id, String book_name, String date, String state, String next_date) {
        this.log_id = log_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.book_id = book_id;
        this.book_name = book_name;
        this.date = date;
        this.state = state;
        this.next_date = next_date;
    }

    @Override
    public String toString() {
        return "LogList{" +
                "log_id=" + log_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", date='" + date + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getNext_date() {
        return next_date;
    }

    public void setNext_date(String next_date) {
        this.next_date = next_date;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
