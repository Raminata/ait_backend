package de.ait.task.controllers;

import de.ait.task.controllers.api.UsersApi;
import de.ait.task.dto.*;
import de.ait.task.dto.pages.TasksDto;
import de.ait.task.dto.pages.UsersDto;
import de.ait.task.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public ResponseEntity<UserDto> addUser(NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(newUser));
    }


    @Override
    public ResponseEntity<UsersDto> getAllUsers(UsersRequest request) {
        return ResponseEntity
                .ok(usersService.getAllUsers(request));
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {
        return ResponseEntity
                .ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UpdateUserDto updateUser) {
        return ResponseEntity
                .ok(usersService.updateUser(userId, updateUser));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<TasksDto> getTasksOfUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getTasksOfUser(userId));
    }
}