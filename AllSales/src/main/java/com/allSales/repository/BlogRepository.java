package com.allSales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allSales.domain.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long>{
	@Query(value = "SELECT * FROM blog b WHERE b.blogCatId = :blogCatId", nativeQuery = true)
	List<Blog> findBlogByCategory(@Param("blogCatId") Integer blogCatId);
}
