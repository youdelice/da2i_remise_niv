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
    Vaisseau v = new Vaisseau(300,200);
    
  public void paintComponent(Graphics g){
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
    v.Bouger(v.co.x, v.co.y);
    v.GraphicVaisseau(g, v);
  }   
  
  public void Update(){
     
  }
  
}
