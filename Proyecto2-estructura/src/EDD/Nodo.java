/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * * @author eliocolmenares
 */
public class Nodo {
    private Object dato; //Variable donde se guardará el valor
    private Nodo pnext; //Variable para enlazar los nodos
/**
 * * Constructor vacio
 */    
    //Constructor vacio
    public Nodo(){
       this.dato = null;
       this.pnext = null; 
    }
/**
 * * Constructor de la clase nodo si le paso solo la info
 */
    //Constructor de la clase nodo si le paso solo la info
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }
/**
 * * Constructor Completo
 */    
    //Constructor Completo
    public Nodo(Object dato, Nodo node){
        this.dato = dato;
        this.pnext = node;
    }
    
/**
 * * Metodos get y set para los atributos
 */  
    //Metodos get y set para los atrubutos
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    } 
}

