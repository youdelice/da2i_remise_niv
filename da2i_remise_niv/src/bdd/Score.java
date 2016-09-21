/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bdd;

import java.util.Date;

/**
 *
 * @author cryl
 */
public class Score {
    int id;
    String pseudo;
    int score;
    String dateDone;

    public Score() {
    }

    public Score(int id, String pseudo, int score, String dateDone) {
        this.id = id;
        this.pseudo = pseudo;
        this.score = score;
        this.dateDone = dateDone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDateDone() {
        return dateDone;
    }

    public void setDateDone(String dateDone) {
        this.dateDone = dateDone;
    }
    
}
