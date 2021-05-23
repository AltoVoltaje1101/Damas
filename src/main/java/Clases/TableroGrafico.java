/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author felix_5bh1a4y
 */
public class TableroGrafico {

    public ArrayList<Casilla> cuadros;
    public ArrayList<Ficha> negras;
    public ArrayList<Ficha> rojas;

    public TableroGrafico() {
        this.cuadros = new ArrayList<Casilla>(64);
        this.negras = new ArrayList<Ficha>(12);
        this.rojas = new ArrayList<Ficha>(12);
    }

    public void cuadricula() {
        int j = 0, a = 0, b = 0, fila = 1;
        for (int i = 0; i < 64; i++) {
            a++;

            Casilla cuadro = new Casilla(b * 85, j);
            if (fila % 2 == 0) {
                if (a % 2 == 0) {
                    cuadro.changeColor("cafe");
                }
            } else if (a % 2 != 0) {
                cuadro.changeColor("cafe");
            }

            cuadro.makeVisible();

            cuadros.add(cuadro);
            b++;
            if (a % 8 == 0) {
                j += 85;
                b = 0;
                a = 0;
                fila++;
            }
        }
    }

    public void matriz() {
        int contadorRojas = 0, contadorNegras = 1;
        for (int i = 0; i < 64; i++) {
            if (cuadros.get(i).getColor().equalsIgnoreCase("cafe") &&
                    (i < 24 && i >= 0)) {
                Ficha ficha = new Ficha(cuadros.get(i).getX() + 5,
                        cuadros.get(i).getY() + 5, 12 - contadorRojas, (i / 8), (i % 8), i);
                ficha.changeColor("red");
                ficha.makeVisible();
                contadorRojas++;
                rojas.add(ficha);
                cuadros.get(i).addFicha(rojas.get(rojas.size() - 1));

            } else if (cuadros.get(i).getColor().equalsIgnoreCase("cafe") 
                    && (i >= 40 && i <= 64)) {
                Ficha ficha = new Ficha(cuadros.get(i).getX() + 5, 
                        cuadros.get(i).getY() + 5, contadorNegras, (i / 8), (i % 8), i);
                ficha.changeColor("black");
                ficha.makeVisible();
                negras.add(ficha);
                cuadros.get(i).addFicha(negras.get(negras.size() - 1));
                contadorNegras++;
            }

        }
    }

    //este metodo devuelve la posicion de la ficha seleccionada dentro del arraylist
    public int buscarNegra(int identificador) {
        for (int i = 0; i < negras.size(); i++) {
            if (negras.get(i).getIdentificador() == identificador) {

                return i;
            }
        }
        System.out.println("No encontrada");
        return -1;
    }

    //este metodo mueve graficamente la ficha
    public void moverNegra(int posicion, int lugar) {
        int a;
        switch (lugar) {
            case 1:
                a = negras.get(posicion).getCasilla() - 9;

                negras.get(posicion).makeVisible();
                negras.get(posicion).cambiarPosicion(cuadros.get(a).getX() + 5, cuadros.get(a).getY() + 5);
                negras.get(posicion).setCasilla(a);
                negras.get(posicion).setColumna(negras.get(posicion).getColumna() - 1);
                negras.get(posicion).setFila(negras.get(posicion).getFila() - 1);
                cuadros.get(a).addFicha(negras.get(posicion));
                cuadros.get(a + 9).quitarFicha();

                break;
            case 2:
                a = negras.get(posicion).getCasilla() - 7;

                negras.get(posicion).makeVisible();
                negras.get(posicion).cambiarPosicion(cuadros.get(a).getX() + 5, cuadros.get(a).getY() + 5);
                negras.get(posicion).setCasilla(a);
                negras.get(posicion).setColumna(negras.get(posicion).getColumna() + 1);
                negras.get(posicion).setFila(negras.get(posicion).getFila() - 1);
                cuadros.get(a).addFicha(negras.get(posicion));
                cuadros.get(a + 7).quitarFicha();

        }
    }

    public void cambioDatos() {

    }

    //este metodo nos sirve para saber si el lugar qu pretendemos ocupar ya esta  o no ocupado por otra ficha
    public boolean disponibleNegras(int posicion, int lugar) {
        boolean disponible = true;
        switch (lugar) {
            case 2:
                if (lugar == 2) {
                    if (cuadros.get(negras.get(posicion).getCasilla() - 7).getOcupado() == true) {
                        System.out.println("color d ela ficha de la casilla :" + cuadros.get(negras.get(posicion).getCasilla()
                                - 7).colorficha());
                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
            case 1:
                if (lugar == 1) {
                    if (cuadros.get(negras.get(posicion).getCasilla() - 9).getOcupado() == true) {
                        System.out.println("color de la ficha de la casilla :" + cuadros.get(negras.get(posicion).getCasilla()
                                - 9).colorficha());
                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
            default:
                return false;
        }
        return disponible;
    }

    public boolean disponibleNegras2(int posicion, int lugar) {
        boolean disponible = true;
        switch (lugar) {
            case 2:
                if (lugar == 2) {
                    if (cuadros.get(negras.get(posicion).getCasilla() - 14).getOcupado() == true) {
                        System.out.println("color de la ficha de la casilla :" + 
                                cuadros.get(negras.get(posicion).getCasilla() - 14).colorficha());
                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
            case 1:
                if (lugar == 1) {
                    if (cuadros.get(negras.get(posicion).getCasilla() - 19).getOcupado() == true) {
                        System.out.println("color d ela ficha de la casilla :" +
                                cuadros.get(negras.get(posicion).getCasilla() + -19).colorficha());
                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
        }
        return disponible;
    }

    public int buscarRoja(int identificador) {
        for (int i = 0; i < rojas.size(); i++) {
            if (rojas.get(i).getIdentificador() == identificador) {
                System.out.println("Encontrada en la pos: " + i);
                return i;
            }
        }
        System.out.println("No encontrada");
        return -1;
    }

    public void moverRoja(int posicion, int lugar) {
        int a;
        switch (lugar) {
            case 1:
                a = rojas.get(posicion).getCasilla() + 7;

                rojas.get(posicion).cambiarPosicion(cuadros.get(a).getX() + 5, 
                        cuadros.get(a).getY() + 5);
                rojas.get(posicion).setCasilla(a);
                rojas.get(posicion).setColumna(rojas.get(posicion).getColumna() - 1);
                rojas.get(posicion).setFila(rojas.get(posicion).getFila() + 1);
                cuadros.get(a).addFicha(rojas.get(posicion));
                cuadros.get(a - 7).quitarFicha();

                break;
            case 2:
                a = rojas.get(posicion).getCasilla() + 9;

                rojas.get(posicion).cambiarPosicion(cuadros.get(a).getX() + 5, 
                        cuadros.get(a).getY() + 5);
                rojas.get(posicion).setCasilla(a);
                rojas.get(posicion).setColumna(rojas.get(posicion).getColumna() + 1);
                rojas.get(posicion).setFila(rojas.get(posicion).getFila() + 1);
                cuadros.get(a).addFicha(negras.get(posicion));
                cuadros.get(a - 9).quitarFicha();

        }
    }

    public boolean disponibleRojas(int posicion, int lugar) {
        boolean disponible = true;
        switch (lugar) {
            case 2:
                if (lugar == 2) {
                    if (cuadros.get(rojas.get(posicion).getCasilla() + 9).getOcupado() == true) {

                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
            case 1:
                if (lugar == 1) {
                    if (cuadros.get(rojas.get(posicion).getCasilla() + 7).getOcupado() == true) {

                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
            default:
                return false;
        }
        return disponible;
    }

    public boolean disponibleRojas2(int posicion, int lugar) {
        boolean disponible = true;
        switch (lugar) {
            case 2:
                if (lugar == 2) {
                    if (cuadros.get(rojas.get(posicion).getCasilla() + 19).getOcupado() == true) {

                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
            case 1:
                if (lugar == 1) {
                    if (cuadros.get(rojas.get(posicion).getCasilla() + 13).getOcupado() == true) {

                        disponible = false;
                    }
                } else {
                    disponible = true;
                }
                break;
        }
        return disponible;
    }

    public void comerRoja(int posicion, int lugar) {
        moverRoja(posicion, lugar);
        moverRoja(posicion, lugar);
        for (int i = 0; i < negras.size(); i++) {
            if (lugar == 2) {
                if (negras.get(i).getCasilla() == (rojas.get(posicion).getCasilla() - 9)) {
                    negras.get(i).makeInvisible();
                    cuadros.get(negras.get(i).getCasilla()).quitarFicha();
                    negras.remove(i);
                }
            } else if (lugar == 1) {
                if (negras.get(i).getCasilla() == (rojas.get(posicion).getCasilla() - 7)) {
                    negras.get(i).makeInvisible();
                    cuadros.get(negras.get(i).getCasilla()).quitarFicha();
                    negras.remove(i);
                }
            }
        }
    }

    public void comerNegra(int posicion, int lugar) {

        moverNegra(posicion, lugar);
        moverNegra(posicion, lugar);
        for (int i = 0; i < rojas.size(); i++) {
            if (lugar == 2) {
                if (rojas.get(i).getCasilla() == (negras.get(posicion).getCasilla() + 7)) {
                    rojas.get(i).makeInvisible();
                    cuadros.get(rojas.get(i).getCasilla()).quitarFicha();
                    rojas.remove(i);
                }
            } else if (lugar == 1) {
                if (rojas.get(i).getCasilla() == (negras.get(posicion).getCasilla() + 9)) {
                    rojas.get(i).makeInvisible();
                    cuadros.get(rojas.get(i).getCasilla()).quitarFicha();
                    rojas.remove(i);
                }
            }
        }

    }

    public int salirLimites(int posicion, int jugador) {
        if (jugador == 1) {
            int a = negras.get(posicion).getColumna();
            return a;
        } else {
            int a = rojas.get(posicion).getColumna();
            return a;
        }
    }

}
