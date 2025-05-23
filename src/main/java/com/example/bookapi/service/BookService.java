package com.example.bookapi.service;

import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {

    List<BookDto> findAll(Pageable pageable);

    BookDto save(CreateBookRequestDto bookRequestDto);

    BookDto findById(Long id);

    void updateById(Long id, CreateBookRequestDto createBookRequestDto);

    void delete(Long id);
}
