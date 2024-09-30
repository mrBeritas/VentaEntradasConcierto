/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author OCA-UIE
 */
public class Venta {
    
    private Date fecha;
    private static int codigoRegistro = 0;
    private int monto;
    private ArrayList<Entrada> entradas;

    public Venta(Date fecha) {
        this.codigoRegistro = ++codigoRegistro;
        this.fecha = fecha;
        this.monto = 0;
        this.entradas = new ArrayList<>();
        
    }
    
    public boolean agregarEntrada(Entrada entrada) {
        if (entrada != null) {
            if(entradas.size() < 4){
            
            this.entradas.add(entrada);
            this.monto = this.monto + entrada.EstimarPrecioEntrada();  
            return true;
            
            }
            
        }
        return false;
    } 
    
    public boolean eliminarEntrada(Entrada entrada) {
        if (this.entradas.contains(entrada)) {
            this.entradas.remove(entrada);
            this.monto = this.monto -  entrada.EstimarPrecioEntrada();
            return true;
        }
        return false;
    }
    
    public boolean anularVenta() {
        if (!entradas.isEmpty()) {
            entradas.clear();
            this.monto = 0;
            return true;
        }
        return false;
    }
    
    public int MostrarMonto() {
        return this.monto;
    }

    @Override
    public String toString() {
        return "Venta{" + "fecha=" + fecha + ", monto=" + monto + ", entradas=" + entradas + '}';
    }

    public static int getCodigoRegistro() {
        return codigoRegistro;
    }
    
   
    
    
}
