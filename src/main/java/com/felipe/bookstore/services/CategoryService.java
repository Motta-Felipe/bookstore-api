package com.felipe.bookstore.services;

import com.felipe.bookstore.DTO.CategoryDTO;
import com.felipe.bookstore.domain.Category;
import com.felipe.bookstore.repositories.CategoryRepository;
import com.felipe.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category findById(Integer id){
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() ->new ObjectNotFoundException("Object not Found! Id: " + id + ", Type: " + Category.class.getName()));
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category create(Category obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Category update(Integer id, CategoryDTO objDto) {
        Category obj = findById(id);
               obj.setName(objDto.getName());
            obj.setDescription(objDto.getDescription());
        return repository.save(obj);
    }
<<<<<<< HEAD

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);

    }
=======
>>>>>>> main
}
