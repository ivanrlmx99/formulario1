package com.example.springboot.form.app.models;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.*;

import com.example.springboot.form.app.models.domain.Pais;
import com.example.springboot.form.app.models.domain.Role;
import com.example.springboot.form.app.validacion.IdentificadorRegex;
import com.example.springboot.form.app.validacion.Requerido;

public class Usuario {

   // @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
    private String identificador;
    @NotEmpty(message = "campo requerido")
    private String nombre;
    @NotEmpty
    @Requerido
    private String apellido;
    @NotBlank
    @NotEmpty
    private String userName;
    @NotEmpty
    @Size (min=3,max=8)
    private String password;
    @Requerido
    @Email(message = "este campo email es requerido")
    private String email;
    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;
    @NotNull
    @Future
  // @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date dateFormat;
    //@NotEmpty es para string no objeto
   // @Valid
    @NotNull
    private Pais pais;
    @NotEmpty
    private List<Role> roles;
    private Boolean habilitar;
    @NotEmpty
    private String genero;
    private String datoOculto;

    

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Date getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(Date dateFormat) {
		this.dateFormat = dateFormat;
	}

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(Boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDatoOculto() {
        return datoOculto;
    }

    public void setDatoOculto(String datoOculto) {
        this.datoOculto = datoOculto;
    }
}
