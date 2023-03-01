package com.example.domotica.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hogar")
public class Hogar {
    @Id
    @Column(name = "id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo")
    @Getter @Setter
    private String tipo;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "pin")
    @Getter @Setter
    private int pin;

    @Column(name = "estado")
    @Getter @Setter
    private int estado;
}
