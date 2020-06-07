package com.example.springboot.form.app.validacion;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IdentificadorRegexValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentificadorRegex {
	
	String message() default "Identificadorinvalido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
