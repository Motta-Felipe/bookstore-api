package com.felipe.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipe.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
