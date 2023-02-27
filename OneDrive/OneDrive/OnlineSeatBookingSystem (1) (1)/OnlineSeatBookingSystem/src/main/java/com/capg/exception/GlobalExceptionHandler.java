package com.capg.exception;


import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ Exception.class })

	public ExceptionErrorMapper handleConflict(Exception ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ExceptionErrorMapper(uri, msg, new Date());
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleBadRequestException(MethodArgumentNotValidException ex) {
//		Map<String, String> errors = new LinkedHashMap<>();
//		
//		ex.getFieldErrors().stream().forEach(fieldError -> {
//			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//		});		
//		ResponseEntity<Map<String, String>> response = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//		return response;		
//	}
}
