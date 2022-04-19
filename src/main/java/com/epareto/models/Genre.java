package com.epareto.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Genre {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	
	private String name;
	
	private String description;
	
	private LocalDateTime createDate;
	
	private LocalDateTime modifyDate;


}
