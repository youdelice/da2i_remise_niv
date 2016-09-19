package da2i_remise_niv;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Vaisseau extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private Game fenetre;
	
	public Vaisseau(Game fenetre)
	{
		//this.setBorder(new LineBorder(Color.black));
		
		this.fenetre = fenetre;
		this.setSize(75, 40);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Image img = new ImageIcon(getClass().getClassLoader().getResource("Ressources/vaisseau.png")).getImage();
		
		g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), null);
	}
	
	public void tirer()
	{
		Point p = this.getLocation();
		
		p.x += (int)this.getSize().getWidth() / 2;
		
		Projectile projectile = new Projectile(p, fenetre);	
		MouvementProjectile mv = new MouvementProjectile(projectile,fenetre);
		mv.start();
	}
}
