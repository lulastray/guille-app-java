package com.GuilleApp.mother.tasks;

import com.GuilleApp.model.tasks.Task;
import com.GuilleApp.model.tasks.enums.TaskProgress;
import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.mother.MotherCreator;
import com.GuilleApp.mother.users.AppUserMother;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskMother {
    public static final Task random(){
        return new Task(
                null,
                MotherCreator.random().lorem().characters(),
                MotherCreator.random().lorem().characters(),
                TaskProgress.IN_PROGRESS,
                MotherCreator.random().number().numberBetween(10L,50L),
                AppUserMother.random()

        );
    }


    public static final Task randomWithUser(AppUser user) {
        Task task = random();
        task.setUser(user);
        return task;

    }

    public static final List<Task> randomListWithUser(int num, AppUser user) {
        List<Task> tasks = new ArrayList<>();

        for(int i=0; i<num; i++){
            tasks.add(randomWithUser(user));
        }
        return tasks;
    }
}
