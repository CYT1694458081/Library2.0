package com.cyt.library.bean;

public class DefaultRecord {
    private int default_record_id;
    private int user_id;
    private int borrow_id;
    private String default_record_date;
    private String reason;
    private String state;

    public DefaultRecord(int default_record_id, int user_id, int borrow_id, String reason, String default_record_date,String state) {
        this.default_record_id = default_record_id;
        this.user_id = user_id;
        this.borrow_id = borrow_id;
        this.default_record_date = default_record_date;
        this.reason = reason;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDefault_record_id() {
        return default_record_id;
    }

    public void setDefault_record_id(int default_record_id) {
        this.default_record_id = default_record_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public String getDefault_record_date() {
        return default_record_date;
    }

    public void setDefault_record_date(String default_record_date) {
        this.default_record_date = default_record_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
