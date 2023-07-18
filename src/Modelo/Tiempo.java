/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.Calendar;


/**
 *
 * @author PC
 */
public class Tiempo {

   
    private int hh, mm, ss;

    public Tiempo() {
         Calendar tiempo = Calendar.getInstance();
        this.hh = tiempo.get(Calendar.HOUR);
        this.mm = tiempo.get(Calendar.MINUTE);
        this.ss = tiempo.get(Calendar.SECOND);

    }

    public Tiempo( int hh, int mm, int ss) {
        
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }
    


    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public void hora() {
        if(hh == 59){
            hh = 0;
        }
        if(hh<24 && mm ==59){
            hh++;
        }
        
    }

    public void minuto() {
        if ((ss == 59) && (mm < 59)) {
            mm++;
        } 
        if(mm == 59){
            mm = 0;
        }

    }

    public void segundo() {
        if (ss < 59) {
            ss++;
        } else {
            ss = 0;
        }
    }

    @Override
    public String toString() {
        return "hora: "  + hh + ":" + mm + ":" + ss ;
    }

    

}
