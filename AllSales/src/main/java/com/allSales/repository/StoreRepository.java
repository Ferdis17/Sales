package com.allSales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.allSales.domain.Store;

public interface StoreRepository extends CrudRepository<Store, Integer>{
	@Query(value = "SELECT * FROM store s WHERE s.store_id != :storeID", nativeQuery = true)
	List<Store> getRelatedStore(@Param("storeId") Integer storeId);

}
