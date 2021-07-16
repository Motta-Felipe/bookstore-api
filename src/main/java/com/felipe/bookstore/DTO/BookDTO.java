package com.felipe.bookstore.DTO;

import com.felipe.bookstore.domain.Book;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class BookDTO {
    private Integer id;

    @NotEmpty(message= "TITLE can't be empty")
    @Length(min = 3, max = 50, message = "The TITLE field must have between 3 and 50 characters")
    private String title;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
