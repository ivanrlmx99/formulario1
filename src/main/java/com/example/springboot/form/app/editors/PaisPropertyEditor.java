package com.example.springboot.form.app.editors;

import com.example.springboot.form.app.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
@Component
public class PaisPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        if(idString!=null&&idString.length()>0){
          try {
              Integer id=Integer.parseInt(idString);
              this.setValue(paisService.obtenerPorId(id));
          }catch (NumberFormatException ex){
              setValue(null);

          }

        }else{
            setValue(null);
        }


    }
}
