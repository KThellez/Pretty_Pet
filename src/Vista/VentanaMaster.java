/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Tiempo;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author PC
 */
public class VentanaMaster extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMaster
     */
    public VentanaMaster() {
        initComponents();
        
    }

   

    public JLabel getLblHora() {
        return lblHora;
    }

    public void setLblHora(JLabel lblHora) {
        this.lblHora = lblHora;
    }

    public JToolBar getToolbarVentanaP() {
        return toolbarVentanaP;
    }

    public void setToolbarVentanaP(JToolBar toolbarVentanaP) {
        this.toolbarVentanaP = toolbarVentanaP;
    }

    public JMenuItem getSobre() {
        return sobre;
    }

    public void setSobre(JMenuItem sobre) {
        this.sobre = sobre;
    }

    public JMenu getHelp() {
        return Help;
    }

    public void setHelp(JMenu Help) {
        this.Help = Help;
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        toolbarVentanaP = new javax.swing.JToolBar();
        lblHora = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        newSale = new javax.swing.JMenuItem();
        costumers = new javax.swing.JMenuItem();
        suppliers = new javax.swing.JMenuItem();
        products = new javax.swing.JMenuItem();
        sales = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolbarVentanaP.setRollover(true);
        toolbarVentanaP.add(lblHora);

        desktopPane.add(toolbarVentanaP);
        toolbarVentanaP.setBounds(0, 700, 1280, 20);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText("Store");

        newSale.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newSale.setText("New Sale");
        jMenu1.add(newSale);

        costumers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        costumers.setText("Costumers");
        jMenu1.add(costumers);

        suppliers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        suppliers.setText("Suppliers");
        jMenu1.add(suppliers);

        products.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        products.setText("Products");
        jMenu1.add(products);

        sales.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        sales.setText("Sales");
        jMenu1.add(sales);

        menuBar.add(jMenu1);

        Help.setText("Help");

        sobre.setText("About");
        Help.add(sobre);

        menuBar.add(Help);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */

  

    public JMenuItem getCostumers() {
        return costumers;
    }

    public void setCostumers(JMenuItem costumers) {
        this.costumers = costumers;
    }



    

   

  

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }


    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public void setExitMenuItem(JMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }


    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    

    public JMenuItem getNewSale() {
        return newSale;
    }

    public void setNewSale(JMenuItem newSale) {
        this.newSale = newSale;
    }

    public JMenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public void setOpenMenuItem(JMenuItem openMenuItem) {
        this.openMenuItem = openMenuItem;
    }


    public JMenuItem getProducts() {
        return products;
    }

    public void setProducts(JMenuItem products) {
        this.products = products;
    }

    public JMenuItem getSales() {
        return sales;
    }

    public void setSales(JMenuItem sales) {
        this.sales = sales;
    }

    public JMenuItem getSaveAsMenuItem() {
        return saveAsMenuItem;
    }

    public void setSaveAsMenuItem(JMenuItem saveAsMenuItem) {
        this.saveAsMenuItem = saveAsMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public void setSaveMenuItem(JMenuItem saveMenuItem) {
        this.saveMenuItem = saveMenuItem;
    }

    public JMenuItem getSuppliers() {
        return suppliers;
    }

    /**
     * @param args the command line arguments
     */
    public void setSuppliers(JMenuItem suppliers) {
        this.suppliers = suppliers;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem costumers;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newSale;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem products;
    private javax.swing.JMenuItem sales;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem sobre;
    private javax.swing.JMenuItem suppliers;
    private javax.swing.JToolBar toolbarVentanaP;
    // End of variables declaration//GEN-END:variables

}
