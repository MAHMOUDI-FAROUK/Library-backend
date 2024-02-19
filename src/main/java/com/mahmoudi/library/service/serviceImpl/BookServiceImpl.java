package com.mahmoudi.library.service.serviceImpl;

import com.mahmoudi.library.entity.Book;
import com.mahmoudi.library.exception.BookNotFoundException;
import com.mahmoudi.library.exception.LibExeption;
import com.mahmoudi.library.repository.BookRepo;
import com.mahmoudi.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.TRUE;


@Service
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book createBook(Book book) {
        log.info("save new Book : {}", book.getTitle() );
        return bookRepo.save(book);
    }

    @Override
    public List<Book> listBooks(int limit) {
        log.info("get book: {}");
        return bookRepo.findAll(PageRequest.of(0 , limit)).toList();
    }

    @Override
    public Book getBook(Long id) {
        log.info("get Book with id: {}", id);
        if(bookRepo.findById(id).isPresent()){
            return bookRepo.findById(id).get();
        } else {
            throw new BookNotFoundException("Book Not Found");
        }
    }

    @Override
    public Book updateBook(Book book) {
        log.info("Update Book : {}", book.getTitle());
        return bookRepo.save(book);
    }

    @Override
    public Boolean deleteBook(Long id) {
        log.info("Delete Book with id  : {}", id);
        if(bookRepo.findById(id).isPresent()){
            bookRepo.deleteById(id);
            return TRUE;
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        log.info("Get Book with isbn: {}", isbn);
        return bookRepo.findByIsbn(isbn);
    }
}
