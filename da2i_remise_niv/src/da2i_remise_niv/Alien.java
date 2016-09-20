package da2i_remise_niv;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Alien extends JPanel {

    private static final long serialVersionUID = 1L;
    Game fenetre;

    public Alien(Game fenetre) {
        this.fenetre = fenetre;
        this.setSize(new Dimension(40, 40));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = new ImageIcon(getClass().getClassLoader().getResource("Ressources/alien.png")).getImage();

        g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), null);
    }

    public void tirer() {
        Point location = this.getLocation();

        location.x += this.getSize().width / 2;

        Projectile p = new Projectile(location, fenetre, false);

        MouvementProjectileAlien mv = new MouvementProjectileAlien(p, fenetre);
        mv.start();
    }

    public void removeAlien() {
        this.fenetre.getPanelGame().remove(this);
    }
}
