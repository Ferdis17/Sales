package com.allSales.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "sale")
public class Sale implements Serializable{
	
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "saleId")
	    private Long id;

	    @NotEmpty(message = "{NotEmpty.validation}")
	    @URL
	    private String saleUrl;

	    @NotEmpty(message = "{NotEmpty.validation}")
	    private String saleTitle;

	    @Min(value=0, message="{Min.Deal.unitPrice.validation}")
	    @Digits(integer=8,fraction=2, message="{Digits.Deal.unitPrice.validation}")
	    @NotNull(message= "{NotNull.validation}")
	    private BigDecimal price;

	    private Date postDate;

	    @NotEmpty(message = "{NotEmpty.validation}")
	    @Column(name="description", columnDefinition="TEXT")
	    private String description;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "deal_cat_id")
	    private SaleCategory saleCategory;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "store_id")
	    private Store store;

	    private Boolean isFeature;
	    private Boolean isFrontPage;

	    @JsonIgnore
	    @Transient
	    private MultipartFile saleImage;

	    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	    @JoinColumn(name = "user_id")
	    private User user;

	    @OneToMany(
	            mappedBy = "deal",
	            cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            orphanRemoval = true
	    )
	    private List<Comment> comments = new ArrayList<>();

	    public Sale() {}

	    public Sale(Long id, String saleTitle) {
	        this.id = id;
	        this.saleTitle = saleTitle;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getSaleUrl() {
	        return saleUrl;
	    }

	    public void setSaleUrl(String dealUrl) {
	        this.saleUrl = dealUrl;
	    }

	    public String getSaleTitle() {
	        return saleTitle;
	    }

	    public void setSaleTitle(String dealTitle) {
	        this.saleTitle = dealTitle;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }

	    public Date getPostDate() {
	        return postDate;
	    }

	    public void setPostDate(Date postDate) {
	        this.postDate = postDate;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public SaleCategory getSaleCategory() {
	        return saleCategory;
	    }

	    public void setDealCategory(SaleCategory saleCategory) {
	        this.saleCategory = saleCategory;
	    }

	    public Store getStore() {
	        return store;
	    }

	    public void setStore(Store store) {
	        this.store = store;
	    }

	    @XmlTransient
	    public MultipartFile getSaleImage() {
	        return saleImage;
	    }

	    public void setDealImage(MultipartFile dealImage) {
	        this.saleImage = dealImage;
	    }

	    public Boolean getIsFeature() {
	        return isFeature;
	    }

	    public void setIsFeature(Boolean feature) {
	        isFeature = feature;
	    }

	    public Boolean getIsFrontPage() {
	        return isFrontPage;
	    }

	    public void setIsFrontPage(Boolean frontPage) {
	        isFrontPage = frontPage;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

	    public void addComment(Comment comment) {
	        comments.add(comment);
	        comment.setSale(this);
	    }

	    public void removeComment(Comment comment) {
	        comments.remove(comment);
	        comment.setSale(null);
	    }

	    public List<Comment> getComments() {
	        return comments;
	    }

	    public void setComments(List<Comment> comments) {
	        this.comments = comments;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Sale )) return false;
	        return id != null && id.equals(((Sale) o).id);
	    }
	    @Override
	    public int hashCode() {
	        return 31;
	    }

}
