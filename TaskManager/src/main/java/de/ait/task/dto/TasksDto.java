package de.ait.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "The tasks of the User")
public class TasksDto {

    @Schema(description = "The list of Tasks")
    private List<TaskDto> tasks;

    @Schema(description = "The total count of tasks for the User", example = "2")
    private Integer count;
}

