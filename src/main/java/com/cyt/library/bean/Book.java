package com.cyt.library.bean;

public class Book {
    private int book_id;
    private String name;
    private String content;
    private String type;
    private int book_num_now;
    private String img;
    private int book_num_all;
    private String location;

    public Book(int book_id, String name, String content, String type, int book_num_now, String img, int book_num_all, String location) {
        this.book_id = book_id;
        this.name = name;
        this.content = content;
        this.type = type;
        this.book_num_now = book_num_now;
        this.img = img;
        this.book_num_all = book_num_all;
        this.location = location;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBook_num_now() {
        return book_num_now;
    }

    public void setBook_num_now(int book_num_now) {
        this.book_num_now = book_num_now;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getBook_num_all() {
        return book_num_all;
    }

    public void setBook_num_all(int book_num_all) {
        this.book_num_all = book_num_all;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", book_num_now=" + book_num_now +
                ", img='" + img + '\'' +
                ", book_num_all=" + book_num_all +
                ", loaction='" + location + '\'' +
                '}';
    }
}
