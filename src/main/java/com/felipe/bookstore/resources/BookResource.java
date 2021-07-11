package com.felipe.bookstore.resources;

import com.felipe.bookstore.domain.Book;
import com.felipe.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/books")
public class BookResource {

    @Autowired
    BookService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Book>>


}
