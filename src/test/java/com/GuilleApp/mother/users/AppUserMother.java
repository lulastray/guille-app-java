package com.GuilleApp.mother.users;

import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.model.users.Role;
import com.GuilleApp.mother.MotherCreator;

import java.util.ArrayList;
import java.util.List;

public class AppUserMother {
    public static final AppUser random() {
        return new AppUser(
                null,
                MotherCreator.random().name().username(),
                MotherCreator.random().internet().password(),
                List.of(new Role("ROLE_USER")),
                MotherCreator.random().number().numberBetween(0L, 80L)
        );
    }

}
