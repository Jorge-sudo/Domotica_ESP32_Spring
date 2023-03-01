package com.example.domotica.controlador;

import com.example.domotica.dao.UsuarioDao;
import com.example.domotica.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    //Esto es la injeccion de dependencias hace que se cree un objeto y se guarde en esta variable
    @Autowired
    private UsuarioDao usuarioDao; //si esta variable se crea en otra clase se utilizara el mismo objeto
    //entonces quiere decir que se compartira el mismo objeto


    @RequestMapping(value="api/usuarios", method = RequestMethod.GET) //recibimos el token
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value="api/usuarios/{password}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable String password){
        Usuario usuario = usuarioDao.obtenerUsuarioPorPassword(password);
        return usuario;
    }


    @RequestMapping(value="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){//con requestBody convierte el JSON que recibe a un usuario
        usuarioDao.registrar(usuario);
    }


    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id){
        usuarioDao.eliminar(id);
    }
}
