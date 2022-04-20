package com.epareto.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;


public interface BookService {
	
	public List<Book>  findBookByAuthor(Author author,Pageable pageable);
	
	public List<Book> findBookByGenre(Genre genre,Pageable pageable);
	
	public List<Book>  findBookByYear(String year, Pageable pageable);

	
	

}
