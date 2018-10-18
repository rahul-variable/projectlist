package com.demoapp.exception;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demoapp.vo.ExceptionResponse;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({Exception.class})
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		ExceptionResponse exResponse=new ExceptionResponse();
		exResponse.setErrorCode(500);
		exResponse.setMessage(ex.getMessage());
		exResponse.setDetails(request.getDescription(false));
		return new ResponseEntity<>(exResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exResponse=new ExceptionResponse();
		exResponse.setErrorCode(400);
		exResponse.setMessage("Validation Failed");
		exResponse.setDetails(ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(exResponse,HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exResponse=new ExceptionResponse();
		List<MediaType> mediaTypes = ex.getSupportedMediaTypes();
		if (!CollectionUtils.isEmpty(mediaTypes)) {
			exResponse.setDetails("Media Type Supported are: "+mediaTypes);
		}

		
		exResponse.setErrorCode(400);
		exResponse.setMessage("Invalid Media Type");
		
		return new ResponseEntity<>(exResponse,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
}
