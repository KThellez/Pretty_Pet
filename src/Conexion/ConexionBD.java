
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonia Pinzón
 */
public class ConexionBD {
    Connection con;
    private Connection conexion;
    private String bd, usuario, clave, mensaje;
    
    /**
     * Constructor parametrico que inicializa los parabetros para realizar la conexciion
     * con la base de datos
     * 
     * @param conexion
     * @param bd
     * @param usuario
     * @param clave
     * @param mensaje
     */
    public ConexionBD(Connection conexion, String bd, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }

    /**
     * constructor que permite inicializar los parametros con el valor
     * que necesitara la base de datos para ingresar y poder conectarse 
     * a la misma
     * 
     */
    public ConexionBD() {
        this.conexion = null;
        this.bd = "prettypetstore";
        this.usuario = "root";
        this.clave = "";
        this.mensaje = "";

    }

    /**
     * el metodo conectar nos permite acceder a la base de datos de XAMMP
     */
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ruta = "jdbc:mysql://localhost/" + bd;
            System.out.println(ruta);
            conexion = DriverManager.getConnection(ruta, usuario, clave);
            mensaje = "Conexión exitosa...";
            JOptionPane.showMessageDialog(null, mensaje);
        } catch (ClassNotFoundException ex) {
            mensaje = "No se pudo establecer conexion...";
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            mensaje = " No se puede conectar con MySQL...";
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Conexccion nos retorna null si no se puede realizar la conexcion
     * con la base de datos
     *  de lo contrario nos retornara la conexcion exitosa con su url
     * @return
     */
    public Connection getConnection() {
        try {
            
            String myBD = "jdbc:mysql://localhost:3306/"+ bd;
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * retorna una cadena de caracteres con los datos registrados
     * @return
     */
    @Override
    public String toString() {
        return "Conexion{" + "conexion=" + conexion + ", bd=" + bd
                + ", usuario=" + usuario + ", clave=" + clave + ", mensaje="
                + mensaje + '}';
    }

    /**
     * retorna la conexcion
     * @return
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * agrega un valir a la conexion
     * @param conexion
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     *retorna el nombre de la base de datos 
     * @return
     */
    public String getBd() {
        return bd;
    }

    /**
     * agrega el nombre de la base de datos al parametro bd
     * @param bd
     */
    public void setBd(String bd) {
        this.bd = bd;
    }

    /**
     * retorna el valor que tien el usuaario
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * agrega un valor a la variable usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * retorna una clave
     * @return
     */
    public String getClave() {
        return clave;
    }

    /**
     * permite agregar una clave a la variable clave
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * retorna un mensaje 
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * permite agregar un mensaje
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
