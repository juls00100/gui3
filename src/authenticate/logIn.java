package authenticate;


import main.Javagui;
import config.config;
import javax.swing.*;

public class logIn extends javax.swing.JFrame {

    public logIn() {
        initComponents();
        
        config conf = new config();
        conf.manageHover(back);
        conf.manageHover(Login);
        conf.manageHover(bg);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        create = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        back = new javax.swing.JPanel();
        backlabel = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emails = new javax.swing.JTextField();
        textLabel = new javax.swing.JLabel();
        bg = new javax.swing.JPanel();
        gg = new javax.swing.JLabel();
        passs = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.activeCaption);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 33, 71));
        jPanel3.setAutoscrolls(true);
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setBackground(new java.awt.Color(0, 33, 71));
        create.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        create.setForeground(new java.awt.Color(240, 240, 240));
        create.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 170, -1));

        jPanel4.setBackground(new java.awt.Color(45, 52, 54));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(197, 179, 88));
        back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.setForeground(new java.awt.Color(0, 204, 51));
        back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backlabel.setBackground(new java.awt.Color(197, 179, 88));
        backlabel.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        backlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backlabel.setText("Back");
        backlabel.setFocusable(false);
        backlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backlabelMouseClicked(evt);
            }
        });
        back.add(backlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jPanel4.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 70, 30));

        Login.setBackground(new java.awt.Color(0, 204, 51));
        Login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Login.setForeground(new java.awt.Color(0, 204, 51));
        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(0, 153, 51));
        login.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("Log in");
        login.setFocusable(false);
        login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        Login.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jPanel4.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 70, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Password:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Email:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 90, 30));

        emails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailsActionPerformed(evt);
            }
        });
        jPanel4.add(emails, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, 30));

        textLabel.setBackground(new java.awt.Color(0, 33, 71));
        textLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        textLabel.setForeground(new java.awt.Color(240, 240, 240));
        textLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLabel.setText("Log In");
        jPanel4.add(textLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 450, 35));

        bg.setBackground(new java.awt.Color(0, 33, 71));

        gg.setBackground(new java.awt.Color(197, 179, 88));
        gg.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        gg.setForeground(new java.awt.Color(197, 179, 88));
        gg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gg.setText("No account? Create new one!");
        gg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gg.setFocusable(false);
        gg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ggMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gg, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(gg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 230, 20));
        jPanel4.add(passs, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 190, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 450, 510));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Academic Evaluations no.2.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 190));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(197, 179, 88));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME TO ACADEMIC EVALUATIONS!");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 450, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailsActionPerformed

    private void backlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backlabelMouseClicked
       
        Javagui javaguiFrame = new Javagui();
        javaguiFrame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backlabelMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
                                
    config conf = new config();
    
    // 1. Get credentials from input fields
    String userEmail = emails.getText();
    String userPass = new String(passs.getPassword()); 
    String query = "SELECT * FROM tbl_user WHERE u_email = '" + userEmail + "' AND u_pass = '" + userPass + "'";

    try {
        java.sql.ResultSet rs = conf.getData(query);

        if (rs.next()) {
            String status = rs.getString("u_status");
            String type = rs.getString("u_type");

            // 3. Check if account is approved
            if (!status.equalsIgnoreCase("Active") && !status.equalsIgnoreCase("Approved")) {
                JOptionPane.showMessageDialog(null, "Your account is " + status + ". Please contact the Administrator.");
            } else {
                // 4. SUCCESS! Save user details into the static config session
                // This ensures other forms like 'evaluate.java' can access the User ID.
                config.setSession(
                    rs.getString("u_id"),
                    rs.getString("u_name"),
                    rs.getString("u_email"),
                    rs.getString("u_type"),
                    rs.getString("u_image") // Path to profile picture
                );

                JOptionPane.showMessageDialog(null, "Login Successful!");

                // 5. Redirect based on User Type
                if (type.equals("Admin")) {
                    new x_admin.adminDashboard().setVisible(true);
                } else if (type.equals("Student")) {
                    new y_student.studDashboard().setVisible(true);
                } else if (type.equals("Teacher")) {
                    // Make sure this package/class exists in your project
                    // new z_teacher.teacherDashboard().setVisible(true); 
                    JOptionPane.showMessageDialog(null, "Teacher Dashboard coming soon.");
                } else {
                    JOptionPane.showMessageDialog(null, "User type not recognized.");
                    return;
                }
                
                // Close the login form
                this.dispose();
            }
        } else {
            // User not found in database
            JOptionPane.showMessageDialog(null, "INVALID EMAIL OR PASSWORD.");
            emails.setText(""); 
            passs.setText("");
        }
        
        // Always close the result set to free database locks
        conf.closeResult(rs);

    } catch (java.sql.SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Database Connection Error!");
    }

    }//GEN-LAST:event_loginMouseClicked

    private void ggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ggMouseClicked
        signup1 signup1Frame = new signup1();
        signup1Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ggMouseClicked

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
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Login;
    public javax.swing.JPanel back;
    public javax.swing.JLabel backlabel;
    public javax.swing.JPanel bg;
    public javax.swing.JPanel create;
    public javax.swing.JTextField emails;
    public javax.swing.JLabel gg;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JLabel login;
    public javax.swing.JPasswordField passs;
    public javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
}
