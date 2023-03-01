package com.example.domotica.dao;

import com.example.domotica.modelo.Hogar;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //funcionalidad de que podra acceder a la base de datos
@Transactional //forma con la cual tratara las consultas SQL en forma transaccion
public class HogarDaoImp implements HogarDao{

    @PersistenceContext
    private EntityManager entityManager ; //nos sirve para la conexion a la BD

    @Override
    public List<Hogar> getHogares() {
        String query = "SELECT h FROM Hogar h";
        List<Hogar> hogars= entityManager.createQuery(query).getResultList();
        return hogars;
    }

    @Override
    public void eliminar(int id) {
        Hogar hogar = entityManager.find(Hogar.class, id);
        entityManager.remove(hogar);
    }

    @Override
    public void registrar(Hogar hogar) {
        entityManager.persist(hogar);
    }

    @Override
    public Hogar obtenerHogarPorPin(int pin) {
        String query = "SELECT h FROM Hogar h WHERE h.pin = :pin";
        List<Hogar> hogars =  entityManager.createQuery(query).
                setParameter("pin", pin)
                .getResultList();
        //si la lista esta vacia
        if (!hogars.isEmpty()){
            return hogars.get(0);
        }
        return null;
    }

    @Override
    public void actualizarHogar(Hogar hogar){
        entityManager.merge(hogar);
    }
}
