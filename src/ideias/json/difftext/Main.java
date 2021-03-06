/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.json.difftext;

import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public void main() {

        String texto1 = JOptionPane.showInputDialog(null, "Texto 1");
        System.out.println(texto1);

        String texto2 = JOptionPane.showInputDialog(null, "Texto 2");
        System.out.println(texto2);

        boolean temDiferenca = false;
        int caracatere;
        int totalDiferencas = 0;
        String diferencas = "";
        String indicador = "";

        int filler2 = 0;

        if (texto1 != null && texto2 != null) {
            if (texto1.length() == texto2.length()) {
                for (int i = 0; i < texto1.length(); i++) {
                    int filler = 0;
                    if (texto1.charAt(i) != texto2.charAt(i)) {
                        filler = i;
                        temDiferenca = true;
                        caracatere = i + 1;
                        diferencas += "\n" + "caractere: " + caracatere + " -> txt1: " + texto1.charAt(i) + " | txt2: " + texto2.charAt(i) + ";";
                        indicador += geraEspacos(i - filler2) + "|";
//						diferencas += "\n" + "caractere: " + diferenca + " -> txt1: " + texto1.substring(i - 10) + " | txt2: " + texto2.substring(i - 10) + ";";
                        filler2 = filler + 1;
                        totalDiferencas += 1;
                    }
                }
                if (temDiferenca) {
                    JOptionPane.showMessageDialog(null, "Textos diferentes");
                    System.out.println(indicador);
                    System.out.println("diferenças = " + totalDiferencas + ":" + diferencas);
                } else {
                    JOptionPane.showMessageDialog(null, "Textos iguais");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Textos com tamanhos diferentes");
            }
        }
    }

    public String geraEspacos(int entry) {
        String espacos = "";
        for (int i = 0; i < entry; i++) {
            espacos += " ";
        }
        return espacos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfTexto1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTexto2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Texto 1");

        jLabel2.setText("Texto 2");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTexto1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTexto2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String texto1 = tfTexto1.getText();
        System.out.println(texto1);

        String texto2 = tfTexto2.getText();
        System.out.println(texto2);

        boolean temDiferenca = false;
        int caracatere;
        int totalDiferencas = 0;
        String diferencas = "";
        String indicador = "";

        int filler2 = 0;

        if (texto1 != null && texto2 != null) {
            if (texto1.length() == texto2.length()) {
                for (int i = 0; i < texto1.length(); i++) {
                    int filler = 0;
                    if (texto1.charAt(i) != texto2.charAt(i)) {
                        filler = i;
                        temDiferenca = true;
                        caracatere = i + 1;
                        diferencas += "\n" + "caractere: " + caracatere + " -> txt1: " + texto1.charAt(i) + " | txt2: " + texto2.charAt(i) + ";";
                        indicador += geraEspacos(i - filler2) + "|";
//						diferencas += "\n" + "caractere: " + diferenca + " -> txt1: " + texto1.substring(i - 10) + " | txt2: " + texto2.substring(i - 10) + ";";
                        filler2 = filler + 1;
                        totalDiferencas += 1;
                    }
                }
                if (temDiferenca) {
                    JOptionPane.showMessageDialog(null, "Textos diferentes");
                    Font f = new Font("f1", Font.BOLD, 12);
                    
                    jTextArea1.setText(texto1 + "\n" + texto2 + "\n" + indicador);
                    jTextArea1.setFont(f);
                    System.out.println(indicador);
                    System.out.println("diferenças = " + totalDiferencas + ":" + diferencas);
                } else {
                    JOptionPane.showMessageDialog(null, "Textos iguais");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Textos com tamanhos diferentes");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField tfTexto1;
    private javax.swing.JTextField tfTexto2;
    // End of variables declaration//GEN-END:variables
}
