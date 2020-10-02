package com.GuilleApp.service.tasks;

import com.GuilleApp.model.tasks.Task;
import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.mother.tasks.TaskMother;
import com.GuilleApp.mother.users.AppUserMother;
import com.GuilleApp.repository.TaskRepository;
import com.GuilleApp.service.exceptions.ExceptionConstants;
import com.GuilleApp.service.exceptions.TaskNotFound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Rollback
@Transactional
@SpringBootTest
public class TaskServiceIntTests {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EntityManager em;

    private List<Task> tasks;

    private AppUser user;

    @BeforeEach
    void setUp() {
        user = AppUserMother.random();
        em.persist(user);
        em.flush();
        tasks = TaskMother.randomListWithUser(5,user);
        tasks.forEach(task -> {
            em.persist(task);
            em.flush();
        });
    }

    @Test
    void should_find_all(){
        List<Task> actual = taskService.findAll();
        Assertions.assertEquals(tasks.size(),actual.size());
        for (int i=0; i<tasks.size();i++) {
            assertTask(tasks.get(i), actual.get(i));
        }
    }

    @Test
    void should_find_one(){
        Task expected = tasks.get(0);
        Task actual = taskService.findById(expected.getId().toString());
        assertTask(expected, actual);
    }

    @Test
    void should_fail_find_by_id_if_not_found(){
        UUID id = UUID.randomUUID();
        Exception e = Assertions.assertThrows(TaskNotFound.class, () -> {
            Task actual = taskService.findById(id.toString());
        });
        Assertions.assertEquals(String.format(ExceptionConstants.TASK_NOT_FOUND,id), e.getMessage());
    }

    @Test
    void should_fail_find_by_id_is_null(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            Task actual = taskService.findById(null);
        });
        Assertions.assertEquals(ExceptionConstants.REQUIRED_ID, e.getMessage());
    }

    @Test
    void should_create_a_task(){
        Task newTask = TaskMother.random();
        int oldSize = tasks.size();

        taskService.create(newTask);

        Assertions.assertEquals(oldSize +1, taskService.findAll().size());
        Task createdTask = taskService.findById(newTask.getId().toString());
        Assertions.assertEquals(newTask.getId(),createdTask.getId());
        Assertions.assertEquals(newTask.getName(),createdTask.getName());
        Assertions.assertEquals(newTask.getDescription(),createdTask.getDescription());
        Assertions.assertEquals(newTask.getValue(),createdTask.getValue());
    }

    private void assertTask(Task expected, Task actual){
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getDescription(), actual.getDescription());
        Assertions.assertEquals(expected.getId(), actual.getId());
    }

}
