package com.GuilleApp.controller.tasks;

import com.GuilleApp.model.tasks.enums.TaskProgress;

public class ChangeProgressDTO {

    private String id;

    private TaskProgress taskProgress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaskProgress getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(TaskProgress taskProgress) {
        this.taskProgress = taskProgress;
    }
}
