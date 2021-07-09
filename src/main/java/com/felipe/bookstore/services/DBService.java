package com.felipe.bookstore.services;

import com.felipe.bookstore.domain.Book;
import com.felipe.bookstore.domain.Category;
import com.felipe.bookstore.repositories.BookRepository;
import com.felipe.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public void instantiateDataBase(){
        Category cat1 = new Category(null, "IT", "IT Books");
        Category cat2 = new Category(null, "Self-help", "Self-help Books");
        Category cat3 = new Category(null, "Biography", "Great Biography Books");

        Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book b2 = new Book(null, "Spring Boot in Action", "Craig Walls", "Lorem ipsum", cat1);
        Book b3 = new Book(null, "unlimited power", "Robert Martin", "Lorem ipsum", cat2);
        Book b4 = new Book(null, "The Art of War", "Sun Tzu", "Lorem ipsum", cat2);
        Book b5 = new Book(null, "The 7 Habits of Highly Effective People", "Stephen Covey", "Lorem ipsum", cat2);

        cat1.getBooks().addAll(Arrays.asList(b1,b2));
        cat2.getBooks().addAll(Arrays.asList(b3,b4));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        bookRepository.saveAll(Arrays.asList(b1,b4,b3,b4,b5));

    }
}
