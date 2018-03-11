package com.allSales.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;

@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    @NotEmpty(message = "{NotEmpty.validation}")
    private String street;

    @NotEmpty(message = "{NotEmpty.validation}")
    private String city;

    @Size(min = 2, max = 2, message = "{Size.Address.state.validation}")
    @Pattern(regexp = "^[A-Z]{2,2}$", message = "{Pattern.Address.state.validation}")
    @NotEmpty(message = "{NotEmpty.validation}")
    private String state;

    @Pattern(regexp = "^[\\d]{5,5}$", message = "{Pattern.Address.zip.validation}")
    @NotEmpty(message = "{NotEmpty.validation}")
    private String zip;

    public Address() {}

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
    
}
