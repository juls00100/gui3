/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y_student;

import authenticate.logIn;
import config.config;
import javax.swing.JOptionPane;
import x_admin.sysLogs;
import x_admin.userAccount;
import config.config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class evaluate extends javax.swing.JFrame {

    private java.util.List<String> questions = new java.util.ArrayList<>();
    private int[] ratings; 
    private int currentQuestionIndex = 0;
    private String selectedTeacherID = "";

    public evaluate() {
        if (config.stopIllegalAccess(this)) return;
        initComponents();
        loadTeachers();
        fetchAllQuestions();
        config conf = new config();
         conf.manageHover(next);
        conf.manageHover(previous);
        conf.manageHover(a);
        conf.manageHover(e);
        conf.manageHover(d);
        conf.manageHover(g);
        conf.manageHover(h);
        conf.manageHover(i);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        a = new javax.swing.JPanel();
        account = new javax.swing.JLabel();
        d = new javax.swing.JPanel();
        dashbord = new javax.swing.JLabel();
        e = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        g = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        i = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        h = new javax.swing.JPanel();
        account1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        user1 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        profile = new config.CircularLabel();
        namee = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        r2 = new javax.swing.JRadioButton();
        r1 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        r5 = new javax.swing.JRadioButton();
        teacherDropdown = new javax.swing.JComboBox<>();
        next = new javax.swing.JPanel();
        NEXT = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        previous = new javax.swing.JPanel();
        PREVIOUS = new javax.swing.JLabel();

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

        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, -1));

        e.setBackground(new java.awt.Color(197, 179, 88));
        e.setForeground(new java.awt.Color(197, 179, 88));
        e.setPreferredSize(new java.awt.Dimension(142, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("VIEW EVALUATIONS");
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

        jPanel2.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, -1));

        g.setBackground(new java.awt.Color(197, 179, 88));
        g.setForeground(new java.awt.Color(197, 179, 88));

        user.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("EVALUATE");
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
            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        gLayout.setVerticalGroup(
            gLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 160, 30));

        i.setBackground(new java.awt.Color(44, 62, 80));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow20.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        Back.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        Back.setForeground(new java.awt.Color(240, 240, 240));
        Back.setText("Back");
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
                .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );
        iLayout.setVerticalGroup(
            iLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 90, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 430));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        user1.setForeground(new java.awt.Color(197, 179, 88));
        user1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user1.setText("STUDENT DASHBOARD");
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        jPanel3.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 480, 70));

        logout.setBackground(new java.awt.Color(0, 33, 71));
        logout.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        logout.setForeground(new java.awt.Color(197, 179, 88));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(197, 179, 88)));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 70, 20));

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

        jPanel5.setBackground(new java.awt.Color(204, 149, 230));

        bgroup.add(r2);
        r2.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        r2.setText("2");
        r2.setMargin(new java.awt.Insets(10, 10, 10, 10));
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        bgroup.add(r1);
        r1.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        r1.setText("1");
        r1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        bgroup.add(r3);
        r3.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        r3.setText("3");
        r3.setMargin(new java.awt.Insets(10, 10, 10, 10));
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        bgroup.add(r4);
        r4.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        r4.setText("4");
        r4.setMargin(new java.awt.Insets(10, 10, 10, 10));
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });

        bgroup.add(r5);
        r5.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        r5.setText("5");
        r5.setMargin(new java.awt.Insets(10, 10, 10, 10));
        r5.setMaximumSize(new java.awt.Dimension(100, 100));
        r5.setPreferredSize(new java.awt.Dimension(43, 31));
        r5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(r1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(r4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(r5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(r3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(r2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(r1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 330, 50));

        teacherDropdown.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        teacherDropdown.setToolTipText("SELECT A TEACHER");
        teacherDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherDropdownActionPerformed(evt);
            }
        });
        jPanel1.add(teacherDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 240, -1));

        next.setBackground(new java.awt.Color(39, 174, 96));

        NEXT.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        NEXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NEXT.setText("Next");
        NEXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NEXTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nextLayout = new javax.swing.GroupLayout(next);
        next.setLayout(nextLayout);
        nextLayout.setHorizontalGroup(
            nextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextLayout.createSequentialGroup()
                .addComponent(NEXT, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );
        nextLayout.setVerticalGroup(
            nextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NEXT, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 80, 40));

        lblQuestion.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("questions");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 400, 80));

        previous.setBackground(new java.awt.Color(197, 179, 88));

        PREVIOUS.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        PREVIOUS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PREVIOUS.setText("Previous");
        PREVIOUS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PREVIOUSMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout previousLayout = new javax.swing.GroupLayout(previous);
        previous.setLayout(previousLayout);
        previousLayout.setHorizontalGroup(
            previousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousLayout.createSequentialGroup()
                .addComponent(PREVIOUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        previousLayout.setVerticalGroup(
            previousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PREVIOUS, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 80, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadTeachers() {
        config conf = new config();
        ResultSet rs = null; 
        try {
            rs = conf.getData("SELECT * FROM tbl_teacher JOIN tbl_user ON t_u_id = u_id");
        teacherDropdown.removeAllItems();
        while (rs.next()) {
            teacherDropdown.addItem(rs.getString("t_u_id") + " - " + rs.getString("u_name"));
        }
        } catch (SQLException e) {
            System.out.println("Error loading teachers: " + e.getMessage());
        } finally {
            conf.closeResult(rs); 
        }
    }
    
    int questionOffset = 0; 

    private void fetchAllQuestions() {
        config conf = new config();
        ResultSet rs = null;
        try {
            rs = conf.getData("SELECT q_text FROM tbl_question");
            questions.clear();
                while (rs.next()) {
                    questions.add(rs.getString("q_text"));
                }
            ratings = new int[questions.size()];
        displayQuestion();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conf.closeResult(rs); 
        }
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            lblQuestion.setText((currentQuestionIndex + 1) + ". " + questions.get(currentQuestionIndex));
            bgroup.clearSelection();
        }
    }
    
    private void submitEvaluation() {
        config conf = new config();
        
        double total = 0;
        for (int r : ratings) total += r;
        double average = total / ratings.length;

        String sql = "INSERT INTO tbl_evaluation (t_u_id, s_u_id, e_average_rating, e_date, e_year, e_sem) VALUES (?, ?, ?, ?, ?, ?)";

        String studentID = config.getID(); 
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

        conf.addRecord(sql, selectedTeacherID, studentID, average, date, "2026", "2nd");

        JOptionPane.showMessageDialog(this, "Evaluation Submitted! Average: " + average);
        new y_student.studDashboard().setVisible(true);
        this.dispose(); 
    }
    private void displayCurrentQuestion() {
    if (currentQuestionIndex >= 0 && currentQuestionIndex < questions.size()) {
        lblQuestion.setText(questions.get(currentQuestionIndex)); 
        
        bgroup.clearSelection();
        int savedRating = ratings[currentQuestionIndex];
        if (savedRating == 1) r1.setSelected(true);
        else if (savedRating == 2) r2.setSelected(true);
        else if (savedRating == 3) r3.setSelected(true);
        else if (savedRating == 4) r4.setSelected(true);
        else if (savedRating == 5) r5.setSelected(true);
    }
}
    private int getSelectedGrade() {
        if (r1.isSelected()) return 1;
        if (r2.isSelected()) return 2;
        if (r3.isSelected()) return 3;
        if (r4.isSelected()) return 4;
        if (r5.isSelected()) return 5;
        return 0; // Returns 0 if nothing is selected
    }
    
   private double calculateAverage() {
        double total = 0;
        for (int rating : ratings) {
            total += rating;
        }
        return (questions.isEmpty()) ? 0 : total / questions.size();
    }
   
    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        userAccount accFrame = new userAccount();
        accFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accountMouseClicked

    private void dashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseClicked
        studDashboard dashFrame = new studDashboard();
        dashFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashbordMouseClicked

    private void dashbordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseEntered

    }//GEN-LAST:event_dashbordMouseEntered

    private void dMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseEntered

    }//GEN-LAST:event_dMouseEntered

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        viewEvals viewFrame = new viewEvals();
        viewFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        evaluate userstableFrame = new evaluate();
        userstableFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userMouseEntered

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        studDashboard s = new studDashboard();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        studDashboard s = new studDashboard();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void account1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account1MouseClicked
        sysLogs tt = new sysLogs();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_account1MouseClicked

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user1MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked

        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
            "Do you really want to log out?", "Logout", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            config.setSession(null, null, null, null, null);
            new logIn().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        userAccount accFrame = new userAccount();
        accFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r2ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r1ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r3ActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r4ActionPerformed

    private void r5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r5ActionPerformed

    private void teacherDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherDropdownActionPerformed

    private void NEXTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NEXTMouseClicked
       if (r1.isSelected()) ratings[currentQuestionIndex] = 1;
        else if (r2.isSelected()) ratings[currentQuestionIndex] = 2;
        else if (r3.isSelected()) ratings[currentQuestionIndex] = 3;
        else if (r4.isSelected()) ratings[currentQuestionIndex] = 4;
        else if (r5.isSelected()) ratings[currentQuestionIndex] = 5;
        else {
        JOptionPane.showMessageDialog(this, "Please select a rating before proceeding.");
        return;
    }
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            displayQuestion();
        } else {
            String selected = teacherDropdown.getSelectedItem().toString();
            selectedTeacherID = selected.split(" - ")[0];
            submitEvaluation();
            new y_student.studDashboard().setVisible(true); 
            this.dispose();
        }
    }//GEN-LAST:event_NEXTMouseClicked

    private void PREVIOUSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PREVIOUSMouseClicked
        if (currentQuestionIndex > 0) {
            // Optionally save the current rating before going back
            ratings[currentQuestionIndex] = getSelectedGrade();

            currentQuestionIndex--;
            displayCurrentQuestion();
        }
        

    }//GEN-LAST:event_PREVIOUSMouseClicked

        private void saveAllToDatabase() {
            String teacherName = teacherDropdown.getSelectedItem().toString();
            if (teacherName.equals("— Select Teacher —")) {
                JOptionPane.showMessageDialog(this, "Please select a teacher!");
                return;
            }

            config conf = new config();
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            boolean success = true;

            for (int i = 0; i < questions.size(); i++) {
                // Matches tbl_evaluation: t_id, s_u_id, e_average_rating, e_date, e_remarks
                String sql = "INSERT INTO tbl_evaluation (t_u_id, s_u_id, e_average_rating, e_date, e_remarks) "
                + "VALUES ("
                + "(SELECT u_id FROM tbl_user WHERE u_name = '" + teacherName + "'), "
                + "'" + config.getOnlineID() + "', "
                + "'" + ratings[i] + "', "
                + "'" + date + "', "
                + "'Question " + (i + 1) + "')";

                if (!conf.insertData(sql)) {
                    success = false;
                    break;
                }
            }

            if (success) {
                JOptionPane.showMessageDialog(this, "Evaluation Submitted Successfully!");
                this.dispose();
            }
}
       
        
    private void saveEvaluation() {
        double total = 0;
        for (int r : ratings) total += r;
        double average = total / ratings.length;

        String sql = "INSERT INTO tbl_evaluation (t_u_id, s_u_id, e_average_rating, e_date, e_year, e_sem) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        config conf = new config();
        String studentID = config.getID(); // Gets the logged-in student's ID
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // Use your existing addRecord method
        conf.addRecord(sql, selectedTeacherID, studentID, average, date, "2024", "1st Semester");
        if(conf.insertData(sql)){
        JOptionPane.showMessageDialog(null, "Evaluation Saved!  Average Score: " + average);
    }
    }
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
            java.util.logging.Logger.getLogger(evaluate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(evaluate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(evaluate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(evaluate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new evaluate().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JLabel NEXT;
    private javax.swing.JLabel PREVIOUS;
    private javax.swing.JPanel a;
    private javax.swing.JLabel account;
    private javax.swing.JLabel account1;
    private javax.swing.JLabel back;
    private javax.swing.ButtonGroup bgroup;
    private javax.swing.JPanel d;
    private javax.swing.JLabel dashbord;
    private javax.swing.JPanel e;
    private javax.swing.JPanel g;
    private javax.swing.JPanel h;
    private javax.swing.JPanel i;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel logout;
    public javax.swing.JLabel namee;
    private javax.swing.JPanel next;
    private javax.swing.JPanel previous;
    private javax.swing.JLabel profile;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JRadioButton r5;
    private javax.swing.JComboBox<String> teacherDropdown;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    // End of variables declaration//GEN-END:variables
}
