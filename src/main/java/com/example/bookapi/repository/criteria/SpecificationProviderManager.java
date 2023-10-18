package com.example.bookapi.repository.criteria;

public interface SpecificationProviderManager<T> {
    SpecificationProvider<T> getSpecificationProvider(String key);

}
