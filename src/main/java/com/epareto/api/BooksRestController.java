package com.epareto.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epareto.GenericReqDTO;
import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;
import com.epareto.repository.AuthorRepository;
import com.epareto.repository.BookRepository;
import com.epareto.repository.GenreRepository;
import com.epareto.service.BookService;

@RestController
@RequestMapping("api/books")
public class BooksRestController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@PostMapping("book/author")
	public List<Book>  findBookByAuthor(@RequestBody GenericReqDTO genericReqDTO) {

		Optional<Author> author = authorRepository.findById(genericReqDTO.getId());
		
		List<Book>  book = bookService.findBookByAuthor(author.get());
		
		return book;
	}
	
	@PostMapping("book/year")
	public List<Book>  findBookByYear(@RequestBody GenericReqDTO genericReqDTO) {
		
		List<Book>  book = bookService.findBookByYear(genericReqDTO.getYear());
		
		return book;
	}
	
	@PostMapping("book/genre")
	public List<Book> findBookByGenre(@RequestBody GenericReqDTO genericReqDTO) {
		
		Optional<Genre> gernre = genreRepository.findById(genericReqDTO.getId());
		List<Book> book = bookService.findBookByGenre(gernre.get());

		
		
		
		return book;
	}

}
