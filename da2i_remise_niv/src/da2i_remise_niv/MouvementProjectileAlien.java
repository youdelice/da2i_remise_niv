package da2i_remise_niv;

import java.awt.Point;
import javax.swing.JOptionPane;

public class MouvementProjectileAlien extends Thread {

    private Game fenetre;
    private Projectile projectile;

    public MouvementProjectileAlien(Projectile projectile, Game fenetre) {
        this.fenetre = fenetre;
        this.projectile = projectile;
    }

    @Override
    public void run() {
        while ((projectile.getLocation().y < fenetre.getPanelGame().getHeight() - projectile.getHeight() - 10) && fenetre.isEnCours) {
            try {
                Point p = projectile.getLocation();

                p.y += 10;

                projectile.setLocation(p);
                colision();

                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("MouvementProjectileAlien : " + e.getMessage());
            }
        }

        projectile.removeProjectile();
    }

    public void colision() {
        try {
            if ((projectile.getY() >= fenetre.vaisseau.getY()) && (projectile.getY() <= fenetre.vaisseau.getY() + fenetre.vaisseau.getHeight())) {
                if ((projectile.getX() >= fenetre.vaisseau.getX()) && (projectile.getX() <= fenetre.vaisseau.getX() + fenetre.vaisseau.getWidth())) {
                    System.out.println("touché ");

                    this.projectile.removeProjectile();
                    fenetre.gameOver();

                    projectile = null;
                    this.join();

                }
            }
        } catch (Exception e) {
            System.out.println("MouvementProjectileAlien colision : " + e.getMessage());
        }
    }
}
