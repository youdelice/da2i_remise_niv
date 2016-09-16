/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

/**
 *
 * @author lambertc
 */
    import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Init extends JPanel { 
  public void paintComponent(Graphics g){
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
    System.out.println("Je suis exécutée !"); 
    Vaisseau v = new Vaisseau(300,200);
    Ennemi e = new Ennemi(150,100);
    v.GraphicVaisseau(g, v);
    e.GraphicEnnemi(g, e);
  }   
}
