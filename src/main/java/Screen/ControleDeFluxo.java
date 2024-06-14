/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Screen;

import TAD.Fila;
import TAD.Pilha;
import java.util.*;

/**
 *
 * @author raijo
 */
public class ControleDeFluxo extends javax.swing.JFrame {

    /**
     * Creates new form ControleDeFluxo
     */
    public ControleDeFluxo() {
        initComponents();
        notFita.setVisible(false);
    }
    
    public void fecharJanela() {
        this.dispose();
    }
    
    public void analisarFita(String fita) {
        try {
            Fila fila = new Fila();
            Pilha pilha = new Pilha();
            String[] splitFita = fita.split("");
            int estado = 0;
            boolean aceito = true;

            for (int i = 0; i < fita.length(); i++) {
                fila.inserir(splitFita[i]);
            }
            
            if (fita.length() == 1 && fita.equals("c")) {
                estado = 1;
            } else {
                for (int i = 1; i <= fita.length(); i++) {
                    if(estado == 0 && pilha.mostrarAtual() == null && fila.mostrarPrimeiro().equals("a") ||
                       estado == 0 && pilha.mostrarAtual() == null && fila.mostrarPrimeiro().equals("b")){
                        pilha.inserir(fila.mostrarPrimeiro());
                        fila.remover();
                    } else if (estado == 0 && pilha.mostrarAtual() == null && fila.mostrarPrimeiro().equals("c")) {
                        System.out.println("estado " + estado);
                        fila.remover();
                        estado = 1;
                    } else if (estado == 0 && pilha.mostrarAtual().equals("a") && fila.mostrarPrimeiro().equals("a") || 
                       estado == 0 && pilha.mostrarAtual().equals("b") && fila.mostrarPrimeiro().equals("a") ||
                       estado == 0 && pilha.mostrarAtual().equals("a") && fila.mostrarPrimeiro().equals("b") ||
                       estado == 0 && pilha.mostrarAtual().equals("b") && fila.mostrarPrimeiro().equals("b")){
                        pilha.inserir(fila.mostrarPrimeiro());
                        fila.remover();
                    } else if(estado == 0 && pilha.mostrarAtual().equals("a") && fila.mostrarPrimeiro().equals("c")) {
                        estado = 1;
                        fila.remover();
                    } else if(estado == 0 && pilha.mostrarAtual().equals("b") && fila.mostrarPrimeiro().equals("c")) {
                        estado = 1;
                        fila.remover();
                    } else if(estado == 1 && pilha.mostrarAtual().equals("a") && fila.mostrarPrimeiro().equals("a") ||
                              estado == 1 && pilha.mostrarAtual().equals("b") && fila.mostrarPrimeiro().equals("b")) {
                        pilha.remover();
                        fila.remover();
                    } else {
                        System.out.println("Nao aceito estado: " + estado + " pilha: " + pilha.mostrarAtual() + " fila: " + fila.mostrarPrimeiro());
                        notFita.setVisible(true);
                        revalidate();
                        repaint();
                        aceito = false;
                        Timer timer = new Timer();

                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                fecharJanela();
                            }
                        };

                        timer.schedule(task, 3000);
                    }
                }
            }

            
            
            if (aceito && estado == 1 && pilha.mostrarQuantidade() == 1 || aceito && estado == 1 && pilha.mostrarQuantidade() == 0) {
                notFita.setText("FITA ACEITA");
                notFita.setVisible(true);
                revalidate();
                repaint();
            
                Timer timer = new Timer();

                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        fecharJanela();
                    }
                };
                
                timer.schedule(task, 3000);
            } else {
                System.out.println("Nao aceito estado: " + estado + " pilha: " + pilha.mostrarAtual() + " fila: " + fila.mostrarPrimeiro());
                notFita.setVisible(true);
                revalidate();
                repaint();
                aceito = false;
                Timer timer = new Timer();

                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        fecharJanela();
                    }
                };
                    
                timer.schedule(task, 3000);
            }
        } catch (Exception e) {
            notFita.setVisible(true);
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

        textFita = new javax.swing.JTextField();
        checkFita = new javax.swing.JButton();
        notFita = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tourning Machine");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setType(java.awt.Window.Type.POPUP);

        textFita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Fita")));
        textFita.setMaximumSize(new java.awt.Dimension(403, 60));
        textFita.setMinimumSize(new java.awt.Dimension(403, 60));
        textFita.setName(""); // NOI18N

        checkFita.setText("Verificar FIta");
        checkFita.setMaximumSize(new java.awt.Dimension(403, 60));
        checkFita.setMinimumSize(new java.awt.Dimension(403, 60));
        checkFita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkFitaMouseClicked(evt);
            }
        });

        notFita.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        notFita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notFita.setText("FITA NAO ACEITA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(notFita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkFita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(textFita, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkFita, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(notFita, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkFitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkFitaMouseClicked
        String fita = textFita.getText();
        analisarFita(fita);
    }//GEN-LAST:event_checkFitaMouseClicked

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
            java.util.logging.Logger.getLogger(ControleDeFluxo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleDeFluxo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleDeFluxo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleDeFluxo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleDeFluxo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkFita;
    private javax.swing.JLabel notFita;
    private javax.swing.JTextField textFita;
    // End of variables declaration//GEN-END:variables
}
