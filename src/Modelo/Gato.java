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
public class Gato extends Mascota{
    private String raza, color;
    private int peso;

    public Gato(String raza, String color, int peso, String nombre, String sexo, int edad) {
        super(nombre, sexo, edad);
        this.raza = raza;
        this.color = color;
        this.peso = peso;
    }
    public Gato() {
        super();
        this.raza = "";
        this.color = "";
        this.peso = 0;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return tipo_mascota() + "\n" +
                super.toString()+
                "\nraza: " + raza +
                "\ncolor: " + color +
                "\npeso: " + peso;
    }

    @Override
    public String tipo_mascota(){
        return "gato";
    }
    
}
