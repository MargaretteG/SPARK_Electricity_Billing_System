package spark;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import spark.compute;
import spark.loginas;

public class FrameWelcome extends JFrame {
    
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
    
    FrameWelcome() {
        super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        JLabel welcomeLabel = new JLabel("WELCOME");
        welcomeLabel.setForeground(customColor);
        Font labelFont = new Font("Century Gothic", Font.BOLD, 70);
        welcomeLabel.setFont(labelFont);
        welcomeLabel.setBounds(520, 100, 400, 90); 
        add(welcomeLabel);
        
        JButton login = new JButton("LOGIN");
        Font buttonFont = new Font("Century Gothic", Font.BOLD, 30);
        Border buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        login.setBorder(buttonBorder);
        login.setForeground(customColor);
        login.setBackground(Color.WHITE);
        login.setBounds(560, 230, 270, 80); 
        login.setFont(buttonFont);
        add(login);
        
        login.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        login.setBackground(Color.decode("#FF7C10"));
        login.setForeground(Color.WHITE);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        login.setBackground(Color.WHITE);
        login.setForeground(customColor);
    }
});
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          dispose();
                new loginas(); 
            }
        });
        
        JButton comp = new JButton("COMPUTE NOW");
        buttonFont = new Font("Century Gothic", Font.BOLD, 30);
        buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        comp.setBorder(buttonBorder);
        comp.setForeground(customColor);
        comp.setBackground(Color.WHITE);
        comp.setBounds(560, 330, 270, 80); 
        comp.setFont(buttonFont);
        add(comp);
        
        comp.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        comp.setBackground(Color.decode("#FF7C10"));
        comp.setForeground(Color.WHITE);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        comp.setBackground(Color.WHITE);
        comp.setForeground(customColor);
    }
});
        
        comp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          dispose();
                new compute(); 
            }
        });

        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(340, 120, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(0, 0, 360, 110);     
        add(logoLabel);
        
        JPanel whiteBoxPanel = new RoundedPanel(30, 30);
        whiteBoxPanel.setBackground(Color.WHITE);
        whiteBoxPanel.setBounds(450, 50, 480, 450);
        whiteBoxPanel.setLayout(null); 
        add(whiteBoxPanel);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1020, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 120, 990, 600);
        add(bgLabel);

        setLayout(null);
        setSize(1000, 600);
        setLocation(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameWelcome();
    }
}
    


