package com.example.jpademo1.service;

import com.example.jpademo1.model.Book;
import com.example.jpademo1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //to extract all the book records from the database using hibernate configurations
    @Override
    public List<Book> getAllBooks() {
        return (List<Book>)bookRepository.findAll();
    }

    //to add a new book object in the database using java persistence api and hibernate configuration
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    //to delete a book object form the existing data present in the database
    @Override
    public void deleteBook(int bookid) {
        bookRepository.deleteById(bookid);
    }
    //to update a pre-existing book record in the database
    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    //to locate the object by specific attribute
    @Override
    public Book getBookbyId(int bookid) {
        Book b= null;
        Optional<Book> data= bookRepository.findById(bookid);
        if(data.isPresent())
        {
            b=data.get();
        }
        return b;
    }

    @Override
    public List<Book> getBookbySubject(String bsub) {
        return bookRepository.findAllByBksubject(bsub);
    }
}
