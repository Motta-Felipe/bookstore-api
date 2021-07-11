package com.felipe.bookstore.resources;

import com.felipe.bookstore.DTO.BookDTO;
import com.felipe.bookstore.domain.Book;
import com.felipe.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PutMapping(value="/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Integer id_cat, @RequestBody Book obj){
        Book newObj = service.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
