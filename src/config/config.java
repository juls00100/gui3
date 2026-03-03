/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package config;

    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.RenderingHints;
    import java.awt.geom.Ellipse2D;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import net.proteanit.sql.DbUtils;
    import java.sql.*;
import javax.swing.ImageIcon;
    import javax.swing.table.TableModel;
    import net.proteanit.sql.DbUtils;


    public class config {
        // Gawing private ang variables para hindi ma-access nang diretso sa labas
        private static String currentID;
        private static String currentName;
        private static String currentEmail;
        private static String currentType;
        private static String currentImage; 

        // SETTER: Ito ang naglalagay ng laman sa variables
        public static void setSession(String id, String name, String email, String type, String image) {
            currentID = id;
            currentName = name;
            currentEmail = email;
            currentType = type;
            currentImage = image;
    }
        public static String getOnlineID() {
        return currentID;
    }
       
    public static String getID() { return currentID; }
    public static String getName() { return currentName; }
    public static String getEmail() { return currentEmail; }
    public static String getType() { return currentType; }
    public static String getImage() { return currentImage; }
    
     public static void setCurrentName(String name) {
        if(name != null && !name.isEmpty()) {
            currentName = name;
        }
    }
    public static class CircularLabel extends JLabel {
        public CircularLabel() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Use the smaller of width/height to ensure a perfect circle
            int diameter = Math.min(getWidth(), getHeight());
            Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);

            g2.setClip(circle);
            super.paintComponent(g2);
            g2.dispose();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
    }
    
    public static Connection connectDB() {


            Connection con = null;
            try {
                Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
                con =DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");

                System.out.println("Connection Successful");
            } catch (Exception e) {
                System.out.println("Connection Failed: " + e);
            }
            return con;
        }

    public int addRecord(String sql, Object... values) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
            pst = conn.prepareStatement(sql);

            for (int i = 0; i < values.length; i++) {
                pst.setObject(i + 1, values[i]);
            }

            result = pst.executeUpdate();
            System.out.println("Record saved successfully!");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } finally {
            // CRITICAL: This is what unlocks the database for the next user
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Closing Error: " + ex.getMessage());
            }
        }
        return result;

    }

     public int updateRecord(String sql, Object... values) { 
        try (java.sql.Connection conn = connectDB(); 
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) { 

           for (int i = 0; i < values.length; i++) { 
               pstmt.setObject(i + 1, values[i]); 
           } 

           return pstmt.executeUpdate(); 

       } catch (java.sql.SQLException e) { 
           System.out.println("Update Error: " + e.getMessage()); 
           return 0; 
       } 
    }
     
     public void deleteRecord(String sql, Object... values) { 
        try (Connection conn = connectDB(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            for (int i = 0; i < values.length; i++) { 
                pstmt.setObject(i + 1, values[i]); } 
            pstmt.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Record deleted successfully!"); 
        } catch (SQLException e) 
        { 
            System.out.println("Error deleting record: " + e.getMessage()); 
        } 
    }
     
     public void displayData(String sql, javax.swing.JTable table) {
        // Try-with-resources syntax (Automatic close)
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     
    public boolean authenticate(String sql, Object ... values) {
        try (Connection conn = connectDB();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i=0; i < values.length; i++) {
        pstmt.setObject(i+1, values[i]);
        }
        try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
        return true;
        }
        }

        } catch (SQLException e) {
        System.out.println("Login Error: "+ e.getMessage());

        }
        return false;
    }
    
    public int getCount(String sql) {
        int count = 0;
        try (Connection conn = connectDB();
             java.sql.Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching count: " + e.getMessage());
        }
        return count;
    }
    
    public java.util.List getQuestionList(String sql) { 
        java.util.List list = new java.util.ArrayList(); 
        try (java.sql.Connection conn = connectDB(); 
                java.sql.PreparedStatement pstmt = conn.prepareStatement(sql); 
                java.sql.ResultSet rs = pstmt.executeQuery()) { 
            while (rs.next()) { list.add(rs.getString(1)); 
            } 
        } catch (
                java.sql.SQLException e) { 
            System.out.println("Error: " + e.getMessage()); 
        } return list; 
    
    }
    public void updateRecordOnly(String sql, Object... values) { 
        try (Connection conn = connectDB(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            for (int i = 0; i < values.length; i++) { 
                pstmt.setObject(i + 1, values[i]); } 
            pstmt.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Record updated successfully!"); 
        } catch (SQLException e) { 
            System.out.println("Error updating record: " + e.getMessage()); 
        } 
        
    }
    
    public static boolean stopIllegalAccess(javax.swing.JFrame frame) {
        if (currentID == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Unable to proceed, please log in first.");
            new authenticate.logIn().setVisible(true);
            frame.dispose();
            return true; 
        }
        return false; 
    }
    
    public void manageHover(javax.swing.JPanel panel) {
        // 1. Remember the color the panel had at the very start
        java.awt.Color originalColor = panel.getBackground();
        // 2. Define your highlight color (Lighter blue)
        java.awt.Color hoverColor = new java.awt.Color(0, 51, 102); 

        java.awt.event.MouseAdapter hoverEffect = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // 3. Return to the EXACT color it had before
                panel.setBackground(originalColor);
            }
        };

        // Apply to the panel
        panel.addMouseListener(hoverEffect);

        // Apply to every Label inside so the text doesn't block the effect
        for (java.awt.Component comp : panel.getComponents()) {
            if (comp instanceof javax.swing.JLabel) {
                comp.addMouseListener(hoverEffect);
            }
        }
    }
    
    // ADD THIS TO YOUR config.java
 public boolean insertData(String sql) {
    Connection conn = null;
    PreparedStatement pst = null;
    try {
        // Ang busy_timeout ay nagbibigay ng pagkakataon sa Java na maghintay kaysa mag-error agad
        conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
        pst = conn.prepareStatement(sql);
        pst.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println("Insert Error: " + ex.getMessage());
        return false;
    } finally {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close(); 
        } catch (SQLException e) {
            System.out.println("Closing Error: " + e.getMessage());
        }
        finally {
            try{
        conn.close();
        pst.close();
        }
        catch(Exception e){
        }
        }
        }
        }

    public TableModel getSafeModel(String sql) {
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            System.out.println("Error fetching model: " + e.getMessage());
            return null;
        }
    }

    /**
     * REFACTORED: If you MUST return a ResultSet, the calling class 
     * is responsible for closing the Connection.
     */
    public ResultSet getData(String sql) throws SQLException {
        // We use the busy_timeout here to prevent immediate locking errors
        Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
        Statement stmt = conn.createStatement();
        // Use the statement to execute so we can trace it back to the connection later
        return stmt.executeQuery(sql);
    }

    /**
     * NEW: Helper to close the connection associated with a ResultSet
     * @param rs
     */public void closeResult(ResultSet rs) {
    try {
        if (rs != null) {
            Statement stmt = rs.getStatement();
            if (stmt != null) {
                Connection conn = stmt.getConnection();
                rs.close();
                stmt.close();
                if (conn != null) conn.close(); 
            }
        }
    } catch (SQLException e) {
        System.out.println("Cleanup Error: " + e.getMessage());
    }
}
     
     public static ImageIcon resizeImage(String imgPath, int width, int height) {
    ImageIcon path = new ImageIcon(imgPath);
    java.awt.Image img = path.getImage();
    java.awt.Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
}
    //LOGS NI
     
        public void logEvent(String action) {
           try {
               // Use your existing currentID from the session
               String sql = "INSERT INTO tbl_logs (u_id, l_action) VALUES (?, ?)";
               Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db");
               PreparedStatement pst = conn.prepareStatement(sql);
               pst.setString(1, currentID); 
               pst.setString(2, action);
               pst.executeUpdate();
               pst.close();
               conn.close();
           } catch (SQLException e) {
               System.out.println("Log Error: " + e.getMessage());
           }
       }

    }
    
    
    



