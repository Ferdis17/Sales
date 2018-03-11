package com.allSales.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.allSales.domain.Comment;
import com.allSales.domain.CommentDTO;
import com.allSales.domain.Sale;
import com.allSales.repository.CommentRepository;

public class CommentServiceImpl implements CommentService {
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	CommentRepository commentRepository;
	

	@Override
	public CommentDTO save(CommentDTO commentDTO, Long saleId) {
		Sale sale = saleService.findOne(saleId);
		Comment comment = new Comment(commentDTO.getTitle(), commentDTO.getContent());
		Date today = new Date();
		comment.setPostingTime(today);
		
		if(sale != null) {
			sale.addComment(comment);
		}
		Comment saveComment = commentRepository.save(comment);
		CommentDTO returnCommentDTO = new CommentDTO(saveComment.getTitle(), saveComment.getContent());
		returnCommentDTO.setPostingTime(comment.getPostingTime());
		return returnCommentDTO;
	}

	@Override
	public List<Comment> getCommentVySaleId(String saleId) {
		

		return (List<Comment>)commentRepository.getCommentBySaleId(saleId);
	}

}
