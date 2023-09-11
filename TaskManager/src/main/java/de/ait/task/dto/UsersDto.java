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
@Schema(description = "The list of the user")
public class UsersDto {
    @Schema(description = "The users of system")
    private List<UserDto> users;

    @Schema(description = "Total count of users", example = "1")
    private Integer count;
}
