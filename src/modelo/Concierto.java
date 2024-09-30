/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Concierto {

    private final String nombre;
    private final Date fecha;
    private final ArrayList<Zona> zonas;

    public Concierto(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.zonas = new ArrayList<>();
    }

    public boolean agregarZona(String nuevaZona) {
        Scanner scanner = null;
        for (Zona zona : zonas) {
            if (zona.getNombre().equals(nuevaZona)) {
                return false; // Zona ya existente
            }
        }
        int capacidad, precio;
        System.out.println("Ingrese la capacidad de la nueva zona:");
        capacidad = scanner.nextInt();
        System.out.println("Ingrese el precio de la nueva zona");
        precio = scanner.nextInt();
        zonas.add((new Zona(nuevaZona, capacidad, precio)));
        return true;
    }
    
    public boolean eliminarZona(String zonaEliminar) {
        for (Zona zona : zonas) {
            if(zona.getNombre().equals(zonaEliminar)) {
                zonas.remove(zona);
                return true;
            }
        }
        return false;
    }

    public String getNombre(){
        return nombre;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date nuevaFecha) {
        this.fecha = nuevaFecha;
    }
    //oli
}
