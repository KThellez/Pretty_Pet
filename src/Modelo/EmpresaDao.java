/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import Vista.DatosEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class EmpresaDao {

    Connection con;
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;

    public DatosEm buscarEmpresa() throws formatoEntradaException {
        DatosEm empresa = new DatosEm();
        String sql = "select * from company";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                empresa.setId(rs.getString("id"));
                empresa.setNombre(rs.getString("name"));
                empresa.setTelefono(rs.getString("phone"));
                empresa.setDireccion(rs.getString("address"));
                empresa.setEmail(rs.getString("Email_address"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        return empresa;
    }

    

}
