/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author lambertc
 */

public class Jeu extends JPanel {
    Vaisseau v = new Vaisseau(150, 550);
    public void paintComponent(Graphics g){
        this.setBackground(Color.BLACK);
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        super.paintComponent(g);
        paintVaisseau(v, g);
        System.out.println("test");
        ajouterListeners();
  }   
    
    public void paintEnnemie(Ennemi e, Graphics g){
        g.setColor(Color.red);
        g.fillRect(e.co.x,e.co.y, 20, 20);
    }
    
     public void paintVaisseau(Vaisseau v, Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(v.co.x,v.co.y, 20, 20);
    }
     
     public void ajouterListeners(){
         addMouseListener(new MouseAdapter() {

             /*@Override
             public void mouseClicked(MouseEvent e) {
                 System.out.println(v.co.x +" "+ v.co.y);
                v.Bouger(v.co.x, v.co.y,e.getX()); 
                repaint();
             }*/
             
             public void mousePressed(MouseEvent e){
                System.out.println(v.co.x +" "+ v.co.y);
                v.Bouger(v.co.x, v.co.y,e.getX()); 
                repaint();
             }
             
    });
     }
     
}
