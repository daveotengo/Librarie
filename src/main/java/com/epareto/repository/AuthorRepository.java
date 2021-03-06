package com.epareto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epareto.models.Author;
import com.epareto.models.Book;
import com.epareto.models.Genre;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	Optional<Author> findAuthorByUsername(String username);
	
	Optional<Author> findAuthorByUsernameOrIdOrFirstNameOrLastName(String username,Long id,String firstName,String LastName);




}
