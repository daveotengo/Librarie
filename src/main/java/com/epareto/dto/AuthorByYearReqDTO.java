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
public class AuthorByYearReqDTO {
	

	@NotEmpty
	@NotNull(message="cannot be null")
	@Size(min=4, message="cannot be blank")
	private String year;


}
