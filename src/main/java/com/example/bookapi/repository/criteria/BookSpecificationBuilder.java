package com.example.bookapi.repository.criteria;

import com.example.bookapi.dto.BookSearchParametersDto;
import com.example.bookapi.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
     public Specification<Book> build(BookSearchParametersDto bookSearchParametersDto) {
        Specification<Book> specification = Specification.where(null);
        if (bookSearchParametersDto != null && bookSearchParametersDto.author().length > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager
                            .getSpecificationProvider("author")
                            .getSpecification(bookSearchParametersDto.author()));
        }
        if (bookSearchParametersDto.title() != null && bookSearchParametersDto.title().length > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager
                            .getSpecificationProvider("title")
                            .getSpecification(bookSearchParametersDto.title()));
        }
        return specification;
    }

}
