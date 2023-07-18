/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class Persona {
    private String nombre, apellido, identificacion, telefono, direccion, email;

    public Persona(String nombre, String apellido, String identificacion, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.identificacion = "";
        this.telefono = "";
        this.direccion = "";
        this.email = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws formatoEntradaException{
        Pattern pat = Pattern.compile("[0-9]");
        Matcher match = pat.matcher(this.nombre);
        if(nombre.equals("")){
            throw new formatoEntradaException(101, "nombre");
        }else if(match.find()){
            throw new formatoEntradaException(103, "nombre");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido)  throws formatoEntradaException{
        Pattern pat = Pattern.compile("[0-9]");
        Matcher match = pat.matcher(this.nombre);
        if(nombre.equals("")){
            throw new formatoEntradaException(101, "apellido");
        }else if(match.find()){
            throw new formatoEntradaException(103, "apellido");
        }
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion)  /*throws formatoEntradaException */{
        /*Pattern pat = Pattern.compile("[a - zA -Z]");
        Matcher match = pat.matcher(this.nombre);
        if(nombre.equals("")){
            throw new formatoEntradaException(101,"identificacion");
        }else if(match.find()){
            throw new formatoEntradaException(102,"identificacion");
        }*/
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        
        return telefono;
    }

    public void setTelefono(String telefono) /*throws formatoEntradaException */{
       /* Pattern pat = Pattern.compile("[a - zA -Z]");
        Matcher match = pat.matcher(this.nombre);
        if(nombre.equals("")){
            throw new formatoEntradaException(101,"telefono");
        }else if(match.find()){
            throw new formatoEntradaException(102,"telefono");
        }*/
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)  {
        this.email = email;
    }

    

    @Override
    public String toString() {
        return "nombre: " + nombre + " "+apellido+
                "\nidentificacion: " + identificacion+ 
                "\ntelefono: " + telefono
                +"\ndireccion: " + direccion
                +"\nemail: " + email;
    }
    
    
    
    
}
