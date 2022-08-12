package com.example.jpademo1.controller;

import com.example.jpademo1.model.Book;
import com.example.jpademo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/myapp/v1")
    public class BookController {


        private BookService bookService;

        @Autowired
        public BookController(BookService bookService){
            this.bookService=bookService;
        }
        // two request handlers
        // first : to get all books from db and return as response to client application
        // second : add received book data db as new record

        // http://localhost:8090/myapp/v1/book  (get)
        @GetMapping("/book") //get
        public ResponseEntity<?> getAllBooks(){ //get
            // return Object of RE with [Book data + status]
            return new ResponseEntity<>( bookService.getAllBooks(), HttpStatus.FOUND);
        }

        // http://localhost:8090/myapp/v1/book  (post)
        @PostMapping("/book") //post
        public ResponseEntity<?> addBook(@RequestBody Book book){ // receives book object as JSON -> Java object
            return new ResponseEntity<>( bookService.addBook(book), HttpStatus.OK);
        }

        // http://localhost:8090/myapp/v1/book/1  (delete)
        @DeleteMapping("/book/{bookid}")
        public ResponseEntity<?> deleteBooks(@PathVariable int bookid){
            bookService.deleteBook(bookid);
            return new ResponseEntity<>("Selected Object Deleted", HttpStatus.OK);
        }
        // http://localhost:8090/myapp/v1/book  (PuT)
        @PutMapping("/book")
        public ResponseEntity<?> update(@RequestBody Book book){
            return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
        }

        // http://localhost:8090/myapp/v1/book/1  (get)
        @GetMapping("/get-book-by-id/{id}")
        public ResponseEntity<?> getBook(@PathVariable int bookid){
            return new ResponseEntity<>(bookService.getBookbyId(bookid),HttpStatus.FOUND);
        }

        // http://localhost:8090/myapp/v1/book  (get)
    @GetMapping("/get-book-by-subject/{bsub}")
        public ResponseEntity<?> findBySub(@PathVariable  String bsub){
            return new ResponseEntity<>(bookService.getBookbySubject(bsub),HttpStatus.FOUND);

    }

    }