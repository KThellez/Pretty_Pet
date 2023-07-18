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
public class ClienteDAO {

    Connection con;

    /**
     * Permite registrar a un cliente por medio del parametro cliente que recibe.
     * @param cl
     * @return retorna un valor booleano
     */
    public boolean RegistrarCliente(Cliente cl) {
        ConexionBD cn = new ConexionBD();
        String sql = "insert into costumers(id_costumer, name, last_name, phone, address, email_address, code, fecha) "
                + "values(?,?,?,?,?,?,?,current_timestamp())";
        try {
            cn.conectar();
            con = cn.getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, cl.getIdentificacion());
                ps.setString(2, cl.getNombre());
                ps.setString(3, cl.getApellido());
                ps.setString(4, cl.getTelefono());
                ps.setString(5, cl.getDireccion());
                ps.setString(6, cl.getEmail());
                ps.setString(7, cl.getCodigoCliente());
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

    /**
     * Permite eliminar a un cliente por medio del parametro cliente que recibe.
     * @param cl
     * @return Bool
     */
    public boolean EliminarCliente(Cliente cl) {
        ConexionBD cn = new ConexionBD();
        System.out.println("    ///////////////////////////////////     ");
        System.out.println(cl.toString());
        String sql = "delete from costumers where id_costumer = "
                + "'" + cl.getIdentificacion() + "'";
        try {
            cn.conectar();
            con = cn.getConnection();
            JOptionPane.showMessageDialog(null, cl.toString());

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

    /**
     * Permite actualizar a un cliente por medio del parametro cliente que recibe.
     * @param cl
     * @return bool
     */
    public boolean ActualizarCliente(Cliente cl) {
        ConexionBD cn = new ConexionBD();
        System.out.println("    ///////////////////////////////////     ");
        System.out.println(cl.toString());
        String sql = "UPDATE costumers "
                + "SET id_costumer=?,name=?,"
                + "last_name=?,phone=?,address=?"
                + ",email_address=? WHERE id_costumer = "
                + cl.getIdentificacion();
        try {
            cn.conectar();
            con = cn.getConnection();
            JOptionPane.showMessageDialog(null, "Se actualizara\n" + cl.toString());

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                System.out.println("PS\n" + ps.toString());
                ps.setString(1, cl.getIdentificacion());
                ps.setString(2, cl.getNombre());
                ps.setString(3, cl.getApellido());
                ps.setString(4, cl.getTelefono());
                ps.setString(5, cl.getDireccion());
                ps.setString(6, cl.getEmail());
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

    /** 
     * crea una lista de clientes por medio de un ArrayList
     * @return List
     */
    public List listaClientes() {
        List<Cliente> listacliente = new ArrayList();
        ConexionBD cn = new ConexionBD();

        ResultSet rs;

        try {
            con = cn.getConnection();
            String sql = "SELECT id_costumer, name, last_name, "
                    + "phone,address,email_address,code,fecha FROM costumers";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                rs = ps.executeQuery();
                try {
                    while (rs.next()) {
                        Cliente cl = new Cliente();
                        System.out.println("entro al while");
                        try {
                            cl.setIdentificacion(rs.getString("id_costumer"));
                            cl.setNombre(rs.getString("name"));
                            cl.setApellido(rs.getString("last_name"));
                            cl.setTelefono(rs.getString("phone"));
                            cl.setDireccion(rs.getString("address"));
                            cl.setEmail(rs.getString("email_address"));
                            cl.setCodigoCliente(rs.getString("code"));
                        } catch (formatoEntradaException ex) {
                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                        }
                        System.out.println("DATOS BD CLIENTE\n" + cl.toString());

                        listacliente.add(cl);
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

        return listacliente;
    }

    /**
     * crea una tabla de clientes por medio de un modelo y la lista de clientes
     * @param modelo
     * @return DefaultTableModel
     */
    public DefaultTableModel ListasCliente(DefaultTableModel modelo) {
        ClienteDAO clD = new ClienteDAO();
        List<Cliente> ListaCl = clD.listaClientes();
        System.out.println("datos que encontro en la lista\n" + ListaCl.toString());

        Object[] objeto = new Object[8];
        for (int i = 0; i < ListaCl.size(); i++) {
            objeto[0] = ListaCl.get(i).getIdentificacion();
            objeto[1] = ListaCl.get(i).getNombre();
            objeto[2] = ListaCl.get(i).getApellido();
            objeto[3] = ListaCl.get(i).getTelefono();
            objeto[4] = ListaCl.get(i).getDireccion();
            objeto[5] = ListaCl.get(i).getEmail();
            objeto[6] = ListaCl.get(i).getCodigoCliente();
            modelo.addRow(objeto);
        }
        return modelo;
    }

    /**
     * Permite buscar los datos de un cliente por medio de un codigo
     * @param cod
     * @return Cliente
     */
    public Cliente buscarProID(String cod) {
        Cliente cliente = new Cliente();
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from costumers where id_costumer = ?";
        try {
            con = cn.getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    cliente.setIdentificacion(rs.getString("id_costumer"));
                    cliente.setNombre(rs.getString("name"));
                    cliente.setApellido(rs.getString("last_name"));
                    cliente.setDireccion(rs.getString("address"));
                    cliente.setEmail(rs.getString("email_address"));
                    cliente.setTelefono(rs.getString("phone"));
                } catch (formatoEntradaException ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return cliente;
    }

    /**
     *  Permite buscar los datos de un cliente por medio de un ID
     * @param Id
     * @return Cliente
     */
    public Cliente buscarCliente(int Id) {
        Cliente cl = new Cliente();
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from costumers where id_costumer = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    cl.setNombre(rs.getString("name"));
                    cl.setApellido(rs.getString("last_name"));
                    cl.setTelefono(rs.getString("phone"));
                    cl.setDireccion(rs.getString("address"));
                    cl.setEmail(rs.getString("email_address"));
                } catch (formatoEntradaException ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showInputDialog(ex.getMessage());
        }
        return cl;
    }

}
