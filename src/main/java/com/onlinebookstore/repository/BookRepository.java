package com.onlinebookstore.repository;

import com.onlinebookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long>{
	
	/*
	 * list of books by category
	 * */
	@RestResource(path = "categoryid")
	Page<Book> findByCategoryId(@Param("id") Long id, Pageable pageable);
	
	/*
	 * list of books by name contains
	 * */
	@RestResource(path = "searchbykeyword")
	Page<Book> findByNameContaining(@Param("name") String keyword, Pageable pageable);
}
