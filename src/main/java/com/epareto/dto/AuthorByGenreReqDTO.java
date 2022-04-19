package com.epareto.dto;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AuthorByGenreReqDTO {
	
//	@NotNull
//	@NotEmpty
//	@Size(min=4,max=6)
	@NotNull(message="cannot be null")
	//@Size(min=4, message="cannot be blank")
	private String name;
	private Long id;


}
