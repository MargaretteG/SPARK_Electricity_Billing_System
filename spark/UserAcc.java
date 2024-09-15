
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

public class UserAcc extends JFrame {
    private String customerName, meterNumber, address, mail, usernn;

    

    
    
    
    public void Connect() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sparkdb", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  
    public UserAcc(String customerName, String meterNumber, String address, String mail, String usernn){
        
        
         super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        this.customerName = customerName;
        this.meterNumber = meterNumber;
        this.address = address;
        this.mail = mail;
        this.usernn = usernn;
        
       
        
        
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("BILL CALCULATOR");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(40, 40, 200, 30); 
        add(calcu);
        
        calcu.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        UserAcc.this.new Calculate();
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
        
         binfo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        UserAcc.this.new BillIn(customerName);
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
        UserAcc.this.new Profile();
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
        String customerName = "";
        String meterNumber = "";
        String address = "";
        String mail = "";
        String usernn = "";
            
        new UserAcc(customerName, meterNumber, address, mail, usernn);
    }
    
    class Profile extends JFrame{
    public Profile(){
          
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("BILL CALCULATOR");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(40, 40, 200, 30); 
        add(calcu);
        
         calcu.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        UserAcc.this.new Calculate();
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
        
         binfo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        UserAcc.this.new BillIn(customerName);
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
        
        JLabel h = new JLabel("<html><span>Welcome to your</span><br><span style='font-weight:bold'>SPARK PROFILE</span></html>");
        h.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 35);
        h.setFont(labelFont);
        h.setBounds(30, 120, 520, 100); 
        add(h);
        
        JLabel namelbl = new JLabel(customerName);
        namelbl.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.BOLD, 40);
        namelbl.setFont(labelFont);
        namelbl.setBounds(520, 190, 500, 100); 
        add(namelbl);
        
        
        JLabel meter = new JLabel("Meter Number: " + meterNumber);
        meter.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        meter.setFont(labelFont);
        meter.setBounds(520, 270, 500, 100); 
        add(meter);
        
        JLabel add = new JLabel("Address: " + address);
        add.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        add.setFont(labelFont);
        add.setBounds(520, 310, 500, 100); 
        add(add);
        
        JLabel eml = new JLabel("Email: " + mail);
        eml.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        eml.setFont(labelFont);
        eml.setBounds(520, 350, 500, 100); 
        add(eml);
        
        JLabel unname = new JLabel("Username: " + usernn);
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
        
        ImageIcon usericon = new ImageIcon(ClassLoader.getSystemResource("icon/iconprof.png"));
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
    }
    
    class BillIn extends JFrame{
        
        private JLabel namelbl, meter, bill, month,  kwh, stat, cost;
        private JTable table;
        private String customerName;
        
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

            String query = "SELECT * FROM billtbl WHERE Customer_Name = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, customerName);
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
        
        public BillIn(String customerName){
            this.customerName = customerName;
            
            
            
            
            
             
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
        
        
        
        JLabel calcu = new JLabel("BILL CALCULATOR");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.PLAIN, 18);
        calcu.setFont(labelFont);
        calcu.setBounds(40, 40, 200, 30); 
        add(calcu);
        
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
         labelFont = new Font("Century Gothic", Font.BOLD, 27);
        binfo.setFont(labelFont);
        binfo.setBounds(250, 40, 300, 30); 
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
        UserAcc.this.new Profile();
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
        
        JLabel h = new JLabel("<html><span>Hello</span><br><span>Here is your </span><span style='font-weight:bold'>BILL INFORMATION </span></html>");
        h.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 35);
        h.setFont(labelFont);
        h.setBounds(30, 120, 700, 100); 
        add(h);
        
         namelbl = new JLabel(customerName);
        namelbl.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.BOLD, 35);
        namelbl.setFont(labelFont);
        namelbl.setBounds(120, 100, 700, 100); 
        add(namelbl);
        
        
          bill = new JLabel("Bill Number");
        bill.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        bill.setFont(labelFont);
        bill.setBounds(670, 170, 500, 100); 
        add(bill);
        
         meter = new JLabel("Meter Number:");
        meter.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        meter.setFont(labelFont);
        meter.setBounds(670, 210, 500, 100); 
        add(meter);
        
         month = new JLabel("Month:");
        month.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        month.setFont(labelFont);
        month.setBounds(670, 250, 500, 100); 
        add(month);
        
         stat = new JLabel("Status:");
        stat.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        stat.setFont(labelFont);
        stat.setBounds(670, 290, 500, 100); 
        add(stat);
        
         kwh = new JLabel("Total Kwh:");
        kwh.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        kwh.setFont(labelFont);
        kwh.setBounds(670, 370, 500, 100); 
        add(kwh);
        
         cost = new JLabel("Total Cost:");
        cost.setForeground(customColor);
         labelFont = new Font("Century Gothic", Font.PLAIN, 30);
        cost.setFont(labelFont);
        cost.setBounds(670, 410, 500, 100); 
        add(cost);
        
         table = new JTable(getDataFromDatabase());
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(10, 230, 600, 400);
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
                Object billId = table.getValueAt(selectedRow, 0); // Assuming bill_id is in the first column
                Object customerName = table.getValueAt(selectedRow, 1);
                Object meterNumber = table.getValueAt(selectedRow, 2);
                Object totalKwh = table.getValueAt(selectedRow, 3);
                Object totalCost = table.getValueAt(selectedRow, 4);
                Object monthd = table.getValueAt(selectedRow, 5);
                Object status = table.getValueAt(selectedRow, 6);

                // Update labels with the selected data
                bill.setText("<html><span>Bill Number: </span><span style='font-weight:bold'>" + billId + "</span></html>");
                namelbl.setText(customerName != null ? customerName.toString() : "");
                meter.setText("<html><span>Meter Number: </span><span style='font-weight:bold'>" + meterNumber + "</span></html>");
                month.setText("<html><span>Month: </span><span style='font-weight:bold'>" + monthd + "</span></html>");
                stat.setText("<html><span>Status: </span><span style='font-weight:bold'>" + status + "</span></html>");
                kwh.setText("<html><span>Total Kwh: </span><span style='font-weight:bold'>" + totalKwh + " kwh</span></html>");
                cost.setText("<html><span>Total Cost: </span><span style='font-weight:bold'>Php " + totalCost + "</span></html>");
            }
        }
    }
});

        
    
        
        
        JPanel obox = new JPanel();
        Border buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        obox.setBorder(buttonBorder);
        obox.setBackground(Color.WHITE);
        obox.setBounds(10, 230, 600, 400);
        obox.setLayout(null); 
        add(obox);
        
        JPanel obox2 = new JPanel();
        buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        obox2.setBorder(buttonBorder);
        obox2.setBackground(Color.WHITE);
        obox2.setBounds(620, 140, 450, 490);
        obox2.setLayout(null); 
        add(obox2);
        
        
        
        
        
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
        
    }
    class Calculate extends JFrame implements ActionListener{
     private JButton btnCalculate;
    private JLabel lblUnits, lblTotalBill, lblkwh, lblkwhm, lblwatts;
    private JTextField txtWatts, txtAppl, txtHours;
    private JComboBox<String> appld;
    
         
    
    public Calculate(){
        
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        
        
        
        
        JLabel calcu = new JLabel("BILL CALCULATOR");
        calcu.setForeground(Color.WHITE);
        Font labelFont = new Font("Century Gothic", Font.BOLD, 23);
        calcu.setFont(labelFont);
        calcu.setBounds(40, 40, 200, 30); 
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
        UserAcc.this.new BillIn(customerName);
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
        UserAcc.this.new Profile();
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
        
        
        
       
        
        JLabel lblwatts = new JLabel("Watts consumption");
        lblwatts.setBounds(90, 210, 600, 100);
        Font boldFont = new Font("Century Gothic", Font.BOLD, 25);
        lblwatts.setForeground(Color.WHITE);
        lblwatts.setFont(boldFont);
        add(lblwatts);
        
        txtWatts = new JTextField();
        txtWatts.setFont(new Font("CEntury Gothic", Font.BOLD, 30));
        Color borderColor = new Color(255, 255, 255);
        txtWatts.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, borderColor)); 
        txtWatts.setOpaque(false); 
        txtWatts.setForeground(Color.WHITE);
        txtWatts.setHorizontalAlignment(JTextField.CENTER);
        txtWatts.setBounds(130, 290, 350, 60);
        add(txtWatts);
        
        JLabel lblappl = new JLabel("Typical Appliance");
        lblappl.setBounds(560, 150, 600, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 25);
        lblappl.setForeground(Color.WHITE);
        lblappl.setFont(boldFont);
        add(lblappl);
        
        JLabel lblnote = new JLabel("<html>Note: These are typical wattages of appliances and <br>may not be accurate to your own appliances</html>");
        lblnote.setBounds(95, 330, 700, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 15);
        lblnote.setForeground(Color.WHITE);
        lblnote.setFont(boldFont);
        add(lblnote);
        

        
               
        String[] applianceOptions = {"Others", "Air Conditioner", "Clothes Dryer", "Clothes Iron", "Clothes Washer", "Electricfan", "Microwave Oven", "Desktop Computer",
            "Laptop Computer","Refrigerator", "Television"};
        appld = new JComboBox<>(applianceOptions);
        appld.setFont(new Font("Century Gothic", Font.BOLD, 20));
        borderColor = new Color(255, 255, 255);
        appld.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, borderColor));
        appld.setOpaque(false);
        appld.setForeground(new Color(255, 124, 16));
        appld.setBounds(600, 230, 350, 60);
        add(appld);
              
       appld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) appld.getSelectedItem();
                if ("Others".equals(selectedOption)) {      
                    txtWatts.setEditable(true);
                    txtWatts.setText("");  
                } else {
                    txtWatts.setEditable(false);
                    switch (selectedOption) {
                        case "Air Conditioner":
                            txtWatts.setText("500"); 
                            break;
                        case "Clothes Dryer":
                            txtWatts.setText("500"); 
                            break;
                        case "Clothes Iron":
                            txtWatts.setText("700"); 
                            break;
                        case "Electricfan":
                            txtWatts.setText("70"); 
                            break;
                        case "Microwave Oven":
                            txtWatts.setText("800"); 
                            break;
                        case "Desktop Computer":
                            txtWatts.setText("100"); 
                            break;
                        case "Laptop Computer":
                            txtWatts.setText("50"); 
                            break;
                        case "Refrigerator":
                            txtWatts.setText("200"); 
                            break;
                        case "Clothes Washer":
                            txtWatts.setText("350"); 
                            break;
                        case "Television":
                            txtWatts.setText("70"); 
                            break;
                    }
                }
            }
        });
        
       JLabel lblhours = new JLabel("Hours use per day");
        lblhours.setBounds(560, 300, 600, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 25);
        lblhours.setForeground(Color.WHITE);
        lblhours.setFont(boldFont);
        add(lblhours);
        
        txtHours = new JTextField();
        txtHours.setFont(new Font("CEntury Gothic", Font.BOLD, 30));
        borderColor = new Color(255, 255, 255);
        txtHours.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, borderColor)); 
        txtHours.setOpaque(false); 
        txtHours.setForeground(Color.WHITE);
        txtHours.setHorizontalAlignment(JTextField.CENTER);
        txtHours.setBounds(600, 380, 350, 60);
        add(txtHours);
       
       
        btnCalculate = new JButton("Calculate Bill");
        btnCalculate.setBounds(745, 570, 230, 60);
        boldFont = new Font("Century Gothic", Font.BOLD, 25);
        btnCalculate.setBackground(Color.WHITE);
        btnCalculate.setForeground(new Color(255, 124, 16));
        btnCalculate.setFont(boldFont);
        btnCalculate.setOpaque(true);
        add(btnCalculate);  
        
        btnCalculate.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnCalculate.setBounds(740, 565, 240, 70);
        
        
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnCalculate.setBounds(745, 570, 230, 60);
       
    }
});
  
         btnCalculate.addActionListener(this);
        
        
        lblwatts = new JLabel();
         lblwatts.setBounds(480, 350, 500, 70);
        add(lblwatts);
        
        lblTotalBill = new JLabel();
        lblTotalBill.setBounds(480, 350, 500, 70);
        add(lblTotalBill);
        
        lblkwh = new JLabel();
        lblkwh.setBounds(550, 350, 500, 70);
        add(lblkwh);
        
        lblkwhm = new JLabel();
        lblkwhm.setBounds(550, 350, 500, 70);
        add(lblkwhm);
          
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(490, 7, 120, 100);     
        add(logoLabel);
        
         ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg2.png"));
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
    
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            
                
                double hours = Double.parseDouble(txtHours.getText());
          
                double watts = Double.parseDouble(txtWatts.getText());
                
             
                double kwhd = watts / 1000 * hours;
                double kwhm = kwhd * 30;
                double totalkwh = kwhd * 11.9112; 
                double totalBill = totalkwh * 30;

                ResultFrame resultFrame = new ResultFrame( kwhd, kwhm, totalBill,  watts);
                resultFrame.setVisible(true);
                
            
        }
       
    }
        
    
    
    class ResultFrame extends JFrame{
        
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
        
    private JLabel lblUnits, lblTotalBill, lblkwh, lblkwhm;
    private JTextField txtWatts;
    public ResultFrame(double kwhd, double kwhm, double totalBill, double watts){
        super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 255, 255);
        getContentPane().setBackground(customColor);
        
        
        
        
       
        
        lblTotalBill = new JLabel();
        lblTotalBill.setBounds(480, 350, 500, 70);
        add(lblTotalBill);
        
        lblkwh = new JLabel();
        lblkwh.setBounds(550, 350, 500, 70);
        add(lblkwh);
        
        lblkwhm = new JLabel();
        lblkwhm.setBounds(550, 350, 500, 70);
        add(lblkwhm);
        
        

JLabel label = new JLabel("Here's your energy consumption cost");
label.setBounds(60, 50, 900, 70);
Font boldFont = new Font("Century Gothic", Font.PLAIN, 35);
label.setForeground(new Color(255, 124, 16));
label.setFont(boldFont);
add(label);

JLabel Wday = new JLabel(watts + " watt-hours per day: ");
Wday.setBounds(100, 100, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 20);
Wday.setForeground(new Color(255, 124, 16));
Wday.setFont(boldFont);
add(Wday);

lblkwh.setText(String.format("% .2f", kwhd) + " kWh");
boldFont = new Font("Century Gothic", Font.BOLD, 35);
lblkwh.setForeground(new Color(255, 124, 16));
lblkwh.setFont(boldFont);
lblkwh.setBounds(150, 150, 500, 70);

JLabel Wmonth = new JLabel(watts + " watt-hours per month: ");
Wmonth.setBounds(100, 200, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 20);
Wmonth.setForeground(new Color(255, 124, 16));
Wmonth.setFont(boldFont);
add(Wmonth);

lblkwhm.setText(String.format("% .2f", kwhm) + " kWh");
boldFont = new Font("Century Gothic", Font.BOLD, 35);
lblkwhm.setForeground(new Color(255, 124, 16));
lblkwhm.setFont(boldFont);
lblkwhm.setBounds(150, 250, 500, 70);

JLabel TBill = new JLabel("Electricity bill per month:");
TBill.setBounds(460, 150, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 20);
TBill.setForeground(new Color(255, 124, 16));
TBill.setFont(boldFont);
add(TBill);

lblTotalBill.setText("Php " + String.format("%.2f", totalBill));
boldFont = new Font("Century Gothic", Font.BOLD, 50);
lblTotalBill.setForeground(new Color(255, 124, 16));
lblTotalBill.setFont(boldFont);
lblTotalBill.setBounds(510, 200, 500, 70);


JPanel whiteBoxPanel = new ResultFrame.RoundedPanel(30, 30);
        whiteBoxPanel.setBackground(Color.WHITE);
        whiteBoxPanel.setBounds(50, 50, 780, 350);
        whiteBoxPanel.setLayout(null); 
        add(whiteBoxPanel);
        
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg2.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1020, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 0, 990, 600);
        add(bgLabel);
        
        setLayout(null);
        setSize(900, 500);
        setLocation(500, 330);
        setVisible(true);
        
    }
    }
    }
    
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
        }
                


    
    


