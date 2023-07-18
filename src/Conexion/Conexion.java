/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Ing. Sonia Pinzón
 */
public class Conexion {
    private BufferedReader entrada;
    private FileReader lectura;
    private FileWriter escribir;
    private PrintWriter salida;

    public Conexion(BufferedReader bufEntrada, FileReader flujoLee, FileWriter flujoEscr, PrintWriter bufSalida) {
        this.entrada = bufEntrada;
        this.lectura = flujoLee;
        this.escribir = flujoEscr;
        this.salida = bufSalida;
    }
    public Conexion() {
        this.entrada = null;
        this.lectura = null;
        this.escribir = null;
        this.salida = null;
    }
    public String leerDatos() throws IOException{
        this.lectura= new FileReader("datos.txt");
        entrada= new BufferedReader(lectura);
        String datos="";
        String linea= this.entrada.readLine();
        while(linea!=null){
          datos+=linea+"\n";
          linea=this.entrada.readLine();
        }
        entrada.close();
        return datos;
    }
    public void EscribeDatos(String datos) throws IOException{
     escribir= new FileWriter("datos.txt", true);
     salida= new PrintWriter(escribir);
     salida.println(datos);
     salida.close();
    }
}
