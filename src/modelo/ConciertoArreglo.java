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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConciertoArreglo {

    private final ArrayList<Concierto> conciertos;
    private int capacidadMaxima;


    public ConciertoArreglo(int capacidadMaxima) {
        this.conciertos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean verificarCapacidad() {
        return conciertos.size() >= capacidadMaxima;
    }

    public boolean AgrearConcierto(Concierto concierto) {
        if (verificarCapacidad()) {
            System.out.println("Capacidad maxima alcanzada");
            return false;
        }

        for (Concierto c : conciertos) {
            if (c.getNombre().equals(concierto.getNombre())) {
                System.out.println("El concierto ya esta agregado");
                return false;
            }
        }
        conciertos.add(concierto);
        return true;
    }

    public boolean eliminarConcierto(String  nombreConcierto) {
        for (Concierto c : conciertos) {
            if (c.getNombre().equals(nombreConcierto)){
                conciertos.remove(c);
                return true;
            }
        }
        return false;
    }

    public Concierto buscarConciertoNombre(String  nombreConcierto) {
        for (Concierto c : conciertos) {
            if (c.getNombre().equalsIgnoreCase(nombreConcierto)){
                return c;
            }
        }
        return null;
    }

    public List<Concierto> buscarConciertoFecha(Date fecha) {
        List<Concierto> conciertosFecha = new ArrayList<>();
        for (Concierto c : conciertos) {
            if (c.getFecha().equals(fecha)) {
                conciertosFecha.add(c);
            }
        }
        return conciertosFecha;
    }

    public void MostrarConciertos() {
        if(conciertos.isEmpty()){
            System.out.println("No hay conciertos disponibles");
            return;
        }
        for (Concierto c : conciertos) {
            System.out.println("Nombre: " + c.getNombre() + "Fecha: " + c.getFecha());
        }
    }

    public int CantidadConciertos(){
        return conciertos.size();
    }

    public boolean actualizarConcierto(String nombreConcierto, Date nuevaFecha) {
        Concierto concierto = buscarConciertoNombre(nombreConcierto);
        if (concierto != null) {
            concierto.setFecha(nuevaFecha);
            return true;
        }
        return false;
    }
    //oli
}
