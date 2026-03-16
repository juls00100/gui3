package main;


import authenticate.logIn;
import authenticate.logIn;
import config.config;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juls
 */
public class Javagui extends javax.swing.JFrame {

public Javagui() {
    initComponents();
    config conf = new config();
        conf.manageHover(proceed);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textLabel3 = new javax.swing.JLabel();
        textLabel4 = new javax.swing.JLabel();
        textLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        proceed = new javax.swing.JPanel();
        LOGIN = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 33, 71));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 52, 54));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textLabel3.setBackground(new java.awt.Color(0, 33, 71));
        textLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textLabel3.setForeground(new java.awt.Color(197, 179, 88));
        textLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/visionmission.png"))); // NOI18N
        jPanel2.add(textLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 360, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -10, 450, 510));

        textLabel4.setBackground(new java.awt.Color(0, 33, 71));
        textLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textLabel4.setForeground(new java.awt.Color(197, 179, 88));
        textLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel4.setText("Where your voices are valuable!");
        jPanel1.add(textLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 240, 30));

        textLabel1.setBackground(new java.awt.Color(0, 33, 71));
        textLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textLabel1.setForeground(new java.awt.Color(197, 179, 88));
        textLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel1.setText("Academic Evaluation Area");
        textLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(197, 179, 88)));
        jPanel1.add(textLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 240, 40));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/the logo 3.2(circular 190px).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 450, 190));

        proceed.setBackground(new java.awt.Color(197, 179, 88));
        proceed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        proceed.setForeground(new java.awt.Color(0, 33, 71));
        proceed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedMouseClicked(evt);
            }
        });
        proceed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LOGIN.setBackground(new java.awt.Color(197, 179, 88));
        LOGIN.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(0, 33, 79));
        LOGIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOGIN.setText("CLICK TO PROCEED");
        LOGIN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGINMouseClicked(evt);
            }
        });
        proceed.add(LOGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 30));

        jPanel1.add(proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void proceedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedMouseClicked
        logIn loginFrame = new logIn();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_proceedMouseClicked

    private void LOGINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseClicked
        logIn loginFrame = new logIn();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LOGINMouseClicked

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
            java.util.logging.Logger.getLogger(Javagui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Javagui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Javagui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Javagui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Javagui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOGIN;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel proceed;
    private javax.swing.JLabel textLabel1;
    private javax.swing.JLabel textLabel3;
    private javax.swing.JLabel textLabel4;
    // End of variables declaration//GEN-END:variables
}
