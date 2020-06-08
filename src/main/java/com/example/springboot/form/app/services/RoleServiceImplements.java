package com.example.springboot.form.app.services;

import com.example.springboot.form.app.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImplements implements RoleService {
    private List<Role> roles;

    public RoleServiceImplements() {
        this.roles = new ArrayList<>();
        roles.add(new Role(1, "administrador", "ROLE_ADMIN"));
        roles.add(new Role(2, "user", "USER"));
        roles.add(new Role(1, "moderator", "MODERATOR"));
    }

    @Override
    public List<Role> listar() {

        return roles;
    }

    @Override
    public Role obtenerPorId(Integer id) {
        Role resultado = null;
        for (Role role : this.listar()) {
            if (id == role.getId()) {
                resultado = role;
                break;
            }
        }


        return resultado;
    }
}
