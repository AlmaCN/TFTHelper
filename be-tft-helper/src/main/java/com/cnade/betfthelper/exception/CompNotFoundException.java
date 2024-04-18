package com.cnade.betfthelper.exception;

import org.springframework.http.HttpStatus;

public class CompNotFoundException extends CustomException{
    @Override
    public HttpStatus cod() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String desc() {
        return "Comp not found";
    }
}
