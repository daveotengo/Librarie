package com.epareto.dto;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorByIsbnReqDTO {
	

	@NotEmpty
	@NotNull(message="cannot be null")
	@Size(min=13, message="cannot be less than 13 characters")
	private String isbn;


}
