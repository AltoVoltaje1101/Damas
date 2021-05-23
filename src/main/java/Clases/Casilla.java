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
public class Casilla extends Square {

    private Ficha ficha;
    private int fila;
    private int columna;
    private boolean ocupado;

    public Casilla(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        ocupado = false;
    }

    public void addFicha(Ficha ficha) {
        this.ficha = ficha;
        ocupado = true;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public String colorficha() {
        return ficha.getColor();
    }

    public void quitarFicha() {
        ocupado = false;
    }

    public void quitarFichaComida() {
        ficha.makeInvisible();
        ocupado = false;

    }

}
