/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package da2i_remise_niv;

import bdd.Bdd;
import bdd.Score;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
/**
 *
 * @author lambertc
 */
public class ScoreJeu extends JFrame {
    
    JPanel jp;
    JLabel jl;
    JList list, list2;
    public ScoreJeu(){
    this.setTitle("SCORE");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
                
        setVisible(true);
         affichScore();
    }
    
    public void affichScore() {
        try{
            Bdd dd = new Bdd();

            List<Score> liste = dd.getAllScore();
            System.out.println(liste.size());
            String[] nomJoueur = new String[liste.size()];
            String[] scoreJoueur = new String[liste.size()];
            System.out.println(liste.get(0).getScore());
            
            for(int i = 0; i<nomJoueur.length; i++)
                nomJoueur[i] = liste.get(i).getPseudo();
            list = new JList(nomJoueur);
            list.setSize(200,500);
            list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            list.setLayoutOrientation(JList.VERTICAL);
            list.setVisibleRowCount(-1);
            
            JScrollPane listScroller = new JScrollPane(list);
            listScroller.setSize(200, 500);
            listScroller.setLocation(0, 0);
            this.getContentPane().add(listScroller);
            
            for(int i = 0; i<scoreJoueur.length; i++)
                scoreJoueur[i] = String.valueOf(liste.get(i).getScore());
            list2 = new JList(scoreJoueur);
            list2.setSize(200,500);
            list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            list2.setLayoutOrientation(JList.VERTICAL);
            list2.setVisibleRowCount(-1);
            
            JScrollPane listScroller2 = new JScrollPane(list2);
            listScroller2.setSize(200, 500);
            listScroller2.setLocation(200, 0);
            this.getContentPane().add(listScroller2);
            
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
