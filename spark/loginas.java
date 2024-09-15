/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author My Computer
 */
public class loginas extends JFrame {
    
    
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
    
    public loginas(){
        super("ELECTRICITY BILLING SYSTEM");
        Color customColor = new Color(255, 124, 16);
        getContentPane().setBackground(customColor);
        
        
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/back.png"));
        Image i7 = i6.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image = new JLabel(i8);
        image.setBounds(800, 400, 250, 190);
        add(image);
        
        image.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        new FrameWelcome();
    }
});
        
        JLabel welcomeLabel = new JLabel("LOGIN AS");
        welcomeLabel.setForeground(customColor);
        Font labelFont = new Font("Century Gothic", Font.BOLD, 50);
        welcomeLabel.setFont(labelFont);
        welcomeLabel.setBounds(380, 100, 400, 90); 
        add(welcomeLabel);
        
        JButton admin = new JButton("ADMIN");
        Font buttonFont = new Font("Century Gothic", Font.BOLD, 30);
        Border buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        admin.setBorder(buttonBorder);
        admin.setForeground(customColor);
        admin.setBackground(Color.WHITE);
        admin.setBounds(360, 230, 270, 80); 
        admin.setFont(buttonFont);
        add(admin);
        
        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          dispose();
                new AdminLog(); 
            }
        });
        
        admin.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        admin.setBackground(Color.decode("#FF7C10"));
        admin.setForeground(Color.WHITE);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        admin.setBackground(Color.WHITE);
        admin.setForeground(customColor);
    }
});
        
        
        JButton user = new JButton("USER");
        buttonFont = new Font("Century Gothic", Font.BOLD, 30);
        buttonBorder = BorderFactory.createLineBorder(customColor, 4);
        user.setBorder(buttonBorder);
        user.setForeground(customColor);
        user.setBackground(Color.WHITE);
        user.setBounds(360, 330, 270, 80); 
        user.setFont(buttonFont);
        add(user);
        
        user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          dispose();
                new UserLog(); 
            }
        });
        
         user.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        user.setBackground(Color.decode("#FF7C10"));
        user.setForeground(Color.WHITE);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        user.setBackground(Color.WHITE);
        user.setForeground(customColor);
    }
});
        
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Slogo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(0, 7, 120, 100);     
        add(logoLabel);
        
        JPanel whiteBoxPanel = new RoundedPanel(30, 30);
        whiteBoxPanel.setBackground(Color.WHITE);
        whiteBoxPanel.setBounds(260, 50, 480, 450);
        whiteBoxPanel.setLayout(null); 
        add(whiteBoxPanel);
        
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bg.png"));
        Image bgImage = bgIcon.getImage().getScaledInstance(1020, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledBgIcon = new ImageIcon(bgImage);
        JLabel bgLabel = new JLabel(scaledBgIcon);
        bgLabel.setBounds(0, 110, 990, 600);
        add(bgLabel);
        
        setLayout(null);

        setSize(1000, 600);
        setLocation(500, 200);
        setVisible(true);
        
    }
    public static void main(String[] args){
        new loginas();
        
    }
    
}
