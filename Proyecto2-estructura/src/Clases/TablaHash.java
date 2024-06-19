/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author luis
 */
public class TablaHash {
   private NodoHash[] tabla;
    private int capacidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new NodoHash[capacidad];
    }

    private int hash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash = (31 * hash + clave.charAt(i)) % capacidad;
        }
        return hash;
    }

    public boolean agregarResumen(Resumen resumen) {
        String clave = resumen.getTitulo();
        int indice = hash(clave);

        NodoHash nuevoNodo = new NodoHash(clave, resumen);
        if (tabla[indice] == null) {
            tabla[indice] = nuevoNodo;
        } else {
            NodoHash actual = tabla[indice];
            while (actual.siguiente != null) {
                if (actual.clave.equals(clave)) {
                    return false; // Clave duplicada
                }
                actual = actual.siguiente;
            }
            if (actual.clave.equals(clave)) {
                return false; // Clave duplicada
            }
            actual.siguiente = nuevoNodo;
        }
        return true;
    }

    public Resumen buscarResumen(String clave) {
        int indice = hash(clave);
        NodoHash actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null;
    } 
}
