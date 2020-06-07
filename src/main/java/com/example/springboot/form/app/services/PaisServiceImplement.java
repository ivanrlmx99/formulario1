package com.example.springboot.form.app.services;

import com.example.springboot.form.app.models.domain.Pais;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImplement implements PaisService{

    private List<Pais>lista;
    public PaisServiceImplement() {
        this.lista= Arrays.asList(
                new Pais(1,"MX","México"),
                new Pais(2,"US","Estados Unidos"),
                new Pais(3,"FR","Francia"),
                new Pais(1,"EN","Inglaterra")
        );

    }

    @Override
    public List<Pais> listar() {
        return lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado=null;
        for(Pais pais :this.lista){
            if(id==pais.getId()){
                resultado=pais;
                break;
            }

        }

        return  resultado;
    }
}
