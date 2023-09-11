package de.ait.timepad.dto;

import de.ait.timepad.models.Article;
import de.ait.timepad.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Статья о каком-либо пользователе")
public class EventDto {

    @Schema(description = "Идентификатор статьи", example = "1")
    private Long id;

    @Schema(description = "Текст статьи", example = "Текст о каком-либо пользователе...")
    private String text;


    public static EventDto from(Event event) {
        EventDto result = EventDto.builder()
                .id(event.getId())
                .text(event.getText())
                .build();

        return result;
    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream()
                .map(EventDto::from)
                .collect(Collectors.toList());
    }
}
