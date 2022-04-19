package com.epareto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;


public interface BookService {
	
	public List<Book>  findBookByAuthor(Author author);
	
	public List<Book> findBookByGenre(Genre genre);
	
	public List<Book>  findBookByYear(String year);
	
	

}
