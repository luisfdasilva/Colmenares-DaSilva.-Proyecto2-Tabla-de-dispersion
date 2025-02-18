/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Clases.Document;
import Funciones.Function;
import Funciones.helpers;
import static Ventanas.BuscarPalabra.v2;
import static Ventanas.Menu.hashTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;



/**
 * * @author eliocolmenares
 */
public class BuscarAutor extends javax.swing.JFrame {

    public static Menu v2;
    DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    
    public BuscarAutor(Menu v2) {
        Function func = new Function();
       initComponents();
        this.v2 = v2;
        v2.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        for (int i = 0; i < func.getAllAuthors(hashTable).getSize(); i++) {
            String currentAutor = (String) func.getAllAuthors(hashTable).getValor(i);
            modeloCombo.addElement(currentAutor);  
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        autores = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        inputCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        verDetalle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleDoc = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        inputClave1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 155, 47));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel1.setText("BUSCAR POR AUTOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 400, 40));

        autores.setModel(modeloCombo);
        jPanel1.add(autores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 280, -1));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 140, -1));

        result.setColumns(20);
        result.setRows(5);
        jScrollPane1.setViewportView(result);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 280, 150));

        inputCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCodActionPerformed(evt);
            }
        });
        jPanel1.add(inputCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 130, 20));

        jLabel2.setText("Ingrese la clave:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 130, -1));

        verDetalle.setText("Ver completo");
        verDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDetalleActionPerformed(evt);
            }
        });
        jPanel1.add(verDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 120, -1));

        detalleDoc.setColumns(20);
        detalleDoc.setRows(5);
        jScrollPane2.setViewportView(detalleDoc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 450, 150));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        inputClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputClave1ActionPerformed(evt);
            }
        });
        jPanel1.add(inputClave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 130, 20));

        jLabel3.setText("Ingrese el codigo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCodActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
       this.setVisible(false);
       v2.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void inputClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputClave1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if (!hashTable.HashisEmpty()){  
            result.setText(hashTable.getDocumentsByAuthor(autores.getSelectedItem().toString()));
        }else{
            JOptionPane.showMessageDialog(null, "NO HAY DOCUMENTOS CARGADOS","ERROR", HEIGHT);
        }
        
    }//GEN-LAST:event_buscarActionPerformed

    private void verDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDetalleActionPerformed
        if(!hashTable.HashisEmpty()){
            String keyString = inputClave1.getText();
            String codString = inputCod.getText();
        
            helpers help = new helpers();
            if(help.ValidarNumeros(keyString) != -1){
                int key = help.ValidarNumeros(keyString);
                if(help.ValidarNumeros(codString) != -1){
                    int cod = help.ValidarNumeros(codString); 
                    if(hashTable.keyInHash(key)){
                        if(help.validarRangeList(cod, hashTable.getTable()[key].getSize())){
                            Document docResult = hashTable.getDocumentByKeyCod(key, cod);
                            detalleDoc.setText(docResult.toString());
                    
                        }else{
                            JOptionPane.showMessageDialog(null,"El codigo no esta dentro de la lista de documentos correspondiente");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"La clave no se encuentra en el hashTable");
                    }         
                }else{ 
                    JOptionPane.showMessageDialog(null,"El codigo deber ser un numero");     
                }
        
            }else{
                JOptionPane.showMessageDialog(null,"La clave deber ser un numero");
            }
        }else{
           JOptionPane.showMessageDialog(null, "NO HAY DOCUMENTOS CARGADOS","ERROR", HEIGHT); 
        }
                   
    }//GEN-LAST:event_verDetalleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarAutor(v2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> autores;
    private javax.swing.JButton buscar;
    private javax.swing.JTextArea detalleDoc;
    private javax.swing.JTextField inputClave1;
    private javax.swing.JTextField inputCod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea result;
    private javax.swing.JButton verDetalle;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
