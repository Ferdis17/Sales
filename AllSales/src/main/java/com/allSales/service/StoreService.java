package com.allSales.service;

import java.util.List;

import com.allSales.domain.Store;


public interface StoreService {

	List<Store> findAll();

    Store findOne(Integer storeId);

    List<Store> getRelatedStores(Integer storeId);
}
