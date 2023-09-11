package de.ait.task.dto;

import de.ait.task.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Task which needs to be executed")
public class TaskDto {

    @Schema(description = "ID of the Task", example = "1")
    private Long id;

    @Schema(description = "Title of the Task", example = "Urgent Notice")
    private String title;

    @Schema(description = "Description of the Task", example = "Go to the bank and pay the electricity bill")
    private String description;

    @Schema(description = "ID of the User who needs to execute or do the Task", example = "1")
    private UserInTaskDto executor;

    @Schema(description = "The start date of the task in  the format YYYY-MM-DD", example = "2022-02-02")
    private String startDate;

    @Schema(description = "The finish date of the task in  the format YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    public static TaskDto from(Task task) {
        TaskDto result = TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();

        if (task.getExecutor() != null) {
            result.setExecutor(UserInTaskDto.from(task.getExecutor()));
        }

        if (task.getStartDate() != null) {
            result.setStartDate(task.getStartDate().toString());
        }

        if (task.getFinishDate() != null) {
            result.setFinishDate(task.getFinishDate().toString());
        }

        return result;
    }

    public static List<TaskDto> from(List<Task> tasks) {
        return tasks.stream()
                .map(TaskDto::from)
                .collect(Collectors.toList());
    }
}
