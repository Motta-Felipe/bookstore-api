package com.felipe.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message= "TITLE can't be empty")
	@Length(min = 3, max = 50, message = "The TITLE field must have between 3 and 50 characters")
	private String title;

	@NotEmpty(message= "AUTHOR'S NAME can't be empty")
	@Length(min = 3, max = 50, message = "The AUTHOR'S NAME field must have between 3 and 50 characters")
	private String name_author;

	@NotEmpty(message= "TEXT can't be empty")
	@Length(min = 10, max = 2000000, message = "The TEXT field must have between 10 and 2000000 characters")
	private String text;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String name_author, String text, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.name_author = name_author;
		this.text = text;
		this.category = category;
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

	public String getName_author() {
		return name_author;
	}

	public void setName_author(String name_author) {
		this.name_author = name_author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
