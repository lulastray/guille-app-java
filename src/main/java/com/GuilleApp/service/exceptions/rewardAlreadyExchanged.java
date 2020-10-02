package com.GuilleApp.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class rewardAlreadyExchanged extends RuntimeException{

    public rewardAlreadyExchanged() {
        super(ExceptionConstants.REWARD_ALREADY_EXCHANGED);
    }

    public rewardAlreadyExchanged(Throwable cause) {
        super(ExceptionConstants.REWARD_ALREADY_EXCHANGED, cause);
    }

}
