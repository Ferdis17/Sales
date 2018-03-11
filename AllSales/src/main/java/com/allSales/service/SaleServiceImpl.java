package com.allSales.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.allSales.domain.Sale;
import com.allSales.domain.User;
import com.allSales.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService{

	@Autowired
	SaleRepository saleRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public void save(Sale sale) {
	Date today = new Date();
	sale.setPostDate(today);
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String email = auth.getName();
	User user = userService.findUserByEmail(email);
	
	if(user != null) {
		user.addSale(sale);
	}
	saleRepository.save(sale);
		
	}

	@Override
	public List<Sale> getFeatureSales() {
		
		return saleRepository.getFeatureSales();
	}

	@Override
	public List<Sale> getFrontpageSales() {
		
		return saleRepository.getFrontPageSales();
	}

	@Override
	public Sale findOne(Long saleId) {
		
		return saleRepository.findOne(saleId);
	}

	@Override
	public List<Sale> findAll() {
		
		return (List<Sale>) saleRepository.findAll();
	}

	@Override
	public List<Sale> findSalesByCategory(int catId) {
		
		return saleRepository.findSaleByaCategory(catId);
	}

	@Override
	public List<Sale> findSalesByStore(int storeId) {
		
		return saleRepository.findSalesByStore(storeId);
	}

}
