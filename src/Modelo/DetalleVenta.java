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
public class DetalleVenta {
    
    private int id, cantidad, id_venta, bar_core; 
    private double precio;

    public DetalleVenta(int id, int cantidad, int id_venta, int bar_core, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.id_venta = id_venta;
        this.bar_core = bar_core;
        this.precio = precio;
    }

    public DetalleVenta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        
        this.cantidad = cantidad;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getBar_core() {
        return bar_core;
    }

    public void setBar_core(int bar_core) {
        this.bar_core = bar_core;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

   
    
    
    
}
