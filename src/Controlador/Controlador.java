/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.*;
import Login.*;
import Modelo.*;
import Reportes.*;
import Reportes.Excel;
import Vista.*;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian Giovanny Tellez Plazas 20192578003
 * 
 * La clase Controlador permite llamar y utilizar las clases del modelo, asi
 * como sus propiedades
 * 
 */
public class Controlador implements ActionListener, Runnable {

    LogIn vistaLog;
    ConexionBD conexion;
    ValidarLogin validar;
    VentanaMaster ventanaP;
    NewSale newSale;
    Costumer costumer;
    DatosEmpresa companyData;
    DatosEm emp;
    Products products;
    Sales sales;
    Suppliers supp;
    Venta venta;
    VentaDAO ventaD;
    DetalleVenta detalle;
    Tiempo objH;
    Thread hilo;

    double totalPago = 0.0;
    int it;
    Pdf p;

    /**
     *Constructore del controlador, nos sirve para inicializar todas las clases
     * variables y/o vistas que necesitara usar nuestro controlador.
     */
    public Controlador() {
        /** Instancia la  vista login*/
        this.vistaLog = new LogIn();
        /** Instancia la  la conexion con la base de datos*/
        this.conexion = new ConexionBD();
        /** Instancia la clase para validad los datos del login*/
        this.validar = new ValidarLogin();
        /** Instancia la  ventana MDI principal*/
        this.ventanaP = new VentanaMaster();
        /** Instancia la  vista  nueva venta*/
        this.newSale = new NewSale();
        /** Instancia la  vista cliente*/
        this.costumer = new Costumer();
        /** Instancia la  vista datos de la empresa*/
        this.companyData = new DatosEmpresa();
        /** Instancia la  vista ventas*/
        this.sales = new Sales();
        /** Instancia la  vista proveedores*/
        this.supp = new Suppliers();
        /** Instancia la  vista productos*/
        this.products = new Products();
        /** Instancia la  clase venta*/
        this.venta = new Venta();
        /** Instancia la  clase venta parametro DAO*/
        this.ventaD = new VentaDAO();
        /** Instancia la  clase detalle de ventas*/
        this.detalle = new DetalleVenta();
        /** Instancia la  clase que genera pdf*/
        this.p = new Pdf();
        /**Instancia la clase de Tiempo*/
        this.objH = new Tiempo();
        /** Instancia la  clase hilo que hereda de Thread*/
        this.hilo = new Thread(this);
        /** Instancia la  clase datos de la empresa*/
        this.emp = new DatosEm();

        ///////////////////////////////////////////////////////////////////////
        /**Agrega un escuchador al boton sign in */
        this.vistaLog.getBtnSingIn().addActionListener(this);
        /**Agrega un escuchador al boton nueva venta */
        this.ventanaP.getNewSale().addActionListener(this);
        /**Agrega un escuchador al boton clientes */
        this.ventanaP.getCostumers().addActionListener(this);
        /**Agrega un escuchador al boton proveedores */
        this.ventanaP.getSuppliers().addActionListener(this);
        /**Agrega un escuchador al boton productos */
        this.ventanaP.getProducts().addActionListener(this);
        /**Agrega un escuchador al boton ventas */
        this.ventanaP.getSales().addActionListener(this);
        /**Agrega un escuchador al boton sobre*/
        this.ventanaP.getSobre().addActionListener(this);

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        //ADD ACTIONLISTENER TO COSTUMER!
        /**Agrega un escuchador al boton crear*/
        this.costumer.getBtnCrate().addActionListener(this);
        /**Agrega un escuchador al boton borrar */
        this.costumer.getBtnDelete().addActionListener(this);
        /**Agrega un escuchador al imprimir in */
        this.costumer.getBtnPrint().addActionListener(this);
        /**Agrega un escuchador al boton leer */
        this.costumer.getBtnRead().addActionListener(this);
        /**Agrega un escuchador al boton salvar */
        this.costumer.getBtnSave().addActionListener(this);
        /**Agrega un escuchador al actualizar */
        this.costumer.getBtnUpdate().addActionListener(this);

        ////////////////////////////////////////////////////////////////////////
        //ADD ACTIONLISTENER TO NEWSALE
        /**Agrega un escuchador al boton borrar */
        this.newSale.getBtnDelete().addActionListener(this);
        /**Agrega un escuchador al imprimir in */
        this.newSale.getBtnPrint().addActionListener(this);
        ////////////////////////////////////////////////////////////////////////
        //ADD ACTIONLISTENER TO PRODUCTS
        /**Agrega un escuchador al boton crear*/
        this.products.getBtnCrate().addActionListener(this);
        /**Agrega un escuchador al boton borrar */
        this.products.getBtnDelete().addActionListener(this);
        /**Agrega un escuchador al imprimir in */
        this.products.getBtnPrint().addActionListener(this);
        /**Agrega un escuchador al boton leer */
        this.products.getBtnRead().addActionListener(this);
        /**Agrega un escuchador al boton salvar */
        this.products.getBtnSave().addActionListener(this);
        /**Agrega un escuchador al boton actualizar */
        this.products.getBtnUpdate().addActionListener(this);
        /**Agrega un escuchador al boton registros */
        this.products.getBtnRegistros().addActionListener(this);
        ////////////////////////////////////////////////////////////////////////
        //ADD ACTIONLISTENER TO Sales!
        /**Agrega un escuchador al boton pdf in */
        this.sales.getBtnPdf().addActionListener(this);
        ////////////////////////////////////////////////////////////////////////
        //ADD ACTIONLISTENER TO SUPPLIERS!
        /**Agrega un escuchador al boton crear*/
        this.supp.getBtnCrate().addActionListener(this);
        /**Agrega un escuchador al boton borrar */
        this.supp.getBtnDelete().addActionListener(this);
        /**Agrega un escuchador al imprimir in */
        this.supp.getBtnPrint().addActionListener(this);
        /**Agrega un escuchador al boton leer */
        this.supp.getBtnRead().addActionListener(this);
        /**Agrega un escuchador al boton salvar */
        this.supp.getBtnSave().addActionListener(this);
        /**Agrega un escuchador al boton actualizar */
        this.supp.getBtnUpdate().addActionListener(this);
        ////////////////////////////////////////////////////////////////////////
        //ADD ACTIONLISTENER TO COMPANY DATA!
        this.companyData.getBtnCompanyData().addActionListener(this);
        ////////////////////////////////////////////////////////////////////////
        // ADD ACTIONLISTENER TO NEW SALE
        /**Agrega un escuchador al boton borrar */
        this.newSale.getBtnDelete().addActionListener(this);
        /**Agrega un escuchador al imprimir in */
        this.newSale.getBtnPrint().addActionListener(this);
        /**Agrega un escuchador al boton buscar */
        this.newSale.getBtnsearch().addActionListener(this);
        /**Agrega un escuchador al boton buscar persona */
        this.newSale.getBtnsearchPerson().addActionListener(this);
        /**Agrega un escuchador al boton limpiar tabla */
        this.newSale.getBtnClearTab().addActionListener(this);
        ////////////////////////////////////////////////////////////////////////
        this.costumer.getBtnPrint().setVisible(false);
        this.supp.getBtnPrint().setVisible(false);
        this.products.getBtnPrint().setVisible(false);
    }

    /**
     *Constructor parametrico permite inicializar los atributos de la instancia
     * 
     * @param objH
     * @param hilo
     */
    public Controlador(Tiempo objH, Thread hilo) {
        this.objH = objH;
        this.hilo = hilo;
        this.ventanaP = new VentanaMaster();

    }

    /**
     * El metodo iniciar inicializa la ventana principal, conecta con el servidor
     * y da titulo a la ventana ademas de su posicion.
     * 
     */
    public void iniciar() {
        conexion.conectar();
        vistaLog.setTitle("Login");
        vistaLog.setLocationRelativeTo(null);
        vistaLog.setVisible(true);

        newSale.getHiddenPanel().setVisible(false);

    }

    /**
     * El metodo accion performed es un metodo del paquete  event el cual nos 
     * permite interactuar con la parte grafica. ventanas y formularios.
     * @param e este parametro es el que registra el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**Verifica que el boton sea sing in sea tocado y abre ventana de principal
         ademas de dar inicio al multihilo*/
        if (e.getSource().equals(vistaLog.getBtnSingIn())) {
            boolean x = vistaLog.validarLogin();
            if (x) {
                ventanaP.setVisible(true);
                vistaLog.dispose();
                hilo.start();
            }
        }
        
        ////////////////////////////////////////////////////////////////////////
        //VENTANA PRINCIPAL
        /**Verifica que el boton sea nueva venta sea tocado y abre ventana nueva venta*/
        if (e.getSource().equals(ventanaP.getNewSale())) {
            ventanaP.getDesktopPane().add(newSale);
            newSale.setLocation(new Point(100, 100));
            newSale.setVisible(true);
        }
        /**Verifica que el boton sea cliente sea tocado y abre ventana cliente
         y limpia y crea una tabla*/
        if (e.getSource().equals(ventanaP.getCostumers())) {
            ventanaP.getDesktopPane().add(costumer);
            costumer.setLocation(new Point(100, 100));
            costumer.setVisible(true);

            DefaultTableModel modelo = (DefaultTableModel) costumer.getTablaCustomer().getModel();
            LimpiarTablas(modelo);
            ClienteDAO cl = new ClienteDAO();

            DefaultTableModel tab = cl.ListasCliente(modelo);
            costumer.getTablaCustomer().setModel(tab);

        }
        /**Verifica que el boton sea proveedor sea tocado y abre ventana preoveedor
         y limpia y crea una tabla*/
        if (e.getSource().equals(ventanaP.getSuppliers())) {
            ventanaP.getDesktopPane().add(supp);
            supp.setLocation(new Point(100, 100));
            supp.setVisible(true);
            DefaultTableModel modelo = (DefaultTableModel) supp.getTablaSupplier().getModel();
            LimpiarTablas(modelo);
            ProveedorDAO proD = new ProveedorDAO();
            DefaultTableModel tab = proD.ListaProveedor(modelo);

            supp.getTablaSupplier().setModel(tab);

        }
        /**Verifica que el boton sea productos sea tocado y abre ventana prductos
         y limpia y crea una tabla*/
        if (e.getSource().equals(ventanaP.getProducts())) {
            ventanaP.getDesktopPane().add(products);
            products.setLocation(new Point(100, 100));
            products.setVisible(true);

            DefaultTableModel modelo = (DefaultTableModel) products.getTablaProducts().getModel();
            LimpiarTablas(modelo);
            ProductosDAO proD = new ProductosDAO();
            DefaultTableModel tab = proD.ListaProducto(modelo);
            products.getTablaProducts().setModel(tab);

        }
        /**Verifica que el boton sea ventas sea tocado y abre ventana ventas
         y limpia y crea una tabla*/
        if (e.getSource().equals(ventanaP.getSales())) {

            ventanaP.getDesktopPane().add(sales);
            sales.setLocation(new Point(100, 100));
            sales.setVisible(true);
            DefaultTableModel modelo = (DefaultTableModel) sales.getTablaSales().getModel();
            LimpiarTablas(modelo);
            DefaultTableModel tab = null;
            try {
                tab = ventaD.ListaVenta(modelo);
            } catch (formatoEntradaException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            sales.getTablaSales().setModel(tab);
            
            
        }
        /**Verifica que el boton sea sobre sea tocado y abre ventana sobre y
         agrega datos de la compania*/
        
        if (e.getSource().equals(ventanaP.getSobre())) {

            ventanaP.getDesktopPane().add(companyData);
            EmpresaDao empe = new EmpresaDao();
            try {
                companyData.listaCompñia();
            } catch (formatoEntradaException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            companyData.setLocation(new Point(100, 100));
            companyData.setVisible(true);
        }
        ////////////////////////////////////////////////////////////////////////
        //Costumer
        /**verifica que se oprima el boton crear para crear un nuevo cliente*/
        if (e.getSource().equals(costumer.getBtnCrate())) {
            try {
                Cliente cl = new Cliente();

                ClienteDAO clD = new ClienteDAO();
                if (!"".equals(costumer.getTxtCustomerID().getText())
                        || !"".equals(costumer.getTxtName().getText())
                        || !"".equals(costumer.getTxtLastName().getText())
                        || !"".equals(costumer.getTxtPhone().getText())
                        || !"".equals(costumer.getTxtAddress().getText())
                        || !"".equals(costumer.getTxtEmailAddress().getText())) {
                    cl.setIdentificacion(costumer.getTxtCustomerID().getText());
                    cl.setNombre(costumer.getTxtName().getText());
                    cl.setApellido(costumer.getTxtLastName().getText());
                    cl.setTelefono(costumer.getTxtPhone().getText());
                    cl.setDireccion(costumer.getTxtAddress().getText());
                    cl.setEmail(costumer.getTxtEmailAddress().getText());
                    String cod = cl.codigo();
                    cl.setCodigoCliente(cod);
                    clD.RegistrarCliente(cl);
                    JOptionPane.showMessageDialog(null, "Cliente Registrado");
                } else {
                }
                JOptionPane.showMessageDialog(null, "Cliente No Registrado" + "\nCampos vacios");
            } catch (formatoEntradaException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        if (e.getSource().equals(costumer.getBtnDelete())) {
            if (!"".equals(costumer.getTxtCustomerID())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "Esta segudo de eliminar registro?");

                if (pregunta == 0) {
                    Cliente cl = new Cliente();
                    ClienteDAO clD = new ClienteDAO();
                    int fila = costumer.getTablaCustomer().getSelectedRow();
                    try {
                        cl.setIdentificacion((String) costumer.getTablaCustomer().getValueAt(fila, 0));
                        cl.setNombre((String) costumer.getTablaCustomer().getValueAt(fila, 1));
                        cl.setApellido((String) costumer.getTablaCustomer().getValueAt(fila, 2));
                        cl.setTelefono((String) costumer.getTablaCustomer().getValueAt(fila, 3));
                        cl.setDireccion((String) costumer.getTablaCustomer().getValueAt(fila, 4));
                        cl.setEmail((String) costumer.getTablaCustomer().getValueAt(fila, 5));
                    } catch (formatoEntradaException ex) {
                        JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                    }
                    boolean b = clD.EliminarCliente(cl);
                    if (b) {
                        JOptionPane.showConfirmDialog(null, "Eliminacion Exitosa");
                    } else {
                        JOptionPane.showConfirmDialog(null, "La eliminacion Fracaso");
                    }
                    DefaultTableModel plantilla = (DefaultTableModel) costumer.getTablaCustomer().getModel();
                    plantilla.removeRow(costumer.getTablaCustomer().getSelectedRow());
                }
            }
        }
        /**verifica que se oprima el boton actualizar para actualizar al cliente*/
        if (e.getSource().equals(costumer.getBtnUpdate())) {

            Cliente cl = new Cliente();
            ClienteDAO clD = new ClienteDAO();
            int fila = costumer.getTablaCustomer().getSelectedRow();

            if (!"".equals(costumer.getTxtCustomerID().getText())
                    || !"".equals(costumer.getTxtName().getText())
                    || !"".equals(costumer.getTxtLastName().getText())
                    || !"".equals(costumer.getTxtPhone().getText())
                    || !"".equals(costumer.getTxtAddress().getText())
                    || !"".equals(costumer.getTxtEmailAddress().getText())) {
                try {
                    cl.setIdentificacion(costumer.getTxtCustomerID().getText());
                    cl.setNombre(costumer.getTxtName().getText());
                    cl.setApellido(costumer.getTxtLastName().getText());
                    cl.setTelefono(costumer.getTxtPhone().getText());
                    cl.setDireccion(costumer.getTxtAddress().getText());
                    cl.setEmail(costumer.getTxtEmailAddress().getText());
                } catch (formatoEntradaException ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }
                String cod = cl.codigo();
                cl.setCodigoCliente(cod);
            }
            boolean b = clD.ActualizarCliente(cl);
            if (b) {
                JOptionPane.showConfirmDialog(null, "Actualizacion Exitosa");
            } else {
                JOptionPane.showConfirmDialog(null, "La actualizacion Fracaso");
            }

            DefaultTableModel modelo = (DefaultTableModel) costumer.getTablaCustomer().getModel();
            LimpiarTablas(modelo);
            DefaultTableModel tab = clD.ListasCliente(modelo);
            costumer.getTablaCustomer().setModel(tab);
        }
        /**verifica que se oprima el boton leer para leer todos los datos del cliente*/
        if (e.getSource().equals(costumer.getBtnRead())) {
            Cliente cli = new Cliente();
            ClienteDAO clD = new ClienteDAO();
            if (!"".equals(costumer.getTxtCustomerID())) {

                String cod = costumer.getTxtCustomerID().getText();
                cli = clD.buscarProID(cod);
                if (cli.getNombre() != null && !"".equals(cli.getNombre())) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\n"
                            + cli.getIdentificacion() + "\n"
                            + cli.getNombre() + "\n"
                            + cli.getApellido() + "\n"
                            + cli.getDireccion() + "\n"
                            + cli.getEmail() + "\n"
                            + cli.getTelefono() + "\n");

                } else {
                    JOptionPane.showMessageDialog(null, "No hay datos para ese codigo de barras.");
                }
            }
        }
        /**verifica que se oprima el boton salvar para actualizar la tabla de datos de los clientes*/
        if (e.getSource().equals(costumer.getBtnSave())) {
            DefaultTableModel modelo = (DefaultTableModel) costumer.getTablaCustomer().getModel();
            LimpiarTablas(modelo);
            ClienteDAO cl = new ClienteDAO();
            DefaultTableModel tab = cl.ListasCliente(modelo);
            costumer.getTablaCustomer().setModel(tab);

            costumer.getTxtName().setText("");
            costumer.getTxtLastName().setText("");
            costumer.getTxtAddress().setText("");
            costumer.getTxtEmailAddress().setText("");
            costumer.getTxtPhone().setText("");
            costumer.getTxtCustomerID().setText("");

        }

        ////////////////////////////////////////////////////////////////////////
        //Supplier
        /**verifica que se oprima el boton crear para crear un nuevo proveedor*/
        if (e.getSource().equals(supp.getBtnCrate())) {
            try {
                Proveedor pro = new Proveedor();
                ProveedorDAO proD = new ProveedorDAO();
                if (!"".equals(supp.getTxtSupplierID().getText())
                        || !"".equals(supp.getTxtName().getText())
                        || !"".equals(supp.getTxtLastName().getText())
                        || !"".equals(supp.getTxtPhone().getText())
                        || !"".equals(supp.getTxtAddress().getText())
                        || !"".equals(supp.getTxtEmailAddress().getText())) {
                    try {
                        pro.setIdentificacion(supp.getTxtSupplierID().getText());
                        pro.setNombre(supp.getTxtName().getText());
                        pro.setApellido(supp.getTxtLastName().getText());
                        pro.setTelefono(supp.getTxtPhone().getText());
                        pro.setDireccion(supp.getTxtAddress().getText());
                        pro.setEmail(supp.getTxtEmailAddress().getText());
                    } catch (formatoEntradaException ex) {
                        JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                    }
                    String cod = pro.codigo();
                    pro.setCodigoProveedor(cod);
                    proD.RegistrarProveedor(pro);
                    JOptionPane.showMessageDialog(null, "Cliente Registrado");
                } else {
                }
                JOptionPane.showMessageDialog(null, "Cliente No Registrado" + "\nCampos vacios");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        /**verifica que se oprima el boton boorrar para borrar al proveedor*/
        if (e.getSource().equals(supp.getBtnDelete())) {
            if (!"".equals(supp.getTxtSupplierID())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "Esta segudo de eliminar registro?");

                if (pregunta == 0) {
                    Proveedor pro = new Proveedor();
                    ProveedorDAO proD = new ProveedorDAO();
                    int fila = supp.getTablaSupplier().getSelectedRow();
                    try {
                        pro.setIdentificacion((String) supp.getTablaSupplier().getValueAt(fila, 0));
                        pro.setNombre((String) supp.getTablaSupplier().getValueAt(fila, 1));
                        pro.setApellido((String) supp.getTablaSupplier().getValueAt(fila, 2));
                        pro.setTelefono((String) supp.getTablaSupplier().getValueAt(fila, 3));
                        pro.setDireccion((String) supp.getTablaSupplier().getValueAt(fila, 4));
                        pro.setEmail((String) supp.getTablaSupplier().getValueAt(fila, 5));
                    } catch (formatoEntradaException ex) {
                        JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                    }
                    boolean b = proD.EliminarProveedor(pro);
                    if (b) {
                        JOptionPane.showConfirmDialog(null, "Eliminacion Exitosa");
                    } else {
                        JOptionPane.showConfirmDialog(null, "La eliminacion Fracaso");
                    }
                    DefaultTableModel plantilla = (DefaultTableModel) supp.getTablaSupplier().getModel();
                    plantilla.removeRow(supp.getTablaSupplier().getSelectedRow());

                }
            }
        }/**verifica que se oprima el boton actualizar para actualizar al proveedor*/
        if (e.getSource().equals(supp.getBtnUpdate())) {

            Proveedor pro = new Proveedor();
            ProveedorDAO proD = new ProveedorDAO();
            int fila = supp.getTablaSupplier().getSelectedRow();

            if (!"".equals(supp.getTxtSupplierID().getText())
                    || !"".equals(supp.getTxtName().getText())
                    || !"".equals(supp.getTxtLastName().getText())
                    || !"".equals(supp.getTxtPhone().getText())
                    || !"".equals(supp.getTxtAddress().getText())
                    || !"".equals(supp.getTxtEmailAddress().getText())) {
                try {
                    pro.setIdentificacion(supp.getTxtSupplierID().getText());
                    pro.setNombre(supp.getTxtName().getText());
                    pro.setApellido(supp.getTxtLastName().getText());
                    pro.setTelefono(supp.getTxtPhone().getText());
                    pro.setDireccion(supp.getTxtAddress().getText());
                    pro.setEmail(supp.getTxtEmailAddress().getText());
                    String cod = pro.codigo();
                    pro.setCodigoProveedor(cod);
                } catch (formatoEntradaException ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
                }

            }
            boolean b = proD.ActualizarProveedor(pro);
            if (b) {
                JOptionPane.showConfirmDialog(null, "Actualizacion Exitosa");
            } else {
                JOptionPane.showConfirmDialog(null, "La actualizacion Fracaso");
            }

            DefaultTableModel modelo = (DefaultTableModel) supp.getTablaSupplier().getModel();
            LimpiarTablas(modelo);
            DefaultTableModel tab = proD.ListaProveedor(modelo);
            supp.getTablaSupplier().setModel(tab);
        }
        /**verifica que se oprima el salvar  actualizar para los datos en la tabla de los proeedores*/
        if (e.getSource().equals(supp.getBtnSave())) {
            DefaultTableModel modelo = (DefaultTableModel) supp.getTablaSupplier().getModel();
            LimpiarTablas(modelo);
            ProveedorDAO cl = new ProveedorDAO();
            DefaultTableModel tab = cl.ListaProveedor(modelo);
            supp.getTablaSupplier().setModel(tab);

            supp.getTxtName().setText("");
            supp.getTxtLastName().setText("");
            supp.getTxtAddress().setText("");
            supp.getTxtEmailAddress().setText("");
            supp.getTxtPhone().setText("");
            supp.getTxtSupplierID().setText("");

        }
        /**verifica que se oprima el boton leer  mostrar en pantalla los datos del proveedor*/
        if (e.getSource().equals(supp.getBtnRead())) {
            Proveedor pro = new Proveedor();
            ProveedorDAO proD = new ProveedorDAO();
            if (!"".equals(supp.getTxtSupplierID())) {

                String cod = supp.getTxtSupplierID().getText();
                pro = proD.buscarProID(cod);
                if (pro.getNombre() != null && !"".equals(pro.getNombre())) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\n"
                            + pro.getIdentificacion() + "\n"
                            + pro.getNombre() + "\n"
                            + pro.getApellido() + "\n"
                            + pro.getDireccion() + "\n"
                            + pro.getEmail() + "\n"
                            + pro.getTelefono() + "\n");

                } else {
                    JOptionPane.showMessageDialog(null, "No hay datos para ese codigo de barras.");
                }
            }
        }

        ////////////////////////////////////////////////////////////////////////
        //Products  bar_code, name, description, amount, price, stock
        /**verifica que se oprima el boton crear para crar al un nuevo producto*/
        if (e.getSource().equals(products.getBtnCrate())) {
            ProductosDAO proD = new ProductosDAO();
            try {
                Producto pro = new Producto();

                if (!"".equals(products.getTxtBarCode().getText())
                        || !"".equals(products.getTxtName().getText())
                        || !"".equals(products.getTxtDescription().getText())
                        || !"".equals(products.getTxtAmount().getText())
                        || !"".equals(products.getTxtPrice().getText())
                        || !"".equals(products.getTxtStock().getText())) {

                    pro.setId(products.getTxtBarCode().getText());
                    pro.setNombre(products.getTxtName().getText());
                    pro.setDescripcion(products.getTxtDescription().getText());
                    pro.setCantidad(Integer.parseInt(products.getTxtAmount().getText()));
                    pro.setPrecio(Double.parseDouble(products.getTxtPrice().getText()));
                    pro.setStock(Integer.parseInt(products.getTxtStock().getText()));

                    String iSelect = products.getCmbSupplier().getSelectedItem().toString();
                    String x = proD.validarProveedor(iSelect);

                    boolean b = proD.RegistrarProductos(pro, x);
                    JOptionPane.showMessageDialog(null, "Producto Registrado");
                } else {
                }
                JOptionPane.showMessageDialog(null, "Producto No Registrado" + "\nCampos vacios");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
            DefaultTableModel modelo = (DefaultTableModel) products.getTablaProducts().getModel();
            LimpiarTablas(modelo);
            DefaultTableModel tab = proD.ListaProducto(modelo);

            products.getTablaProducts().setModel(tab);

        }
        /**verifica que se oprima el boton borrar para borar un producto*/
        if (e.getSource().equals(products.getBtnDelete())) {
            if (!"".equals(products.getTxtBarCode())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "Esta segudo de eliminar registro?");

                if (pregunta == 0) {

                    Producto pro = new Producto();
                    ProductosDAO proD = new ProductosDAO();
                    int fila = products.getTablaProducts().getSelectedRow();

                    pro.setId((String) products.getTablaProducts().getValueAt(fila, 0));
                    pro.setNombre((String) products.getTablaProducts().getValueAt(fila, 1));
                    pro.setDescripcion((String) products.getTablaProducts().getValueAt(fila, 2));
                    pro.setCantidad((Integer) products.getTablaProducts().getValueAt(fila, 3));
                    pro.setPrecio((Double) products.getTablaProducts().getValueAt(fila, 4));
                    pro.setStock((Integer) products.getTablaProducts().getValueAt(fila, 5));
                    pro.setProveedor((String) products.getTablaProducts().getValueAt(fila, 6));

                    boolean b = proD.EliminarProductos(pro);
                    if (b) {
                        JOptionPane.showConfirmDialog(null, "Eliminacion Exitosa");
                    } else {
                        JOptionPane.showConfirmDialog(null, "La eliminacion Fracaso");
                    }
                    DefaultTableModel plantilla = (DefaultTableModel) products.getTablaProducts().getModel();
                    plantilla.removeRow(products.getTablaProducts().getSelectedRow());
                }
            }

        }

        /**verifica que se oprima el boton actualizar para actualizar los datos del producto*/
        if (e.getSource().equals(products.getBtnUpdate())) {
            Producto pro = new Producto();
            ProductosDAO proD = new ProductosDAO();
            int fila = products.getTablaProducts().getSelectedRow();

            if (!"".equals(products.getTxtBarCode().getText())
                    || !"".equals(products.getTxtName().getText())
                    || !"".equals(products.getTxtDescription().getText())
                    || !"".equals(products.getTxtAmount().getText())
                    || !"".equals(products.getTxtPrice().getText())
                    || !"".equals(products.getTxtStock().getText())) {
                pro.setId(products.getTxtBarCode().getText());
                pro.setNombre(products.getTxtName().getText());
                pro.setDescripcion(products.getTxtDescription().getText());
                pro.setCantidad(Integer.parseInt(products.getTxtAmount().getText()));
                pro.setPrecio(Double.parseDouble(products.getTxtPrice().getText()));
                pro.setStock(Integer.parseInt(products.getTxtStock().getText()));
                pro.setProveedor((String) products.getCmbSupplier().getSelectedItem());
                ///////////////////////////////////////// IMPORTANTE!
                String iSelect = products.getCmbSupplier().getSelectedItem().toString();
                String x = proD.validarProveedor(iSelect);
//////////////////////////////////////////////////////////////////////////////////////////////
                boolean b = proD.ActualizarProducto(pro, x);
                if (b) {
                    JOptionPane.showConfirmDialog(null, "Actualizacion Exitosa");
                } else {
                    JOptionPane.showConfirmDialog(null, "La actualizacion Fracaso");
                }
            }

            DefaultTableModel modelo = (DefaultTableModel) products.getTablaProducts().getModel();
            LimpiarTablas(modelo);
            DefaultTableModel tab = proD.ListaProducto(modelo);

            products.getTablaProducts().setModel(tab);
        }
        /**verifica que se oprima el boton leer para mostrar los datos del producto*/
        if (e.getSource().equals(products.getBtnRead())) {
            Producto pro = new Producto();
            ProductosDAO proD = new ProductosDAO();
            if (!"".equals(products.getTxtBarCode())) {

                String cod = products.getTxtBarCode().getText();
                pro = proD.buscarProBarCode(cod);
                if (pro.getNombre() != null && !"".equals(pro.getNombre())) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\n"
                            + pro.getNombre() + "\n"
                            + pro.getDescripcion() + "\n"
                            + pro.getCantidad() + "\n"
                            + pro.getPrecio() + "\n"
                            + pro.getStock() + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay datos para ese codigo de barras.");
                }
            }
        }
        /**verifica que se oprima el boton registros para generar un registro en excel de los productos*/
        if (e.getSource().equals(products.getBtnRegistros())) {
            Excel.reporte();
        }
        if (e.getSource().equals(products.getBtnSave())) {
            ProductosDAO proD = new ProductosDAO();
            DefaultTableModel modelo = (DefaultTableModel) products.getTablaProducts().getModel();
            LimpiarTablas(modelo);
            DefaultTableModel tab = proD.ListaProducto(modelo);
            products.getTablaProducts().setModel(tab);
            products.getTxtName().setText("");
            products.getTxtDescription().setText("");
            products.getTxtAmount().setText("");
            products.getTxtPrice().setText("");

        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //New SALE
        /**verifica que se oprima el boton buscar para buscar los datos de una venta*/
        if (e.getSource().equals(newSale.getBtnsearch())) {
            Producto pro = new Producto();
            ProductosDAO proD = new ProductosDAO();
            if (!"".equals(newSale.getTxtIdCode())) {

                String cod = newSale.getTxtIdCode().getText();
                pro = proD.buscarProBarCode(cod);
                if (pro.getNombre() != null && !"".equals(pro.getNombre())) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\n"
                            + pro.getNombre() + "\n"
                            + pro.getDescripcion() + "\n"
                            + pro.getCantidad() + "\n"
                            + pro.getPrecio() + "\n"
                            + pro.getStock() + "\n");
                    newSale.Insert(pro.getNombre(), pro.getDescripcion(), pro.getPrecio(), pro.getStock());

                } else {
                    newSale.Limpiar();
                    JOptionPane.showMessageDialog(null, "No hay datos para ese codigo de barras.");
                }
            }
            
            if (!"".equals(newSale.getTxtAmount().getText())) {
                String cod = newSale.getTxtIdCode().getText();
                String nombre = newSale.getTxtName().getText();
                String descripcion = newSale.getTxtDescript().getText();
                int cantidad = Integer.parseInt(newSale.getTxtAmount().getText());
                double precio = Double.parseDouble(newSale.getTxtPrice().getText());
                double total = cantidad * precio;
                int stock = Integer.parseInt(newSale.getTxtStock().getText());
                if (stock >= cantidad) {
                    it += 1;
                    ArrayList lista = new ArrayList();
                    DefaultTableModel modelo = new DefaultTableModel();

                    modelo = (DefaultTableModel) newSale.getTablaNewSale().getModel();

                    for (int i = 0; i < newSale.getTablaNewSale().getRowCount(); i++) {
                        if (newSale.getTablaNewSale().getValueAt(i, 0).equals(newSale.getTxtIdCode().getText())) {
                            JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            return;
                        }

                    }
                    lista.add(it);
                    lista.add(cod);
                    lista.add(nombre);
                    lista.add(descripcion);
                    lista.add(cantidad);
                    lista.add(precio);
                    lista.add(total);

                    Object[] obj = new Object[6];
                    obj[0] = lista.get(1);
                    obj[1] = lista.get(2);
                    obj[2] = lista.get(3);
                    obj[3] = lista.get(4);
                    obj[4] = lista.get(5);
                    obj[5] = lista.get(6);

                    modelo.addRow(obj);

                    newSale.getTablaNewSale().setModel(modelo);
                    double tot = TotalPagar();
                    newSale.total(tot);
                    newSale.Limpiar();

                } else {
                    JOptionPane.showConfirmDialog(null, "Stock no dispible");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Ingrese Cantidad");
            }
        }
        
        /**verifica que se oprima el boton bortrar para borrar los datos de la venta*/
        if (e.getSource().equals(newSale.getBtnDelete())) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) newSale.getTablaNewSale().getModel();
            modelo.removeRow(newSale.getTablaNewSale().getSelectedRow());
            double tot = TotalPagar();
            newSale.total(tot);

        }
        if (e.getSource().equals(newSale.getBtnsearchPerson())) {
            ClienteDAO clD = new ClienteDAO();
            Cliente cl = new Cliente();
            try {
                if (!"".equals(newSale.getTxtCustomerId())) {
                    int id = Integer.parseInt(newSale.getTxtCustomerId().getText());
                    System.out.println("DATO QUE ENTRA PARA VALIDAR EL ID DEL CLIENTE      " + id);
                    cl = clD.buscarCliente(id);
                    if (cl.getNombre() != null && !"".equals(cl.getNombre())) {
                        newSale.getTxtCustomerName().setText("" + cl.getNombre());
                        newSale.getTxtCustomerLastName().setText("" + cl.getApellido());
                        newSale.getCostumerPhone().setText("" + cl.getTelefono());
                        newSale.getCostumerEmailAddress().setText("" + cl.getEmail());
                        newSale.getCostumerAddress().setText("" + cl.getDireccion());

                    } else {
                        newSale.getTxtCustomerId().setText("");
                        JOptionPane.showMessageDialog(null, "El cliente no Existe... :O");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
        /**verifica que se oprima el boton imprimir para imprimir en pdf los datos de la venta*/
        if (e.getSource().equals(newSale.getBtnPrint())) {
            if (newSale.getTablaNewSale().getRowCount() > 0) {
                if (!"".equals(newSale.getTxtCustomerName())) {
                    try {
                        registrarVenta();
                    } catch (formatoEntradaException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        RegistrarDetalles();
                    } catch (formatoEntradaException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ActualizarStock();
                    p.crear_PDF("Reportes de PrettyPetStore", "PrettyPetStore", "Mascotas", "Reporte", costumer, newSale);
                    JOptionPane.showMessageDialog(null, "Venta Realizada...");
                    DefaultTableModel modelo = (DefaultTableModel) newSale.getTablaNewSale().getModel();
                    LimpiarTablas(modelo);
                    newSale.getTxtCustomerId().setText("");
                    newSale.getTxtAmount().setText("");
                    newSale.getTxtCustomerName().setText("");
                    newSale.getTxtIdCode().setText("");
                    newSale.getTxtDescript().setText("");
                    newSale.getTxtCustomerLastName().setText("");
                    newSale.getTxtPrice().setText("");
                    newSale.getTxtStock().setText("");
                }else {JOptionPane.showConfirmDialog(null, "Busque el Cliente");}
            } else {
                JOptionPane.showConfirmDialog(null, "No hay productos\nRegistre una nueva venta");
            }

        }
        /**verifica que se oprima el boton limpiar tabla  para limpiar los datos de la tabla*/
        if (e.getSource().equals(newSale.getBtnClearTab())) {
            DefaultTableModel modelo = (DefaultTableModel) newSale.getTablaNewSale().getModel();
            LimpiarTablas(modelo);
            newSale.getTxtTotalToPay().setText("");

        }
        
         ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //SALE's
        
        /**verifica que se oprima el boton pdf para abrir el pdf de dicha venta*/
        if(e.getSource().equals(sales.getBtnPdf())){
            int fila = sales.getTablaSales().getSelectedRow();
            String x = sales.getTablaSales().getValueAt(fila, 0).toString();
            File file = new File("src/Pdfs/Reporte-"+x+".pdf");
            
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    /**
     *
     * @param x es en el que se almacena un modelo de una tabla de tipo DefaultTableModel
     * para poder limpiar la tabla con la misma cantidad de columnas y filas segun corresponda
     */
    public void LimpiarTablas(DefaultTableModel x) {
        DefaultTableModel modelo = x;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * total a pagar calcula cual es el monto que se debe pagar por compra y factura.
     */
    private double TotalPagar() {
        totalPago = 0.00;
        int fila = newSale.getTablaNewSale().getRowCount();
        for (int i = 0; i < fila; i++) {
            double calculo = Double.parseDouble(String.valueOf(newSale.getTablaNewSale().getModel().getValueAt(i, 5)));
            totalPago += calculo;
        }
        return totalPago;
    }

    /**
     *  Registrar venta permite registrar una nueva venta ...
     * @throws formatoEntradaException
     */
    public void registrarVenta() throws formatoEntradaException {
        String cliente = newSale.getTxtCustomerName().getText() + " " + newSale.getTxtCustomerLastName().getText();
        String Vendedor = " Pretty Pet Store";
        double monto = TotalPagar();
        
        venta.setCliente(cliente);
        venta.setVendedor(Vendedor);
        venta.setTotal(monto);
        ventaD.RegistrrarVenta(venta);
        RegistrarDetalles();
    }

    /**
     *  Registrar Detalle Permite registrar los detalles de vienta
     * @throws formatoEntradaException
     */
    public void RegistrarDetalles() throws formatoEntradaException {
        for (int i = 0; i < newSale.getTablaNewSale().getRowCount(); i++) {
            int cod = Integer.parseInt(newSale.getTablaNewSale().getValueAt(i, 0).toString());
            int cant = Integer.parseInt(newSale.getTablaNewSale().getValueAt(i, 3).toString());
            double pre = Double.parseDouble(newSale.getTablaNewSale().getValueAt(i, 4).toString());
            detalle.setBar_core(cod);
            detalle.setCantidad(cant);
            detalle.setPrecio(pre);
            detalle.setId_venta(ventaD.IdVenta());
            ventaD.RegistrarDetalle(detalle);
        }
    }

    /**
     * Actualizar stock permite actualizar el stock de la base de datos despues de realizar una venta
     */
    public void ActualizarStock() {
        for (int i = 0; i < newSale.getTablaNewSale().getRowCount(); i++) {
            String cod = newSale.getTablaNewSale().getValueAt(i, 0).toString();
            int cant = Integer.parseInt(newSale.getTablaNewSale().getValueAt(i, 3).toString());
            Producto p = new Producto();
            ProductosDAO pD = new ProductosDAO();

            p = pD.buscarProBarCode(cod);
            int StockActual = p.getStock() - cant;
            ventaD.ActualizarStock(StockActual, cod);
        }
    }

    /**
     * run es un metodo abstrabto que proviene de la clase padre Thread para poder
     * hacer uso de los multihilos.
     */
    @Override
    public void run() {
        while (true) {
            ventanaP.getLblHora().setText(objH.toString());
            objH.getSs();
            objH.getMm();
            objH.getHh();
            try {
                hilo.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
