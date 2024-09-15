
package spark;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.mindrot.jbcrypt.BCrypt;

public class UserLog extends JFrame {
    
    
    public void Connect() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/sparkdb", "root", "");
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
        throw new SQLException("Error connecting to the database", ex);
    }
}
    
        
        private class RoundedPanel extends JPanel {
        private int arcWidth;
        private int arcHeight;

        public RoundedPanel(int arcWidth, int arcHeight) {
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
            g2d.dispose();
        }
    }
        public UserLog(){
             super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/back.png"));
        Image i7 = i6.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(770, 380, 250, 190);
        add(image);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(270, 90, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(0, 0, 300, 100);     
        add(logoLabel);
        
        ImageIcon usericon = new ImageIcon(ClassLoader.getSystemResource("icon/usericon.png"));
        Image userimage = usericon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon scaledusericon = new ImageIcon(userimage);
        JLabel userlabel = new JLabel(scaledusericon);
        userlabel.setBounds(65, 120, 320, 320);     
        add(userlabel);
        
        
        
        JLabel welcomeLabel = new JLabel("USER");
        welcomeLabel.setForeground(customColor);
        Font labelFont = new Font("Century Gothic", Font.BOLD, 50);
        welcomeLabel.setFont(labelFont);
        welcomeLabel.setBounds(640, 45, 400, 90); 
        add(welcomeLabel);
        
        JLabel Loglbl = new JLabel("LOGIN");
        Loglbl.setForeground(customColor);
        labelFont = new Font("Century Gothic", Font.PLAIN, 40);
        Loglbl.setFont(labelFont);
        Loglbl.setBounds(633, 80, 400, 90); 
        add(Loglbl);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(500, 150, 600, 100);
        lblusername.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblusername.setForeground(customColor);
        add(lblusername);
        
        JTextField username = new JTextField();
        username.setFont(new Font("CEntury Gothic", Font.BOLD, 25));
        username.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, customColor)); 
        username.setOpaque(false); 
        username.setForeground(customColor);
        username.setHorizontalAlignment(JTextField.CENTER);
        username.setBounds(500, 210, 380, 50);
        add(username);
        
        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(500, 245, 600, 100);
        lblpass.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblpass.setForeground(customColor);
        add(lblpass);
        
        JPasswordField pass = new JPasswordField(); 
        pass.setFont(new Font("CEntury Gothic", Font.BOLD, 25));
        pass.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, customColor)); 
        pass.setOpaque(false); 
        pass.setForeground(customColor);
        pass.setHorizontalAlignment(JTextField.CENTER);
        pass.setBounds(500, 305, 380, 50);
        add(pass);
        
        JButton loginu = new JButton("LOGIN");
        Font buttonFont = new Font("Century Gothic", Font.BOLD, 30);
        Border buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        loginu.setBorder(buttonBorder);
        loginu.setForeground(Color.WHITE);
        loginu.setBackground(customColor);
        loginu.setBounds(610, 380, 180, 70);
        loginu.setFont(buttonFont);
        add(loginu);
        
         loginu.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        loginu.setBounds(605, 375, 190, 80);
        
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        loginu.setBounds(610, 380, 180, 70);
       
    }
});
      
 loginu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String Eusername = username.getText();
        String Epassword = new String(pass.getPassword());
        String hashedPassword = BCrypt.hashpw(Epassword, BCrypt.gensalt());
        
        try {
            Connect(); 
            
            pst = con.prepareStatement("SELECT * FROM usertbl WHERE user_un = ? AND user_pw = ?");
            pst.setString(1, Eusername);
            pst.setString(2, Epassword);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                String customerName = rs.getString("Customer_name");
                String meterNumber = rs.getString("Meter_Number");
                String address = rs.getString("Address");
                String mail = rs.getString("Email");
                String usernn = rs.getString("user_un");
                
               
                dispose();
                new UserAcc(customerName, meterNumber, address, mail, usernn);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
});
         
        
        
        
        JPanel whiteBoxPanel = new UserLog.RoundedPanel(30, 30);
        whiteBoxPanel.setBackground(Color.WHITE);
        whiteBoxPanel.setBounds(450, 50, 480, 450);
        whiteBoxPanel.setLayout(null); 
        add(whiteBoxPanel);
        
        image.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        dispose();
        new loginas();
        
    }
});
        setLayout(null);

        setSize(1000, 600);
        setLocation(500, 200);
        setVisible(true);
            
            
            
            
        }
        
        
        
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
        public static void main(String[] args){
        new UserLog();
        
    }
     }
        
        
    
    

