package com.example.bookapi.service.impl;

import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.CreateBookRequestDto;
import com.example.bookapi.entity.Book;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.mapper.BookMapper;
import com.example.bookapi.repository.BookRepository;
import com.example.bookapi.service.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto bookRequestDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(bookRequestDto)));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id" + id)));
    }

    @Override
    public void updateById(Long id, CreateBookRequestDto createBookRequestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find book " + id));
        Book book1 = bookMapper.toModel(createBookRequestDto);
        book1.setId(id);
        bookRepository.save(book1);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
