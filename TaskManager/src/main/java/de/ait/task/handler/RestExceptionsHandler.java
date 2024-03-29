package de.ait.task.handler;

import de.ait.task.dto.ErrorDto;
import de.ait.task.exceptions.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(RestException.class) // какой класс ошибок перехватываем
    public ResponseEntity<ErrorDto> handleRestException(RestException e) { // что именно перехватили
        return ResponseEntity // сформировали ответ
                .status(e.getHttpStatus()) // прописываем статус ответа
                .body(ErrorDto.builder() // собираем ответ
                        .message(e.getMessage())
                        .build());
    }
}
