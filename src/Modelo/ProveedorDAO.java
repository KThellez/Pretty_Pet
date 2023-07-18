/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ProveedorDAO {

    Connection con;

    public boolean RegistrarProveedor(Proveedor pro) {
        ConexionBD cn = new ConexionBD();
        String sql = "insert into supplier(id_supplier, name, last_name, phone, address, email_address, code, fecha) "
                + "values(?,?,?,?,?,?,?,current_timestamp())";
        try {
            cn.conectar();
            con = cn.getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, pro.getIdentificacion());
                ps.setString(2, pro.getNombre());
                ps.setString(3, pro.getApellido());
                ps.setString(4, pro.getTelefono());
                ps.setString(5, pro.getDireccion());
                ps.setString(6, pro.getEmail());
                ps.setString(7, pro.getCodigoProveedor());
                System.out.println("PS\n" + ps.toString());
                ps.execute();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
            cn.getConnection().close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public boolean EliminarProveedor(Proveedor pro) {
        ConexionBD cn = new ConexionBD();
        System.out.println("    ///////////////////////////////////     ");
        System.out.println(pro.toString());
        String sql = "delete from supplier where id_supplier = "
                + "'" + pro.getIdentificacion() + "'";
        try {
            cn.conectar();
            con = cn.getConnection();
            JOptionPane.showMessageDialog(null, pro.toString());

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                System.out.println("PS\n" + ps.toString());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Se elimino el registro");
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
            cn.getConnection().close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public boolean ActualizarProveedor(Proveedor pro) {
        ConexionBD cn = new ConexionBD();
        System.out.println("    ///////////////////////////////////     ");
        System.out.println(pro.toString());
        String sql = "UPDATE supplier "
                + "SET id_supplier=?,name=?,"
                + "last_name=?,phone=?,address=?"
                + ",email_address=? WHERE id_supplier = "
                + pro.getIdentificacion();
        try {
            cn.conectar();
            con = cn.getConnection();
            JOptionPane.showMessageDialog(null, "Se actualizara\n" + pro.toString());

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                System.out.println("PS\n" + ps.toString());
                ps.setString(1, pro.getIdentificacion());
                ps.setString(2, pro.getNombre());
                ps.setString(3, pro.getApellido());
                ps.setString(4, pro.getTelefono());
                ps.setString(5, pro.getDireccion());
                ps.setString(6, pro.getEmail());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Se actualizo el registro");
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
            cn.getConnection().close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public List listaProveedores() {
        List<Proveedor> listaproveedor = new ArrayList();
        ConexionBD cn = new ConexionBD();

        ResultSet rs;

        try {
            con = cn.getConnection();
            String sql = "SELECT id_supplier, name, last_name, "
                    + "phone,address,email_address,code,fecha FROM supplier";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                rs = ps.executeQuery();
                try {
                    while (rs.next()) {
                        Proveedor pro = new Proveedor();
                        System.out.println("entro al while");
                        try {
                            pro.setIdentificacion(rs.getString("id_supplier"));
                            pro.setNombre(rs.getString("name"));
                            pro.setApellido(rs.getString("last_name"));
                            pro.setTelefono(rs.getString("phone"));
                            pro.setDireccion(rs.getString("address"));
                            pro.setEmail(rs.getString("email_address"));
                            pro.setCodigoProveedor(rs.getString("code"));
                        } catch (formatoEntradaException ex) {
                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                        }
                        System.out.println("DATOS BD PROVEEDOR\n" + pro.toString());

                        listaproveedor.add(pro);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        return listaproveedor;
    }

    public DefaultTableModel ListaProveedor(DefaultTableModel modelo) {
        ProveedorDAO proD = new ProveedorDAO();
        List<Proveedor> ListaPro = proD.listaProveedores();
        System.out.println("datos que encontro en la lista\n" + ListaPro.toString());

        Object[] objeto = new Object[8];
        for (int i = 0; i < ListaPro.size(); i++) {
            objeto[0] = ListaPro.get(i).getIdentificacion();
            objeto[1] = ListaPro.get(i).getNombre();
            objeto[2] = ListaPro.get(i).getApellido();
            objeto[3] = ListaPro.get(i).getTelefono();
            objeto[4] = ListaPro.get(i).getDireccion();
            objeto[5] = ListaPro.get(i).getEmail();
            objeto[6] = ListaPro.get(i).getCodigoProveedor();
            modelo.addRow(objeto);
        }
        return modelo;
    }

    public Proveedor buscarProID(String cod) {
        Proveedor proveedor = new Proveedor();
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from supplier where id_supplier = ?";
        try {
            con = cn.getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    proveedor.setIdentificacion(rs.getString("id_supplier"));
                    proveedor.setNombre(rs.getString("name"));
                    proveedor.setApellido(rs.getString("last_name"));
                    proveedor.setDireccion(rs.getString("address"));
                    proveedor.setEmail(rs.getString("email_address"));
                    proveedor.setTelefono(rs.getString("phone"));
                } catch (formatoEntradaException ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return proveedor;
    }
}
