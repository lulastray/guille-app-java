package com.GuilleApp.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotEnoughPoints extends RuntimeException{

    public NotEnoughPoints() {
        super(ExceptionConstants.NOT_ENOUGH_POINTS);
    }

    public NotEnoughPoints(Throwable cause) {
        super(ExceptionConstants.NOT_ENOUGH_POINTS, cause);
    }

}
