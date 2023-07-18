
package Controlador;

import Conexion.ConexionBD;
import Modelo.Items;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Esta clase nos permite agregar los datos de lso proveedores a un combo Box
 * para se usados en una vista a posterior.
 * y asi no perder los datos llenados en el combo box
 * @author Cristian Giovanny Tellez Plazas 20192578003
 */
public class AgregarDatosAlCMB {

    Connection con;
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;

    /**
     * get usuario Obtiene busca los proveedores en la base de datos y los trae
     * para agregarlos en un combo box
     * @param box
     */
    public void getUsuario(JComboBox box) {
        ArrayList<Items> listaCmb = new ArrayList();
        String sql = "SELECT * FROM supplier";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                box.addItem(rs.getString("name") + " " + rs.getString("last_name"));
                
                listaCmb.add(new Items(rs.getString("id_supplier"), rs.getString("name")));
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }

    }

}
