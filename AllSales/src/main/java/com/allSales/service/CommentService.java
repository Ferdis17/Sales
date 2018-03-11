package com.allSales.service;

import java.util.List;

import com.allSales.domain.Comment;
import com.allSales.domain.CommentDTO;

public interface CommentService {

		CommentDTO save(CommentDTO comment, Long saleId);
		
		List<Comment> getCommentVySaleId(String saleId);
}
