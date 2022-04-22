package com.epareto.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookByAuthorReqDTO {
	
	
	private Long id;
	private String username;
	private LocalDateTime createDate;
	private String firstName;
	private String lastName;


}
