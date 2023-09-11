package de.ait.task.dto.pages;

import de.ait.task.dto.UserDto;
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
    @Schema(description = "The list of the users")
    private List<UserDto> users;

    @Schema(description = "Total count of the users", example = "1")
    private Long count;

    @Schema(description = "Total page count", example = "3")
    private Integer pagesCount;
}
