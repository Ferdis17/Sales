package com.allSales.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class Store {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int id;

//    @NotEmpty(message = "{NotEmpty.validation}")
    @Column(name = "store_name")
    private String name;

    @Column(name="description", columnDefinition="TEXT")
    private String description;

//    @OneToMany(cascade = CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinTable(name = "deal_store")
//    private List<Deal> deal;
//
//    public List<Deal> getDeal() {
//        return deal;
//    }
//
//    public void setDeal(List<Deal> deal) {
//        this.deal = deal;
//    }

    @OneToMany(
            mappedBy = "store",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Sale> sales = new ArrayList<>();

    public Store() {
    }

    public Store(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sale> getSale() {
        return sales;
    }

    public void setSale(List<Sale> sale) {
        this.sales = sale;
    }
}
