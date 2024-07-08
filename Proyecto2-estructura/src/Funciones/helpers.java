/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 * * @author eliocolmenares
 */
public class helpers {
    /**
    * * Valida que sea un string con digitos permitidos
    */
    private boolean validarnumeros(String num){
       return num.matches("[0-9]*");
    }
    /**
    * * Valida que sea un numero y lo retorna como int
    */
    public int ValidarNumeros(String numero){
        if(validarnumeros(numero)== true){
            int num = Integer.parseInt(numero);
            return num;
        }else{
            return -1;
        }
    }
    /**
    * * Valida si el codigo esta dentro del rango de la lista
    */
    public boolean validarRangeList(int num, int range){
        return num < range && num >= 0;
    }
}
