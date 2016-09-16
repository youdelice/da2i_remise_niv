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
public abstract class Entite {
    
    public Coordonne co;
    
    public void Bouger(int x, int y,int z){
        if(z<150){
        this.co.x -= 10;
        }else
        this.co.x += 10;
      //  this.co.y += 10;
        
    }
    
    
}
