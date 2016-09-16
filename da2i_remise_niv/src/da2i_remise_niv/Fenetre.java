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
 * @author santc
 */
public class Fenetre extends JFrame{

    public Fenetre(){
	this.setTitle("fenetre");
	this.setSize(400,500);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panneau());
	JPanel pan = new JPanel();
	pan.setBackground(Color.WHITE);
	this.setContentPane(pan);
	this.setVisible(true);
    }
}
