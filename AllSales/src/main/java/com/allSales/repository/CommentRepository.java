package com.allSales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.allSales.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	@Query(value = "SELECT c from Comment c where c.saleId = :saleId", nativeQuery = true)
	List<Comment> getCommentBySaleId(String saleId);

}
