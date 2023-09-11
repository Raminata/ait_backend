package de.ait.task.dto.pages;

import de.ait.task.dto.TaskDto;
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

    @Schema(description = "The total count of pages", example = "3")
    private Integer pagesCount;
}
