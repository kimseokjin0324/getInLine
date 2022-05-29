package com.example.getInLine.error;

import com.example.getInLine.constant.ErrorCode;
import com.example.getInLine.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


//- view에대한 ControllerAdvice를 만드는 과정
@ControllerAdvice   //-전체컨트롤러의 동작을 감시
public class BaseExceptionHandler {

    //- GeneralException이 터졌을때
    @ExceptionHandler
    public ModelAndView general(GeneralException e) {

        ErrorCode errorCode = e.getErrorCode();
        HttpStatus httpStatus = errorCode.isClientSideError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView(
                "error",
                Map.of(
                        "statusCode", httpStatus.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage()
                ),
                httpStatus);
    }

    //- GeneralException이 아닌 일반 Exception을 처리하는 메소드
    @ExceptionHandler
    public ModelAndView exception(Exception e) {

        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus httpStatus =HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView(
                "error",
                Map.of(
                        "statusCode", httpStatus.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(e)
                ),
                httpStatus);
    }
}
