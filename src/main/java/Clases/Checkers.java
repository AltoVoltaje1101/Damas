/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author felix_5bh1a4y
 */
public class Checkers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b;
        Scanner lectura = new Scanner(System.in);
        // TODO code application logic here
        TableroGrafico tablero = new TableroGrafico();
        TableroLogico tabla = new TableroLogico(tablero);
        tabla.hacerTablero();
        int regresar;
        boolean hecho;
        do {
            do{
                System.out.println("Ficha que deseas mover: ");
            a = lectura.nextInt();
            System.out.println("Lugar a la que deseas moverla");
            b = lectura.nextInt();
            if (tabla.buscarFicha(1, a, b) == true) {
                tabla.movimientoNegra(a, b);
                regresar = 2;
            } else {
                regresar = 1;
            }
            }while(regresar==1);
            do{
            System.out.println("Ficha que deseas mover: ");
            a = lectura.nextInt();
            System.out.println("Lugar a la que deseas moverla");
            b = lectura.nextInt();
            tabla.buscarFicha(2, a, b);
             if (tabla.buscarFicha(2, a, b) == true) {
                tabla.movimientoRoja(a, b);
                regresar = 2;
            } else {
                regresar = 1;
            }
            }while(regresar==1);
            if (hecho = false) {

            }
        } while (a != 100);
    }

}
