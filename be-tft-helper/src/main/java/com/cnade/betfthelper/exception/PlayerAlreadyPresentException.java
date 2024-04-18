package com.cnade.betfthelper.exception;

import org.springframework.http.HttpStatus;

public class PlayerAlreadyPresentException extends CustomException{
    @Override
    public HttpStatus cod() {
        return HttpStatus.CONFLICT;
    }

    @Override
    public String desc() {
        return "Player already present";
    }
}
