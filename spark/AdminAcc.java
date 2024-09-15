
package spark;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AdminAcc extends JFrame {
    private String adminName, address, mail, userad;
    public void Connect() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sparkdb", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
    
    public AdminAcc(String adminName, String address, String mail, String userad){
         super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        this.adminName = adminName;
        this.address = address;
        this.mail = mail;
        this.userad = userad;
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("CUSTOMER");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(60, 40, 200, 30); 
        add(calcu);
        
                 calcu.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        calcu.setFont(labelFont);
        calcu.setBounds(55, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(60, 40, 200, 30); 
        
    }
});
    calcu.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        AdminAcc.this.new Customer();
    }
});
        
        JLabel binfo = new JLabel("BILL INFORMATION");
        binfo.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        binfo.setFont(labelFont);
        binfo.setBounds(280, 40, 200, 30); 
        add(binfo);
        
        binfo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        AdminAcc.this.new Bill();
    }
});
        
        binfo.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 22);
        binfo.setFont(labelFont);
        binfo.setBounds(273, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        binfo.setFont(labelFont);
        binfo.setBounds(280, 40, 200, 30); 
        
    }
});
        JLabel profile = new JLabel("PROFILE");
        profile.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        add(profile);
        
        profile.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        AdminAcc.this.new AdProfile(adminName, address, mail, userad);
    }
});
        
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        profile.setFont(labelFont);
        profile.setBounds(695, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        
    }
});
        
        JLabel lout = new JLabel("LOG OUT ");
        lout.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        add(lout);
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "LOG OUT Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    dispose(); 
                    FrameWelcome frameWelcome = new FrameWelcome();
                    frameWelcome.setVisible(true);
                }
            }
        });
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        lout.setFont(labelFont);
        lout.setBounds(895, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        
    }
});
        
        
        
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bglong.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1200, 550, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 40, 1200, 700);
        add(bgLabel);
        
        
        setLayout(null);
        setSize(1100, 700);
        setLocation(420, 200);
        setVisible(true);
    
}
    public static void main(String[] args){
        String adminName = "";
       
        String address = "";
        String mail = "";
        String userad = "";
        
        new AdminAcc(adminName, address, mail, userad);
    }

   
    
   class Customer extends JFrame{
       
        public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sparkdb", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
    

private void deleteImageMouseClicked(java.awt.event.MouseEvent evt) {
    int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);
    
    if (result == JOptionPane.YES_OPTION) {
        try {
            Connect();
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int userId = (int) table.getValueAt(selectedRow, 0);

                String query = "DELETE FROM usertbl WHERE user_id=?";
                pst = con.prepareStatement(query);
                pst.setInt(1, userId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record deleted successfully!");
                    
                    table.setModel(getDataFromDatabase());
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete record.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CusViewAd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
        private JTextField txtName, txtMeter, txtAdd, txtEmail, txtUn, txtPw;
     private JTable table;

       
    public DefaultTableModel getDataFromDatabase() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("User ID");
       
        model.addColumn("Customer Name");
        model.addColumn("Meter Number");
        model.addColumn("Address");
        model.addColumn("Email");
        model.addColumn("Username");
        model.addColumn("Password");
        

        try {
            Connect();

            String query = "SELECT * FROM usertbl";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("user_id"),
                        rs.getString("Customer_Name"),
                        rs.getString("Meter_Number"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("user_un"),
                        rs.getString("user_pw"),
                        
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminAcc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }
    
    
    private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {
    try {
            
            String customerName = txtName.getText();
            String meterNumber = txtMeter.getText();
            String address = txtAdd.getText();
            String email = txtEmail.getText();
            String userUn = txtUn.getText();
            String userPw = txtPw.getText();

            
            if (customerName.isEmpty() || meterNumber.isEmpty() || address.isEmpty()
                    || email.isEmpty() || userUn.isEmpty() || userPw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

           
            Connect();
            String query = "INSERT INTO usertbl (Customer_Name, Meter_Number, Address, Email, user_un, user_pw) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, customerName);
            pst.setString(2, meterNumber);
            pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, userUn);
            pst.setString(6, userPw);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Record added successfully!");
                
                table.setModel(getDataFromDatabase());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add record.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CusViewAd.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
     
        public Customer(){       
          
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("CUSTOMER");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.BOLD, 30);
        calcu.setFont(labelFont);
        calcu.setBounds(60, 40, 200, 30); 
        add(calcu);
        
                 
        
        JLabel binfo = new JLabel("BILL INFORMATION");
        binfo.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        binfo.setFont(labelFont);
        binfo.setBounds(280, 40, 200, 30); 
        add(binfo);
        binfo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
         AdminAcc.this.new Bill();
    }
});
        
        binfo.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 22);
        binfo.setFont(labelFont);
        binfo.setBounds(273, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        binfo.setFont(labelFont);
        binfo.setBounds(280, 40, 200, 30); 
        
    }
});
        JLabel profile = new JLabel("PROFILE");
        profile.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        add(profile);
        
        profile.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        AdminAcc.this.new AdProfile(adminName, address, mail, userad);
    }
});
        
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        profile.setFont(labelFont);
        profile.setBounds(695, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        
    }
});
        
        JLabel lout = new JLabel("LOG OUT ");
        lout.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        add(lout);
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        lout.setFont(labelFont);
        lout.setBounds(895, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        
    }
});
         lout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "LOG OUT Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    dispose(); 
                    FrameWelcome frameWelcome = new FrameWelcome();
                    frameWelcome.setVisible(true);
                }
            }
        });
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.BOLD, 23);
        namelbl.setFont(labelFont);
        namelbl.setBounds(74, 130, 150, 30); 
        add(namelbl);
        
         txtName = new JTextField();
        txtName.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
        Color borderColor = new Color(255, 124, 16);
        txtName.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtName.setOpaque(true); 
        txtName.setBackground(Color.WHITE);
        txtName.setForeground(Color.BLACK);
        txtName.setHorizontalAlignment(JTextField.CENTER);
        txtName.setBounds(150, 130, 300, 35);
        add(txtName);
        
        JLabel meterlbl = new JLabel("Meter No.");
        meterlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        meterlbl.setFont(labelFont);
        meterlbl.setBounds(40, 183, 150, 30); 
        add(meterlbl);
        
         txtMeter = new JTextField();
        txtMeter.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtMeter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtMeter.setOpaque(true); 
        txtMeter.setBackground(Color.WHITE);
        txtMeter.setForeground(Color.BLACK);
        txtMeter.setHorizontalAlignment(JTextField.CENTER);
        txtMeter.setBounds(150, 180, 300, 35);
        add(txtMeter);
        
        JLabel addlbl = new JLabel("Address");
        addlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        addlbl.setFont(labelFont);
        addlbl.setBounds(56, 233, 150, 30); 
        add(addlbl);
        
         txtAdd = new JTextField();
        txtAdd.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtAdd.setOpaque(true); 
        txtAdd.setBackground(Color.WHITE);
        txtAdd.setForeground(Color.BLACK);
        txtAdd.setHorizontalAlignment(JTextField.CENTER);
        txtAdd.setBounds(150, 230, 300, 35);
        add(txtAdd);
        
        
        JLabel emaillbl = new JLabel("Email");
        emaillbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        emaillbl.setFont(labelFont);
        emaillbl.setBounds(510, 130, 150, 30); 
        add(emaillbl);
        
         txtEmail = new JTextField();
        txtEmail.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtEmail.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtEmail.setOpaque(true); 
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setHorizontalAlignment(JTextField.CENTER);
        txtEmail.setBounds(580, 130, 300, 35);
        add(txtEmail);
        
        JLabel unlbl = new JLabel("Username");
        unlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        unlbl.setFont(labelFont);
        unlbl.setBounds(465, 183, 150, 30); 
        add(unlbl);
        
         txtUn = new JTextField();
        txtUn.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtUn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtUn.setOpaque(true); 
        txtUn.setBackground(Color.WHITE);
        txtUn.setForeground(Color.BLACK);
        txtUn.setHorizontalAlignment(JTextField.CENTER);
        txtUn.setBounds(580, 180, 300, 35);
        add(txtUn);
        
        JLabel pwlbl = new JLabel("Password");
        pwlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        pwlbl.setFont(labelFont);
        pwlbl.setBounds(470, 233, 150, 30); 
        add(pwlbl);
        
        txtPw = new JTextField();
        txtPw.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtPw.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtPw.setOpaque(true); 
        txtPw.setBackground(Color.WHITE);
        txtPw.setForeground(Color.BLACK);
        txtPw.setHorizontalAlignment(JTextField.CENTER);
        txtPw.setBounds(580, 230, 300, 35);
        add(txtPw);
        
        JButton btnadd = new JButton("ADD");
        btnadd.setBounds(670, 280, 100, 30);
        Font boldFont = new Font("Century Gothic", Font.BOLD, 16);
        btnadd.setBackground(Color.WHITE);
        btnadd.setForeground(new Color(255, 124, 16));
        btnadd.setFont(boldFont);
        btnadd.setOpaque(true);
        add(btnadd);
        
        btnadd.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateRecordActionPerformed(evt);   
    }
});
        
        JButton btnclear = new JButton("CLEAR");
        btnclear.setBounds(780, 280, 100, 30);
        boldFont = new Font("Century Gothic", Font.BOLD, 16);
        btnclear.setBackground(Color.WHITE);
        btnclear.setForeground(new Color(255, 124, 16));
        btnclear.setFont(boldFont);
        btnclear.setOpaque(true);
        add(btnclear);
        
        btnclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtName.setText("");
                txtMeter.setText("");
                txtAdd.setText("");
                txtEmail.setText("");
                txtUn.setText("");
                txtPw.setText("");
            }
        });
        
        
       
       
        
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i7 = i6.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(900, 260, 50, 50);
        add(image);
        
        image.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        ImageIcon i6En = new ImageIcon(ClassLoader.getSystemResource("icon/delete2.png"));
        Image i7En = i6En.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i8En = new ImageIcon(i7En);       
        image.setIcon(i8En);        
        
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        ImageIcon i6Ex = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i7Ex = i6Ex.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i8Ex = new ImageIcon(i7Ex);
        image.setIcon(i8Ex);      
    }
});
        image.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        deleteImageMouseClicked(evt);
    }
});
        
        
             
        table = new JTable(getDataFromDatabase());
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(40, 340, 1000, 290);
            table.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 15));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(customColor);
        add(scrollPane);
        
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
            int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { 
                        
                        
                        
                        Object customerName = table.getValueAt(selectedRow, 1); 
                        Object meterNumber = table.getValueAt(selectedRow, 2);
                        Object address = table.getValueAt(selectedRow, 3);
                        Object email = table.getValueAt(selectedRow, 4);
                        Object userUn = table.getValueAt(selectedRow, 5);
                        Object userPw = table.getValueAt(selectedRow, 6);
                        
                        txtName.setText(customerName != null ? customerName.toString() : "");
                        txtMeter.setText(meterNumber != null ? meterNumber.toString() : "");
                        txtAdd.setText(address != null ? address.toString() : "");
                        txtEmail.setText(email != null ? email.toString() : "");
                        txtUn.setText(userUn != null ? userUn.toString() : "");
                    txtPw.setText(userPw != null ? userPw.toString() : "");
                    
                    
                    }
                }
            }
        });
        
            
            ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bglong.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1200, 550, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 40, 1200, 700);
        add(bgLabel);
        

            
        setLayout(null);
        setSize(1100, 700);
        setLocation(420, 200);
        setVisible(true);
            
        
    }
       
        
       

   
   }
   
   class Bill extends JFrame{
       
       private void deleteImageMouseClicked(java.awt.event.MouseEvent evt) {
    int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);
    
    if (result == JOptionPane.YES_OPTION) {
        try {
            Connect();
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int userId = (int) table.getValueAt(selectedRow, 0);

                String query = "DELETE FROM billtbl WHERE bill_id=?";
                pst = con.prepareStatement(query);
                pst.setInt(1, userId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record deleted successfully!");
                    
                    table.setModel(getDataFromDatabase());
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete record.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CusViewAd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
       
       private JTextField txtName, txtMeter, txtAdd, txtEmail, txtUn, txtPw;
     private JTable table;
     
     
     
     private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {
    try {
            // Get data from text fields
            String customerName = txtName.getText();
            String meterNumber = txtMeter.getText();
            String address = txtAdd.getText();
            String email = txtEmail.getText();
            String userUn = txtPw.getText();
            String userPw = txtUn.getText();

            
            if (customerName.isEmpty() || meterNumber.isEmpty() || address.isEmpty()
                    || email.isEmpty() || userUn.isEmpty() || userPw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }

           
            Connect();
            String query = "INSERT INTO billtbl (Customer_Name, Meter_Number, Total_Kwh, Total_Cost, Month, Status) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, customerName);
            pst.setString(2, meterNumber);
            pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, userPw);
            pst.setString(6, userUn);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Record added successfully!");
                
                table.setModel(getDataFromDatabase());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add record.");
            }
        } catch (SQLException ex) {
             
            Logger.getLogger(CusViewAd.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

       
    public DefaultTableModel getDataFromDatabase() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Bill ID");
       
        model.addColumn("Customer Name");
        model.addColumn("Meter Number");
        model.addColumn("Total Kwh");
        model.addColumn("Total Cost");
        model.addColumn("Month");
        model.addColumn("Status");
        

        try {
            Connect();

            String query = "SELECT * FROM billtbl";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("bill_id"),
                        rs.getString("Customer_Name"),
                        rs.getString("Meter_Number"),
                        rs.getString("Total_Kwh"),
                        rs.getString("Total_Cost"),
                        rs.getString("Month"),
                        rs.getString("Status"),
                        
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminAcc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }
      
    
        public Bill(){
            
             
            
          
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("CUSTOMER");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(60, 40, 200, 30); 
        add(calcu);
        calcu.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        AdminAcc.this.new Customer();
    }
});
                
        
        calcu.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        calcu.setFont(labelFont);
        calcu.setBounds(55, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(60, 40, 200, 30); 
        
    }
});
    
    
        
                 
        
        JLabel binfo = new JLabel("BILL INFORMATION");
        binfo.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.BOLD, 27);
        binfo.setFont(labelFont);
        binfo.setBounds(230, 40, 300, 30); 
        add(binfo);
        
        
        JLabel profile = new JLabel("PROFILE");
        profile.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        add(profile);
      
        profile.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
         AdminAcc.this.new AdProfile(adminName, address, mail, userad);
    }
});
        
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        profile.setFont(labelFont);
        profile.setBounds(695, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        
    }
});
        
        JLabel lout = new JLabel("LOG OUT ");
        lout.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        add(lout);
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "LOG OUT Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    dispose(); 
                    FrameWelcome frameWelcome = new FrameWelcome();
                    frameWelcome.setVisible(true);
                }
            }
        });
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        lout.setFont(labelFont);
        lout.setBounds(895, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        
    }
});
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.BOLD, 23);
        namelbl.setFont(labelFont);
        namelbl.setBounds(74, 130, 150, 30); 
        add(namelbl);
        
         txtName = new JTextField();
        txtName.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
        Color borderColor = new Color(255, 124, 16);
        txtName.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtName.setOpaque(true); 
        txtName.setBackground(Color.WHITE);
        txtName.setForeground(Color.BLACK);
        txtName.setHorizontalAlignment(JTextField.CENTER);
        txtName.setBounds(150, 130, 300, 35);
        add(txtName);
        
        JLabel meterlbl = new JLabel("Meter No.");
        meterlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        meterlbl.setFont(labelFont);
        meterlbl.setBounds(40, 183, 150, 30); 
        add(meterlbl);
        
         txtMeter = new JTextField();
        txtMeter.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtMeter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtMeter.setOpaque(true); 
        txtMeter.setBackground(Color.WHITE);
        txtMeter.setForeground(Color.BLACK);
        txtMeter.setHorizontalAlignment(JTextField.CENTER);
        txtMeter.setBounds(150, 180, 300, 35);
        add(txtMeter);
        
        JLabel addlbl = new JLabel("Total Kwh");
        addlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        addlbl.setFont(labelFont);
        addlbl.setBounds(40, 233, 150, 30); 
        add(addlbl);
        
         txtAdd = new JTextField();
        txtAdd.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtAdd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtAdd.setOpaque(true); 
        txtAdd.setBackground(Color.WHITE);
        txtAdd.setForeground(Color.BLACK);
        txtAdd.setHorizontalAlignment(JTextField.CENTER);
        txtAdd.setBounds(150, 230, 300, 35);
        add(txtAdd);
        
        
        JLabel emaillbl = new JLabel("Total Cost");
        emaillbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        emaillbl.setFont(labelFont);
        emaillbl.setBounds(467, 130, 150, 30); 
        add(emaillbl);
        
         txtEmail = new JTextField();
        txtEmail.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtEmail.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtEmail.setOpaque(true); 
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setHorizontalAlignment(JTextField.CENTER);
        txtEmail.setBounds(580, 130, 300, 35);
        add(txtEmail);
        
        JLabel unlbl = new JLabel("Month");
        unlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        unlbl.setFont(labelFont);
        unlbl.setBounds(505, 183, 150, 30); 
        add(unlbl);
        
         txtUn = new JTextField();
        txtUn.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtUn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtUn.setOpaque(true); 
        txtUn.setBackground(Color.WHITE);
        txtUn.setForeground(Color.BLACK);
        txtUn.setHorizontalAlignment(JTextField.CENTER);
        txtUn.setBounds(580, 180, 300, 35);
        add(txtUn);
        
        JLabel pwlbl = new JLabel("Status");
        pwlbl.setForeground(Color.WHITE);
        labelFont = new Font("Century Gothic", Font.BOLD, 23);
        pwlbl.setFont(labelFont);
        pwlbl.setBounds(510, 233, 150, 30); 
        add(pwlbl);
        
        
         txtPw = new JTextField();
        txtPw.setFont(new Font("CEntury Gothic", Font.PLAIN, 20));
         borderColor = new Color(255, 124, 16);
        txtPw.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, borderColor)); 
        txtPw.setOpaque(true); 
        txtPw.setBackground(Color.WHITE);
        txtPw.setForeground(Color.BLACK);
        txtPw.setHorizontalAlignment(JTextField.CENTER);
        txtPw.setBounds(580, 230, 300, 35);
        add(txtPw);
        
         JButton btnadd = new JButton("ADD");
        btnadd.setBounds(670, 280, 100, 30);
        Font boldFont = new Font("Century Gothic", Font.BOLD, 16);
        btnadd.setBackground(Color.WHITE);
        btnadd.setForeground(new Color(255, 124, 16));
        btnadd.setFont(boldFont);
        btnadd.setOpaque(true);
        add(btnadd);
        
        btnadd.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateRecordActionPerformed(evt);   
    }
});
        
        
        JButton btnclear = new JButton("CLEAR");
        btnclear.setBounds(780, 280, 100, 30);
        boldFont = new Font("Century Gothic", Font.BOLD, 16);
        btnclear.setBackground(Color.WHITE);
        btnclear.setForeground(new Color(255, 124, 16));
        btnclear.setFont(boldFont);
        btnclear.setOpaque(true);
        add(btnclear);
        
        btnclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtName.setText("");
                txtMeter.setText("");
                txtAdd.setText("");
                txtEmail.setText("");
                txtUn.setText("");
                txtPw.setText("");
            }
        });
        
        
        
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i7 = i6.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(900, 260, 50, 50);
        add(image);
        
        image.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        ImageIcon i6En = new ImageIcon(ClassLoader.getSystemResource("icon/delete2.png"));
        Image i7En = i6En.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i8En = new ImageIcon(i7En);       
        image.setIcon(i8En);  
     
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        ImageIcon i6Ex = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i7Ex = i6Ex.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i8Ex = new ImageIcon(i7Ex);
        image.setIcon(i8Ex); 
        
         image.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        deleteImageMouseClicked(evt);
    }
});
        
       
        
       
    }
});
        
        
             
        table = new JTable(getDataFromDatabase());
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(40, 340, 1000, 290);
            table.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 15));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(customColor);
        add(scrollPane);
        
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
            int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { 
                        
                        
                        
                        Object customerName = table.getValueAt(selectedRow, 1); 
                        Object meterNumber = table.getValueAt(selectedRow, 2);
                        Object address = table.getValueAt(selectedRow, 3);
                        Object email = table.getValueAt(selectedRow, 4);
                        Object userUn = table.getValueAt(selectedRow, 5);
                        Object userPw = table.getValueAt(selectedRow, 6);
                        
                        txtName.setText(customerName != null ? customerName.toString() : "");
                        txtMeter.setText(meterNumber != null ? meterNumber.toString() : "");
                        txtAdd.setText(address != null ? address.toString() : "");
                        txtEmail.setText(email != null ? email.toString() : "");
                        txtUn.setText(userUn != null ? userUn.toString() : "");
                    txtPw.setText(userPw != null ? userPw.toString() : "");
                    
                    
                    }
                }
            }
        });
        
            
            ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bglong.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1200, 550, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 40, 1200, 700);
        add(bgLabel);
        

            
        setLayout(null);
        setSize(1100, 700);
        setLocation(420, 200);
        setVisible(true);
            
        
    }
       
       Connection con;
    PreparedStatement pst;
    ResultSet rs; 

    public void Connect() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/sparkdb", "root", "");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
    }
} 
       
   }
   
   class AdProfile extends JFrame{
       
       private String adminName, address, mail, userad;
       public AdProfile(String adminName, String address, String mail, String userad){
           
           Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("CUSTOMER");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
         calcu.setBounds(60, 40, 200, 30); 
        add(calcu);
        calcu.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        AdminAcc.this.new Customer();
    }
});
        
                 calcu.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 22);
        calcu.setFont(labelFont);
        calcu.setBounds(35, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(40, 40, 200, 30); 
        
    }
});
        
        JLabel binfo = new JLabel("BILL INFORMATION");
        binfo.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        binfo.setFont(labelFont);
        binfo.setBounds(280, 40, 200, 30); 
        add(binfo);
        binfo.setBounds(280, 40, 200, 30); 
        add(binfo);
        binfo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
         AdminAcc.this.new Bill();
    }
});
        
        binfo.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 22);
        binfo.setFont(labelFont);
        binfo.setBounds(273, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        binfo.setFont(labelFont);
        binfo.setBounds(280, 40, 200, 30); 
        
    }
});
        JLabel profile = new JLabel("PROFILE");
        profile.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.BOLD, 28);
        profile.setFont(labelFont);
        profile.setBounds(700, 40, 200, 30); 
        add(profile);
        
       
        
        JLabel lout = new JLabel("LOG OUT ");
        lout.setForeground(Color.WHITE);
         labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        add(lout);
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        lout.setFont(labelFont);
        lout.setBounds(895, 7, 200, 90); 
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        lout.setFont(labelFont);
        lout.setBounds(900, 40, 200, 30); 
        
    }
});
        
        lout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "LOG OUT Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    dispose(); 
                    FrameWelcome frameWelcome = new FrameWelcome();
                    frameWelcome.setVisible(true);
                }
            }
        });
        
        JLabel h = new JLabel("<html><span>Welcome to your</span><br><span style='font-weight:bold'>ADMIN PROFILE</span></html>");
        h.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 35);
        h.setFont(labelFont);
        h.setBounds(30, 120, 520, 100); 
        add(h);
        
        JLabel namelbl = new JLabel(adminName);
        namelbl.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.BOLD, 40);
        namelbl.setFont(labelFont);
        namelbl.setBounds(520, 190, 500, 100); 
        add(namelbl);
        
        
        JLabel meter = new JLabel("Adress: " + address);
        meter.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        meter.setFont(labelFont);
        meter.setBounds(520, 270, 500, 100); 
        add(meter);
        
        JLabel add = new JLabel("Email: " + mail);
        add.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        add.setFont(labelFont);
        add.setBounds(520, 310, 500, 100); 
        add(add);
        
        
        
        JLabel unname = new JLabel("Username: " + userad);
        unname.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        unname.setFont(labelFont);
        unname.setBounds(520, 410, 500, 100); 
        add(unname);
        
        
        
        
        
        
        JPanel obox = new JPanel();
        Border buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        obox.setBorder(buttonBorder);
        obox.setBackground(Color.WHITE);
        obox.setBounds(500, 200, 700, 380);
        obox.setLayout(null); 
        add(obox);
        
        ImageIcon usericon = new ImageIcon(ClassLoader.getSystemResource("icon/adminprof.png"));
        Image userimage = usericon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon scaledusericon = new ImageIcon(userimage);
        JLabel userlabel = new JLabel(scaledusericon);
        userlabel.setBounds(95, 230, 320, 320);     
        add(userlabel);
        
        
        
        JPanel box = new JPanel();
        box.setBackground(Color.WHITE);
        box.setBounds(0, 115, 1200, 700);
        box.setLayout(null); 
        add(box);
        
        
        
        
        
        
        setLayout(null);
        setSize(1100, 700);
        setLocation(420, 200);
        setVisible(true);
       }
       public void Connect() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/sparkdb", "root", "");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
    }
} 
       
   }
   
   
   Connection con;
    PreparedStatement pst;
    ResultSet rs;  
}

   







