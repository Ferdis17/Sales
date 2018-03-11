package com.allSales.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allSales.domain.SaleCategory;

@Repository
public interface SaleCategoryRepository extends CrudRepository<SaleCategory, Integer>{
	
	@Query(value = "SELECT * FROM saleCategory sc WHERE sc.saleCatName = :saleCatName", nativeQuery = true)
	SaleCategory getSaleCategoryByName(@Param("saleCatName") String saleCatName);
	

}
