package com.GuilleApp.service.tasks;

import com.GuilleApp.controller.ChangeProgressDTO;
import com.GuilleApp.model.tasks.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(String id);
    void create (Task task);
    Task changeTaskProgress(ChangeProgressDTO changeProgressDTO);
    void delete(String id);

}
