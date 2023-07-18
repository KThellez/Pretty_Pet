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
public class formatoEntradaException extends Exception{
    private int numero;
    private String dato;

    public formatoEntradaException() {
        this.numero = 0;
        this.dato = "";
    }
    
    public formatoEntradaException(int numero) {
        this.numero = numero;
        switch(numero){
            case 101:{
                dato= "No se admiten Datos Nulos";
                break;
            }
            case 102:{
                dato= "Solo datos Numericos";
                break;
            } 
            case 103:{
                dato= "Solo datos de texto";
                break;
            } 
            
        }
    }
    public formatoEntradaException(int numero, String dato) {
        this.numero = numero;
        switch(numero){
            case 101:{
                dato= "No se admiten Datos Nulos";
                break;
            }
            case 102:{
                dato= "Solo datos Numericos";
                break;
            } 
            case 103:{
                dato= "Solo datos de texto";
                break;
            } 
            
        }
        dato += "generado por " + dato;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "formatoEntradaException{" + "numero=" + numero + ", dato=" + dato + '}';
    }
    
    
    
}
