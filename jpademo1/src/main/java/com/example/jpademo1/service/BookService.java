package com.example.jpademo1.service;

import com.example.jpademo1.model.Book;

import java.util.List;

public interface BookService {
    public abstract List<Book> getAllBooks();
    public abstract Book addBook(Book book);
    public abstract void deleteBook(int bookid);
    public abstract Book updateBook(Book book);
    public abstract Book getBookbyId(int bookid);
    public abstract List<Book> getBookbySubject(String bsub);
}
