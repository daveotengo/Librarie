package com.epareto.dto;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class AuthorByYearReqDTO {
	

	private String year;


}
