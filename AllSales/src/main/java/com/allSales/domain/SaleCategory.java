package com.allSales.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "saleCat")
public class SaleCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="saleCatId")
	private int id;
	
	@Column(name = "saleCatName")
	private String name;
	
	@Column(name = "description", columnDefinition ="TEXT")
	private String description;
	
	@OneToMany(
			mappedBy = "saleCategory",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	private List<Sale> sales = new ArrayList<>();
	
	
	public SaleCategory() {
		
	}
	public SaleCategory(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public  void setDeal(List<Sale> sale) {
		this.sales = sale;
	}
	

}
