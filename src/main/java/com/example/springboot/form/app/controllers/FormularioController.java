package com.example.springboot.form.app.controllers;

import com.example.springboot.form.app.editors.PaisPropertyEditor;
import com.example.springboot.form.app.models.domain.Pais;
import com.example.springboot.form.app.services.PaisService;
import com.example.springboot.form.app.validacion.UsuarioValidador;
import com.example.springboot.form.app.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


import javax.validation.Valid;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormularioController {
    @Autowired
    private UsuarioValidador validacion;
    @Autowired
   private  PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.addValidators(validacion);
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	dateFormat.setLenient(false);
    	binder.registerCustomEditor(Date.class,"dateFormat",new CustomDateEditor(dateFormat,false));
    	binder.registerCustomEditor(String.class,"apellido",new NombreMayusculaEditor());
        binder.registerCustomEditor(Pais.class,"pais",paisPropertyEditor);
    }
    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return paisService.listar();
    }
    /*@ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        return Arrays.asList(
                new Pais(1,"MX","México"),
                new Pais(2,"US","Estados Unidos"),
                new Pais(3,"FR","Francia"),
                new Pais(1,"EN","Inglaterra")
             );
    }*/
@ModelAttribute("listadoRolesString")
public List<String>listadoRolesString(){
    List<String>roles=new ArrayList<>();
    roles.add("ROLE_ADMIN");
    roles.add("ROLE_MODERATOR");
    roles.add("ROLE_USER");

    return roles;
}

    @ModelAttribute("paises")
    public List<String> paises(){
       return Arrays.asList("México","Francia","Alemania","Suecia","Rusia","China","USA");
    }

    @ModelAttribute("paisesMap")
    public Map<String,String> paisesMap(){
Map<String,String>paises=new HashMap<String,String>();
paises.put("Mx","México");
paises.put("FR","Francia");
paises.put("EU","Estados Unidos");
paises.put("AL","Alemania");
paises.put("RS","Rusia");
paises.put("CH","China");
return paises;
    }


    @GetMapping("/form")
    public String fomularioDatos(Model model) {
        Usuario usuario=new Usuario();
        usuario.setNombre("Ivan");
        usuario.setApellido("Ramos");
        usuario.setIdentificador("12.456.897-A");
        model.addAttribute("titulo","Registro de formulario");
        model.addAttribute("usuario",usuario);
        return "form";
    }
// de esta forma tambien se puede hacer mas limpio el codigo
    @PostMapping("/form")
    public String formularioEnvioDatos(@Valid  Usuario usuario, BindingResult result, Model model, SessionStatus status){
     //   validacion.validate(usuario,result);
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
