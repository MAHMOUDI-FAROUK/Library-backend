package com.mahmoudi.library.controller;


import com.mahmoudi.library.entity.Book;
import com.mahmoudi.library.entity.Response;
import com.mahmoudi.library.service.serviceImpl.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/lib")
@RequiredArgsConstructor
public class LibController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/book/list")
    public ResponseEntity<Response> getAllBooksDetails () {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("books" , bookServiceImpl.listBooks(30)))
                        .message("books retreived")
                        .status(OK).statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("book/{id}")
    public ResponseEntity<Response> getBookDetails(@PathVariable("id") Long id){
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("book" , bookServiceImpl.getBook(id)))
                        .status(OK).statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/book/add")
    public ResponseEntity<Response> createBook(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("book" , bookServiceImpl.createBook(book)))
                        .message("Book Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );

    }

    @PutMapping("/book/update")
    public ResponseEntity<Response> updateBook(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("book" , bookServiceImpl.updateBook(book)))
                        .message("Book Updated")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<Response> deleteBookDetails(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Book",bookServiceImpl.deleteBook(id)))
                        .message("Book deleted")
                        .status(OK).statusCode(OK.value())
                        .build()
        );

    }

    @GetMapping("/book/isbn/{isbn}")
    public ResponseEntity<Response> getBookByIsbnDetails(@PathVariable("isbn") String isbn){
        return  ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("book" , bookServiceImpl.findBookByIsbn(isbn)))
                        .status(OK).statusCode(OK.value())
                        .build()
        );
    }
}
