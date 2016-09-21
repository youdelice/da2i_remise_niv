/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bdd;
import bdd.Score;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author cryl
 */
public class Bdd {
    private Connection c = null;
    public Bdd(){
        try {
            Class.forName("org.postgresql.Driver");
            this.c = DriverManager
            .getConnection("jdbc:postgresql://meleze24:5432/bd_spaceinv",
            "bdd", "root");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    public int getLastId() throws SQLException{
        int retun = 0;
        Statement req = c.createStatement();
        ResultSet rs = req.executeQuery("SELECT max(id) FROM SCORE;");
        while( rs.next()){
            retun = rs.getInt("id");
        }
        return retun;
    }
    public void addScore(String pseudo, int score, String dateDone) {
        try{
            int id = 0;
        Statement req = c.createStatement();
        ResultSet rs = req.executeQuery("SELECT max(id) as id FROM SCORE");
        int idmax = 0;
        while( rs.next()){
            idmax = rs.getInt("id");
        }
        rs.close();
        req.close();
        id = idmax + 1;
        Statement stmt = c.createStatement();
        //String dat = dateDone.getYear()+"-"+dateDone.getMonth()+"-"+dateDone.getDay();
        stmt.executeUpdate("INSERT INTO score(id, pseudo, score, datedone) values("+id+",'"+pseudo+"',"+score+",'"+dateDone+"')");
        stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public Score getBestScore() throws SQLException{
        Score ret = null;
        Statement req = c.createStatement();
        ResultSet rs = req.executeQuery("SELECT id, pseudo, score, dateDone FROM score WHERE score IN (SELECT max(score) FROM score) AND dateDone IN (SELECT min(dateDone) FROM score WHERE score IN (SELECT max(score) FROM score)) AND id IN (SELECT min(id) FROM score WHERE score IN (SELECT max(score) FROM score));");
        while(rs.next()){
            int id = rs.getInt("id");
            String pseudo = rs.getString("pseudo");
            int score = rs.getInt("score");
            String dateDone = rs.getString("dateDone");
            //String[] dateTps = dateTp.split("-");
           // Date dateDone = new Date(Integer.getInteger(dateTps[0]),Integer.getInteger(dateTps[1]),Integer.getInteger(dateTps[2]));
            ret = new Score(id,pseudo,score,dateDone);
        }
        return ret;
    }
    public List<String> getAllScore() throws SQLException{
        List<String> ret = new ArrayList();
        Statement req = c.createStatement();
        ResultSet rs = req.executeQuery("SELECT DISTINCT(pseudo) FROM score WHERE id > 0;");
        while(rs.next()){
            ret.add(rs.getString("pseudo"));
        }
        return ret;
    }
    
    public List<String> getScore(String pseudo) throws SQLException{
        List<String> ret = new ArrayList();
        Statement req = c.createStatement(); // select score from score where pseudo = 'test 1' Order By score ASC
        ResultSet rs = req.executeQuery("select score from score where pseudo = '"+ pseudo + "' Order By score DESC");
        while(rs.next()){
            ret.add(rs.getString("score"));
        }
        return ret;
    }
    
}
