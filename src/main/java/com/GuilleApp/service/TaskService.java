package com.GuilleApp.service;

import com.GuilleApp.model.tasks.Task;
import com.GuilleApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        System.out.println("hola " + id);
        Optional<Task> movieOptional = taskRepository.findById(parseUUID(id));
        return movieOptional.get();
    }


    public void create (Task task) {
        taskRepository.save(task);
    }

 /*   public Task update (Task task, String id) {
        Task taskDb = findById(id);

    }*/

    public void delete(String id) {
        System.out.println("to delete " + id);
        Task taskDb= findById(id);
        if(taskDb != null) {
            taskRepository.deleteById(parseUUID(id));
        }

    }
    private UUID parseUUID(String id) {
        return UUID.fromString(id);
    }
}
