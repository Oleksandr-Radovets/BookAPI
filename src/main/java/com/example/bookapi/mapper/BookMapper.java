package com.example.bookapi.mapper;

import com.example.bookapi.config.MapperConfig;
import com.example.bookapi.dto.BookDto;
import com.example.bookapi.dto.CreateBookRequestDto;
import com.example.bookapi.entity.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookRequestDto);
}
