package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@Schema(description = "Добавляемая статья")
public class NewEventDto {

    @Schema(description = "Текст статьи", example = "Текст о пользователе...")
    private String text;

}
