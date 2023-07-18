
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class DatosEm {
    private String id, nombre, telefono, direccion, email;

    /**
     * Constructor PArametrico que permite inicializar los datos de la empresa
     * ejemp (123056, Sabritas, 3123323215, Sabritas #50-20 sur, sabritas@correo.com)
     * @param id
     * @param nombre
     * @param telefono
     * @param direccion
     * @param email
     */
    public DatosEm(String id, String nombre, String telefono, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    /**
     * Construcor que permite inicializar los valores y limiarpos.
     */
    public DatosEm() {
        this.id = "";
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.email = "";
    }

    /**
     * permite acceder al valor del id
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * permite ingresar un valor al id
     * @param id
     * @throws formatoEntradaException
     */
    public void setId(String id) throws formatoEntradaException{
        this.id = id;
    }

    /**
     * permite acceder al valor del nombre
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * permite ingresar el valor al nombre
     * @param nombre
     * @throws formatoEntradaException
     */
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

    /**
     * permite acceder al valor del telefono
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * permite darle un valor al telefono
     * @param telefono
     * @throws formatoEntradaException
     */
    public void setTelefono(String telefono) throws formatoEntradaException{
        Pattern pat = Pattern.compile("[a - zA -Z]");
        Matcher match = pat.matcher(this.telefono);
        if(telefono.equals("")){
            throw new formatoEntradaException(101,"telefono");
        }else if(match.find()){
            throw new formatoEntradaException(102,"telefono");
        }
        this.telefono = telefono;
    }

    /**
     * permite acceder al valor de la direccion
     * @return String 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *  permite ignresar un valor de direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * permite acceder al valor del Email
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * permite ingresar un valor de email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *  retorna cadena de caracteres
     * @return String
     */
    @Override
    public String toString() {
        return 
                "id:" + id + "\nnombre" + nombre + "n\telefono" + telefono 
                + "\ndireccion" + direccion + "\nemail" + email;
    }
    
    
    
    
}
