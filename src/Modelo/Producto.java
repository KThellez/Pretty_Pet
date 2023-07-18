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
public class Producto {
    protected String Id, nombre, descripcion, proveedor;
    protected int cantidad, stock;
    protected double precio;
    Fecha Fecha;

    public Producto(String Id, String nombre, String descripcion, String proveedor, int cantidad, int stock, double precio, Fecha Fecha) {
        this.Id = Id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.stock = stock;
        this.precio = precio;
        this.Fecha = Fecha;
    }

    

    public Producto() {
        this.Id = "";
        this.nombre = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.stock = 0;
        this.precio = 0;
        this.Fecha = null;
    }

    public String getId() {
        return Id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Fecha getFecha() {
        return Fecha;
    }

    public void setFecha(Fecha Fecha) {
        this.Fecha = Fecha;
    }
    



    
    @Override
    public String toString() {
        return  "Id: " + Id +
                "\nnombre: " + nombre +
                "\ndescripcion: " + descripcion +
                "\ncantidad: " + cantidad+
                "\nstock: " + stock +
                "\nprecio: " + precio +
                "\nfecha: " + Fecha  ;
    }
    
    
    
    
    
}
