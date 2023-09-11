package de.ait.task.validation.constraints;

import de.ait.task.validation.validators.TodayDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // на что ее можно вешать - на поле
@Retention(RetentionPolicy.RUNTIME) // что аннотация не будет удалена в момент работы приложения
@Constraint(validatedBy = TodayDateValidator.class) // чем валидируется
public @interface NotBeforeToday {

    String message() default "must be today or in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
