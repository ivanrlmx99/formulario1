package com.example.springboot.form.validacion;

import com.example.springboot.form.Constants;
import com.example.springboot.form.models.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Usuario.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
      //  Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmpty(errors, "nombre", "requerido.usuario.nombre");

        //  if(usuario.getIdentificador().matches(Constants.VALIDADORID)==false)
       /* if (!usuario.getIdentificador().matches(Constants.VALIDADORID)) {
            errors.rejectValue("identificador", "pattern.usuario.identificador");

        }*/
    }
}
