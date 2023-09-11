package de.ait.task.services;

import de.ait.task.dto.TaskDto;
import de.ait.task.dto.NewTaskDto;


public interface TasksService {
    TaskDto addTask(NewTaskDto newTask);
}
