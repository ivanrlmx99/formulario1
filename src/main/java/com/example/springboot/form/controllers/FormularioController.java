package com.example.springboot.form.controllers;

import com.example.springboot.form.models.Usuario;
import com.example.springboot.form.validacion.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class FormularioController {
    @Autowired
    private UsuarioValidador validacion;

    @GetMapping("/form")
    public String fomularioDatos(Model model) {
        Usuario usuario=new Usuario();
        usuario.setNombre("Ivan");
        usuario.setApellido("Ramos");
        usuario.setIdentificador("123-456-7-B");
        model.addAttribute("titulo","Registro de formulario");
        model.addAttribute("usuario",usuario);
        return "form";
    }
// de esta forma tambien se puede hacer mas limpio el codigo
    @PostMapping("/form")
    public String formularioEnvioDatos(@Valid  Usuario usuario, BindingResult result, Model model, SessionStatus status){
        validacion.validate(usuario,result);
        model.addAttribute("titulo","Resultado datos formulario");


        if(result.hasErrors()){
        /*    Map<String,String> errores=new HashMap<>();
            result.getFieldErrors().forEach(err->{
                errores.put(err.getField(),"el campo--->".concat(err.getField()).concat(err.getDefaultMessage()));
            });
            model.addAttribute("error",errores);*/
            return "form";
        }
        model.addAttribute("usuario",usuario);
        status.setComplete();
        return "resultado";
    }



   /* @PostMapping("/form")
    public String formularioEnvioDatos(Model model,
                                       @RequestParam(name="userName") String userName,
                                       @RequestParam String password,
                                       @RequestParam String email) {

        Usuario usuario=new Usuario();
        usuario.setUserName(userName);
        usuario.setPassword(password);
        usuario.setEmail(email);
        model.addAttribute("titulo","Resultado datos formulario");
        model.addAttribute("usuario",usuario);


        return "resultado";
    }*/


}
