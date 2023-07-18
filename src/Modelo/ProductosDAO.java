/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionBD;
import Controlador.AgregarDatosAlCMB;
import Vista.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductosDAO {

    Connection con;
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProductos(Producto pro, String x) {
        Products p = new Products();
        String sql = "INSERT INTO products (bar_code, name, description, amount, price, stock, id_supplier) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getId());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getCantidad());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getStock());
            ps.setString(7, x);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
            return false;
        } catch (ClassCastException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
            return false;
        }

    }

    
    
    
    public Producto BuscarId(int id) {
        Producto pro = new Producto();
        
        AgregarDatosAlCMB datos = new AgregarDatosAlCMB();
        
        System.out.println("DATO RECIBIDO DEBE SER EL CC DE ALGUN SUPPLIER "+ id);
        
        String sql = "SELECT * FROM supplier WHERE id_supplier = ?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getString("bar_code"));
                pro.setNombre(rs.getString("name"));
                pro.setDescripcion(rs.getString("description"));
                pro.setCantidad(rs.getInt("amount"));
                pro.setPrecio(rs.getDouble("price"));
                pro.setStock(rs.getInt("stock"));
                pro.setProveedor(rs.getString("id_supplier"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pro;
    }

    

    public boolean ActualizarProducto(Producto producto, String x) {
        String sql = "UPDATE products "
                + "SET bar_code=?,name=?,"
                + "description=?,amount=?,price=?"
                + ",stock=?,id_supplier=? WHERE bar_code = "
                + producto.getId();
        try {
            cn.conectar();
            con = cn.getConnection();
            JOptionPane.showMessageDialog(null, "Se actualizara\n" + producto.toString());

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                System.out.println("PS\n" + ps.toString());
                ps.setString(1, producto.getId());
                ps.setString(2, producto.getNombre());
                ps.setString(3, producto.getDescripcion());
                ps.setInt(4, producto.getCantidad());
                ps.setDouble(5, producto.getPrecio());
                ps.setInt(6, producto.getStock());
                ps.setString(7, x);
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

    public boolean EliminarProductos(Producto pro) {
        String sql = "delete from costumers where id_costumer = "
                + "'" + pro.getId() + "'";
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

    public Producto buscarProBarCode(String cod) {
        Producto pro = new Producto();
        String sql = "select * from products where bar_code = ?";
        try {
            con = cn.getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getString("bar_code"));
                pro.setNombre(rs.getString("name"));
                pro.setDescripcion(rs.getString("description"));
                pro.setCantidad(rs.getInt("amount"));
                pro.setPrecio(rs.getDouble("price"));
                pro.setStock(rs.getInt("stock"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return pro;
    }
     
    
    public DefaultTableModel ListaProducto(DefaultTableModel modelo) {
        List<Producto> ListaProduct = ListarProductos();
        System.out.println("datos que encontro en la lista\n" + ListaProduct.toString());

        Object[] objeto = new Object[8];
        for (int i = 0; i < ListaProduct.size(); i++) {
            objeto[0] = ListaProduct.get(i).getId();
            objeto[1] = ListaProduct.get(i).getNombre();
            objeto[2] = ListaProduct.get(i).getDescripcion();
            objeto[3] = ListaProduct.get(i).getCantidad();
            objeto[4] = ListaProduct.get(i).getPrecio();
            objeto[5] = ListaProduct.get(i).getStock();
            objeto[6] = ListaProduct.get(i).getProveedor();
            modelo.addRow(objeto);
        }
        return modelo;
    }
    
    public List ListarProductos() {
        List<Producto> Listapro = new ArrayList();
        String sql = "SELECT * FROM products";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getString("bar_code"));
                pro.setNombre(rs.getString("name"));
                pro.setDescripcion(rs.getString("description"));
                pro.setCantidad(rs.getInt("amount"));
                pro.setPrecio(rs.getDouble("price"));
                pro.setStock(rs.getInt("stock"));
                pro.setProveedor(rs.getString("id_supplier"));
                Listapro.add(pro);

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listapro;
    }
    
    public String validarProveedor(String d){
        System.out.println("DATOOOOOOOOOOOOOOOO QUE VALIDARA EL METODO PARA ENVIAR A SQL" + d);
        String[] split = d.split(" ");
        
        for (int i = 0; i < split.length; i++) {
            System.out.println("DATOOOOOOOS DEL SPLIIIIIIIIIT " + split[i] + "\n");
        }
        
        String sql = "SELECT id_supplier FROM supplier WHERE name = ? and last_name = ?";
        String id = "";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, split[0]);
            ps.setString(2, split[1]);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getString("id_supplier");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
}
