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
public class Genre {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Size(max = 45)
	@Column(unique = true, nullable = false, length = 45)
	private String name;

	@Column(length = 255)
	@Size(max = 255)
	private String description;

	private LocalDateTime createDate;

	@PrePersist
	public void setUpCreateDate() {
		createDate = LocalDateTime.now();
	}

	private LocalDateTime modifyDate;

}
