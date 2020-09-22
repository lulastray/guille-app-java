package com.GuilleApp.service.utils;

import com.GuilleApp.service.exceptions.NotValidUUID;

import java.util.UUID;

public class UUIDUtils {
    public final static UUID parseUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new NotValidUUID(id);
        }
    }
}
