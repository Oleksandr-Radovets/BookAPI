package com.example.bookapi.service;

import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookSearchParametersDto;
import com.example.bookapi.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto bookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    void updateById(Long id, CreateBookRequestDto createBookRequestDto);

    void delete(Long id);

    List<BookDto> search(BookSearchParametersDto bookSearchParametersDto);
}
