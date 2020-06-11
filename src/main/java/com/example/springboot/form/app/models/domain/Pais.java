package com.example.springboot.form.app.models.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Pais {
    //@NotNull
    private Integer id;
  //  @NotEmpty
    private String codigoPostall;
    private String nombrePais;

    public Pais() {
    }

    public Pais(Integer id, String codigoPostall, String nombrePais) {
        this.id = id;
        this.codigoPostall = codigoPostall;
        this.nombrePais = nombrePais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoPostall() {
        return codigoPostall;
    }

    public void setCodigoPostall(String codigoPostall) {
        this.codigoPostall = codigoPostall;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
