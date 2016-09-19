package da2i_remise_niv;

import java.awt.Point;
import java.util.List;

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

        while (projectile.getLocation().y > 10) {
            p = projectile.getLocation();

            p.y -= 10;

            projectile.setLocation(p);

            for (List<Alien> aliens : game.colonneAlien) {
                if (!aliens.isEmpty()) {
                    for (Alien alien : aliens) {
                           colision(aliens, alien.getX(), alien.getY(), alien);
                    }
                }

                
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

                this.game.getPanelGame().remove(alien);
                this.game.aliensLigne.remove(alien);
                aliens.remove(alien);
                
                this.projectile.removeProjectile();

                try {
                    this.game.setScore(this.game.getScore() + 5);
                    this.game.lb_score.setText("Score : " + this.game.getScore());
                    System.out.println(this.game.getScore());
                    projectile = null;
                    this.join();

                } catch (Exception e) {
                }
            }
        }
    }
}
