package com.GuilleApp.service.tasks;

import com.GuilleApp.controller.ChangeProgressDTO;
import com.GuilleApp.model.tasks.Task;
import com.GuilleApp.repository.TaskRepository;
import com.GuilleApp.security.SecurityUtils;
import com.GuilleApp.service.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SecurityUtils securityUtils;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Task findById(String id) {
        System.out.println("hola " + id);
        Optional<Task> movieOptional = taskRepository.findById(UUIDUtils.parseUUID(id));
        return movieOptional.get();
    }

    @Override
    @Transactional
    public void create (Task task) {
        taskRepository.save(task);
    }

 /*   public Task update (Task task, String id) {
        Task taskDb = findById(id);

    }*/
    @Override
    @Transactional
    public Task changeTaskProgress(ChangeProgressDTO changeProgressDTO){
        Task taskToChange = findById(changeProgressDTO.getId());
        System.out.println(taskToChange);
        taskToChange.setTaskProgress(changeProgressDTO.getTaskProgress());
        return taskRepository.save(taskToChange);
    }
    @Override
    @Transactional
    public void delete(String id) {
        System.out.println("to delete " + id);
        Task taskDb= findById(id);
        if(taskDb != null) {
            taskRepository.deleteById(UUIDUtils.parseUUID(id));
        }

    }
}
