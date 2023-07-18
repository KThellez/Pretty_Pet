/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 * 
 * @author Cristian Giovanny Tellez Plazas 20192578003
 */
public class Login {
    private int id;
    private String nombre, apellido, correo, password;
   
    /**
     * Constructor  vacio
     */
    public Login() {
        
    }

    /**
     * Construcor parametrico que permite inicializar por ejemplo
     * nuevo usuario (3333222, Pablo, Escamilla, correo@correo.com, *****password)
     * @param id
     * @param nombre
     * @param apellido
     * @param correo
     * @param password
     */
    public Login(int id, String nombre, String apellido, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
    }

    /**
     * permite acceder al valor del id 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * retorna el valor del id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *permite acceder al valor del nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * retorna el valor del nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * permite acceder al valor del apellido 
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * retorna el valor del pellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *permite acceder al valor del correo 
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * retorna el valor del correo
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *permite acceder al valor del password 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * retorna el valor del contrasenia
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * retorna el la cadena con las credenciales.
     * @return
     */
    @Override
    public String toString() {
        return "Login{" + "id=" + id + 
                ", nombre=" + nombre + ", apellido=" 
                + apellido + ", correo=" + correo + ", password="
                + password + '}';
    }
    
    
       
}
