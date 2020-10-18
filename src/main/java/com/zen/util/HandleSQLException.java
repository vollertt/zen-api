package com.zen.util;

import org.hibernate.TransientPropertyValueException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * ExceptionHandler associados com JPA/Hibernate e persistencias. Requisitada pelos Controlers (Resources) da Api
 */
@ControllerAdvice
public class HandleSQLException {
	
	private LogPrint log= new LogPrint();
	
	@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleRunTimeException(RuntimeException e) {
		log.get("ExceptionHandler RunTime : "+ e.getMessage(),"error");
		String ex=e.getMessage();
		HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
		if(e.getMessage().contains("hibernate.TransientPropertyValueException")) {
			ex="Erro com os parâmetros do objeto!";
			status=HttpStatus.UNPROCESSABLE_ENTITY;
		}
		if(e.getMessage().contains("JSON parse error: Cannot construct instance of")) {
			ex="Erro com os parâmetros do objeto!";
			status=HttpStatus.UNPROCESSABLE_ENTITY;
		}
        return error(status, ex);
    }
	
	@ExceptionHandler({DataAccessResourceFailureException.class})
    public ResponseEntity<?> handleDataAccessResourceFailureException(DataAccessResourceFailureException e) {
		log.get("ExceptionHandler DataAccessResourceFailureException : "+ e.getMessage(),"error");
        return error(HttpStatus.NOT_FOUND, e.getMessage());
    }
	
	@ExceptionHandler({TransientPropertyValueException.class})
    public ResponseEntity<?> handleTransientPropertyValueException(TransientPropertyValueException e) {
		log.get("ExceptionHandler TransientPropertyValueException : "+ e.getMessage(),"error");
        return error(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }
	
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    	log.get("ExceptionHandler DataIntegrityViolationException : "+ e.getMessage(),"error");
    	String ex=e.getMessage();
		if(e.getMessage().contains("could not execute statement; SQL")) {
			ex="Erro com os parâmetros do objeto!";
		}
        return error(HttpStatus.UNPROCESSABLE_ENTITY, ex);
    }

    private ResponseEntity<?> error(HttpStatus status, String e) {
        log.get("Exception tratada : "+ e,"error");
        MesssageException msex=new MesssageException(status.value(), status.name(), e);
        return new ResponseEntity<Object>(msex, new HttpHeaders(), status);
    }

}
