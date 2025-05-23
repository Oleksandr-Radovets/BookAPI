package com.example.bookapi.repository;

import com.example.bookapi.entity.Book;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<Book, Long>,
        JpaSpecificationExecutor<Book>, PagingAndSortingRepository<Book, Long> {

    void deleteById(Long id);

    Book save(Book book);

    Optional<Book> findById(Long id);

    Page<Book> findAll(Pageable pageable);

}
