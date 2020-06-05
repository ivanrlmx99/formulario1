package com.example.springboot.form.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.springboot.form.validacion.IdentificadorRegex;
import com.example.springboot.form.validacion.Requerido;

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
  // @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date dateFormat;

    

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

	
}
