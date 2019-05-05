package com.example.demo.dao;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findAll();

    List<Book> findByName(String name);

    Book findById(long id);

    @Transactional
    @Modifying
    @Query("update Book set name = ?1  where id = ?2")
    int updateBookName(String name, long id);

}
