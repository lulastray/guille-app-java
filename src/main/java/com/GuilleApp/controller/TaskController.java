package com.GuilleApp.controller;

import com.GuilleApp.model.tasks.Task;
import com.GuilleApp.service.tasks.TaskService;
import com.GuilleApp.service.tasks.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAll(){ return taskService.findAll(); }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable String id) { return taskService.findById(id);}

    @PostMapping("/new")
    public void create(@RequestBody Task task) {
        taskService.create(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { taskService.delete(id);}

    @PutMapping("/progress/change")
    public void update(@RequestBody ChangeProgressDTO changeProgressDTO) { taskService.changeTaskProgress(changeProgressDTO);}


}
