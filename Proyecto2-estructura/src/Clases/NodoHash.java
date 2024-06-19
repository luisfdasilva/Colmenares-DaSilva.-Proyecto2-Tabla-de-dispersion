/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * *  @author luis
 */
public class NodoHash {
    public String clave;
    public Resumen valor;
    public NodoHash siguiente;

    public NodoHash(String clave, Resumen valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Resumen getValor() {
        return valor;
    }

    public void setValor(Resumen valor) {
        this.valor = valor;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }
    
}
