 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * * @author luis
 */
public class Resumen {
    private String titulo;
    private String autores;
    private String cuerpo;
    private String[] palabrasClave;

    public Resumen(String titulo, String autores, String cuerpo, String[] palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpo = cuerpo;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String[] getPalabrasClave() {
        return palabrasClave;
    }
}
