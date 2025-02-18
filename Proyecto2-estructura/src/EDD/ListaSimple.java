/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Document;
import javax.swing.JOptionPane;

/**
 * * @author eliocolmenares
 */
public class ListaSimple {
     private Nodo pFirst; //nodo apuntador al primero
    private int size; //tamaño de la lista
/**
 * * Constructor de la clase Lista
 */    
    //Constructor de la clase Lista
    public ListaSimple() {
        this.pFirst = null;
        this.size = 0; 
    }
/**
 * * Metodos get y set para los atributos
 */    
    //Metodos get y set para los atrubutos

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Primitivas
/**
 * * Funcion para verificar si la lista es vacia
 */      
    //Funcion para verificar si la lista es vacia
    public boolean EsVacio(){
        return this.pFirst == null;
    }
    
/**
 * * metodo para insertar al inicio
 */    
    //Metodo para insertar al inicio
    public Nodo InsertarInicio(Object dato){
        
        Nodo pNew = new Nodo();
        pNew.setDato(dato);
       
        if (EsVacio()) {   
            pFirst = pNew;
        } else{
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
        return pNew;
    }
    
    public void InsertarIncio2(Object dato){
        Nodo pNew = new Nodo();
        pNew.setDato(dato);
        
        if(EsVacio()){
            this.pFirst.setDato(dato);
            this.pFirst.setPnext(null);
        }else{
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
    }
/**
 * * metodo para insertar al final
 */ 
    //Metodo para insertar al final
    public void InsertarFinal(Object dato){
        Nodo pNew = new Nodo(dato);
        if(EsVacio()){
            pFirst = pNew;
        }else{
            Nodo aux = pFirst;
            while (aux.getPnext() != null){
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }
/**
 * * Metodo para insertar por posición
 */      
    public void insertarPorPosicion(int posicion, Object valor){
        if(posicion>=0 && posicion<size){
            Nodo nuevo = new Nodo(valor);
            if(posicion == 0){
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            }
            else{
                if(posicion == size-1){
                    Nodo aux = pFirst;
                    while(aux.getPnext() != null){
                        aux = aux.getPnext();
                    }
                    aux.setPnext(nuevo);              
                }
                else{
                    Nodo aux = pFirst;
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getPnext();
                    }
                    Nodo siguiente = aux.getPnext();
                    aux.setPnext(nuevo);
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }
    
    
    
/**
 * * para transformar una lista en cadena de caracteres
 */     
    //Metodo para transformar una lista en cadena de caracteres
    public String Transformar(){
        if(!EsVacio()){
            
            Nodo aux = pFirst;
            String expresion = "";
            
            for(int i = 0; i <size;i++){
            expresion += aux.getDato().toString() + "\n";
            aux = aux.getPnext();
            }
            return expresion;
        }
        return "Lista vacia";
    }
/**
 * * Metodo para mostrar
 */      
    public void mostrar(){
        if (!EsVacio()){
            Nodo aux = pFirst;
            String expresion = "";
            while(aux != null){
               expresion = expresion + aux.getDato().toString() + "\n";
               aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
   
    /**
 * * Metodo para para eliminar por posición
 */  
    public void EliminarPorPosicion(int posicion){

        if(posicion>=0 && posicion<size){
            if(posicion == 0){
                pFirst = pFirst.getPnext();
            }
            else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext();
                aux.setPnext(siguiente.getPnext());
            }
            size--;
        }
    }
    
   
/**
 * * Metodo para obtener el valor de un nodo en una determinada posición
 */     
    //Metodo para obtener el valor de un nodo en una determinada posición
    public Object getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
/**
 * * Metodo para obtener un nodo en una determinada posición
 */     
        //Metodo para obtener un nodo en una determinada posición
    public Nodo getNodo(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst;
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux;
            }
        }
        return null;
    }
/**
 * * Metodo para retornar la posicion de un nodo
 */      
    //Metodo para retornar la posicion de un nodo
    public int getIndex (Nodo nodito){
        if (!EsVacio()){
            Nodo aux = pFirst;
            int count = 0;
            while(aux != null){
                
                if (nodito == aux){
                    return count;     //posicion en memoria del nodo
                }
                count ++;
                aux = aux.getPnext();
            }
            return -1;
        }
    return -1;
    }
    
   
/**
 * * Funcion para buscar un elemento en la lista
 */      
    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    
    public int buscar2(Document referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        int count = 0;
        while(aux != null && encontrado != true){
            Document currentDoc = (Document) aux.getDato();
            if (referencia.getTitle() == currentDoc.getTitle()){ 
                return count;
            }
            else{
                count += 1;
                aux = aux.getPnext();
            }
        }
        return -1;
    }
    
    //Destructor
    public void eliminar(){
        pFirst = null;
        size = 0;
    }

    
   
}
