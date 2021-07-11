package com.felipe.bookstore.services;

import com.felipe.bookstore.domain.Book;
import com.felipe.bookstore.domain.Category;
import com.felipe.bookstore.repositories.BookRepository;
import com.felipe.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public Book findById(Integer id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Book not Found! Id: " + id + ", Type: " + Book.class.getName()));
    }
}
