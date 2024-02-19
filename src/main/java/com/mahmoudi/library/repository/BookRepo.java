package com.mahmoudi.library.repository;

import com.mahmoudi.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
//    Optional<Object> findBookById(Long id);
}
