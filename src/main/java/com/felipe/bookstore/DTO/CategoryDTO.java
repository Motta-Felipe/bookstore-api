package com.felipe.bookstore.DTO;

import com.felipe.bookstore.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private Integer id;

    @NotEmpty(message= "NAME can't be empty")
    @Length(min = 2, max = 100, message = "The NAME field must have between 3 and 100 characters")
    private String name;

    @NotEmpty(message= "DESCRIPTION can't be empty")
    @Length(min = 3, max = 200, message = "The DESCRIPTION field must have between 3 and 100 characters")
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
