package com.epareto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;
import com.epareto.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
@Autowired
private BookRepository bookRepository;
	@Override
	public List<Book>  findBookByAuthor(Author author) {
		return bookRepository.findBookByAuthor(author);
	}

	@Override
	public List<Book>  findBookByGenre(Genre genre) {
		return bookRepository.findBookByGenre(genre);
	}

	@Override
	public List<Book>  findBookByYear(String year) {
		return bookRepository.findBookByYear(year);
	}
	


}
