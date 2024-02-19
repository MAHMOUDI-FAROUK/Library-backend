package com.mahmoudi.library.service;

import com.mahmoudi.library.entity.Book;

import java.util.List;

public interface BookService {
    /*les services qui conserne classe Livre*/
    Book createBook(Book book);
    List<Book> listBooks(int limit);
    Book getBook(Long id);
    Book updateBook(Book book);
    Boolean deleteBook(Long id);
    Book findBookByIsbn(String isbn);
}
