/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Document;

/**
 *
 * @author luis
 */
public class HashTable {
    private int size;
    private ListaSimple[] table;

    public HashTable() {
        this.size = 50;
        this.table = new ListaSimple[size];
        initTable();
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the table
     */
    public ListaSimple[] getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(ListaSimple[] table) {
        this.table = table;
    }

    public void initTable() {
        for (int i = 0; i < size; i++) {
            table[i] = new ListaSimple();
        }
    }

    /* Función hash que genera una clave única a partir del nombre de un documento */
    public int hashFunction(Document document) {
        String title = document.getTitle();
        int index = 0;
        for (int i = 0; i < title.length(); i++) {
            index += title.codePointAt(i);
        }
        return Math.abs(index % this.getSize());
    }

    /* Inserta en la HashTable un documento en la posición que indique la clave única */
    public void insertDocument(Document document) {
        int index = hashFunction(document);
        ListaSimple list = table[index];
        if (!list.buscar(document)) {
            list.InsertarFinal(document);
            System.out.println("Documento : " + document.getTitle() + ", insertado en la posición " + index);
        } else {
            System.out.println("¡ERROR! El documento ya está registrado");
        }
    }

    /* Verifica si un documento ya existe en la HashTable */
    public boolean isInHash(Document document) {
        int index = hashFunction(document);
        return table[index].buscar(document);
    }
    
    /* Método para obtener un documento por título */
    public Document getDocument(String title) {
        Document dummyDoc = new Document(title, "", "", "");
        int index = hashFunction(dummyDoc);
       
        ListaSimple list = table[index];
        Nodo currentNode = list.getpFirst();
        
        while (currentNode != null) {
            Document doc = (Document) currentNode.getDato();
            if (doc.getTitle().equalsIgnoreCase(title)) {
                return doc;
            }
            currentNode = currentNode.getPnext();
        }
        return null;
    }
    
    /* Método para eliminar un documento por título */
    public void removeDocument(String title) {
        Document dummyDoc = new Document(title, "", "", "");
        int index = hashFunction(dummyDoc);
        ListaSimple list = table[index];
        Nodo currentNode = list.getpFirst();
        int position = 0;
        while (currentNode != null) {
            Document doc = (Document) currentNode.getDato();
            if (doc.getTitle().equalsIgnoreCase(title)) {
                list.EliminarPorPosicion(position);
                System.out.println("Documento " + title + " eliminado de la posición " + index);
                return;
            }
            currentNode = currentNode.getPnext();
            position++;
        }
        System.out.println("Documento " + title + " no encontrado");
    }
    
    /* Mostrar todos los documentos en la tabla hash */
    public void displayAllDocuments() {
        for (int i = 0; i < size; i++) {
            if (!table[i].EsVacio()) {
                System.out.println("Índice " + i + ": ");
                table[i].mostrar();
            }
        }
    }
}
