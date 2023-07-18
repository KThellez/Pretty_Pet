/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Giovanny Tellez Plazas 20192578003
 */
public class loginDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ConexionBD cn;
    //Login l;

    /**
     * Construcor parametrico que permite agregar los datos de conexcion y 
     * los metodos de java que se usaran...
     * @param con
     * @param ps
     * @param rs
     * @param cn
     */
    public loginDAO(Connection con, PreparedStatement ps, ResultSet rs, ConexionBD cn /*,Login l*/) {
        this.con = con;
        this.ps = ps;
        this.rs = rs;
        this.cn = cn;
        //this.l = l;
    }

    /**
     * contructor que inicializa la base de datos de la clase COnexion BD
     */
    public loginDAO() {
        //this.l = new Login();
        this.cn = new ConexionBD();
    }

    /**
     * Metodo que permite acceder al resto del programa una vez realizada 
     * la validacion de credenciales y respectiva conexcion a bd
     * ejempo (Pepe123, contra123)
     * @param correo
     * @param password
     * @return
     */
    public Login log(String correo, String password) {
        System.out.println("Entrando al metodo log...");
        Login l = new Login();
        String sql = "select * from user where email_address = ? and password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("name"));
                l.setApellido(rs.getString("last_name"));
                l.setCorreo(rs.getString("email_address"));
                l.setPassword(rs.getString("password"));

            }
            rs.close();
            cn.getConexion().close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error log "+ex.getMessage());
        } catch (NullPointerException ex) {
            //JOptionPane.showMessageDialog(null, "Error datos log  vacios "+ex.getMessage());
        }

        return l;
    }
}
