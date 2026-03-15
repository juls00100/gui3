/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x_admin;


import authenticate.logIn;
import config.config;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
/**
 *
 * @author juls
 */
public class manageUsers extends javax.swing.JFrame {

    /**
     * Creates new form userTadmin
     */
    public manageUsers() {
        if (config.stopIllegalAccess(this)) return;
        initComponents();
        
        namee.setText(config.getName()); 
        displayProfileImage();
        displayUser();
        config conf = new config();
        conf.manageHover(ADD);
        conf.manageHover(EDIT);
        conf.manageHover(DELETE);
        conf.manageHover(APPROVE);
        conf.manageHover(SEARCH);
        conf.manageHover(a);
        conf.manageHover(b);
        conf.manageHover(e);
        conf.manageHover(d);
        conf.manageHover(g);
        conf.manageHover(h);
        conf.manageHover(i);
        
        conf.designTable(table_user);
       


    }
    
    public void displayProfileImage() {
        String path = config.getImage();
        if (path != null && !path.isEmpty()) {
            config conf = new config();
            profile.setIcon(conf.resizeImage(path, null, profile.getWidth(), profile.getHeight()));
        }
    }
    
    
    void displayUser(){
        
        config con = new config();
        String sql = "SELECT * FROM tbl_user";
        con.displayData(sql, table_user);
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(((DefaultTableModel)table_user.getModel()));
        table_user.setRowSorter(sorter);

        searchbox.getDocument().addDocumentListener(new DocumentListener() {
            
    @Override
    public void insertUpdate(DocumentEvent e) { search(); }
    @Override
    public void removeUpdate(DocumentEvent e) { search(); }
    @Override
    public void changedUpdate(DocumentEvent e) { search(); }
    public void search() {
        String text = searchbox.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            // (?i) makes the search case-insensitive
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
    }
    );
        con.displayData("SELECT u_id AS 'USER ID', u_name AS 'NAME', u_email AS 'EMAIL', u_type AS 'USER TYPE', u_status AS 'STATUS' FROM tbl_user", table_user);
                
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        user1 = new javax.swing.JLabel();
        namee = new javax.swing.JLabel();
        profile = new config.CircularLabel();
        totp4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_user = new javax.swing.JTable();
        DELETE = new javax.swing.JPanel();
        delete = new javax.swing.JLabel();
        APPROVE = new javax.swing.JPanel();
        approve = new javax.swing.JLabel();
        SEARCH = new javax.swing.JPanel();
        search = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        EDIT = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        ADD = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
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
        i = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 33, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        user1.setForeground(new java.awt.Color(240, 240, 240));
        user1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user1.setText("MANAGE USERS");
        user1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user1MouseClicked(evt);
            }
        });
        jPanel3.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 680, 70));

        namee.setBackground(new java.awt.Color(44, 62, 80));
        namee.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        namee.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.add(namee, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, 30));

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jPanel3.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        totp4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/admin.png"))); // NOI18N
        jPanel3.add(totp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 70, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        table_user.setBackground(new java.awt.Color(240, 240, 240));
        table_user.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_user.setOpaque(false);
        table_user.setRowHeight(30);
        table_user.setShowHorizontalLines(false);
        table_user.setShowVerticalLines(false);
        table_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_user);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 530, 300));

        DELETE.setBackground(new java.awt.Color(192, 57, 43));
        DELETE.setForeground(new java.awt.Color(240, 240, 240));
        DELETE.setPreferredSize(new java.awt.Dimension(90, 90));

        delete.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(240, 240, 240));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("DELETE");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DELETELayout = new javax.swing.GroupLayout(DELETE);
        DELETE.setLayout(DELETELayout);
        DELETELayout.setHorizontalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        DELETELayout.setVerticalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 60, 30));

        APPROVE.setBackground(new java.awt.Color(41, 128, 185));
        APPROVE.setForeground(new java.awt.Color(240, 240, 240));

        approve.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        approve.setForeground(new java.awt.Color(240, 240, 240));
        approve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        approve.setText("APPROVE");
        approve.setPreferredSize(new java.awt.Dimension(60, 30));
        approve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                approveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout APPROVELayout = new javax.swing.GroupLayout(APPROVE);
        APPROVE.setLayout(APPROVELayout);
        APPROVELayout.setHorizontalGroup(
            APPROVELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(approve, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        APPROVELayout.setVerticalGroup(
            APPROVELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(approve, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(APPROVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 70, 30));

        SEARCH.setBackground(new java.awt.Color(52, 73, 94));
        SEARCH.setForeground(new java.awt.Color(240, 240, 240));

        search.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(240, 240, 240));
        search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search.setText("SEARCH");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SEARCHLayout = new javax.swing.GroupLayout(SEARCH);
        SEARCH.setLayout(SEARCHLayout);
        SEARCHLayout.setHorizontalGroup(
            SEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        SEARCHLayout.setVerticalGroup(
            SEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(SEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 60, 30));

        searchbox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        jPanel1.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 170, 30));

        EDIT.setBackground(new java.awt.Color(243, 156, 18));
        EDIT.setForeground(new java.awt.Color(240, 240, 240));

        edit.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(240, 240, 240));
        edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit.setText("EDIT");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EDITLayout = new javax.swing.GroupLayout(EDIT);
        EDIT.setLayout(EDITLayout);
        EDITLayout.setHorizontalGroup(
            EDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        EDITLayout.setVerticalGroup(
            EDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 60, 30));

        ADD.setBackground(new java.awt.Color(39, 174, 96));
        ADD.setForeground(new java.awt.Color(240, 240, 240));

        add.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(240, 240, 240));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("ADD");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ADDLayout = new javax.swing.GroupLayout(ADD);
        ADD.setLayout(ADDLayout);
        ADDLayout.setHorizontalGroup(
            ADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        ADDLayout.setVerticalGroup(
            ADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 60, 30));

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
        evaluations.setText("VIEW EVALUATIONS");
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

        i.setBackground(new java.awt.Color(44, 62, 80));
        i.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 179, 88)));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrow20.png"))); // NOI18N

        Back.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        Back.setForeground(new java.awt.Color(197, 179, 88));
        Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
                .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        iLayout.setVerticalGroup(
            iLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel2.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user1MouseClicked

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_searchboxActionPerformed

    private void approveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approveMouseClicked
        int rowIndex = table_user.getSelectedRow(); 
        if (rowIndex < 0) { 
            javax.swing.JOptionPane.showMessageDialog(null, "Please select a user first!"); 
        } else { 
            javax.swing.table.TableModel model = table_user.getModel(); 
            String id = model.getValueAt(rowIndex, 0).toString(); 
            String name = model.getValueAt(rowIndex, 1).toString(); 
            int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Approve " + name + "?", "Confirm", javax.swing.JOptionPane.YES_NO_OPTION); 
            if (confirm == javax.swing.JOptionPane.YES_OPTION) { 
                config conf = new config(); 
                String sql = "UPDATE tbl_user SET u_status = 'Approved' WHERE u_id = ?"; 
                int result = conf.updateRecord(sql, id); 
                if (result > 0) { javax.swing.JOptionPane.showMessageDialog(null, "User Approved!"); 
                displayUser(); 
                conf.logEvent("Approved a user.");
                } else { 
                    javax.swing.JOptionPane.showMessageDialog(null, "Error updating database."); 
                } 
            } 
        }
    }//GEN-LAST:event_approveMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
       int rowIndex = table_user.getSelectedRow();
if (rowIndex != -1) {
    // Get the ID from the first column (index 0)
    String id = table_user.getModel().getValueAt(rowIndex, 0).toString();
    
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Warning", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        config conf = new config();
        String sql = "DELETE FROM tbl_user WHERE u_id = ?";
        conf.deleteRecord(sql, id); 
        displayUser(); 
        conf.logEvent("Deleted a user.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a user to delete.");
}
       
    }//GEN-LAST:event_deleteMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
                               
    int row = table_user.getSelectedRow();
    if(row == -1){
        JOptionPane.showMessageDialog(null, "Please select a user first!");
    } else {
        TableModel model = table_user.getModel();
        editUser ed = new editUser();
        config conf = new config();
        conf.logEvent("Edited user's info.");
        
        ed.iddd.setText("" + model.getValueAt(row, 0));
        ed.nameee.setText("" + model.getValueAt(row, 1)); 
        ed.emaill.setText("" + model.getValueAt(row, 2)); 
        ed.passs.setText("");
        ed.setVisible(true);
        this.dispose();
    }


    }//GEN-LAST:event_editMouseClicked
    public void searchTable() {
        String text = searchbox.getText();
        // Get the sorter from the table
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) table_user.getRowSorter();

        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            // (?i) makes the search case-insensitive
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        searchTable();
    }//GEN-LAST:event_searchMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        addUser au = new addUser();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addMouseClicked

    private void accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMouseClicked
        editUser editFrame = new editUser();
        editFrame.setVisible(true);
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

    private void table_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_userMouseClicked

    }//GEN-LAST:event_table_userMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        editUser editFrame = new editUser();
        editFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        adminDashboard ad = new adminDashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

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
            java.util.logging.Logger.getLogger(manageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADD;
    private javax.swing.JPanel APPROVE;
    private javax.swing.JLabel Back;
    private javax.swing.JPanel DELETE;
    private javax.swing.JPanel EDIT;
    private javax.swing.JPanel SEARCH;
    private javax.swing.JPanel a;
    private javax.swing.JLabel account;
    private javax.swing.JLabel account1;
    private javax.swing.JLabel add;
    private javax.swing.JLabel approve;
    private javax.swing.JPanel b;
    private javax.swing.JLabel back;
    private javax.swing.JPanel d;
    private javax.swing.JLabel dashbord;
    private javax.swing.JLabel delete;
    private javax.swing.JPanel e;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel evaluations;
    private javax.swing.JPanel g;
    private javax.swing.JPanel h;
    private javax.swing.JPanel i;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel namee;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table_user;
    private javax.swing.JLabel totp4;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user1;
    // End of variables declaration//GEN-END:variables
}
