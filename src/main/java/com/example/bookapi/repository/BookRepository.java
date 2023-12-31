package com.example.bookapi.repository;

import com.example.bookapi.entity.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);

}
