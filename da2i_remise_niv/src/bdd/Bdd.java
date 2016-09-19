/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bdd;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author cryl
 */
public class Bdd {
    Connection c = null;
    public Bdd(){
        try {
            Class.forName("org.postgresql.Driver");
            this.c = DriverManager
            .getConnection("jdbc:postgresql://meleze14:5432/bd_spaceinv",
            "bdd", "root");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    
}
