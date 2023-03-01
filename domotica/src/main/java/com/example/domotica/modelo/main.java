package com.example.domotica.modelo;

import java.util.Scanner;

public class main {
    static int contador1 = 0;
    static int contador2 = 0;
    static int aux = 0;
    static int aux1 = 0;
    static int valor = 0;
    static int contador3 = 0;
    static int contador4 = 0;
    static int aux2 = 0;
    static int aux3 = 0;

    public static void main(String[] args) {
        while (true) {
            Scanner consola = new Scanner(System.in);
            System.out.print("Valor:"); // del 1 al 4
            valor = consola.nextInt();
            System.out.println(valor);
            accion(valor);
        }
    }


    static void accion(int mensaje) {
        if (aux != mensaje && aux1 != mensaje) {
            if (mensaje == 1) {
                contador1++;
                if (contador1 > 0) {
                    aux = mensaje;
                }
                System.out.println("contador1 = " + contador1);
                aux1 = 0;
            } else if (mensaje == 2) {
                contador2++;
                if (contador2 > 0) {
                    aux1 = mensaje;
                }
                System.out.println("contador2 = " + contador2);
                aux = 0;
            }
        }
        if (aux2 != mensaje && aux3 != mensaje) {
            if (mensaje == 3) {
                contador3++;
                if (contador3 > 0) {
                    aux2 = mensaje;
                }
                System.out.println("contador3 = " + contador3);
                aux3 = 0;
            } else if (mensaje == 4) {
                contador4++;
                if (contador4 > 0) {
                    aux3 = mensaje;
                }
                System.out.println("contador4 = " + contador4);
                aux2 = 0;
            }
        }

    }
}
