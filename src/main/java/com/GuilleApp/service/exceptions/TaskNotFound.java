package com.GuilleApp.service.exceptions;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound() {
        super();
    }

    public TaskNotFound(String id) {
        super(String.format(ExceptionConstants.TASK_NOT_FOUND, id));
    }

    public TaskNotFound(String id, Throwable cause) {
        super(String.format(ExceptionConstants.TASK_NOT_FOUND, id), cause);
    }
}

