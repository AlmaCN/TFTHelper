package com.cnade.betfthelper.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {
    public HttpStatus cod() {return null;}
    public String desc() {return null;}
}
