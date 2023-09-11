package de.ait.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RestException {

    public NotFoundException(String entity, Long id) {
        super(HttpStatus.NOT_FOUND, entity + " with id <" + id + "> not found.");
    }
}
