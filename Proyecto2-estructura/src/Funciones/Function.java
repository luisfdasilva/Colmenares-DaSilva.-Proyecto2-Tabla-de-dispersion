/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Document;
import EDD.HashTable;
import EDD.ListaSimple;
import EDD.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author eliocolmenares
 */
public class Function {

    /* La función crea un String con todos los autores que aparecen en la HashTable */
    public ListaSimple getAllAuthors(HashTable tabla) {
        ListaSimple autors = new ListaSimple();
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < tabla.getSize(); i++) {
            ListaSimple list = tabla.getTable()[i];
            Nodo currentNode = list.getpFirst();
            while (currentNode != null) {
                Document doc = (Document) currentNode.getDato();
                String[] autores_split = doc.getAuthors().split("\n");
                for (String autor : autores_split) {
                    if (!info.toString().contains(autor)) {
                        autors.InsertarFinal(autor);
                        info.append(autor).append("\n");
                    }
                }
                currentNode = currentNode.getPnext();
            }
        }
        return autors;
    }
    
    public String searchDocumentsByKeyword(HashTable hashTable, String keyword) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < hashTable.getSize(); i++) {
            ListaSimple list = hashTable.getTable()[i];
            Nodo currentNode = list.getpFirst();
            
            int count = 0;

            while (currentNode != null) {
                Document doc = (Document) currentNode.getDato();
                String[] keywordsArray = doc.getKeyWords().split("\n");

                for (String docKeyword : keywordsArray) {
                    if (docKeyword.equalsIgnoreCase(keyword)) {
                        result.append("Clave: ").append(i).append(", Cod: ").append(count).append(", Título: ").append(doc.getTitle()).append("\n");
                        break;
                    }
                }
                currentNode = currentNode.getPnext();
                count += 1;
            }
            
        }

        return result.toString();
   }


    
    /* Recibe un String de los autores y lo convierte en un arreglo, donde cada posición es un autor */
    public String[] createAuthorsArray(String autores) {
        return autores.split("\n");
    }

    /* Crea un String con la información de un documento. Recibe la clave única del documento */
    public String showDocument(HashTable tabla, int index) {
        ListaSimple list = tabla.getTable()[index];
        if (!list.EsVacio()) {
            Nodo currentNode = list.getpFirst();
            String infoDoc = "";
            while (currentNode != null) {
                Document doc = (Document) currentNode.getDato();
                infoDoc += "Título: " + doc.getTitle() + "\n" + "Autores: " + doc.getAuthors() + "\n" + "Palabras Clave: " + doc.getKeyWords() + "\n";
            }
            return infoDoc;
        }
        return null;
    }

    /* Genera un String con la clave y el título de cada documento almacenado en la HashTable */
    public String showAllDocuments(HashTable tabla) {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < tabla.getSize(); i++) {
            ListaSimple list = tabla.getTable()[i];
            Nodo currentNode = list.getpFirst();
            while (currentNode != null) {
                Document doc = (Document) currentNode.getDato();
                info.append(doc.getTitle()).append(" CLAVE: ").append(i).append("\n");
                currentNode = currentNode.getPnext();
            }
        }
        return info.toString();
    }

    public String showAllDocuments2(HashTable tabla) {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < tabla.getSize(); i++) {
            ListaSimple list = tabla.getTable()[i];
            Nodo currentNode = list.getpFirst();
            while (currentNode != null) {
                Document doc = (Document) currentNode.getDato();
                info.append(doc.getTitle()).append(",").append(doc.getAuthors()).append(",").append(doc.getSummaryBody()).append(",").append(doc.getKeyWords()).append("\n");
                currentNode = currentNode.getPnext();
            }
        }
        return info.toString();
    }

    /* Crea un arreglo de String, donde cada espacio es una palabra clave de un documento */
    public String[] createKeyArray(String keyWords) {
        return keyWords.split(",");
    }
    
    
    /* Cuenta la cantidad de veces que se repiten las palabras clave dentro de un documento */
    public String contKeyWords(String[] keyWords, String body) {
    StringBuilder cont = new StringBuilder();
    body = body.toLowerCase(); 

    for (String keyWord : keyWords) {
        keyWord = keyWord.toLowerCase(); 
        int times = 0;

        for (String parrafo1 : body.split(" ")) {
            if (parrafo1.startsWith(keyWord)) {
                times++;
            }
        }

        cont.append("La palabra {").append(keyWord).append("} aparece ").append(times).append(" veces en el documento\n");
    }
    return cont.toString();
}
    
    /*public String contKeyWords(String[] keyWords, String body) {
        StringBuilder cont = new StringBuilder();
        for (String keyWord : keyWords) {
            int times = 0;
            for (int j = 0; j < body.length(); j++) {
                if (body.substring(j).startsWith(keyWord)) {
                    times++;
                }
            }
            cont.append("La palabra {").append(keyWord).append("} aparece ").append(times).append(" veces en el documento\n");
        }
        return cont.toString();
    } 
    
         /* Ordena y crea un String con la información de un documento, para su análisis */
    public String getInformationToAnalyze(Document doc) {
        StringBuilder information = new StringBuilder(doc.getTitle().toUpperCase()).append("\n \n").append("Autores: ").append(doc.getAuthors()).append("\n \n");
        String[] keys = createKeyArray(doc.getKeyWords());
        information.append(contKeyWords(keys, doc.getSummaryBody()));
        return information.toString();
    }
    
     /* Ordena por orden alfabetico una lista de titulos para mostrarlos */
    public ListaSimple AscendenteTitulo(ListaSimple list) {
        if (!list.EsVacio()) {
            for (int i = 0; i < list.getSize() - 1; i++) {
                for (int j = 0; j < list.getSize() - 1; j++) {
                    String titulo1 = (String) list.getValor(j);
                    String titulo2 = (String) list.getValor(j + 1);
                    if (titulo1.compareToIgnoreCase(titulo2) > 0) {
                        String cam = (String) list.getValor(j);
                        list.EliminarPorPosicion(j);
                        list.insertarPorPosicion(j + 1, cam);
                    }
                }
            }
            return list;
        }
        return null;
    }
}
