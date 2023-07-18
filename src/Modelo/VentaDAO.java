/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import Vista.NewSale;
import Vista.Sales;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class VentaDAO {

    int r = 0;

    public int RegistrrarVenta(Venta v) {
        Connection con;
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;

        String sql = "insert into sales(costumer, salesman, total) values (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();

            con.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return r;
    }

    public int RegistrarDetalle(DetalleVenta DetaVent) {
        String sql = "insert into details(code_product, amount, price, id_sales) values (?,?,?,?)";
        Connection con;
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, DetaVent.getBar_core());
            ps.setInt(2, DetaVent.getCantidad());
            ps.setDouble(3, DetaVent.getPrecio());
            ps.setInt(4, DetaVent.getId_venta());
            ps.execute();

            con.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return r;
    }

    public int IdVenta() {
        String sql = "select MAX(id_sales) from  sales";
        Connection con;
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            con.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

        return id;
    }

    public boolean ActualizarStock(int cant, String cod) {

        String sql = "update products set stock = ? where bar_code = ?";
        Connection con;
        ConexionBD cn = new ConexionBD();
        PreparedStatement ps;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }

        
    }
    public List listaVentas() throws formatoEntradaException {
        List<Venta> listaventa = new ArrayList();
        ConexionBD cn = new ConexionBD();

        ResultSet rs;

        try {
            Connection con ;
            con = cn.getConnection();
            String sql = "SELECT * FROM sales";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                rs = ps.executeQuery();
                try {
                    while (rs.next()) {
                        Venta venta = new Venta();
                        System.out.println("entro al while");
                        venta.setId_venta(rs.getString("id_sales"));
                        venta.setCliente(rs.getString("costumer"));
                        venta.setVendedor(rs.getString("salesman"));
                        venta.setVendedor(rs.getString("salesman"));
                        venta.setTotal(rs.getDouble("total"));
                        System.out.println("DATOS BD CLIENTE\n" + venta.toString());

                        listaventa.add(venta);
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

        return listaventa;
    }
    public DefaultTableModel ListaVenta(DefaultTableModel modelo) throws formatoEntradaException {
        VentaDAO venD = new VentaDAO();
        List<Venta> ListaVen = listaVentas();
        System.out.println("datos que encontro en la lista\n" + ListaVen.toString());
        Sales s = new Sales();
        
        modelo = (DefaultTableModel) s.getTablaSales().getModel();
        
        Object[] objeto = new Object[4];
        for (int i = 0; i < ListaVen.size(); i++) {
            objeto[0] = ListaVen.get(i).getId_venta();
            objeto[1] = ListaVen.get(i).getCliente();
            objeto[2] = ListaVen.get(i).getVendedor();
            objeto[3] = ListaVen.get(i).getTotal();

            modelo.addRow(objeto);
        }
        return modelo;
    }
}
