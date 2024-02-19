package com.mahmoudi.library.controller;


import com.mahmoudi.library.entity.Book;
import com.mahmoudi.library.exception.BookNotFoundException;
import com.mahmoudi.library.service.serviceImpl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/lib")
@RequiredArgsConstructor
public class LibController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/book/list")
    public ResponseEntity<List<Book>> getAllBooksDetails () {
        List<Book> books = bookServiceImpl.listBooks(10);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookDetails(@PathVariable("id") Long id){
        Book book = bookServiceImpl.getBook(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/book/add")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = bookServiceImpl.createBook(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/book/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book newBook = bookServiceImpl.updateBook(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<Boolean> deleteBookDetails(@PathVariable("id") Long id) {
        bookServiceImpl.deleteBook(id);
        return new ResponseEntity<Boolean>(TRUE, HttpStatus.OK);

    }

    @GetMapping("/book/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbnDetails(@PathVariable("isbn") String isbn){
        Book book = bookServiceImpl.findBookByIsbn(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
