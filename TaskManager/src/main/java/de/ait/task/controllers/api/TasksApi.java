package de.ait.task.controllers.api;

import de.ait.task.dto.TaskDto;
import de.ait.task.dto.NewTaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tags(value = {
        @Tag(name = "Tasks")
})
@RequestMapping("/api/tasks")
public interface TasksApi {

    @Operation(summary = "Create new task for the user", description = "Only USER Roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "The User ID is mismatching from the system",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "201", description = "Added new Task",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
                    })
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<TaskDto> addTask(@RequestBody NewTaskDto newTask);
}
