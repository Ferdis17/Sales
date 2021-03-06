package com.allSales.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

public class Comment implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long id;

    private Date postingTime;

    @NotEmpty(message = "{NotEmpty.validation}")
    private String title;

    @NotEmpty(message = "{NotEmpty.validation}")
    @Column(name="content", columnDefinition="TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "saleId")
    private Sale sale;

    public Comment() {}

    public Comment(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(Date postingTime) {
        this.postingTime = postingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

}
