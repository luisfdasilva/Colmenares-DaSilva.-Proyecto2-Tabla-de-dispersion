/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Txt;
import Clases.Resumen;
import Clases.TablaHash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
/**
 * * @author luis
 */
public class GestorArchivos {
    public static void cargarResumensDeDirectorio(String directorio, TablaHash tablaHash) {
        File folder = new File(directorio);
        File[] listaDeArchivos = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (listaDeArchivos != null) {
            for (File archivo : listaDeArchivos) {
                cargarResumenDeArchivo(archivo.getAbsolutePath(), tablaHash);
            }
        }
    }

    public static void cargarResumenDeArchivo(String nombreArchivo, TablaHash tablaHash) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String titulo = br.readLine();
            String autores = br.readLine();
            StringBuilder cuerpo = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                cuerpo.append(linea).append("\n");
            }

            String[] palabrasClave = br.readLine().split(",");

            Resumen resumen = new Resumen(titulo, autores, cuerpo.toString().trim(), palabrasClave);
            if (!tablaHash.agregarResumen(resumen)) {
                System.out.println("El resumen con el título \"" + titulo + "\" ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarResumenEnArchivo(Resumen resumen, String directorio) {
        String nombreArchivo = directorio + "/" + resumen.getTitulo().replaceAll("\\s+", "_") + ".txt";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(resumen.getTitulo() + "\n");
            writer.write(resumen.getAutores() + "\n");
            writer.write(resumen.getCuerpo() + "\n");
            writer.write(String.join(",", resumen.getPalabrasClave()) + "\n");
            System.out.println("Resumen guardado en: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
