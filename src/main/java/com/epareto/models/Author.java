package com.epareto.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table
public class Author {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Size(max = 25)
	@Column(length = 25)
	private String firstName;
	
	@Size(max = 25)
	@Column(length = 25)
	private String lastName;

	@Size(max = 15)
	@Column(unique = true, nullable = false, length = 15)
	private String username;

	private LocalDateTime createDate;

	@PrePersist
	public void setUpCreateDate() {
		createDate = LocalDateTime.now();
	}

	private LocalDateTime modifyDate;

}
