package com.allSales.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allSales.domain.CommentDTO;
import com.allSales.service.CommentService;

@RestController
@RequestMapping(value = "rest/comment")
public class CommentRestController {
	
	@Autowired
	private CommentService commentSecrvice;

	@PostMapping(value = "/{saleId}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public CommentDTO saveComment(@Valid @RequestBody CommentDTO comment, @PathVariable("saleId") Long saleId) {
		return commentSecrvice.save(comment, saleId);
	}

}
