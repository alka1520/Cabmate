package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	//customer exception
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	//login exception
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(LoginException ce, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	// driver exception
	@ExceptionHandler(DriverException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(DriverException ce, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	// admin exception
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(AdminException ce, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	//cab exception
	@ExceptionHandler(CabException.class)
	public ResponseEntity<MyErrorDetails> cabExceptionHandler(CabException ce, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	//booking exception
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyErrorDetails> bookingExceptionHandler(BookingException ce, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<MyErrorDetails> anyExceptionHandler(Exception ie, WebRequest req) {
//		
//		MyErrorDetails err = new MyErrorDetails();
//		err.setTimestamp(LocalDateTime.now());
//		err.setMessage(ie.getMessage());
//		err.setDetails(req.getDescription(false));
//		
//		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException ie, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myInvalidDataExpHandler(MethodArgumentNotValidException me) {
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
}
