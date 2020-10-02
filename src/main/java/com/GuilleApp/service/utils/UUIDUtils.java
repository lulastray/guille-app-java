package com.GuilleApp.service.utils;

import com.GuilleApp.service.exceptions.ExceptionConstants;
import com.GuilleApp.service.exceptions.NotValidUUID;
import org.springframework.util.Assert;

import java.util.UUID;

public class UUIDUtils {
    public final static UUID parseUUID(String id) {
        Assert.notNull(id,ExceptionConstants.REQUIRED_ID);

        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new NotValidUUID(id);
        }
    }
}
