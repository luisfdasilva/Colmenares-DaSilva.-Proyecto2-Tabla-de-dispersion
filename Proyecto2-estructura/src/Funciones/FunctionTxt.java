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
import javax.swing.JOptionPane;

/**
 * * @author eliocolmenares
 */
public class FunctionTxt {
    /**
    * * Extrae con strings y listas si son palabras separadas o personas para luego devolver Documento
    */
    public Document cargar_documento(String txt1) {
        ListaSimple listautores = new ListaSimple();
        ListaSimple listpalabras_claves = new ListaSimple();

        String[] devision_info = txt1.replaceAll("Autores", "Ω").replaceAll("Resumen", "Ω").split("Ω");

        String titulo = devision_info[0].trim();
        String[] info_autores = devision_info[1].trim().split("\n");
        
        for (String autor : info_autores) {
            listautores.InsertarFinal(autor.trim());
        }

        String cuerpo = devision_info[2].trim().split("\n")[0].trim();
        String[] palabras_claves = devision_info[2].trim().split("\n")[devision_info[2].trim().split("\n").length - 1].split(":")[1].split(",");
        for (String palabra : palabras_claves) {
            listpalabras_claves.InsertarFinal(palabra.trim().replaceAll("\\.", ""));
        }

        String autor = listautores.Transformar();
        String palabrasClaves = listpalabras_claves.Transformar();

        return new Document(titulo, autor, cuerpo, palabrasClaves);
    }
    /**
    * * Ingresa el documento en el hash
    */
    /*Ingresa el documento en el hash */
    public void cargar_HashTable(ListaSimple list1, Document document, HashTable tabla) {
        Nodo aux = list1.getpFirst();
        boolean encontrado = false;
        while (aux != null && !encontrado) {
            if (aux.getDato().equals(document.getTitle())) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }

        if (!encontrado) {
            list1.InsertarFinal(document.getTitle());
            tabla.insertDocument(document);
            JOptionPane.showMessageDialog(null, "Documento Cargado");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe el documento", "AVISO", 0);
        }
    }
    
    public void Escribir_txt(HashTable documents) {
        Function func = new Function();
        String expresion_actual = func.showAllDocuments2(documents);

        try {
            PrintWriter pw = new PrintWriter("test\\documentos.txt");
            pw.print(expresion_actual);
            pw.close();
            System.out.println("Guardado exitoso");
        } catch (Exception err) {
            System.err.println(err);
        }
    }

    public HashTable Leer_txt() {
        HashTable document = new HashTable();
        StringBuilder expresion_txt = new StringBuilder();
        String path = "test\\documentos.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        expresion_txt.append(line).append("\n");
                    }
                }
                if (!expresion_txt.toString().isEmpty()) {
                    String[] expresion_split = expresion_txt.toString().split("\n");
                    for (String expresion : expresion_split) {
                        String[] campos = expresion.split(",");
                        Document doc = new Document(campos[0], campos[1], campos[2], campos[3]);
                        document.insertDocument(doc);
                    }
                }
                br.close();
                System.out.println("Lectura exitosa");
            }
        } catch (Exception ex) {
            System.err.println("Error al leer la expresión: " + ex);
        }
        return document;
    }
    
}
