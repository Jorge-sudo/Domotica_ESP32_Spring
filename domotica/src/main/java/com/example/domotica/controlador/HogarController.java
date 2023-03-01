package com.example.domotica.controlador;

import com.example.domotica.dao.HogarDao;
import com.example.domotica.modelo.Hogar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HogarController {

    //injectamos la interfaz
    @Autowired
    private HogarDao hogarDao;

    @RequestMapping(value="api/hogares", method = RequestMethod.GET) //recibimos el token
    public List<Hogar> getHogares(){
        return hogarDao.getHogares();
    }

    @RequestMapping(value="api/hogares/{pin}", method = RequestMethod.GET)
    public Hogar getHogar(@PathVariable int pin){
        Hogar hogar = hogarDao.obtenerHogarPorPin(pin);
        return hogar;
    }

    @RequestMapping(value="api/hogares", method = RequestMethod.POST)
    public void registrarHogar(@RequestBody Hogar hogar){//con requestBody convierte el JSON que recibe a un usuario
        hogarDao.registrar(hogar);
    }

    @RequestMapping(value = "api/hogares", method = RequestMethod.PUT)
    public void actualizarHogar(@RequestBody Hogar hogar){
        hogarDao.actualizarHogar(hogar);
    }


    @RequestMapping(value="api/hogares/{pin}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int pin){
        hogarDao.eliminar(pin);
    }

}
