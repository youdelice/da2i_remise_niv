/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lambertc
 */
public class Ennemi extends Entite{

    public Ennemi(int x, int y){
        super.co=new Coordonne(x,y);
    }
    
    public void GraphicEnnemi(Graphics g,Ennemi e){
        g.setColor(Color.red);
        g.fillRect(e.co.x, e.co.y,20, 20);
    }
}
