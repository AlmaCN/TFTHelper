package com.cnade.betfthelper.exception;

import org.springframework.http.HttpStatus;

public class PlayerNotFoundException extends CustomException{
    @Override
    public HttpStatus cod() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String desc() {
        return "Player not found";
    }
}
