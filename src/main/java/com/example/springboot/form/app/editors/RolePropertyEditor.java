package com.example.springboot.form.app.editors;

import com.example.springboot.form.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {
@Autowired
private RoleService service;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
try {
    Integer id=Integer.parseInt(text);
    setValue(service.obtenerPorId(id));

}catch (NumberFormatException ex){
setValue(null);
}
    }
}
