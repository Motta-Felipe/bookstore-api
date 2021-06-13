package com.felipe.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
