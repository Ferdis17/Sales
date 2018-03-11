package com.allSales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.allSales.domain.Store;
import com.allSales.repository.StoreRepository;

public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreRepository storeRepository;
	

	@Override
	public List<Store> findAll() {
		
		return (List<Store>) storeRepository.findAll();
	}

	@Override
	public Store findOne(Integer storeId) {
		
		return storeRepository.findOne(storeId);
	}

	@Override
	public List<Store> getRelatedStores(Integer storeId) {
		
		return storeRepository.getRelatedStore(storeId);
	}

	

}
