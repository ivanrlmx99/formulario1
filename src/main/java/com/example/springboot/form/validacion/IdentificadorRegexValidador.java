package com.example.springboot.form.validacion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.springboot.form.Constants;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 if (value.matches(Constants.VALIDADORID)) {
			 return true;
		 }
		return false;
	}

}
