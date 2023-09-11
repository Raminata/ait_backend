package de.ait.task.validation.validators;

import de.ait.task.validation.constraints.NotBeforeToday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 8/3/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class TodayDateValidator implements ConstraintValidator<NotBeforeToday, String> {

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate now = LocalDate.now();
        LocalDate inputDate = parseStringToLocalDate(date);
        return isTodayOrFutureDate(inputDate);
    }

    private static LocalDate parseStringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    private static boolean isTodayOrFutureDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        return date.isAfter(today) || date.isEqual(today);
    }
}
