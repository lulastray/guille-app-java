package com.GuilleApp.model.tasks;


import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.model.tasks.enums.TaskProgress;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class Task implements Serializable {

    private static final long serialVersionUID = -5116328897591134655L;
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    private String description;

    @Column(name="task_progress")
    private TaskProgress taskProgress;

    @NotNull
    private Long value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private AppUser user;

    public Task(){
    }

    public Task(UUID id, String name, String description, TaskProgress taskprogress, long value, AppUser user){
        this.id = id;
        this.name = name;
        this.description = description;
        this.taskProgress = taskprogress;
        this.value = value;
        this.user = user;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskProgress getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(TaskProgress taskProgress) {
        this.taskProgress = taskProgress;
    }

    public Boolean isCompleted(){ return taskProgress != null ? taskProgress.equals(TaskProgress.COMPLETED) : false; }

    public Boolean isInProgress(){ return taskProgress != null ? taskProgress.equals(TaskProgress.IN_PROGRESS) : false; }

    public Boolean isDeleted(){ return taskProgress != null ? taskProgress.equals(TaskProgress.DELETED) : false; }
}
