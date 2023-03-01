package com.example.domotica.dao;

import com.example.domotica.modelo.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(int id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorPassword(String password);

}
