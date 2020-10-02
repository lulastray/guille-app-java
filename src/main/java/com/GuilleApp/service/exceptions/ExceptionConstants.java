package com.GuilleApp.service.exceptions;

public class ExceptionConstants {

    //UTILS
    public static final String REQUIRED_ID = "Id is required";
    public static final String NOT_VALID_UUID = "%s is not a valid UUID";

    //USERS
    public static final String USER_NOT_FOUND = "Can not find a user with username %s";
    public static final String USER_WITHOUT_ROLES = "User %s has not roles";
    public static final String NOT_ENOUGH_POINTS = "Not enough points to exchange the reward";


    //TASKS
    public static final String TASK_NOT_FOUND = "Can not find a task with id %s";
    //REWARDS
    public static final String REWARD_ALREADY_EXCHANGED = "Cant not exchange this rewards, is already exchanged";
}
