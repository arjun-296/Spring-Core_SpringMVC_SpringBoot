package com.example.jpademo1.repository;

import com.example.jpademo1.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

    public abstract List<Book> findAllByBksubject(String bsub);

}
