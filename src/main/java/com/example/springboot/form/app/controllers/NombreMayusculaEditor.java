package com.example.springboot.form.app.controllers;


import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport {
	public void setAsText(String text)throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
		}
}
