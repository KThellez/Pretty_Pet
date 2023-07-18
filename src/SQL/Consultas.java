/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

/**
 *
 * @author PC
 */
public class Consultas {
    /*
    public DefaultTableModel consultar() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD con = new ConexionBD();
        try {
            con.conectar();
            Statement consulta = con.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("SELECT formulario.Fecha, "
                    + "persona.Id, persona.Nombre, persona.Apellido,"
                    + "persona.Tel, inmueble.tipo_inmueble, inmueble.CHIP , "
                    + "inmueble.Direccion, inmueble.Metros2, inmueble.Valor, "
                    + "inmueble.CanBan, inmueble.CanHab, inmueble.Pisos "
                    + "FROM formulario "
                    + "join persona on (persona.Id = formulario.Id_Propietario) "
                    + "join inmueble on (inmueble.CHIP = formulario.CHIP_Inmueble)"
                    + "ORDER BY formulario.Fecha;");

            ResultSetMetaData campos = datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while (datos.next()) {
                Object fila[] = new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                    fila[i] = datos.getObject(i + 1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            con.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return plantilla;
    }

    public DefaultTableModel buscar() {
        DefaultTableModel plantilla = new DefaultTableModel();
        Persona persona = new Persona();

        ConexionBD con = new ConexionBD();
        try {

            con.conectar();
            Statement consulta = con.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("SELECT formulario.Fecha, "
                    + "persona.Id, persona.Nombre, persona.Apellido,"
                    + "persona.Tel, inmueble.CHIP , inmueble.Direccion, "
                    + "inmueble.Metros2, inmueble.Valor, inmueble.CanBan, "
                    + "inmueble.CanHab, inmueble.Pisos FROM formulario "
                    + "join persona on (persona.Id = formulario.Id_Propietario) "
                    + "join inmueble on (inmueble.CHIP = formulario.CHIP_Inmueble)"
                    + " WHERE " + tab.getKeytable().getItemAt(tab.getKeytable().getSelectedIndex()) + '.'
                    + tab.getKeyword().getItemAt(tab.getKeyword().getSelectedIndex()) + " = '"
                    + tab.getTxtBuscarBD().getText() + "'"
            );

            ResultSet tipo_inmueble = consulta.executeQuery("SELECT "
                    + "inmueble.tipo_inmueble from inmueble "
                    + "where inmueble." + tab.getKeyword().getSelectedIndex()
                    + " = '" + tab.getTxtBuscarBD() + "';");
            String inm = tipo_inmueble.getNString("tipo_inmueble");
            Casa c = new Casa();
            Apartamento a = new Apartamento();

            if ("Casa".equals(inm)) {
                while (datos.next()) {
                    persona.setNombre(datos.getString("Nombre"));
                    persona.setApellido(datos.getString("Apellido"));
                    persona.setId(datos.getString("Id"));
                    persona.setTel(datos.getString("Tel"));
                    c.setDireccion(datos.getString("Direccion"));
                    c.setMetros(Integer.parseInt(datos.getString("Metros2")));
                    c.setValor(Double.parseDouble(datos.getString("Valor")));
                    c.setCanTBan(Integer.parseInt(datos.getString("CanBan")));
                    c.setCantHab(Integer.parseInt(datos.getString("CanHab")));
                    c.setCantPisos(Integer.parseInt(datos.getString("Pisos")));
                }
            }
            if ("Apartamento".equals(inm)) {
                while (datos.next()) {
                    persona.setNombre(datos.getString("Nombre"));
                    persona.setApellido(datos.getString("Apellido"));
                    persona.setId(datos.getString("Id"));
                    persona.setTel(datos.getString("Tel"));
                    a.setDireccion(datos.getString("Direccion"));
                    a.setMetros(Integer.parseInt(datos.getString("Metros2")));
                    a.setValor(Double.parseDouble(datos.getString("Valor")));
                    a.setCantBan(Integer.parseInt(datos.getString("CanBan")));
                    a.setCantHab(Integer.parseInt(datos.getString("CanHab")));
                    a.setPisoLoc(Integer.parseInt(datos.getString("Pisos")));
                }
            }
            ResultSetMetaData campos = datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while (datos.next()) {
                Object fila[] = new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                    fila[i] = datos.getObject(i + 1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            con.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return plantilla;
    }

    public String insertar() {
       Persona persona = new Persona();
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            String comando = "insert into persona values('" + persona.getNombre() + "  "
                    + persona.getApellido() + "','" + persona.getId() + "','" + persona.getTel() + "')\n"
                    + "insert into inmueble values('" + persona.getNombre() + "  "
                    + persona.getApellido() + "','" + persona.getId() + "','" + persona.getTel();
            consulta = conexion.getConexion().createStatement();
            consulta.execute(comando);
            mensaje = "Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar insertar...\n" + ex;
        }
        return mensaje;
    }

    public String insertar2(Persona persona, Casa casa, Apartamento a) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date fecha = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        String mensaje = "";
        if (casa != null) {
            try {

                ConexionBD conexion = new ConexionBD();
                PreparedStatement consulta1 = null;
                PreparedStatement consulta2 = null;
                PreparedStatement consulta3 = null;

                conexion.conectar();
                String comando1 = "insert into persona values(?,?,?,?)";
                consulta1 = conexion.getConexion().prepareStatement(comando1);
                consulta1.setString(1, persona.getId());
                consulta1.setString(2, persona.getNombre());
                consulta1.setString(3, persona.getApellido());
                consulta1.setString(4, persona.getTel());
                consulta1.execute();
                String comando2 = "insert into inmueble values(?,?,?,?,?,?,?)";
                consulta2 = conexion.getConexion().prepareStatement(comando1);
                consulta2.setString(1, casa.getCHIP());
                consulta2.setString(2, casa.getDireccion());
                consulta2.setInt(3, casa.getMetros());
                consulta2.setDouble(4, casa.getValor());
                consulta2.setInt(5, casa.getCanTBan());
                consulta2.setInt(6, casa.getCantHab());
                consulta2.setInt(7, casa.getCantPisos());
                consulta2.setString(8, casa.getTipo());
                consulta2.execute();
                conexion.conectar();
                String comando3 = "insert into formulario values(?,?,?)";
                consulta3 = conexion.getConexion().prepareStatement(comando1);
                consulta3.setString(1, persona.getId());
                consulta3.setString(2, casa.getCHIP());
                consulta3.setDate(3, (java.sql.Date) fecha);
                consulta3.execute();
                conexion.conectar();
                mensaje = "Registro exitoso...";
                consulta1.close();
                consulta2.close();
                consulta3.close();
                conexion.getConexion().close();
            } catch (SQLException ex) {
                mensaje = "Error al intentar insertar...\n" + ex;
            }
        }
        if (a != null) {
            try {
                ConexionBD conexion = new ConexionBD();
                PreparedStatement consulta1 = null;
                PreparedStatement consulta2 = null;
                PreparedStatement consulta3 = null;
                conexion.conectar();
                String comando1 = "insert into persona values(?,?,?,?)";
                consulta1 = conexion.getConexion().prepareStatement(comando1);
                consulta1.setString(1, persona.getId());
                consulta1.setString(2, persona.getNombre());
                consulta1.setString(3, persona.getApellido());
                consulta1.setString(4, persona.getTel());
                consulta1.execute();
                conexion.conectar();
                String comando2 = "insert into inmueble values(?,?,?,?,?,?,?,?)";
                consulta2 = conexion.getConexion().prepareStatement(comando1);
                consulta2.setString(1, a.getCHIP());
                consulta2.setString(2, a.getDireccion());
                consulta2.setInt(3, a.getMetros());
                consulta2.setDouble(4, a.getValor());
                consulta2.setInt(5, a.getCantBan());
                consulta2.setInt(6, a.getCantHab());
                consulta2.setInt(7, a.getPisoLoc());
                consulta2.setString(8, a.getTipo());
                consulta2.execute();
                conexion.conectar();
                String comando3 = "insert into formulario values(?,?,?)";
                consulta3 = conexion.getConexion().prepareStatement(comando1);
                consulta3.setString(1, persona.getId());
                consulta3.setString(2, a.getCHIP());
                consulta3.setDate(3, (java.sql.Date) fecha);
                consulta3.execute();

                mensaje = "Registro exitoso...";
                consulta1.close();
                consulta2.close();
                consulta3.close();

                conexion.getConexion().close();
            } catch (SQLException ex) {
                mensaje = "Error al intentar insertar...\n" + ex;
            }
        }
        return mensaje;
    }

    public String actualizar() {
        Persona persona = new Persona();
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();

            String instruccion = "update persona "
                    + "set Nombre=?, Apellido=?, Id=?, Tel=? where Id='"
                    + persona.getId() + "'";
            consulta = conexion.getConexion().prepareStatement(instruccion);
            consulta.setString(1, persona.getId());
            consulta.setString(2, persona.getNombre());
            consulta.setString(3, persona.getApellido());
            consulta.setString(4, persona.getTel());
            consulta.execute();
            mensaje = "Actualizacion exitosa...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar actualizar...\n" + ex;
        }
        return mensaje;

    }

    public String eliminar() {
        Persona persona = new Persona();
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();

            String comando = "drop from persona "
                    + " where Id='" + persona.getId() + "'";
            consulta = conexion.getConexion().prepareStatement(comando);
            consulta.execute();
            mensaje = "Eliminacion exitosa...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar eliminar...\n" + ex;
        }
        return mensaje;

    }*/

    
}
