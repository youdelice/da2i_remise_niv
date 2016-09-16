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
public class Vaisseau extends Entite{

    public Vaisseau(int x, int y) {
        super.co = new Coordonne(x,y); 
    }

    public void setCo(Coordonne co) {
        this.co = co;
    }
    

    
    
    
}
