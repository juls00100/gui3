/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x_admin;
import authenticate.logIn;
import config.config;

import javax.swing.ImageIcon;


/**
 *
 * @author juls
 */
public class adminDashboard extends javax.swing.JFrame {
    private String currentImagePath;
    private String currentUserName;
    
    public adminDashboard(String name, String imagePath) {
        if (config.stopIllegalAccess(this)) return;
        initComponents(); 
        namee.setText(config.getName());
        this.currentUserName = name;
        this.currentImagePath = imagePath;
        namee.setText(currentUserName);
        setupDashboard();
        
        config conf = new config();
        conf.logEvent("User Logged In");
        conf.manageHover(a);
        conf.manageHover(b);
        conf.manageHover(e);
        conf.manageHover(d);
        conf.manageHover(g);
        conf.manageHover(h);
    }
    
    public adminDashboard() {
        if (config.stopIllegalAccess(this)) return;
        initComponents();
        
        // Pull data from the session config
        this.currentUserName = config.getName();
        this.currentImagePath = config.getImage();
        
        setupDashboard();
    }
    
    private void setupDashboard() {
        namee.setText(currentUserName);
        
        config conf = new config();
        // Hover effects
        conf.manageHover(a); conf.manageHover(b); conf.manageHover(d);
        conf.manageHover(e); conf.manageHover(g); conf.manageHover(h);
        conf.manageHover(A); conf.manageHover(B);
        conf.manageHover(C); conf.manageHover(D);
        
        // Update the image using the crop logic
        displayProfileImage(currentImagePath);
        
        refreshStats();
    }
    
    private void displayProfileImage(String path) {
        if (path != null && !path.isEmpty()) {
            try {
                int targetSize = 70; // Matches your layout constraints
                ImageIcon imgIcon = new ImageIcon(path);
                java.awt.Image sourceImg = imgIcon.getImage();

                int width = sourceImg.getWidth(null);
                int height = sourceImg.getHeight(null);

                // Calculate crop to center square
                int cropSize = Math.min(width, height);
                int x = (width - cropSize) / 2;
                int y = (height - cropSize) / 2;

                java.awt.image.BufferedImage buffered = new java.awt.image.BufferedImage(
                    width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);
                java.awt.Graphics2D g2d = buffered.createGraphics();
                g2d.drawImage(sourceImg, 0, 0, null);
                g2d.dispose();

                java.awt.image.BufferedImage croppedImg = buffered.getSubimage(x, y, cropSize, cropSize);
                java.awt.Image finalImg = croppedImg.getScaledInstance(targetSize, targetSize, java.awt.Image.SCALE_SMOOTH);

                profile.setIcon(new ImageIcon(finalImg));
            } catch (Exception e) {
                System.out.println("Error processing image: " + e.getMessage());
            }
        }
    }
    public void refreshStats() {
        config conf = new config();
        
        
        int totalUsers = conf.getCount("SELECT COUNT(*) FROM tbl_user WHERE u_type != 'Admin'");
        users4.setText(String.valueOf(totalUsers));

        // 2. Pending Approvals
        int pending = conf.getCount("SELECT COUNT(*) FROM tbl_user WHERE u_status = 'Pending'");
        pending1.setText(String.valueOf(pending));

        // 3. Active Evaluations (Assuming you have a tbl_evaluation)
        int activeEvals = conf.getCount("SELECT COUNT(DISTINCT t_u_id) FROM tbl_evaluation");
        eprog3.setText(String.valueOf(activeEvals));

        // 4. Progress Percentage (Logic: (Total Evals / Total Students) * 100)
        int totalStudents = conf.getCount("SELECT COUNT(*) FROM tbl_user WHERE u_type = 'Student'");
        int finishedEvals = conf.getCount("SELECT COUNT(DISTINCT s_u_id) FROM tbl_evaluation");

        if (totalStudents > 0) {
            int percentage = (finishedEvals * 100) / totalStudents;
            activeE1.setText(percentage + "%");
        } else {
            activeE1.setText("0%");
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        a = new javax.swing.JPanel();
        account = new javax.swing.JLabel();
        b = new javax.swing.JPanel();
        evaluations = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        dashbord = new javax.swing.JLabel();
        e = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        h = new javax.swing.JPanel();
        account1 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        user1 = new javax.swing.JLabel();
        profile = new config.CircularLabel();
        namee = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        A = new javax.swing.JPanel();
        activeE = new javax.swing.JLabel();
        activeE1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        activeE2 = new javax.swing.JLabel();
        activeE3 = new javax.swing.JLabel();
        B = new javax.swing.JPanel();
        pending = new javax.swing.JLabel();
        pending1 = new javax.swing.JLabel();
        C = new javax.swing.JPanel();
        users4 = new javax.swing.JLabel();
        users5 = new javax.swing.JLabel();
        D = new javax.swing.JPanel();
        eprog2 = new javax.swing.JLabel();
        eprog3 = new javax.swing.JLabel();

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

        jPanel2.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 160, -1));

        b.setBackground(new java.awt.Color(197, 179, 88));
        b.setForeground(new java.awt.Color(197, 179, 88));
        b.setPreferredSize(new java.awt.Dimension(142, 30));

        evaluations.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        evaluations.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        evaluations.setText("ACADEMIC CONTENT");
        evaluations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evaluationsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bLayout = new javax.swing.GroupLayout(b);
        b.setLayout(bLayout);
        bLayout.setHorizontalGroup(
            bLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(evaluations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bLayout.setVerticalGroup(
            bLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(evaluations, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));

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

        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 160, -1));

        e.setBackground(new java.awt.Color(197, 179, 88));
        e.setForeground(new java.awt.Color(197, 179, 88));
        e.setPreferredSize(new java.awt.Dimension(142, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("MANAGE QUESTIONS");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout eLayout = new javax.swing.GroupLayout(e);
        e.setLayout(eLayout);
        eLayout.setHorizontalGroup(
            eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        eLayout.setVerticalGroup(
            eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 160, -1));

        g.setBackground(new java.awt.Color(197, 179, 88));
        g.setForeground(new java.awt.Color(197, 179, 88));

        user.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("USER MANAGEMENT");
        user.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout gLayout = new javax.swing.GroupLayout(g);
        g.setLayout(gLayout);
        gLayout.setHorizontalGroup(
            gLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gLayout.setVerticalGroup(
            gLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 30));

        h.setBackground(new java.awt.Color(197, 179, 88));
        h.setForeground(new java.awt.Color(197, 179, 88));
        h.setPreferredSize(new java.awt.Dimension(142, 30));

        account1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        account1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account1.setText("SYSTEM LOGS");
        account1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hLayout = new javax.swing.GroupLayout(h);
        h.setLayout(hLayout);
        hLayout.setHorizontalGroup(
            hLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(account1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        hLayout.setVerticalGroup(
            hLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(account1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, -1));

        logout.setBackground(new java.awt.Color(0, 33, 71));
        logout.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(197, 179, 88));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(197, 179, 88)));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel2.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 90, 30));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow20.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 430));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        user1.setForeground(new java.awt.Color(197, 179, 88));
        user1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user1.setText("ADMIN PORTAL");
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        jPanel3.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 500, 70));

        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jPanel3.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 60));

        namee.setBackground(new java.awt.Color(44, 62, 80));
        namee.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        namee.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.add(namee, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 140, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        jPanel5.setBackground(new java.awt.Color(79, 20, 54));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("System Overview");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 230, 30));

        A.setBackground(new java.awt.Color(45, 52, 54));
        A.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activeE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        activeE.setForeground(new java.awt.Color(240, 240, 240));
        activeE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activeE.setText("Evaluations");
        A.add(activeE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, -1));

        activeE1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        activeE1.setForeground(new java.awt.Color(240, 240, 240));
        activeE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A.add(activeE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 40));

        jPanel7.setBackground(new java.awt.Color(45, 52, 54));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activeE2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        activeE2.setForeground(new java.awt.Color(240, 240, 240));
        activeE2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activeE2.setText("Evaluations");
        jPanel7.add(activeE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, -1));

        activeE3.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        activeE3.setForeground(new java.awt.Color(240, 240, 240));
        activeE3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(activeE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 40));

        A.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 240, 110));

        jPanel1.add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 240, 110));

        B.setBackground(new java.awt.Color(45, 52, 54));
        B.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pending.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pending.setForeground(new java.awt.Color(240, 240, 240));
        pending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pending.setText("Pending Approvals");
        B.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 240, -1));

        pending1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        pending1.setForeground(new java.awt.Color(240, 240, 240));
        pending1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B.add(pending1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 40));

        jPanel1.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 240, 110));

        C.setBackground(new java.awt.Color(45, 52, 54));
        C.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users4.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        users4.setForeground(new java.awt.Color(240, 240, 240));
        users4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C.add(users4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 40));

        users5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        users5.setForeground(new java.awt.Color(240, 240, 240));
        users5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users5.setText("Users");
        C.add(users5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, -1));

        jPanel1.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 240, 110));

        D.setBackground(new java.awt.Color(45, 52, 54));
        D.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eprog2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        eprog2.setForeground(new java.awt.Color(240, 240, 240));
        eprog2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eprog2.setText("Evaluation Progress");
        D.add(eprog2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, -1));

        eprog3.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        eprog3.setForeground(new java.awt.Color(240, 240, 240));
        eprog3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D.add(eprog3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 40));

        jPanel1.add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 240, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        manageUsers userstableFrame = new manageUsers();
        userstableFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMouseClicked

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user1MouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userMouseEntered

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
       editUser editFrame = new editUser();
        editFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accountMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        manageQ manageqFrame = new manageQ();
        manageqFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void account1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account1MouseClicked
        sysLogs tt = new sysLogs();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_account1MouseClicked

    private void dashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseClicked
        adminDashboard dashFrame = new adminDashboard();
        dashFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashbordMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        editUser editFrame = new editUser();
        editFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void dashbordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseEntered
       
    }//GEN-LAST:event_dashbordMouseEntered

    private void dMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseEntered
        
    }//GEN-LAST:event_dMouseEntered

    private void evaluationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluationsMouseClicked
        manageEvaluations ad = new manageEvaluations();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evaluationsMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
            "Do you really want to log out?",
            "Logout Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            logIn loginFrame = new logIn();
            loginFrame.setVisible(true);
            this.dispose();
        } else {
            System.out.println("Logout cancelled by user.");
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        adminDashboard ad = new adminDashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel A;
    private javax.swing.JPanel B;
    private javax.swing.JPanel C;
    private javax.swing.JPanel D;
    private javax.swing.JPanel a;
    private javax.swing.JLabel account;
    private javax.swing.JLabel account1;
    private javax.swing.JLabel activeE;
    private javax.swing.JLabel activeE1;
    private javax.swing.JLabel activeE2;
    private javax.swing.JLabel activeE3;
    private javax.swing.JPanel b;
    private javax.swing.JLabel back;
    private javax.swing.JPanel d;
    private javax.swing.JLabel dashbord;
    private javax.swing.JPanel e;
    private javax.swing.JLabel eprog2;
    private javax.swing.JLabel eprog3;
    private javax.swing.JLabel evaluations;
    private javax.swing.JPanel g;
    private javax.swing.JPanel h;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel logout;
    public javax.swing.JLabel namee;
    private javax.swing.JLabel pending;
    private javax.swing.JLabel pending1;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    private javax.swing.JLabel users4;
    private javax.swing.JLabel users5;
    // End of variables declaration//GEN-END:variables
}
