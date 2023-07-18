/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Vista.LogIn;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Giovanny Tellez Plazas 20192578003
 */
public class ValidarLogin {

    LogIn login;
    Login lg;
    loginDAO logDao ;

    /**
     * Constructor que permite inicializar las clases y vistas que se usaran
     */
    public ValidarLogin() {
        this.login = new LogIn();
        this.logDao = new loginDAO();
        this.lg = new Login();
        
    }

    /**
     * Contruscor parametrico.
     * @param login
     * @param lg
     * @param logDao
     */
    public ValidarLogin(LogIn login, Login lg, loginDAO logDao) {
        this.login = login;
        this.lg = lg;
        this.logDao = logDao;
    }
    
    /**
     * Validar login, Permite validar si las credenciales introducidas en la 
     * vista login son realmente correctas o no y en base a eso retorna un valor
     * booleano 
     * @return
     */
    public boolean validarLogin() {
        System.out.println("entro a validar");
        String correo = login.getTxtUsername().getText();
        System.out.println("valido correo el cual es" + correo);
        String password = String.valueOf(login.getTxtPassword().getText());
        System.out.println("valido password el cual es" + password);
        boolean validacion = false;
        
        try {
            
            System.out.println("entro al try");
            if (!"".equals(correo) || !"".equals(password)) {
                System.out.println("entro al primer if y valido");
                lg = logDao.log(correo, password);
                System.out.println("se valido la contrasena" + lg);
                if (lg.getCorreo() != null && lg.getPassword() != null) {
                    System.out.println("segundo if validado si el correo y contra n oestan vacios");
                    System.out.println("validacion antesd el true" + validacion);
                    validacion = true;
                    System.out.println("validacion despues el true" + validacion);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Credenciales invalidas");
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showConfirmDialog(null, "Error datos vacios "+ex.getMessage());
        }

        return validacion;
    }

}
