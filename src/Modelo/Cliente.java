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
public class Cliente extends Persona {
    
    private String codigoCliente;
    CodAleatorio CodigoAleatorio;

    /**
     * Contrusctor que permite inicializar los parametros del cliente
     * ejemplo (Carlos, Perez, 1000123123, 6017902136, correo@correo.com)
     * @param codigoCliente
     * @param CodigoAleatorio
     * @param nombre
     * @param apellido
     * @param identificacion
     * @param telefono
     * @param direccion
     * @param email
     */
    public Cliente(String codigoCliente, CodAleatorio CodigoAleatorio, String nombre, String apellido, String identificacion, String telefono, String direccion, String email) {
        super(nombre, apellido, identificacion, telefono, direccion, email);
        this.codigoCliente = codigoCliente;
        this.CodigoAleatorio = CodigoAleatorio;
    }

    /**
     *constructor que inicializa la super clase y los valores del codigo aleatorio
     * que se genera para el cliete
     */
    public Cliente() {
        super();
        this.codigoCliente = "";
        this.CodigoAleatorio = null;
    }

    /**
     * retorna el codigo de tipo String al cliente
     * @return String
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     *  agrega un valor el parametro codigoCliente 
     * @param codigoCliente
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * retorna un valor de tipo CodAleatorio .
     * @return
     */
    public CodAleatorio getCodigoAleatorio() {
        return CodigoAleatorio;
    }

    /**
     * permite cambiar el valor del Codigo aleatorio
     * @param CodigoAleatorio
     */
    public void setCodigoAleatorio(CodAleatorio CodigoAleatorio) {
        this.CodigoAleatorio = CodigoAleatorio;
    }

    /**
     * retorna una cadena de caracteres.
     * @return String
     */
    @Override
    public String toString() {
        return "Cliente " + super.toString() + "\nCodigo Cliente: " + codigoCliente ;
    }
    
    /**
     * retorna una cadena de caracteres con el codigo aleatorio generado.
     * @return String
     */
    public String codigo(){
        //El indice que se envia es la longitud de caracteres que requiere el codigo
        String cadena = CodAleatorio.getRandomString(7);
        this.codigoCliente = cadena;
        return cadena;
    }
    
    

    
    
    
    
    
}
