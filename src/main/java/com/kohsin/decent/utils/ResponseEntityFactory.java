package com.kohsin.decent.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public final class ResponseEntityFactory {

    private ResponseEntityFactory() {
    }

    public static <T> ResponseEntity<T> returnOkOrEmptyStatus(T body){
        if (Objects.isNull(body) || (body instanceof Boolean && !(Boolean) body)) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static <T> ResponseEntity<List<T>> returnListOk(List<T> body){
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
