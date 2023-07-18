/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PC
 */
public class CodAleatorio {

    /**
     * Metodo que genera un codigo aleatorio con valores alfanumericos.
     * @param i
     * @return String
     */
    public static  String getRandomString(int i) {
        String valorAlfanumerico;
        StringBuilder constructor;

        valorAlfanumerico = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        //cracion de la memoria de strings.
        constructor = new StringBuilder(i);

        for (int m = 0; m < i; m++) {

            //Generando numeros
            int indice
                    = (int) (valorAlfanumerico.length() * Math.random());
            // Añadiendo caracteres
            constructor.append(valorAlfanumerico.charAt(indice));
        }
        return constructor.toString();
    }
}
