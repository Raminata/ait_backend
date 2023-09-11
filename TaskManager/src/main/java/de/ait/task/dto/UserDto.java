package de.ait.task.dto;

import de.ait.task.models.User;
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
@Schema(description = "The user of the API systems")
public class UserDto {

    @Schema(description = "The ID of the User", example = "1")
    private Long id;

    @Schema(description = "Email of the user", example = "simple@mail.com" )
    private String email;

    @Schema(description = "The role of the User - ADMIN, USER, MANAGER", example = "ADMIN")
    private String role;

    @Schema(description = "The status of the user - NOT_CONFIRMED, " +
            "CONFIRMED, BANNED, DELETED", example = "CONFIRMED")
    private String state;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .state(user.getState().name())
                .role(user.getRole().name())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
