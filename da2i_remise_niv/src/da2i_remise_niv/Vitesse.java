/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

/**
 *
 * @author santc
 */
public enum Vitesse {
    DEBUTANT(100, 50), NOVICE(75, 30), MAITRE(50, 20);
    
    private int vitesse, projectiles;  
      
     private Vitesse(int v, int p) {  
         this.vitesse = v;
         this.projectiles = p;  
    }  
      
     public int getVitesse() {  
         return this.vitesse;  
    }  

    public int getProjectiles() {
        return projectiles;
    }
     
}
