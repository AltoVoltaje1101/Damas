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
public class Ficha extends Circle{
    private int fila;
    private int columna;
    private int numCasilla;
    public Ficha(int xPosition, int yPosition, int identificador, int fila,
            int columna, int casilla){
        super(xPosition, yPosition, identificador);
        this.fila=fila;
        this.columna=columna;
        this.identificador = identificador;
        this.numCasilla = casilla;
    }
    public String getColor(){
        return color;
    }
    public int getIdentificador(){
        System.out.println(identificador);
        return identificador;
    }
    public int getCasilla(){
        return this.numCasilla;
    }
    public void setCasilla(int casilla){
        this.numCasilla=casilla;
    }
    public int getColumna(){
        return columna;
    }
    public int getFila(){
        return fila;
    }
    public void setColumna(int columna){
        this.columna=columna;
    }
    public void setFila(int fila){
        this.fila=fila;
    }
    
}
