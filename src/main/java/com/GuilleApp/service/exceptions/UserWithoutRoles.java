package com.GuilleApp.service.exceptions;




public class UserWithoutRoles extends RuntimeException{
    public UserWithoutRoles() {
        super();
    }

    public UserWithoutRoles(String name) {
        super(String.format(ExceptionConstants.USER_WITHOUT_ROLES, name));
    }

    public UserWithoutRoles(String name, Throwable cause) {
        super(String.format(ExceptionConstants.USER_WITHOUT_ROLES, name), cause);
    }
}
