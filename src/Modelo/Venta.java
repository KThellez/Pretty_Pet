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
public class Venta {
    private String id_venta,cliente,vendedor;
    private double total;

    public Venta() {
    }

    public Venta(String id_venta, String cliente, String vendedor, double total) {
        this.id_venta = id_venta;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }
    

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente)  {
        
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", cliente=" + cliente + ", vendedor=" + vendedor + ", total=" + total + '}';
    }
    
    
    
    
}
