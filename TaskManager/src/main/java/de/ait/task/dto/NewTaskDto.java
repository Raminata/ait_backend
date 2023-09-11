package de.ait.task.dto;

import de.ait.task.validation.constraints.NotBeforeToday;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Builder
@Schema(description = "Add new task")
public class NewTaskDto {

    @Schema(description = "Title of the Task", example = "Urgent Notice")
    @NotNull
    @NotBlank
    private String title;

    @Schema(description = "Description of the Task", example = "Go to the bank and pay the electricity bill")
    @NotNull
    @NotBlank
    private String description;

    @Schema(description = "ID of the User who needs to execute or do the Task", example = "1")
    private Long executorUserId;

    @Schema(description = "The start date of the task in  the format YYYY-MM-DD", example = "2022-02-02")
    @NotBeforeToday
    private String startDate;

    @Schema(description = "The finish date of the task in  the format YYYY-MM-DD", example = "2022-02-02")
    @NotBeforeToday
    private String finishDate;
}
