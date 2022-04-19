package com.epareto.dto;

import java.util.List;

import com.epareto.models.Book;

import lombok.Data;

@Data
public class RespDTO {
	private String status;
	private String message;
	private List<Book> data;

}
