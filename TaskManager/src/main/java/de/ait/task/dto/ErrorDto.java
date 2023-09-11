package de.ait.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Information about Error")
public class ErrorDto {

    @Schema(description = "Error message", example = "The requested User ID was not found")
    private String message;
}
