/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x_admin;
import config.config;
import authenticate.logIn;
/**
 *
 * @author juls
 */
public class manageQ extends javax.swing.JFrame {

    /**
     * Creates new form manageQ
     */
    public manageQ() {
        if (config.stopIllegalAccess(this)) return;
        initComponents();
        config conf = new config();
        conf.manageHover(ADD);
        conf.manageHover(EDIT);
        conf.manageHover(DELETE);
        conf.manageHover(a);
        conf.manageHover(b);
        conf.manageHover(e);
        conf.manageHover(d);
        conf.manageHover(g);
        conf.manageHover(h);
        conf.manageHover(i);
        totNumQues();
    }
    
    public void totNumQues() { 
        quessts.setText("");
        config conf = new config(); 
        int totalQue = conf.getCount("SELECT COUNT(*) FROM tbl_question"); 
        quesnumtot.setText(String.valueOf(totalQue));

        java.util.List questions = conf.getQuestionList("SELECT q_text FROM tbl_question");
        StringBuilder sb = new StringBuilder();

        int i = 1; 
        for (Object q : questions) {
            sb.append(i).append(". ").append(q.toString()).append("\n");
            i++; 
        }

        quessts.setText(sb.toString());
        this.revalidate();
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        user1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        quesnumtot = new javax.swing.JLabel();
        QUES2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        quessts = new javax.swing.JTextArea();
        EDIT = new javax.swing.JPanel();
        editBtn = new javax.swing.JLabel();
        DELETE = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JLabel();
        ADD = new javax.swing.JPanel();
        addBtn = new javax.swing.JLabel();
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
        i = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        h = new javax.swing.JPanel();
        account1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 33, 71));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        user1.setForeground(new java.awt.Color(197, 179, 88));
        user1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user1.setText("MANAGE QUESTIONS");
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        jPanel3.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 450, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        jPanel5.setBackground(new java.awt.Color(79, 20, 54));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quesnumtot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quesnumtot.setForeground(new java.awt.Color(240, 240, 240));
        quesnumtot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quesnumtot.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel5.add(quesnumtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 50, 30));

        QUES2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QUES2.setForeground(new java.awt.Color(240, 240, 240));
        QUES2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QUES2.setText("QUESTIONS:");
        QUES2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel5.add(QUES2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 140, 30));

        jPanel6.setBackground(new java.awt.Color(79, 20, 54));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(197, 179, 88)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quessts.setEditable(false);
        quessts.setBackground(new java.awt.Color(44, 62, 80));
        quessts.setColumns(20);
        quessts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quessts.setForeground(new java.awt.Color(240, 240, 240));
        quessts.setRows(5);
        jScrollPane1.setViewportView(quessts);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 220));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 510, 220));

        EDIT.setBackground(new java.awt.Color(240, 190, 18));
        EDIT.setForeground(new java.awt.Color(240, 240, 240));
        EDIT.setPreferredSize(new java.awt.Dimension(60, 30));

        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        editBtn.setForeground(new java.awt.Color(51, 51, 51));
        editBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editBtn.setText("EDIT");
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EDITLayout = new javax.swing.GroupLayout(EDIT);
        EDIT.setLayout(EDITLayout);
        EDITLayout.setHorizontalGroup(
            EDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        EDITLayout.setVerticalGroup(
            EDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, 30));

        DELETE.setBackground(new java.awt.Color(231, 23, 37));
        DELETE.setForeground(new java.awt.Color(240, 240, 240));
        DELETE.setPreferredSize(new java.awt.Dimension(60, 30));

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteBtn.setText("DELETE");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DELETELayout = new javax.swing.GroupLayout(DELETE);
        DELETE.setLayout(DELETELayout);
        DELETELayout.setHorizontalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        DELETELayout.setVerticalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 60, 30));

        ADD.setBackground(new java.awt.Color(80, 200, 120));
        ADD.setForeground(new java.awt.Color(240, 240, 240));

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addBtn.setForeground(new java.awt.Color(51, 51, 51));
        addBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBtn.setText("ADD");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ADDLayout = new javax.swing.GroupLayout(ADD);
        ADD.setLayout(ADDLayout);
        ADDLayout.setHorizontalGroup(
            ADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        ADDLayout.setVerticalGroup(
            ADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 60, 30));

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

        dashbord.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        dashbord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashbord.setText("DASHBOARD");
        dashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashbordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dLayout = new javax.swing.GroupLayout(d);
        d.setLayout(dLayout);
        dLayout.setHorizontalGroup(
            dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashbord, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        dLayout.setVerticalGroup(
            dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashbord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user1MouseClicked

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        config conf = new config(); 
        String newQ = javax.swing.JOptionPane.showInputDialog(this, "Enter New Question:"); 
        if (newQ != null && !newQ.trim().isEmpty()) { 
            conf.addRecord("INSERT INTO tbl_question (q_text) VALUES (?)", newQ); 
            totNumQues(); 
        } 
    }//GEN-LAST:event_addBtnMouseClicked

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        String numStr = javax.swing.JOptionPane.showInputDialog(this, "Enter the Question Number to Edit:"); 
        if (numStr != null) { 
            try { 
                int num = Integer.parseInt(numStr); 
                config conf = new config(); 
                java.util.List questions = conf.getQuestionList("SELECT q_text FROM tbl_question"); 

                if (num > 0 && num <= questions.size()) { 
                    String oldQ = questions.get(num - 1).toString(); 
                    String newQ = javax.swing.JOptionPane.showInputDialog(this, "Edit Question:", oldQ); 

                    if (newQ != null && !newQ.trim().isEmpty()) { 
                        conf.updateRecordOnly("UPDATE tbl_question SET q_text = ? WHERE q_text = ?", newQ, oldQ.trim()); 
                        totNumQues(); 
                    } 
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid Question Number!");
                }
                } catch (NumberFormatException e) { 
                javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid number."); 
                }
            catch (Exception e) { 
                javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); 
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_editBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        String numStr = javax.swing.JOptionPane.showInputDialog(this, "Enter the Question Number to Delete:"); 
        if (numStr != null) { 
            try { int num = Integer.parseInt(numStr); 
            config conf = new config(); 
            java.util.List questions = conf.getQuestionList("SELECT q_text FROM tbl_question"); 
            if (num > 0 && num <= questions.size()) { 
                String qToDelete = questions.get(num - 1).toString(); 
                conf.deleteRecord("DELETE FROM tbl_question WHERE q_text = ?", qToDelete); 
                totNumQues(); } } catch (Exception e) { 
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid input!"); 
                } 
        } 
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        userAccount accFrame = new userAccount();
        accFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accountMouseClicked

    private void dashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbordMouseClicked
        adminDashboard dashFrame = new adminDashboard();
        dashFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashbordMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        manageQ manageqFrame = new manageQ();
        manageqFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        manageUsers userstableFrame = new manageUsers();
        userstableFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userMouseEntered

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        adminDashboard ad = new adminDashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        adminDashboard ad = new adminDashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void account1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account1MouseClicked
        sysLogs tt = new sysLogs();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_account1MouseClicked

    private void evaluationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluationsMouseClicked
         manageEvaluations ad = new manageEvaluations();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evaluationsMouseClicked

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
            java.util.logging.Logger.getLogger(manageQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageQ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADD;
    private javax.swing.JLabel Back;
    private javax.swing.JPanel DELETE;
    private javax.swing.JPanel EDIT;
    private javax.swing.JLabel QUES2;
    private javax.swing.JPanel a;
    private javax.swing.JLabel account;
    private javax.swing.JLabel account1;
    private javax.swing.JLabel addBtn;
    private javax.swing.JPanel b;
    private javax.swing.JLabel back;
    private javax.swing.JPanel d;
    private javax.swing.JLabel dashbord;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JPanel e;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel evaluations;
    private javax.swing.JPanel g;
    private javax.swing.JPanel h;
    private javax.swing.JPanel i;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quesnumtot;
    private javax.swing.JTextArea quessts;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    // End of variables declaration//GEN-END:variables
}
