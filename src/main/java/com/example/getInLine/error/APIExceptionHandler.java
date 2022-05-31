package com.example.getInLine.error;

import com.example.getInLine.constant.ErrorCode;
import com.example.getInLine.dto.APIErrorResponse;
import com.example.getInLine.exception.GeneralException;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;


//- API에 대한 ControllerAdvice를 만드는 과정
@RestControllerAdvice(annotations = {RestController.class, RepositoryRestController.class})
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    //- ConstraintViolationException 터졌을때
    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        return handleExceptionInternal(e, ErrorCode.VALIDATION_ERROR, HttpHeaders.EMPTY, request);
    }


    //- GeneralException이 터졌을때
    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e, WebRequest request) {
        return handleExceptionInternal(e, e.getErrorCode(), HttpHeaders.EMPTY, request);
    }

    //- GeneralException이 아닌 일반 Exception을 처리하는 메소드
    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        return handleExceptionInternal(e, ErrorCode.INTERNAL_ERROR, HttpHeaders.EMPTY, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal
            (Exception ex,
             Object body,
             HttpHeaders headers,
             HttpStatus status,
             WebRequest request) {
        return handleExceptionInternal(ex, ErrorCode.valueOf(status), headers, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, ErrorCode errorCode, HttpHeaders headers, WebRequest request) {
        return super.handleExceptionInternal(
                e,
                APIErrorResponse.of(false, errorCode.getCode(), errorCode.getMessage(e)),
                headers,
                errorCode.getHttpStatus(),
                request
        );
    }

}
