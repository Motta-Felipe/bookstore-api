package com.felipe.bookstore.DTO;

import com.felipe.bookstore.domain.Book;

public class BookDTO {
    private Integer id;
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
