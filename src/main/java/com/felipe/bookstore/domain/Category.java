package com.felipe.bookstore.domain;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity   //if not defined will get Category name as table name
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //
	private Integer id;

	@NotEmpty(message= "NAME can't be empty")
	@Length(min = 2, max = 100, message = "The NAME field must have between 3 and 100 characters")
	private String name;

	@NotEmpty(message= "DESCRIPTION can't be empty")
	@Length(min = 3, max = 200, message = "The DESCRIPTION field must have between 3 and 100 characters")
	private String description;
	
	@OneToMany(mappedBy = "category")
	private List<Book> books = new ArrayList<>();

	
	public Category() {
	}

	public Category(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	

}
