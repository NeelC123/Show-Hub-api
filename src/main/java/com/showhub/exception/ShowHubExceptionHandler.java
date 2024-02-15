package com.showhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShowHubExceptionHandler {

	@ExceptionHandler(value = { ShowHubExceptionNotFound.class })
	public ResponseEntity<Object> handleNotFoundException(ShowHubExceptionNotFound channelAdminNotFound) {
		ShowHubException adminException = new ShowHubException(channelAdminNotFound.getMessage(),
				channelAdminNotFound.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(adminException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { ShowHubOk.class })
	public ResponseEntity<Object> handleOkException(ShowHubOk hubOk) {
		ShowHubException adminException = new ShowHubException(hubOk.getMessage(), hubOk.getCause(), HttpStatus.OK);
		return new ResponseEntity<>(adminException, HttpStatus.OK);
	}

	@ExceptionHandler(value = { ShowHubCreated.class })
	public ResponseEntity<Object> handleCreatedException(ShowHubCreated hubCreated) {
		ShowHubException adminException = new ShowHubException(hubCreated.getMessage(), hubCreated.getCause(),
				HttpStatus.CREATED);
		return new ResponseEntity<>(adminException, HttpStatus.CREATED);
	}

	@ExceptionHandler(value = { ShowHubUnauthorized.class })
	public ResponseEntity<Object> handleCreatedException(ShowHubUnauthorized hubUnauthorized) {
		ShowHubException adminException = new ShowHubException(hubUnauthorized.getMessage(), hubUnauthorized.getCause(),
				HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(adminException, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = { ShowHubForbidden.class })
	public ResponseEntity<Object> handleForbiddenException(ShowHubForbidden hubUnauthorized) {
		ShowHubException adminException = new ShowHubException(hubUnauthorized.getMessage(), hubUnauthorized.getCause(),
				HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(adminException, HttpStatus.FORBIDDEN);
	}

}
