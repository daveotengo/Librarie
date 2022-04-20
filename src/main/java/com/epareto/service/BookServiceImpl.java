package com.epareto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	public List<Book>  findBookByAuthor(Author author,Pageable pageable) {
		return bookRepository.findAllByAuthor(author, pageable);
	}

	@Override
	public List<Book>  findBookByGenre(Genre genre,Pageable pageable) {
		return bookRepository.findAllByGenre(genre, pageable);
	}

	@Override
	public List<Book>  findBookByYear(String year,Pageable pageable) {
		return bookRepository.findAllByYear(year, pageable);
	}
	


}
