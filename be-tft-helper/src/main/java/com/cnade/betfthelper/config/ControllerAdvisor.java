package com.cnade.betfthelper.config;

import com.cnade.betfthelper.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleSquadraException(CustomException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        body.put("timestamp", formatDateTime);
        body.put("COD", ex.cod());
        body.put("DES", ex.desc());
        return ResponseEntity.status(ex.cod()).body(body);
    }

}
