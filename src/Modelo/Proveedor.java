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
public class Proveedor extends Persona {
    
    private String codigoProveedor;
    CodAleatorio CodigoAleatorio;

    public Proveedor(String codigoProveedor, CodAleatorio CodigoAleatorio, String nombre, String apellido, String identificacion, String telefono, String direccion, String email) {
        super(nombre, apellido, identificacion, telefono, direccion, email);
        this.codigoProveedor = codigoProveedor;
        this.CodigoAleatorio = CodigoAleatorio;
    }

    
    
    public Proveedor() {
        super();
        this.codigoProveedor = "";
        this.CodigoAleatorio = null;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public CodAleatorio getCodigoAleatorio() {
        return CodigoAleatorio;
    }

    public void setCodigoAleatorio(CodAleatorio CodigoAleatorio) {
        this.CodigoAleatorio = CodigoAleatorio;
    }

   

    @Override
    public String toString() {
        return "Proveedor " + super.toString() + "\nCodigo Cliente: " + codigoProveedor ;
    }
    
    public String codigo(){
        //El indice que se envia es la longitud de caracteres que requiere el codigo
        String cadena = CodAleatorio.getRandomString(7);
        this.codigoProveedor = cadena;
        return cadena;
    }
    
    

    
    
    
    
    
}
