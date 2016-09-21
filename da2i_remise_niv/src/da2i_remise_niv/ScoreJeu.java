/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

import bdd.Bdd;
import bdd.Score;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 *
 * @author lambertc
 */
public class ScoreJeu extends JFrame {
    
    public ScoreJeu(){
    this.setTitle("SCORE");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        setVisible(true);
        affichScore();
    }
    
    public void affichScore() {
        try{
        Bdd dd = new Bdd();
        //Score s = new Score();
        dd.getAllScore();
        
        
        
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}
