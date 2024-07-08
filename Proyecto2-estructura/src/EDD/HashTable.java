/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Document;

/**
 * * @author luis,eliocolmenares
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
     * *@return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * *@param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * *@return the table
     */
    public ListaSimple[] getTable() {
        return table;
    }

    /**
     * *@param table the table to set
     */
    public void setTable(ListaSimple[] table) {
        this.table = table;
    }

    public void initTable() {
        for (int i = 0; i < size; i++) {
            table[i] = new ListaSimple();
        }
    }
    /**
     * *Función hash que genera una clave única a partir del nombre de un documento
     */
    /* Función hash que genera una clave única a partir del nombre de un documento */
    public int hashFunction(Document document) {
        String title = document.getTitle();
        int index = 0;
        for (int i = 0; i < title.length(); i++) {
            index += title.codePointAt(i);
        }
        return Math.abs(index % this.getSize());
    }
    /**
     * *Inserta en la HashTable un documento en la posición que indique la clave única
     */
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
    /**
     * *Verifica si un documento ya existe en la HashTable
     */
    /* Verifica si un documento ya existe en la HashTable */
    public boolean isInHash(Document document) {
        int index = hashFunction(document);
        return table[index].buscar(document);
    }
    /**
     * *Devuelve la clave de un documento al pasarselo
     */
    /*Devuelve la clave de un documento al pasarselo*/
     public int KeyHashDocument(Document document) {
        int index = hashFunction(document);
        if (table[index].buscar(document)){
            return index;
        }
        return -1;
    }
    /**
     * *Busca por titulo y devuelve un string con clave y codigo
     */ 
     /*Busca por titulo y devuelve un string con clave y codigo*/
     public String KeyHashCodDocument(String titulo) {
        Document doc = new Document(titulo);
        int index = hashFunction(doc);
        if (table[index].buscar2(doc) != -1) {
            return "Clave: " + index +", Codigo: " + table[index].buscar2(doc) + "Titulo: " + titulo;
           
        }
        return null;
    }
    /**
     * *Método para obtener un documento por título
     */
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
    
    public boolean HashisEmpty(){
        for (int i=0;i<size;i++){
            if(table[i].getpFirst()!=null){
                return false;
            }
        }
        return true;
    }
    /**
     * *Método para eliminar un documento por título
     */
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
    /**
     * *Mostrar todos los documentos en la tabla hash
     */
    /* Mostrar todos los documentos en la tabla hash */
    public void displayAllDocuments() {
        for (int i = 0; i < size; i++) {
            if (!table[i].EsVacio()) {
                System.out.println("Índice " + i + ": ");
                table[i].mostrar();
            }
        }
    }
    /**
     * *Muestra un documento al darle su clave y codigo
     */
    /*Muestra un documento al darle su clave y codigo */
    public Document getDocumentByKeyCod(int key, int cod){
        Document doc = (Document) table[key].getValor(cod); 
        return doc;
    }
    /**
     * *Comprueba si la lista en esa posicion del hashtable contiene ya un documento
     */
    /* Comprueba si la lista en esa posicion del hashtable contiene ya un documento*/
     public boolean keyInHash(int key){
        return table[key].getSize() != 0;
    }
    /**
     * *Retorna un string con la clave, codigo y titulo de los documentos hechos por ese autor
     */ 
    /*Retorna un string con la clave, codigo y titulo de los documentos hechos por ese autor*/ 
     public String getDocumentsByAuthor(String author) {
        String documentsByAuthor = "";

        for (int i = 0; i < size; i++) {
            ListaSimple list = table[i];
            Nodo currentNode = list.getpFirst();
            
            int count = 0;

            while (currentNode != null) {
                Document doc = (Document) currentNode.getDato();
                String[] authorsArray = doc.getAuthors().split("\n");

                for (String docAuthor : authorsArray) {
                    if (docAuthor.equalsIgnoreCase(author)) {
                        documentsByAuthor += "Clave: " + i +", Codigo: "+ count +", Titulo: "+ doc.getTitle() + "\n";
                        break;
                    }
                }
                count += 1;
                currentNode = currentNode.getPnext();
            }
        }

        return documentsByAuthor;
    }


}