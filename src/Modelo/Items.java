/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PC
 */
public class Items {
    
    private String id, dato;

    public Items(String id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    public Items() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    
       

    @Override
    public String toString() {
        return this.getDato();
    }
    
    
    
}
