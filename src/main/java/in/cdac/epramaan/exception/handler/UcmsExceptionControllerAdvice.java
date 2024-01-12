package in.cdac.epramaan.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.cdac.epramaan.exception.UserDataNotSavedException;
import in.cdac.epramaan.util.ApiError;

@RestControllerAdvice
public class UcmsExceptionControllerAdvice {
	
	@ExceptionHandler(value=UserDataNotSavedException.class)
	public ResponseEntity<ApiError> handelUserDataNotSavedException(UserDataNotSavedException e) {
		
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(), new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
