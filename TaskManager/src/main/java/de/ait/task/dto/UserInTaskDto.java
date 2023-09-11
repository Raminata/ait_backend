package de.ait.task.dto;

import de.ait.task.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "The information about the User in the Task")
public class UserInTaskDto {
    @Schema(description = "ID of the user", example = "1")
    private Long id;

    @Schema(description = "Email of the User", example = "user@mail.com")
    private String email;

    public static UserInTaskDto from(User user) {
        return UserInTaskDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
