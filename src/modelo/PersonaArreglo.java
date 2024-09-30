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
public class PersonaArreglo {
    
    private Persona[] personas;
    private int indice;
    
    public PersonaArreglo(int cantidad){
        
        indice = 0;
        personas = new Persona[cantidad];
    
    }
    
    public boolean agregar(Persona obj){
	boolean result = false;
		if(!estaLleno()) {
                    personas[this.indice] = obj;
		this.indice ++ ; 
		result = true;
	}
		return result;
	}
    
    public boolean estaLleno() {
        return this.indice <= personas.length;
    }
    
    public boolean eliminarPersona(Persona obj) {
    for (int i = 0; i < this.indice; i++) {
        if (personas[i].equals(obj)) {           
            for (int j = i; j < this.indice - 1; j++) {
                personas[j] = personas[j + 1];
            }
            personas[this.indice - 1] = null;  
            this.indice--;  
        }
    }
    return false; 
}
    
    public Persona buscarPorDNI(String dni) {
        for (int i = 0; i < this.indice; i++) {
            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                return personas[i];
            }
        }
        return null; 
    }
    
    public int cantidadDePersonas() {
        return this.indice;
    }

    public int CapacidadMaxima() {
        return personas.length;
    }
    
}
