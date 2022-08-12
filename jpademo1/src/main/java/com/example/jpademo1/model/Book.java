package com.example.jpademo1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private int bookid;

    private String bkname, bksubject, bkauthor;

    private int bkprice;

    public Book() {
    }

    public Book(int bookid, String bkname, String bksubject, String bkauthor, int bkprice) {
        this.bookid = bookid;
        this.bkname = bkname;
        this.bksubject = bksubject;
        this.bkauthor = bkauthor;
        this.bkprice = bkprice;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getBksubject() {
        return bksubject;
    }

    public void setBksubject(String bksubject) {
        this.bksubject = bksubject;
    }

    public String getBkauthor() {
        return bkauthor;
    }

    public void setBkauthor(String bkauthor) {
        this.bkauthor = bkauthor;
    }

    public int getBkprice() {
        return bkprice;
    }

    public void setBkprice(int bkprice) {
        this.bkprice = bkprice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bkname='" + bkname + '\'' +
                ", bksubject='" + bksubject + '\'' +
                ", bkauthor='" + bkauthor + '\'' +
                ", bkprice=" + bkprice +
                '}';
    }
}
