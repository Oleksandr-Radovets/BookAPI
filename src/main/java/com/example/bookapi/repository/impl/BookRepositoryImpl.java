package com.example.bookapi.repository.impl;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {

    private EntityManagerFactory entityManagerFactory;

    @Override
    public Book save(Book book) {
        EntityTransaction entityTransaction = null;

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityTransaction = entityManager.getTransaction();
            entityManager.persist(book);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            } else {
                throw new RuntimeException("Can't save " + book + " " + e);
            }
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Book> query = entityManager.createQuery("SELECT b.id, b.description,"
                    + "b.title,b.author,"
                    + "b.coverImage, b.isbn, b.price FROM Book b", Book.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("there are no books");
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Book book = entityManager.find(Book.class, id);
            return Optional.ofNullable(book);
        }
    }
}
