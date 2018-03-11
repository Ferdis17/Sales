package com.allSales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.allSales.domain.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {
	@Query(value = "SELECT * FROM sale s WHERE s.isFeature = true", nativeQuery = true)
	List<Sale> getFeatureSales();
	
	@Query(value = "SELECT * FROM sale s where s.isFrontPage = true", nativeQuery = true)
	List<Sale> getFrontPageSales();
	
	@Query(value = "SELECT * FROM sale s.saleId = catId", nativeQuery = true)
	List<Sale> findSaleByaCategory(@Param("catId") int catId);
	
	@Query(value = "SELECT * FROM sale s where s.storeId = :storeId", nativeQuery = true)
	List<Sale> findSalesByStore(@Param("storeId") int storeId);
	
}
