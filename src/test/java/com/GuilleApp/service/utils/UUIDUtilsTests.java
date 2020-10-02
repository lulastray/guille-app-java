package com.GuilleApp.service.utils;

import com.GuilleApp.service.exceptions.ExceptionConstants;
import com.GuilleApp.service.exceptions.NotValidUUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UUIDUtilsTests {

    @Test
    void should_parse_uuid_from_string() {
        //GIVEN
        String id = "83dd97c2-64af-4a82-b8af-ffa3d00f51ce";
        //WHEN
        UUID actual = UUIDUtils.parseUUID(id);
        //THEN
        Assertions.assertNotNull(actual);
    }

    @Test
    void should_fail_parse_if_string_is_null() {
        String id = null;
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            UUID actual = UUIDUtils.parseUUID(id);
        });
        assertEquals(ExceptionConstants.REQUIRED_ID, e.getMessage());
    }

    @Test
    void shoul_fail_parse_if_string_is_not_valid() {
        String id = "batman";
        Exception e = assertThrows(NotValidUUID.class, ()->{
            UUID actual = UUIDUtils.parseUUID(id);
        });
        assertEquals(String.format(ExceptionConstants.NOT_VALID_UUID,id), e.getMessage());
    }
}
