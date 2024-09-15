
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author My Computer
 */
public class compute extends JFrame implements ActionListener{
    private JButton btnCalculate;
    private JLabel lblUnits, lblTotalBill, lblkwh, lblkwhm, lblwatts;
    private JTextField txtWatts, txtName, txtAppl, txtHours;
    private JComboBox<String> appld;
    
    public compute(){
        super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
         ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/back.png"));
        Image i7 = i6.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(900, 400, 50, 190);
        add(image);
        
        image.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        dispose();
        new FrameWelcome();
    }
});

        
        JLabel lblname = new JLabel("Enter your name");
        lblname.setBounds(50, 17, 600, 110);
        Font boldFont = new Font("Century Gothic", Font.BOLD, 30);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(boldFont);
        add(lblname); 
        
        txtName = new JTextField();
        txtName.setFont(new Font("CEntury Gothic", Font.BOLD, 30));
        Color borderColor = new Color(255, 255, 255);
        txtName.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, borderColor)); 
        txtName.setOpaque(false); 
        txtName.setForeground(Color.WHITE);
        txtName.setHorizontalAlignment(JTextField.CENTER);
        txtName.setBounds(90, 100, 350, 60);
        add(txtName);
        
        JLabel lblwatts = new JLabel("Watts consumption");
        lblwatts.setBounds(50, 170, 600, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 30);
        lblwatts.setForeground(Color.WHITE);
        lblwatts.setFont(boldFont);
        add(lblwatts);
        
        txtWatts = new JTextField();
        txtWatts.setFont(new Font("CEntury Gothic", Font.BOLD, 30));
        borderColor = new Color(255, 255, 255);
        txtWatts.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, borderColor)); 
        txtWatts.setOpaque(false); 
        txtWatts.setForeground(new Color(255, 255, 255));
        txtWatts.setHorizontalAlignment(JTextField.CENTER);
        txtWatts.setBounds(90, 250, 350, 60);
        add(txtWatts);
        
        JLabel lblappl = new JLabel("Typical Appliance");
        lblappl.setBounds(500, 20, 600, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 25);
        lblappl.setForeground(Color.WHITE);
        lblappl.setFont(boldFont);
        add(lblappl);
        
        JLabel lblnote = new JLabel("<html>Note: These are typical wattages of appliances and <br>may not be accurate to your own appliances</html>");
        lblnote.setBounds(55, 290, 700, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 15);
        lblnote.setForeground(Color.WHITE);
        lblnote.setFont(boldFont);
        add(lblnote);
        

        
               
        String[] applianceOptions = {"Others", "Air Conditioner", "Clothes Dryer", "Clothes Iron", "Clothes Washer", "Electricfan", "Microwave Oven", "Desktop Computer",
            "Laptop Computer","Refrigerator", "Television"};
        appld = new JComboBox<>(applianceOptions);
        appld.setFont(new Font("Century Gothic", Font.BOLD, 20));
        borderColor = new Color(255, 255, 255);
        appld.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, borderColor));
        appld.setOpaque(false);
        appld.setForeground(new Color(255, 124, 16));
        appld.setBounds(540, 100, 350, 60);
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
        lblhours.setBounds(500, 170, 600, 100);
        boldFont = new Font("Century Gothic", Font.BOLD, 25);
        lblhours.setForeground(Color.WHITE);
        lblhours.setFont(boldFont);
        add(lblhours);
        
        txtHours = new JTextField();
        txtHours.setFont(new Font("CEntury Gothic", Font.BOLD, 30));
        borderColor = new Color(255, 255, 255);
        txtHours.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, borderColor)); 
        txtHours.setOpaque(false); 
        txtHours.setForeground(new Color(255, 255, 255));
        txtHours.setHorizontalAlignment(JTextField.CENTER);
        txtHours.setBounds(540, 250, 350, 60);
        add(txtHours);
       
       
        btnCalculate = new JButton("Calculate Bill");
        btnCalculate.setBounds(645, 460, 230, 60);
        boldFont = new Font("Century Gothic", Font.BOLD, 25);
        btnCalculate.setBackground(Color.WHITE);
        btnCalculate.setForeground(new Color(255, 124, 16));
        btnCalculate.setFont(boldFont);
        btnCalculate.setOpaque(true);
        add(btnCalculate);
        
        btnCalculate.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnCalculate.setBounds(640, 455, 240, 70);
        
        
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnCalculate.setBounds(645, 460, 230, 60);
       
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
        
    
        
        
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg2.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1020, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 0, 990, 600);
        add(bgLabel);
        
        
        
        
        
        
        setLayout(null);

        setSize(1000, 600);
        setLocation(500, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            
                String name = txtName.getText();
                double hours = Double.parseDouble(txtHours.getText());
          
                double watts = Double.parseDouble(txtWatts.getText());
                
             
                double kwhd = watts / 1000 * hours;
                double kwhm = kwhd * 30;
                double totalkwh = kwhd * 11.9112; 
                double totalBill = totalkwh * 30;

                ResultFrame resultFrame = new ResultFrame(name, kwhd, kwhm, totalBill,  watts);
                dispose();
                resultFrame.setVisible(true);
                
            
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        new compute();
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
    private JTextField txtWatts, txtName;
    public ResultFrame( String name, double kwhd, double kwhm, double totalBill, double watts){
        super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 255, 255);
        getContentPane().setBackground(customColor);
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(340, 120, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(0, 0, 360, 110);     
        add(logoLabel);
        
        
        JLabel lblwelc = new JLabel("HELLO ");
        lblwelc.setBounds(505, 30, 600, 100);
        Font boldFont = new Font("Century Gothic", Font.BOLD, 60);
        lblwelc.setForeground(new Color(255, 124, 16));
        lblwelc.setFont(boldFont);
        add(lblwelc);
        
        lblTotalBill = new JLabel();
        lblTotalBill.setBounds(480, 350, 500, 70);
        add(lblTotalBill);
        
        lblkwh = new JLabel();
        lblkwh.setBounds(550, 350, 500, 70);
        add(lblkwh);
        
        lblkwhm = new JLabel();
        lblkwhm.setBounds(550, 350, 500, 70);
        add(lblkwhm);
        
        JLabel lblName = new JLabel(name);
lblName.setBounds(510, 90, 500, 70);
boldFont = new Font("Century Gothic", Font.BOLD, 50);
lblName.setForeground(new Color(255, 124, 16));
lblName.setFont(boldFont);
add(lblName);

JLabel label = new JLabel("Here's your energy consumption cost");
label.setBounds(505, 130, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 16);
label.setForeground(new Color(255, 124, 16));
label.setFont(boldFont);
add(label);

JLabel Wday = new JLabel(watts + " watt-hours per day: ");
Wday.setBounds(490, 200, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 15);
Wday.setForeground(new Color(255, 124, 16));
Wday.setFont(boldFont);
add(Wday);

lblkwh.setText(String.format("% .2f", kwhd) + " kWh");
boldFont = new Font("Century Gothic", Font.BOLD, 35);
lblkwh.setForeground(new Color(255, 124, 16));
lblkwh.setFont(boldFont);
lblkwh.setBounds(520, 230, 500, 70);

JLabel Wmonth = new JLabel(watts + " watt-hours per month: ");
Wmonth.setBounds(490, 280, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 15);
Wmonth.setForeground(new Color(255, 124, 16));
Wmonth.setFont(boldFont);
add(Wmonth);

lblkwhm.setText(String.format("% .2f", kwhm) + " kWh");
boldFont = new Font("Century Gothic", Font.BOLD, 35);
lblkwhm.setForeground(new Color(255, 124, 16));
lblkwhm.setFont(boldFont);
lblkwhm.setBounds(520, 310, 500, 70);

JLabel TBill = new JLabel("Electricity bill per month");
TBill.setBounds(490, 380, 500, 70);
boldFont = new Font("Century Gothic", Font.PLAIN, 20);
TBill.setForeground(new Color(255, 124, 16));
TBill.setFont(boldFont);
add(TBill);

lblTotalBill.setText("Php " + String.format("%.2f", totalBill));
boldFont = new Font("Century Gothic", Font.BOLD, 50);
lblTotalBill.setForeground(new Color(255, 124, 16));
lblTotalBill.setFont(boldFont);
lblTotalBill.setBounds(550, 425, 500, 70);



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/slogo.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        JButton home = new JButton("Home", new ImageIcon(i5));
        boldFont = new Font("Century Gothic", Font.BOLD, 23);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 4);
        home.setBorder(border);   
        home.setOpaque(false); 
        home.setForeground(Color.WHITE);
        home.setBackground(new Color(0, 0, 0, 0)); 
        home.setBounds(40, 460, 150, 50);
        home.setFont(boldFont);
        add(home);
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FrameWelcome(); 
            }
        });
        
        JButton calagain = new JButton("Calculate Again");
        boldFont = new Font("Century Gothic", Font.BOLD, 23);
        border = BorderFactory.createLineBorder(Color.WHITE, 4);
        calagain.setBorder(border);   
        calagain.setOpaque(false); 
        calagain.setForeground(Color.WHITE);
        calagain.setBackground(new Color(0, 0, 0, 0)); 
        calagain.setBounds(230, 460, 230, 50);
        calagain.setFont(boldFont);
        add(calagain);
        calagain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new compute(); 
            }
        });


JPanel whiteBoxPanel = new ResultFrame.RoundedPanel(30, 30);
        whiteBoxPanel.setBackground(Color.WHITE);
        whiteBoxPanel.setBounds(470, 50, 470, 480);
        whiteBoxPanel.setLayout(null); 
        add(whiteBoxPanel);
        
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg2.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1020, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 0, 990, 600);
        add(bgLabel);

        
        
        setLayout(null);
        setSize(1000, 600);
        setLocation(500, 200);
        setVisible(true);
        
        
    }
    }
}
    
    
    

    

