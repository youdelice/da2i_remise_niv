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

    public void run() 
    {
        Point p = projectile.getLocation();
        p.y -= 15;

        while (projectile.getLocation().y > 10) 
        {
            p = projectile.getLocation();

            p.y -= 10;

            projectile.setLocation(p);
            
            for(List<Alien> alien : game.colonneAlien)
            {
                if(!alien.isEmpty())
                   colision(alien, alien.get(alien.size() - 1 ).getX(), alien.get(alien.size() - 1 ).getY());
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            projectile.removeProjectile();
    }

    public void colision(List<Alien> aliens, int coX, int coY) 
    {
        if ((projectile.getY() >= coY) && (projectile.getY() <= coY + 40)) 
        {
            if ((projectile.getX() >= coX) && (projectile.getX() <= coX + 40)) {
                System.out.println("touché ");

                this.game.getPanelGame().remove(aliens.get(aliens.size() - 1));
                this.game.aliensLigne.remove(aliens.get(aliens.size() - 1));

                aliens.remove(aliens.size() - 1);
                this.projectile.removeProjectile();

                try 
                {
                    projectile = null;
                    this.join();
                    
                } catch (Exception e) {

                }
            }
        }
    }
}
