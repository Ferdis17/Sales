package com.allSales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.allSales.domain.DomainError;
import com.allSales.domain.DomainErrors;
import com.allSales.exceptionHandler.AccessDeniedException;

@ControllerAdvice
public class ExceptionCotroller {
	
	@Autowired
	MessageSourceAccessor messageAccessor;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DomainErrors handleException(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("CommentValidationError");
		for(FieldError fieldError : fieldErrors) {
			DomainError error = new DomainError(messageAccessor.getMessage(fieldError));
			errors.addError(error);
		}
		return errors;
	}
	@ExceptionHandler(value = AccessDeniedException.class)
	public String accessDenied(AccessDeniedException exception, Model model) {
		model.addAttribute("link", exception.getLink());
		return "errorForbidden";
		
	}

}
