package com.epareto.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table
public class Book {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @ManyToOne
    @JoinColumn(name = "authorId")
    Author author;
	private String title;
	private String year;
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genre genre;

}
