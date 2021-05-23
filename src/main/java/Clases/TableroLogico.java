/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author felix_5bh1a4y
 */
public class TableroLogico {

    public TableroGrafico cuadricula;

    public TableroLogico(TableroGrafico cuadricula) {
        this.cuadricula = cuadricula;
    }

    public void hacerTablero() {
        cuadricula.cuadricula();
        cuadricula.matriz();
    }

    public boolean movimientoNegra(int numeroFicha, int lugar) {
        boolean siSePudo = true;
        int encontrado = cuadricula.buscarNegra(numeroFicha);
        if (encontrado != -1) {
            if (cuadricula.disponibleNegras(encontrado, lugar) == true) {
                cuadricula.moverNegra(encontrado, lugar);
                siSePudo = true;
            } else if (cuadricula.disponibleNegras2(encontrado, lugar) == true) {
                cuadricula.comerNegra(encontrado, lugar);
            }

        } else {
            siSePudo = false;
            System.out.println("La ficha no fue encontrada");
        }
        return siSePudo;
    }

    public boolean movimientoRoja(int numeroFicha, int lugar) {
        boolean siSePudo = true;
        int encontrado = cuadricula.buscarRoja(numeroFicha);
        if (encontrado != -1) {
            if (cuadricula.disponibleRojas(encontrado, lugar) == true) {
                cuadricula.moverRoja(encontrado, lugar);
                siSePudo = true;
            } else if (cuadricula.disponibleRojas2(encontrado, lugar) == true) {
                cuadricula.comerRoja(encontrado, lugar);
            }

        } else {
            siSePudo = false;
            System.out.println("La ficha no fue encontrada");
        }
        System.out.println(siSePudo);
        return siSePudo;
    }

    public boolean buscarFicha(int jugador, int ficha, int moverALugar) {
        if (jugador == 1) {
            int a = cuadricula.buscarNegra(ficha);
            if (a != -1) {
                if ((cuadricula.salirLimites(a, jugador) == 0 && moverALugar == 1)
                        || (cuadricula.salirLimites(a, jugador) == 7 && moverALugar == 2)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            int a = cuadricula.buscarRoja(ficha);
            if (a != -1) {
                if ((cuadricula.salirLimites(a, jugador) == 0 && moverALugar == 1)
                        || (cuadricula.salirLimites(a, jugador) == 7 && moverALugar == 2)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}
