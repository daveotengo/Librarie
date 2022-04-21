package com.epareto.models;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"isbn"})})
public class Book {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

	@NotEmpty
	@NotNull
    @ManyToOne
    @JoinColumn(name = "authorId")
    Author author;
    
    @Size(max = 45)
	@Column(length = 45)
	private String title;
	
    @Size(max = 5)
 	@Column(length = 5)
	private String year;
	
    @Size(max = 20)
	@Column(unique=true,nullable=false,length=20)
	private String isbn;
	
    @NotEmpty
	@NotNull
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genre genre;
    
    private LocalDateTime createDate;

	@PrePersist
	public void setUpCreateDate() {
		createDate = LocalDateTime.now();
	}

	private LocalDateTime modifyDate;

}
