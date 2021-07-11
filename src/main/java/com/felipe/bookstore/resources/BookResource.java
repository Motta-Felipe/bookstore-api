package com.felipe.bookstore.resources;

import com.felipe.bookstore.DTO.BookDTO;
import com.felipe.bookstore.domain.Book;
import com.felipe.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<BookDTO>> findAll(){
        List<Book> list = service.findAll();
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value="/category/{id}")   //to maintain both findAll and findAllByCategory
    //@GetMapping                         //if we want get just all books by category, with book?category=2 for example
    public ResponseEntity<List<BookDTO>> findAllByCategory(/*@RequestParam(value = "category", defaultValue = "0") Integer id*/ @PathVariable Integer id){
        List<Book> list = service.findAllByCategory(id);
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }





}
