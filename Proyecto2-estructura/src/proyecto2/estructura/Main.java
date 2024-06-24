/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2.estructura;

import Clases.Document;
import EDD.HashTable;

/**
 *
 * @author luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashTable hashTable = new HashTable();

        Document doc1 = new Document("Complemento de software para el diseño de fundaciones",
                "Raquel Sandoval, Iván Loscher, Christian Guillén-Drija",
                "El adelanto tecnológico presente hoy en día ha traído una gran cantidad de herramientas útiles para los ingenieros...",
                "fundaciones directas, AutoCAD, complemento, C#");

        Document doc2 = new Document("Arquitectura referencial para mecanismos de Internacionalización y localización en PHP",
                "Christian Guillén Drija, Andrea Pérez, Carlos Maldonado",
                "Los procesos de internacionalización y localización inciden directamente en la usabilidad de un sistema web...",
                "análisis de dominio, ingeniería de dominio, PHP, arquitectura referencial, internacionalización y localización");

        hashTable.insertDocument(doc1);
        hashTable.insertDocument(doc2);

        //hashTable.displayAllDocuments();

        //Document foundDoc = hashTable.getDocument("Complemento de software para el diseño de fundaciones");
        //System.out.println("Documento encontrado: " + foundDoc.getTitle());

        hashTable.removeDocument("Complemento de software para el diseño de fundaciones");
        hashTable.displayAllDocuments();
    }
    
}
