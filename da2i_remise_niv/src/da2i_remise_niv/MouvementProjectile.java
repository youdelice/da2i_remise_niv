package da2i_remise_niv;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MouvementProjectile extends Thread {

    private Projectile projectile;
    private Game game;

    public MouvementProjectile(Projectile p, Game game) {
        this.projectile = p;
        this.game = game;
    }

    public void run() {
        Point p = projectile.getLocation();
        p.y -= 15;

        while (projectile.getLocation().y > 10 && game.isEnCours) {
            p = projectile.getLocation();

            p.y -= 10;

            projectile.setLocation(p);

            List<Integer> indexVide = new ArrayList<Integer>();
            
            for (List<Alien> aliens : game.colonneAlien) 
            {
                    for (Alien alien : aliens) {
                        colision(aliens, alien.getX(), alien.getY(), alien);
                    }
                    
                    if(aliens.isEmpty())
                            indexVide.add(game.colonneAlien.indexOf(aliens));
            }

            for(int i : indexVide)
                game.colonneAlien.remove(i);
            
            if(game.colonneAlien.isEmpty())
            {
                game.stopJeu();
                JOptionPane.showMessageDialog(null, "GG");
            }
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        projectile.removeProjectile();
    }

    public void colision(List<Alien> aliens, int coX, int coY, Alien alien) {
        if ((projectile.getY() >= coY) && (projectile.getY() <= coY + 40)) {
            if ((projectile.getX() >= coX) && (projectile.getX() <= coX + 40)) {
                System.out.println("touché ");
                   
                this.game.aliensLigne.remove(alien);
                this.game.getPanelGame().remove(alien);
                aliens.remove(alien);

                this.projectile.removeProjectile();

                try {
                    this.game.setScore(this.game.getScore() + 5);
                    this.game.lb_score.setText("Score : " + this.game.getScore());
                   // System.out.println(this.game.getScore());
                    projectile = null;
                    this.join();

                } catch (Exception e) {
                    System.out.println("MouvementProjectile colision : " + e.getMessage());
                }
            }
        }
    }
}
