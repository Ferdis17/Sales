package com.allSales.service;

import java.util.List;

import com.allSales.domain.Sale;

public interface SaleService {
	
	void save(Sale sale);
	List<Sale> getFeatureSales();
	List<Sale> getFrontpageSales();
	Sale findOne(Long saleId);
	List<Sale> findAll();
	List<Sale> findSalesByCategory(int catId);
	List<Sale> findSalesByStore(int storeId);

}
