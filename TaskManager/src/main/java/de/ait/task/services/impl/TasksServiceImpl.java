package de.ait.task.services.impl;

import de.ait.task.dto.TaskDto;
import de.ait.task.dto.NewTaskDto;
import de.ait.task.exceptions.IncorrectUserIdException;
import de.ait.task.models.Task;
import de.ait.task.models.User;
import de.ait.task.repositories.TasksRepository;
import de.ait.task.repositories.UsersRepository;
import de.ait.task.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static de.ait.task.dto.TaskDto.from;


@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final UsersRepository usersRepository;

    private final TasksRepository tasksRepository;

    @Override
    public TaskDto addTask(NewTaskDto newTask) {
        User user = usersRepository.findById(newTask.getExecutorUserId())
                .orElseThrow(() ->
                        new IncorrectUserIdException("Id <" + newTask.getExecutorUserId() + "> is not correct"));

        Task task = Task.builder()
                .title(newTask.getTitle())
                .description(newTask.getDescription())
                .executor(user)
                .startDate(LocalDate.parse(newTask.getStartDate()))
                .finishDate(LocalDate.parse(newTask.getFinishDate()))
                .build();

        tasksRepository.save(task);

        return from(task);
    }
}
