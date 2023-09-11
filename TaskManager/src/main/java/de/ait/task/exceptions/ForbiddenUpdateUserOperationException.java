package de.ait.task.exceptions;

import org.springframework.http.HttpStatus;

public class ForbiddenUpdateUserOperationException extends RestException {

    public ForbiddenUpdateUserOperationException(String field, String newValue) {
        super(HttpStatus.FORBIDDEN, "Cannot set <" + field + "> as <" + newValue + ">");
    }

}
