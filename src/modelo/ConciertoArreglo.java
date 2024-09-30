/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OCA-UIE
 */
package modelo;

public class ConciertoArreglo {

    private Concierto[] conciertos;
    private int indice;

    public ConciertoArreglo(int cantidad) {
        indice = 0;
        conciertos = new Concierto[cantidad];
    }

    public boolean agregar(Concierto obj) {
        if (!estaLleno()) {
            conciertos[this.indice] = obj;
            this.indice++;
            return true;
        }
        return false;
    }

    public boolean estaLleno() {
        return this.indice >= conciertos.length;
    }

    public boolean eliminarConcierto(Concierto obj) {
        for (int i = 0; i < this.indice; i++) {
            if (conciertos[i].equals(obj)) {
                for (int j = i; j < this.indice - 1; j++) {
                    conciertos[j] = conciertos[j + 1];
                }
                conciertos[this.indice - 1] = null;
                this.indice--;
                return true;
            }
        }
        return false;
    }

    public Concierto buscarPorNombre(String nombre) {
        for (int i = 0; i < this.indice; i++) {
            if (conciertos[i].getNombre().equalsIgnoreCase(nombre)) {
                return conciertos[i];
        }
        return null;
    }

    public int cantidadDeConciertos() {
        return this.indice;
    }

    public int capacidadMaxima() {
        return conciertos.length;
}

