package com.example.bookapi.controller;

import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.BookSearchParametersDto;
import com.example.bookapi.dto.CreateBookRequestDto;
import com.example.bookapi.service.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("books/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/book")
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }

    @PutMapping("book/{id}")
    public void updateBook(@PathVariable Long id,
                           @RequestBody CreateBookRequestDto createBookRequestDto) {
        bookService.updateById(id, createBookRequestDto);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("books/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/search")
    public List<BookDto> search(BookSearchParametersDto bookSearchParametersDto) {
        return bookService.search(bookSearchParametersDto);
    }
}
