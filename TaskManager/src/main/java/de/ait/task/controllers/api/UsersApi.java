package de.ait.task.controllers.api;

import de.ait.task.dto.*;
import de.ait.task.dto.pages.TasksDto;
import de.ait.task.dto.pages.UsersDto;
import de.ait.task.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Tags(value = {
        @Tag(name = "Users")
})
@RequestMapping("/api/users")
public interface UsersApi {

    @Operation(summary = "Create new User", description = "Only ADMIN role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<UserDto> addUser(@Parameter(required = true, description = "User") @RequestBody @Valid NewUserDto newUser);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Users",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UsersDto.class))
                    }),
            @ApiResponse(responseCode = "403", description = "Попытка сортировки по запрещенному полю",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    })
    })
    @Operation(summary = "Получение пользователей", description = "Доступно всем")
    @GetMapping
    ResponseEntity<UsersDto> getAllUsers(UsersRequest usersRequest);

    @Operation(summary = "Delete user", description = "OnlyADMIN Role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "User deleted",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @DeleteMapping("/{user-id}")
    ResponseEntity<UserDto> deleteUser(@Parameter(required = true, description = "The ID of the user", example = "2")
                       @PathVariable("user-id") Long userId);

    @Operation(summary = "Update of the User", description = "Only ADMIN Role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "403", description = "Role not correct for this action",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @PutMapping("/{user-id}")
    ResponseEntity<UserDto> updateUser(@Parameter(required = true, description = "The ID of the User", example = "2")
                       @PathVariable("user-id") Long userId,
                       @RequestBody UpdateUserDto updateUser);

    @Operation(summary = "Get user", description = "All roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Information about the user",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @GetMapping("/{user-id}")
    ResponseEntity<UserDto> getUser(@Parameter(required = true, description = "The ID of the user", example = "2")
                       @PathVariable("user-id") Long userId);

    @Operation(summary = "Get all tasks for the user", description = "All roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "The user is not found",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Tasks from the User",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TasksDto.class))
                    })
    })
    @GetMapping("/{user-id}/tasks")
    ResponseEntity<TasksDto> getTasksOfUser(@Parameter(required = true, description = "The ID of the user", example = "2")
                    @PathVariable("user-id") Long userId);

}
