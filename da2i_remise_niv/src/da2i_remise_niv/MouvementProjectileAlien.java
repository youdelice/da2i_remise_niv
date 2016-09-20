package da2i_remise_niv;

import java.awt.Point;
import javax.swing.JOptionPane;

public class MouvementProjectileAlien extends Thread
{
    private Game fenetre;
    private Projectile projectile;
    
    public MouvementProjectileAlien(Projectile projectile, Game fenetre)
    {
        this.fenetre = fenetre;
        this.projectile = projectile;
    }
    
    @Override
    public void run()
    {
        while((projectile.getLocation().y < fenetre.getPanelGame().getHeight() - projectile.getHeight() - 10) && fenetre.isEnCours)
        {
            Point p = projectile.getLocation();
            
            p.y += 10;
            
            projectile.setLocation(p);
            colision();
            try
            {
                Thread.sleep(50);
            }catch(Exception e)
            {
                System.out.println("mv proj alien " + e.getMessage());
            }
        }
        
        projectile.removeProjectile();
    }
    
    public void colision()
    {
        if ((projectile.getY() >= fenetre.vaisseau.getY()) && (projectile.getY() <= fenetre.vaisseau.getY() + fenetre.vaisseau.getHeight())) {
            if ((projectile.getX() >= fenetre.vaisseau.getX()) && (projectile.getX() <= fenetre.vaisseau.getX() + fenetre.vaisseau.getWidth())) {
                System.out.println("touché ");

                this.projectile.removeProjectile();
                fenetre.stopJeu();
                
                JOptionPane.showMessageDialog(null, "Game Over");

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
