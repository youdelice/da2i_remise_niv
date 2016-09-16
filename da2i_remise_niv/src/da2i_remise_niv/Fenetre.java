/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lambertc
 */
public class Fenetre extends JFrame{
    public Fenetre(){
    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 400);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new Init());
    this.setBackground(Color.BLACK);
    this.setVisible(true);

    }
}
