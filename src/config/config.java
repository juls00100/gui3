/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package config;
    import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
import java.awt.Image;
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
    import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
    import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
    import com.lowagie.text.pdf.PdfPTable;
    import com.lowagie.text.pdf.PdfWriter;
    import java.io.FileOutputStream;
    import javax.swing.JFileChooser;
    import javax.swing.JTable;
    import javax.swing.filechooser.FileNameExtensionFilter;
    import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
    import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


    public class config {
        //VARIABLES TO USE
        private static String currentID;
        private static String currentName;
        private static String currentEmail;
        private static String currentType;
        private static String currentImage;
    //SETTERS    
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
    //GETTERS
    public static String getID() { return currentID; }
    public static String getName() { return currentName; }
    public static String getEmail() { return currentEmail; }
    public static String getType() { return currentType; }
    public static String getImage() { return currentImage; }
    
    public static void setName(String name) {
    currentName = name; // Replace with your actual variable name in config
}

    public static void setEmail(String email) {
        currentEmail = email; // Replace with your actual variable name in config
    }

    public static void setImage(String imagePath) {
        currentImage = imagePath; // Replace with your actual variable name in config
    }
    
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
    
    public void exportToPDF(JTable table, String fileName) {
    
    java.awt.Color navyBlue = new java.awt.Color(0, 51, 102); 
    java.awt.Color goldTheme = new java.awt.Color(197, 179, 88);
    
    com.lowagie.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
    com.lowagie.text.Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, com.lowagie.text.Font.NORMAL, java.awt.Color.WHITE);
    com.lowagie.text.Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
    com.lowagie.text.Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, com.lowagie.text.Font.NORMAL, navyBlue);
    com.lowagie.text.Font boldNormalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10); // Kani ang idugang
    com.lowagie.text.Font addressFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
    
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Report As PDF");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Document", "pdf"));

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();
        if (!filePath.toLowerCase().endsWith(".pdf")) {
            filePath += ".pdf";
        }

        try {
           
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(filePath));
            doc.open();
            
            try {
                com.lowagie.text.Image logo = com.lowagie.text.Image.getInstance("src/resources/the logo 3.0.png");

                logo.scaleToFit(80, 80); 
                logo.setAlignment(com.lowagie.text.Element.ALIGN_CENTER); 

                doc.add(logo);
            } catch (Exception e) {
                System.out.println("Logo not found, skipping... " + e.getMessage());
            }
            
            Paragraph schoolName = new Paragraph("CAMPANER STATE UNIVERSITY - CEBU CAMPUS", titleFont);
            schoolName.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            doc.add(schoolName);
            
            
            Paragraph address = new Paragraph("Poblacion, Argao, Cebu, Philippines 6021", addressFont);
            address.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            address.setSpacingBefore(2f); 
            address.setSpacingAfter(5f);
            doc.add(address);
            

            PdfPTable line = new PdfPTable(1);
            line.setWidthPercentage(100);
            line.setSpacingBefore(2f);
            
            com.lowagie.text.pdf.PdfPCell lineCell = new com.lowagie.text.pdf.PdfPCell();
            lineCell.setBorder(com.lowagie.text.Rectangle.BOTTOM);
            lineCell.setBorderWidthBottom(2f);
            lineCell.setBorderColorBottom(goldTheme); 
            line.addCell(lineCell);
            doc.add(line);
            
            Paragraph reportTitle = new Paragraph("ACADEMIC EVALUATION RESULT", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            reportTitle.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            doc.add(reportTitle);
            
            doc.add(new Paragraph(" ")); 

            Paragraph evalOf = new Paragraph();
            evalOf.setSpacingBefore(10f);
            
            String roleLabel;
            String userType = config.getType(); 

            if (userType != null && userType.equalsIgnoreCase("Teacher")) {
                roleLabel = "Faculty Member: ";
            } else if (userType != null && userType.equalsIgnoreCase("Student")) {
                roleLabel = "Evaluations of: ";
            } else {
                roleLabel = "Admin Name: ";
            }
            evalOf.add(new Phrase(roleLabel, normalFont));
            evalOf.add(new Phrase(config.getName().toUpperCase(), nameFont)); 
            
            doc.add(evalOf);
            evalOf.add(new Phrase(roleLabel, normalFont));
            Paragraph dateLine = new Paragraph("Date: " + new java.util.Date().toString(), normalFont);
            doc.add(dateLine); 

            doc.add(new Paragraph(" "));

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            for (int i = 0; i < table.getColumnCount(); i++) {
                String hName = table.getColumnName(i).toUpperCase();
                if(hName.equalsIgnoreCase("SCORE")) { hName = "AVERAGE"; }

                com.lowagie.text.pdf.PdfPCell cell = new com.lowagie.text.pdf.PdfPCell(new Phrase(hName, headerFont));
                cell.setBackgroundColor(navyBlue);
                cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
                cell.setPadding(8);
                pdfTable.addCell(cell);
            }

            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    Object val = table.getModel().getValueAt(rows, cols);
                    com.lowagie.text.pdf.PdfPCell dataCell = new com.lowagie.text.pdf.PdfPCell(new Phrase(val != null ? val.toString() : "", normalFont));
                    dataCell.setPadding(5);
                    pdfTable.addCell(dataCell);
                }
            }
            doc.add(pdfTable);
                doc.add(new Paragraph("\n\n"));
                PdfPTable footerTable = new PdfPTable(2);
                footerTable.setWidthPercentage(100);

                // Admin Side with your Name
                com.lowagie.text.pdf.PdfPCell sig1 = new com.lowagie.text.pdf.PdfPCell();
                Paragraph adminSig = new Paragraph();
                adminSig.setLeading(12f);
                adminSig.setAlignment(Element.ALIGN_CENTER);
                adminSig.add(new Phrase("\n________________________\n", normalFont));
                adminSig.add(new Phrase("JULIOS S. CAMPANER\n", boldNormalFont));
                adminSig.add(new Phrase("Administrator", normalFont)); 
                adminSig.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);

                sig1.addElement(adminSig);
                sig1.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                sig1.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);

                // Date Signed Side
                com.lowagie.text.pdf.PdfPCell sig2 = new com.lowagie.text.pdf.PdfPCell();
                Paragraph dateSig = new Paragraph();
                dateSig.setLeading(12f); 
                dateSig.setAlignment(Element.ALIGN_CENTER);
                dateSig.add(new Phrase("\n______________________\n", normalFont));
                dateSig.add(new Phrase("DATE SIGNED", boldNormalFont));
                dateSig.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);
                dateSig.add(new Phrase("\n ", normalFont));
                sig2.addElement(dateSig);
                sig2.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                sig2.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);

                footerTable.addCell(sig1);
                footerTable.addCell(sig2);

                doc.add(footerTable);

            doc.close();
            javax.swing.JOptionPane.showMessageDialog(null, "Report successfully saved to:\n" + filePath);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Export Error: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}
    public synchronized void logEvent(String action) {
    // 1. First, let's make sure the u_id column exists (Self-Healing Code)
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
         Statement stmt = conn.createStatement()) {
        stmt.execute("ALTER TABLE tbl_logs ADD COLUMN u_id TEXT");
    } catch (SQLException e) {
    }
    String sql = "INSERT INTO tbl_logs (l_action, l_timestamp, u_id) VALUES (?, DATETIME('now', 'localtime'), ?)";
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aes.db?busy_timeout=5000");
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, action);
        pstmt.setString(2, config.getID()); 
        pstmt.executeUpdate();
        
    } catch (SQLException e) {
        System.out.println("Logging Error: " + e.getMessage());
    }
}
   
public String[] getSystemSettings() {
    String[] settings = {"Not Set", "Not Set"};
    try (java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:sqlite:aes.db")) {
        // Gigamit ang column names nga se_sem ug se_year gikan sa imong screenshot
        String sql = "SELECT se_sem, se_year FROM tbl_settings WHERE se_key = 'current_semester'";
        java.sql.ResultSet rs = conn.createStatement().executeQuery(sql);
        if (rs.next()) {
            settings[0] = rs.getString("se_sem");
            settings[1] = rs.getString("se_year");
        }
    } catch (Exception e) { System.out.println(e.getMessage()); }
    return settings;
}

    public void designTable(JTable table) {
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                javax.swing.JLabel label = (javax.swing.JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                label.setBackground(new Color(197, 179, 88)); // Imong Gold color
                label.setForeground(Color.BLACK); 
                label.setFont(new Font("Segoe UI", Font.BOLD, 14));
                label.setHorizontalAlignment(javax.swing.JLabel.LEADING); 

                return label;
            }
        });

        table.setRowHeight(30);
        table.setSelectionBackground(new Color(0, 204, 51)); // Imong Green color
        table.setSelectionForeground(Color.WHITE);
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
     // Centralized function in config.java
    public ImageIcon resizeImage(String imgPath, byte[] pic, int width, int height) {
        ImageIcon MyImage = (imgPath != null) ? new ImageIcon(imgPath) : new ImageIcon(pic);
        Image img = MyImage.getImage();
    
    int size = Math.min(width, height); // Kunin ang pinakamaliit na side para perfect circle
        BufferedImage bim = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bim.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(new Ellipse2D.Double(0, 0, size, size));
        g2.setComposite(AlphaComposite.SrcIn);
        g2.drawImage(img, 0, 0, size, size, null);
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(java.awt.Color.WHITE);
        g2.setStroke(new java.awt.BasicStroke(3f)); // 3 ang kapal ng border
        g2.draw(new Ellipse2D.Double(1, 1, width - 2, height - 2));
        g2.dispose();
    
    return new ImageIcon(bim);
    }
    
    public String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
     
    public int getQuestionCount() {
    config conf = new config();
    int count = 0;
    try {
        java.sql.ResultSet rs = conf.getData("SELECT COUNT(*) FROM tbl_question");
        if (rs.next()) {
            count = rs.getInt(1);
        }
    } catch (Exception e) {
        System.out.println("Error counting questions: " + e.getMessage());
    }
    return count;
}
      
    public int insertAndGetId(String sql, Object... values) {
    int generatedId = -1;
    String url = "jdbc:sqlite:aes.db?busy_timeout=5000"; 
    
    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }
        
        // I-DELETE TONG EXTRA DRIVERMANAGER LINE DIRI!
        
        pstmt.executeUpdate();
        
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        System.out.println("Insert Error: " + e.getMessage());
    }
    return generatedId;
}

       
    }
    
    
    



