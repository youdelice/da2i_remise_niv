package da2i_remise_niv;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author lambertc
 */
public class Menu extends JFrame {
    
    public JLabel pImage;
    public JPanel panel1;
    public JPanel panel2;
    public JButton bouton1;
    public JButton bouton2;
    public JButton bt_difficulter;


    public Menu()  
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 700);
        panel1 = new JPanel();
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("Ressources/SIArcadeCabImage.jpg"));
        pImage = new JLabel(image);
        panel1.add(pImage);
        this.getContentPane().add(pImage, BorderLayout.CENTER);
        
        bouton1 = new JButton("Game");
        bouton2 = new JButton("Score");
        bt_difficulter = new JButton("Difficulter");
        
        this.getContentPane().add(bouton1, BorderLayout.NORTH);
        this.getContentPane().add(bouton2, BorderLayout.SOUTH);

        
        this.setVisible(true);
        
        bouton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                setVisible(false);
                Game frame = new Game();
                
                frame.setVisible(true);
            }
        });
        bouton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Score frame = new Score();
                
                //frame.setVisible(true);
            }
        });
        bt_difficulter.addActionListener(new ActionListener () {
            
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                   
            }
        });
    
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    Menu menu = new Menu();
                    //Game frame = new Game();
                    menu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
}
