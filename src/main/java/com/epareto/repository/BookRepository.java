package com.epareto.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	public List<Book>  findAllByAuthor(Author author,Pageable pageable);
	
	public List<Book>  findAllByGenre(Genre genre,Pageable pageable);
	
	public List<Book>  findAllByYear(String year,Pageable pageable);



}
