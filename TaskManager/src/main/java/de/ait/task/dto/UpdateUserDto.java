package de.ait.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Schema(description = "Update the User data")
public class UpdateUserDto {

    @Schema(description = "The role of the User - USER, MANAGER", example = "USER")
    private String newRole;

    @Schema(description = "The status of the User - NOT_CONFIRMED, " +
            "CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String newState;
}
