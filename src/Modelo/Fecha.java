
package Modelo;

import java.util.Calendar;

/*
 *  @author Cristian Giovanny tellez Plazas 
 *  @ version v.3
 * 
 *  La Clase Fecha
 */
public class Fecha {
    private int aa, mm, dd;

    public Fecha(int aa, int mm, int dd) {
        this.aa = aa;
        this.mm = mm;
        this.dd = dd;
    }
    public Fecha() {
        Calendar fecha = Calendar.getInstance();
        this.aa = fecha.get(Calendar.DAY_OF_MONTH);
        this.mm = fecha.get(Calendar.MONTH)+1;
        this.dd = fecha.get(Calendar.YEAR);
    }     
    public int getAa() {
        return aa;
    }
    public void setAa(int aa) {
        this.aa = aa;
    }
    public int getMm() {
        return mm;
    }
    public void setMm(int mm) {
        this.mm = mm;
    }
    public int getDd() {
        return dd;
    }
    public void setDd(int dd) {
        this.dd = dd;
    }
    public int edad(){
        Calendar fecha= Calendar.getInstance();
        return fecha.get(Calendar.YEAR-aa);
    }

    @Override
    public String toString() {
        return "Fecha:  "  + aa + " / " + mm + " / " + dd;
    }
    
}
