/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_teacher;


import authenticate.logIn;
import config.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
import x_admin.adminDashboard;
import x_admin.manageQ;
import x_admin.sysLogs;
/**
 *
 * @author juls
 */
public class tDashboard extends javax.swing.JFrame {

    private String currentImagePath;
    private String currentUserName;
    
    public tDashboard(String name, String imagePath) {
        if (config.stopIllegalAccess(this)) return;
        initComponents();
        this.currentUserName = name;
        this.currentImagePath = imagePath;
        namee.setText(currentUserName);
        setupDashboard();
        displayResults(); 
        displayStatistics();
        

        //OTTTTTTTTTTTTTTTEN
    }

    public tDashboard() {
    if (config.stopIllegalAccess(this)) return;
    initComponents();
    
    config conf = new config();
    
    namee.setText(config.getName()); 
    displayProfileImage();
    setupDashboard(); 
    
    
    displayResults(); 
    displayStatistics();
     conf.designTable(table_results); 
     displayLeastScored();
     displayMostScored();
}
    public void displayProfileImage() {
        String path = config.getImage();
        if (path != null && !path.isEmpty()) {
            config conf = new config();
            profile.setIcon(conf.resizeImage(path, null, profile.getWidth(), profile.getHeight()));
        }
    }

      private void setupDashboard() {
        
        config conf = new config();
        // Hover effects
        conf.manageHover(a);  conf.manageHover(d);
         conf.manageHover(h);

        conf.manageHover(C); 
        
        // Update the image using the crop logic
        if (currentImagePath != null && !currentImagePath.isEmpty()) {
        // Pass the path, null for byte array, and the label dimensions
        profile.setIcon(conf.resizeImage(currentImagePath, null, profile.getWidth(), profile.getHeight()));
    }
        
    }
    
    public void syncUserSession() {
    // This works for EVERYONE
    namee.setText(config.getName());
    
    String path = config.getImage();
    if (path != null && !path.isEmpty()) {
        config conf = new config();
        // Uses the proportional resizing (anti-squeeze) we made
        profile.setIcon(conf.resizeImage(path, null, profile.getWidth(), profile.getHeight()));
    }
}
   
   public void displayLeastScored() {
    config conf = new config();
    String teacherID = config.getID(); // Gamita ang ID kung t_u_id ang naa sa imong table

    try {
        // Gi-usab nato ang tbl_evaluation_main ngadto sa tbl_evaluation
        // Gi-usab nato ang e.eval_main_id ngadto sa e.e_id
        String query = "SELECT q.q_text, AVG(e.score) as average_score " +
                       "FROM tbl_evaluation_details e " +
                       "JOIN tbl_question q ON e.q_id = q.q_id " +
                       "JOIN tbl_evaluation m ON e.e_id = m.e_id " + 
                       "WHERE m.t_u_id = '" + teacherID + "' " + 
                       "GROUP BY e.q_id " +
                       "ORDER BY average_score ASC LIMIT 1";

        java.sql.ResultSet rs = conf.getData(query);

        if (rs.next()) {
            String questionText = rs.getString("q_text");
            double score = rs.getDouble("average_score");

            lbl_weakness.setText(questionText);
            lbl_score.setText(String.format("%.2f", score));
        } else {
            lbl_weakness.setText("No evaluations yet.");
            lbl_score.setText("0.00");
        }
    } catch (Exception e) {
        System.out.println("Error calculating least scored: " + e.getMessage());
    }
}
    public void displayMostScored() {
    config conf = new config();
    // Siguroha kung ID ba o Email ang gi-save nimo sa t_u_id
    String teacherID = config.getID(); 

    try {
        String query = "SELECT q.q_text, AVG(e.score) as average_score " +
                       "FROM tbl_evaluation_details e " +
                       "JOIN tbl_question q ON e.q_id = q.q_id " +
                       "JOIN tbl_evaluation m ON e.e_id = m.e_id " + // e_id ang link
                       "WHERE m.t_u_id = '" + teacherID + "' " +     // Filter by current teacher
                       "GROUP BY e.q_id " +
                       "ORDER BY average_score DESC LIMIT 1";        // DESC para MOST scored

        java.sql.ResultSet rs = conf.getData(query);

        if (rs.next()) {
            lbl_strength.setText(rs.getString("q_text"));
            lbl_high_score.setText(String.format("%.2f", rs.getDouble("average_score")));
        } else {
            lbl_strength.setText("No data yet.");
            lbl_high_score.setText("0.00");
        }
    } catch (Exception e) {
        System.out.println("Error calculating most scored: " + e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        a = new javax.swing.JPanel();
        account = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        dashbord = new javax.swing.JLabel();
        h = new javax.swing.JPanel();
        logs = new javax.swing.JLabel();
        i = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        user1 = new javax.swing.JLabel();
        profile = new config.CircularLabel();
        namee = new javax.swing.JLabel();
        totp4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_results = new javax.swing.JTable();
        C = new javax.swing.JPanel();
        lbl_totalAvg = new javax.swing.JLabel();
        users5 = new javax.swing.JLabel();
        totp1 = new javax.swing.JLabel();
        C1 = new javax.swing.JPanel();
        lbl_totalStudents = new javax.swing.JLabel();
        users6 = new javax.swing.JLabel();
        totp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SAVE = new javax.swing.JPanel();
        print = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_weakness = new javax.swing.JLabel();
        lbl_score = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_strength = new javax.swing.JLabel();
        lbl_high_score = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 33, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 52, 54));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a.setBackground(new java.awt.Color(197, 179, 88));
        a.setForeground(new java.awt.Color(197, 179, 88));
        a.setPreferredSize(new java.awt.Dimension(142, 30));

        account.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account.setText("MY PROFILE");
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout aLayout = new javax.swing.GroupLayout(a);
        a.setLayout(aLayout);
        aLayout.setHorizontalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(account, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        aLayout.setVerticalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, -1));

        d.setBackground(new java.awt.Color(197, 179, 88));
        d.setForeground(new java.awt.Color(197, 179, 88));
        d.setPreferredSize(new java.awt.Dimension(142, 30));
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dMouseEntered(evt);
            }
        });
        d.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashbord.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        dashbord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashbord.setText("DASHBOARD");
        dashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashbordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashbordMouseEntered(evt);
            }
        });
        d.add(dashbord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

        h.setBackground(new java.awt.Color(197, 179, 88));
        h.setForeground(new java.awt.Color(197, 179, 88));
        h.setPreferredSize(new java.awt.Dimension(142, 30));

        logs.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        logs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logs.setText("MY LOGS");
        logs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hLayout = new javax.swing.GroupLayout(h);
        h.setLayout(hLayout);
        hLayout.setHorizontalGroup(
            hLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        hLayout.setVerticalGroup(
            hLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, -1));

        i.setBackground(new java.awt.Color(44, 62, 80));
        i.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 179, 88)));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow20.png"))); // NOI18N

        Back.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        Back.setForeground(new java.awt.Color(197, 179, 88));
        Back.setText("Log out");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iLayout = new javax.swing.GroupLayout(i);
        i.setLayout(iLayout);
        iLayout.setHorizontalGroup(
            iLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iLayout.createSequentialGroup()
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        iLayout.setVerticalGroup(
            iLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel2.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 110, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 430));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        user1.setForeground(new java.awt.Color(197, 179, 88));
        user1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user1.setText("TEACHER DASHBOARD");
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        jPanel3.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 680, 70));

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jPanel3.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        namee.setBackground(new java.awt.Color(44, 62, 80));
        namee.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        namee.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.add(namee, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, 30));

        totp4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/man.png"))); // NOI18N
        jPanel3.add(totp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 70, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        table_results.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_results);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 620, 130));

        C.setBackground(new java.awt.Color(45, 52, 54));
        C.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totalAvg.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 28)); // NOI18N
        lbl_totalAvg.setForeground(new java.awt.Color(39, 174, 96));
        lbl_totalAvg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C.add(lbl_totalAvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 160, 40));

        users5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        users5.setForeground(new java.awt.Color(240, 240, 240));
        users5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users5.setText("OVERALL RATING");
        C.add(users5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 190, -1));

        totp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/totevsl.png"))); // NOI18N
        C.add(totp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        jPanel1.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 300, 80));

        C1.setBackground(new java.awt.Color(45, 52, 54));
        C1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totalStudents.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 28)); // NOI18N
        lbl_totalStudents.setForeground(new java.awt.Color(39, 174, 96));
        lbl_totalStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C1.add(lbl_totalStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 170, 40));

        users6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        users6.setForeground(new java.awt.Color(240, 240, 240));
        users6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users6.setText("TOTAL EVALUATIONS");
        C1.add(users6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 230, -1));

        totp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/checklist.png"))); // NOI18N
        C1.add(totp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 30));

        jPanel1.add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 280, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("HIGHEST RATING RECEIVED:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 230, 20));

        SAVE.setBackground(new java.awt.Color(51, 182, 81));
        SAVE.setForeground(new java.awt.Color(240, 240, 240));
        SAVE.setPreferredSize(new java.awt.Dimension(90, 90));
        SAVE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        print.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        print.setText("SAVE EVALUATION FILE");
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        SAVE.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 30));

        jPanel1.add(SAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 250, 30));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(lbl_weakness, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 32));

        lbl_score.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_score.setForeground(new java.awt.Color(255, 102, 51));
        jPanel4.add(lbl_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 0, 90, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 620, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(lbl_strength, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 32));

        lbl_high_score.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_high_score.setForeground(new java.awt.Color(51, 204, 0));
        jPanel5.add(lbl_high_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 0, 90, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 620, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("EVALUATIONS RECEIVED:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 230, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("LOWEST RATING RECEIVED:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 333, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void displayResults() {
    String sql = "SELECT DISTINCT e_date AS 'DATE', "
               + "ROUND(e_average, 2) AS 'RATING', "
               + "e_remarks AS 'REMARKS' "
               + "FROM tbl_evaluation WHERE t_u_id = ?"; 

    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, config.getID()); 
        
        try (ResultSet rs = pst.executeQuery()) {
            table_results.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
    } catch (SQLException e) {
        System.out.println("Error displaying results: " + e.getMessage());
    }
}
    
 public void displayStatistics() {
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000")) {
       
        String sqlCount = "SELECT COUNT(DISTINCT s_u_id) FROM tbl_evaluation WHERE t_u_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sqlCount)) {
            pst.setString(1, config.getID());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) lbl_totalStudents.setText(String.valueOf(rs.getInt(1)));
            }
        }
        
        // Average Score
        String sqlAvg = "SELECT AVG(e_average) FROM tbl_evaluation WHERE t_u_id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sqlAvg)) {
            pst.setString(1, config.getID());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) lbl_totalAvg.setText(String.format("%.2f", rs.getDouble(1)));
            }
        }
    } catch (SQLException e) {
        System.out.println("Stats Error: " + e.getMessage());
    }
}
    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        teditUser accFrame = new teditUser();
        accFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accountMouseClicked

    private void dashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseClicked
        tDashboard c= new tDashboard();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashbordMouseClicked

    private void dashbordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseEntered

    }//GEN-LAST:event_dashbordMouseEntered

    private void dMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseEntered

    }//GEN-LAST:event_dMouseEntered

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        tLogs tt = new tLogs();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logsMouseClicked

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user1MouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        teditUser editFrame = new teditUser();
        editFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked

        config conf = new config();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
            "Do you really want to log out?",
            "Logout Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            conf.logEvent("User Logged Out");
            new logIn().setVisible(true);
            this.dispose();
        } else {
            System.out.println("Logout cancelled by user.");
        }
    }//GEN-LAST:event_BackMouseClicked

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        config conf = new config();
        conf.exportToPDF(table_results, "Teacher_Evaluation_Report");
    }//GEN-LAST:event_printMouseClicked

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
            java.util.logging.Logger.getLogger(tDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JPanel C;
    private javax.swing.JPanel C1;
    private javax.swing.JPanel SAVE;
    private javax.swing.JPanel a;
    private javax.swing.JLabel account;
    private javax.swing.JLabel back;
    private javax.swing.JPanel d;
    private javax.swing.JLabel dashbord;
    private javax.swing.JPanel h;
    private javax.swing.JPanel i;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_high_score;
    private javax.swing.JLabel lbl_score;
    private javax.swing.JLabel lbl_strength;
    private javax.swing.JLabel lbl_totalAvg;
    private javax.swing.JLabel lbl_totalStudents;
    private javax.swing.JLabel lbl_weakness;
    private javax.swing.JLabel logs;
    public javax.swing.JLabel namee;
    private javax.swing.JLabel print;
    private javax.swing.JLabel profile;
    private javax.swing.JTable table_results;
    private javax.swing.JLabel totp;
    private javax.swing.JLabel totp1;
    private javax.swing.JLabel totp4;
    private javax.swing.JLabel user1;
    private javax.swing.JLabel users5;
    private javax.swing.JLabel users6;
    // End of variables declaration//GEN-END:variables
}
