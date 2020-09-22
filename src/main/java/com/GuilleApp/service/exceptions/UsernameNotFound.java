package com.GuilleApp.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class UsernameNotFound extends RuntimeException{
    public UsernameNotFound() {
        super();
    }

    public UsernameNotFound(String name) {
        super(String.format(ExceptionConstants.USER_NOT_FOUND, name));
    }

    public UsernameNotFound(String name, Throwable cause) {
        super(String.format(ExceptionConstants.USER_NOT_FOUND, name), cause);
    }

}
