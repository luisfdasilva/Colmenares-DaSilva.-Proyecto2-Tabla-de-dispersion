 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * * @author luis,eliocolmenares
 */
public class Document {
    private String title;
    private String authors;
    private String summaryBody;
    private String keyWords;

    public Document(String title, String authors, String summaryBody, String keyWords) {
        this.title = title;
        this.authors = authors;
        this.summaryBody = summaryBody;
        this.keyWords = keyWords;
    }
    
     public Document(String title) {
        this.title = title;
        this.authors = null;
        this.summaryBody = null;
        this.keyWords = null;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSummaryBody() {
        return summaryBody;
    }

    public void setSummaryBody(String summaryBody) {
        this.summaryBody = summaryBody;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }


    public boolean compareDocuments(Document document) {
        return document.getTitle().equalsIgnoreCase(this.title) && document.getAuthors().equalsIgnoreCase(this.authors);
    }

    @Override
    public String toString() {
        return "Titulo: " + title+"\n" + "\n Autores:" + authors + "\n Resumen:\n" + summaryBody + "\n\n, Palabras Claves: \n" + keyWords;
    }
    
     
}
