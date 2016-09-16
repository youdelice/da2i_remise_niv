/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lambertc
 */
public class Fenetre extends JFrame {
    Vaisseau v;
    public Fenetre(){
      this.setTitle("Ma première fenêtre Java");
    this.setSize(300, 600);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Jeu());
    this.setBackground(Color.BLACK);

    this.setVisible(true);

    }

    
    
    
}
