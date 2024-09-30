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
public class VentaArreglo {
    
    private Venta[] ventas;
    private int indice;
    
     public VentaArreglo(int cantidad){
        
        indice = 0;
        ventas = new Venta[cantidad];
    
    }
     
     public boolean agregar(Venta vent){
	boolean result = false;
		if(!estaLleno()) {
                    ventas[this.indice] = vent;
		this.indice ++ ; 
		result = true;
	}
		return result;
	}
    
     public boolean estaLleno() {
        return this.indice < ventas.length;
    }
    
     public boolean eliminarPersona(Venta vent) {
        for (int i = 0; i < this.indice; i++) {
        if (ventas[i].equals(vent)) {           
            for (int j = i; j < this.indice - 1; j++) {
                ventas[j] = ventas[j + 1];
            }
            ventas[this.indice - 1] = null;  
            this.indice--;  
        }
    }
        return false; 
    }
     
     public Venta buscarPorDNI(int codigo) {
        for (int i = 0; i < this.indice; i++) {
            if (ventas[i].getCodigoRegistro() == codigo) {
                return ventas[i];
            }
        }
        return null; 
    }
     
     public int cantidadDeVentas() {
        return this.indice;
    }

    public int CapacidadMaxima() {
        return ventas.length;
    }
}
