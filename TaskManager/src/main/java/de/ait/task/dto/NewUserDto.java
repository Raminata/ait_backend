package de.ait.task.dto;

import de.ait.task.validation.constraints.NotWeakPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;


@Data
@Builder
@Schema(description = "Add new user")
public class NewUserDto {

    @Schema(description = "Email of the User", example = "simple@mail.com")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Schema(description = "Password of the User", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 1000)
    @NotWeakPassword
    private String password;
}
