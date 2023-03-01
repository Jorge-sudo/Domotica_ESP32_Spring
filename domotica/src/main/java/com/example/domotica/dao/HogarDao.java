package com.example.domotica.dao;

import com.example.domotica.modelo.Hogar;
import com.example.domotica.modelo.Usuario;

import java.util.List;

public interface HogarDao {
    List<Hogar> getHogares();

    void eliminar(int id);

    void registrar(Hogar hogar);

    Hogar obtenerHogarPorPin(int pin);

    void actualizarHogar(Hogar hogar);
}
