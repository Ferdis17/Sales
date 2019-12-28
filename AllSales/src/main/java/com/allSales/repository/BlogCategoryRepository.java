package com.allSales.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.allSales.domain.BlogCategory;

@Repository
public interface BlogCategoryRepository extends CrudRepository<BlogCategory,Integer>{

}
