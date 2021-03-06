/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVectores.A_valorMaximo;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Programa que lee 10 valores numéricos, los almacena en un vector 
 * y muestra el valor máximo así como la posición que ocupa.
 * @author Ignacio
 */
public class ValorMaximo extends javax.swing.JFrame {

    private final int MAX_VALORES = 10;
    int[] listaNumeros = new int[MAX_VALORES];
    int numValores = 0;
    /**
     * Creates new form ValorMaximo
     */
    public ValorMaximo() {
        initComponents();
        
        //Centramos la ventana
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTFNuevoValor = new javax.swing.JTextField();
        jBAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAFinal = new javax.swing.JTextArea();
        jBCalcular = new javax.swing.JButton();
        jBReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introduzca Valor");

        jBAdd.setText("Add");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jTAFinal.setEditable(false);
        jTAFinal.setColumns(20);
        jTAFinal.setRows(5);
        jScrollPane1.setViewportView(jTAFinal);

        jBCalcular.setText("Calcula Maximo");
        jBCalcular.setEnabled(false);
        jBCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularActionPerformed(evt);
            }
        });

        jBReiniciar.setText("Reiniciar");
        jBReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBAdd)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBReiniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBCalcular)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCalcular)
                    .addComponent(jBReiniciar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try{
            int numEntero = Integer.valueOf(jTFNuevoValor.getText());
            listaNumeros[numValores]=numEntero;
            jTAFinal.append(String.valueOf(numEntero) + "\n");
            seleccionaJTextField(jTFNuevoValor);
            
            numValores++;            
            
            //Si se han añadido todos los valores -> Desactivamos
            if (numValores == MAX_VALORES){
                jBAdd.setEnabled(false);
                jBCalcular.setEnabled(true);
                jTFNuevoValor.setEnabled(false);
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Error, el valor introducido no es numerico");
        }     
    }//GEN-LAST:event_jBAddActionPerformed

    private void seleccionaJTextField(JTextField texto){
        texto.requestFocus();
        texto.setSelectionStart(0);
        texto.setSelectionEnd(texto.getText().length());
    }
    
    private void jBCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularActionPerformed
        
        int maximo = 0;
        
        for (int valor:listaNumeros){
            if (valor > maximo)
                maximo = valor;
        }
        jTAFinal.append("El valor Maximo es el: "+maximo);
    }//GEN-LAST:event_jBCalcularActionPerformed

    private void jBReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReiniciarActionPerformed
        jTFNuevoValor.setEnabled(true);
        jBAdd.setEnabled(true);
        jBCalcular.setEnabled(false);
        jTAFinal.setText(null);
        numValores = 0;
        listaNumeros = new int[MAX_VALORES];
    }//GEN-LAST:event_jBReiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(ValorMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValorMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValorMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValorMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValorMaximo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCalcular;
    private javax.swing.JButton jBReiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAFinal;
    private javax.swing.JTextField jTFNuevoValor;
    // End of variables declaration//GEN-END:variables
}
