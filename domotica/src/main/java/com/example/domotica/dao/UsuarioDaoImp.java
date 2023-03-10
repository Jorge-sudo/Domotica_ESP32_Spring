package com.example.domotica.dao;

import com.example.domotica.modelo.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "SELECT u FROM Usuario u";
        List<Usuario> usuarios= entityManager.createQuery(query).getResultList();
        return usuarios;
    }

    @Override
    public void eliminar(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        //agregamos
        entityManager.persist(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorPassword(String password) {
        //En este query no podemos concatenar el usuario y password por que es vulnerable a hacker y daria true y tendria acceso
        //por los tanto utilizamos :email y :password
        String query = "SELECT u FROM Usuario u WHERE u.password = :password";
        List<Usuario> lista =  entityManager.createQuery(query).
                setParameter("password", password)
                .getResultList();
        //si la lista esta vacia
        if (!lista.isEmpty()){
            return lista.get(0);
        }

        return null;
    }
}
