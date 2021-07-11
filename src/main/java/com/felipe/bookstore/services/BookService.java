package com.felipe.bookstore.services;

import com.felipe.bookstore.DTO.BookDTO;
import com.felipe.bookstore.domain.Book;
import com.felipe.bookstore.domain.Category;
import com.felipe.bookstore.repositories.BookRepository;
import com.felipe.bookstore.repositories.CategoryRepository;
import com.felipe.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    BookRepository repository;

    @Autowired
    CategoryService categoryService;

    public Book findById(Integer id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Book not Found! Id: " + id + ", Type: " + Book.class.getName()));
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public List<Book> findAllByCategory(Integer id) {
        Category obj = categoryService.findById(id);
        return obj.getBooks();
    }

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);

    }
    private void updateData(Book newObj, Book obj) {
        newObj.setName_author(obj.getName_author());
        newObj.setText(obj.getText());
        newObj.setTitle(obj.getTitle());
    }


    public Book create(Integer id_cat, Book obj) {
        obj.setId(null);
        Category category = categoryService.findById(id_cat);
        obj.setCategory(category);
        return repository.save(obj);
    }
}
