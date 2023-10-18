package com.example.bookapi.repository.criteria.book;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.criteria.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "title";
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, criteriaQuery, criteriaBuilder) -> root.get("title")
                .in(Arrays.stream(params).toArray());
    }

}
