package com.epareto.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epareto.dto.BookByAuthorReqDTO;
import com.epareto.dto.AuthorByGenreReqDTO;
import com.epareto.dto.AuthorByIsbnReqDTO;
import com.epareto.dto.AuthorByTitleReqDTO;
import com.epareto.dto.AuthorByYearReqDTO;
import com.epareto.dto.RespDTO;
import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;
import com.epareto.repository.AuthorRepository;
import com.epareto.repository.BookRepository;
import com.epareto.repository.GenreRepository;
import com.epareto.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public ResponseEntity<RespDTO> findBookByAuthor(@RequestBody BookByAuthorReqDTO genericReqDTO, Pageable pageable) {
		
		RespDTO resp = new RespDTO();
		List<Book> book = new ArrayList<Book>();
		Optional<Author> author = null;
		
		Pageable pageWithThreeElements = PageRequest.of(0, 3,Sort.by("title").descending());

		if (genericReqDTO.getId() != null || genericReqDTO.getUsername() != null || genericReqDTO.getFirstName() != null
				|| genericReqDTO.getLastName() != null) {

			log.info("genericReqDTO: {}", genericReqDTO);

			author = authorRepository.findAuthorByUsernameOrIdOrFirstNameOrLastName(genericReqDTO.getUsername(),
					genericReqDTO.getId(), genericReqDTO.getFirstName(), genericReqDTO.getLastName());

			if (author.isPresent()) {
				book = bookService.findBookByAuthor(author.get(),pageWithThreeElements);
				resp.setMessage("Data Fetched Successfully");
				resp.setStatus("00");
			} else {
				resp.setMessage("No Data");
				resp.setStatus("01");
			}

		} else {
			resp.setMessage("Enter Search Param");
			resp.setStatus("02");
			
			return ResponseEntity.badRequest().body(resp);
		}
		
		

		resp.setData(book);

		return ResponseEntity.ok(resp);
	}

	@PostMapping("book/year")
	public  ResponseEntity<RespDTO> findBookByYear(@Valid @RequestBody AuthorByYearReqDTO genericReqDTO,Pageable pageable) {
		
		RespDTO resp = new RespDTO();
		List<Book> book = new ArrayList<Book>();
		
		Pageable pageWithThreeElements = PageRequest.of(0, 3,Sort.by("title").descending());


		if (genericReqDTO.getYear() != null) {
			
			book = bookService.findBookByYear(genericReqDTO.getYear(),pageWithThreeElements);
			resp.setMessage("Data Fetched Successfully");
			resp.setStatus("00");
			
		} else {
			
			resp.setMessage("No Data");
			resp.setStatus("01");

		}

		resp.setData(book);

		return ResponseEntity.ok(resp);
	}

	@PostMapping("book/genre")
	public ResponseEntity<RespDTO> findBookByGenre(@RequestBody AuthorByGenreReqDTO genericReqDTO,Pageable pageable) {

		RespDTO resp = new RespDTO();

		List<Book> book = new ArrayList<Book>();
		
		Pageable pageWithThreeElements = PageRequest.of(0, 3,Sort.by("title").descending());


		if (genericReqDTO.getId() != null || genericReqDTO.getName() != null) {

			Optional<Genre> gernre = genreRepository.findGenreByNameOrId(genericReqDTO.getName(),
					genericReqDTO.getId());

			if (gernre.isPresent()) {

				book = bookService.findBookByGenre(gernre.get(),pageWithThreeElements);
				resp.setMessage("Data Fetched Successfully");
				resp.setStatus("00");

			} else {

				resp.setMessage("No Data");
				resp.setStatus("01");

			}
		} else {

			resp.setMessage("Enter Search Param");
			resp.setStatus("02");
			return ResponseEntity.badRequest().body(resp);

		}
		resp.setData(book);

		return ResponseEntity.ok(resp);
	}

	
	@PostMapping("book/title")
	public  ResponseEntity<RespDTO> findBookByTitle(@Valid @RequestBody AuthorByTitleReqDTO genericReqDTO,Pageable pageable) {
		
		RespDTO resp = new RespDTO();
		List<Book> book = new ArrayList<Book>();
		
		Pageable pageWithThreeElements = PageRequest.of(0, 3,Sort.by("title").descending());


		if (genericReqDTO.getTitle() != null) {
			
			book = bookService.findBookByTitle(genericReqDTO.getTitle(),pageWithThreeElements);
			resp.setMessage("Data Fetched Successfully");
			resp.setStatus("00");
			
		} else {
			
			resp.setMessage("No Data");
			resp.setStatus("01");

		}

		resp.setData(book);

		return ResponseEntity.ok(resp);
	}
	
	@PostMapping("book/isbn")
	public  ResponseEntity<RespDTO> findBookByIsbn(@Valid @RequestBody AuthorByIsbnReqDTO genericReqDTO,Pageable pageable) {
		
		RespDTO resp = new RespDTO();
		List<Book> book = new ArrayList<Book>();
		
		Pageable pageWithThreeElements = PageRequest.of(0, 3,Sort.by("title").descending());


		if (genericReqDTO.getIsbn() != null) {
			
			book = bookService.findBookByIsbn(genericReqDTO.getIsbn(),pageWithThreeElements);
			resp.setMessage("Data Fetched Successfully");
			resp.setStatus("00");
			
		} else {
			
			resp.setMessage("No Data");
			resp.setStatus("01");

		}

		resp.setData(book);

		return ResponseEntity.ok(resp);
	}
}
