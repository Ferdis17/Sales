package com.allSales.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.*;
import org.springframework.web.multipart.MultipartFile;


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Email(message = "{Email.User.email.validation}")
	@NotEmpty(message = "{NotEmpty.validation}")
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	@Size(min = 6, message = "{Size.User.password.validation}")
	@NotEmpty(message = "{NotEmpty.validation}")
	private String password;
	
	@NotEmpty(message = "{NotEmpty.validation}")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "{NotEmpty.validation}")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "active")
	private int active;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	@Valid
	private Address address;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	@JsonIgnore
	@Transient
	private MultipartFile profilePicture;

	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sale> sales = new ArrayList<>();

	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Blog> blogs = new ArrayList<>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@XmlTransient
	public MultipartFile getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(MultipartFile profilePicture) {
		this.profilePicture = profilePicture;
	}

	public List<Sale> getDeals() {
		return sales;
	}

	public void setDeals(List<Sale> sales) {
		this.sales = sales;
	}

	public void addSale(Sale sale) {
		sales.add(sale);
		sale.setUser(this);
	}

	public void removeSale(Sale sale) {
		sales.remove(sale);
		sale.setUser(null);
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public void addBlog(Blog blog) {
		blogs.add(blog);
		blog.setUser(this);
	}

	public void removeBlog(Blog blog) {
		blogs.remove(blog);
		blog.setUser(null);
	}
}
