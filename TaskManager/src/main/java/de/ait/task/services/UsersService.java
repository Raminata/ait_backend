package de.ait.task.services;

import de.ait.task.dto.*;
import de.ait.task.dto.pages.TasksDto;
import de.ait.task.dto.pages.UsersDto;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers(UsersRequest request);

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    TasksDto getTasksOfUser(Long userId);
}
