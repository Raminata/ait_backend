package de.ait.validators.impl;

import de.ait.validators.NameValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class NameLengthValidatorImpl implements NameValidator {
    private final int minLength;

    public NameLengthValidatorImpl(@Value("${name.min.length}") int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String name) {
        if (name.length() < minLength) {
            throw new IllegalArgumentException("Пароль слишком короткий");
        }
    }
}
