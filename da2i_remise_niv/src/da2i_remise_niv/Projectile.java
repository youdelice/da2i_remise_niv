package da2i_remise_niv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class Projectile extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private Game fenetre;
	
	public Projectile(Point p, Game fenetre) //Point p, Game fenetre
	{
		this.fenetre = fenetre; 
		
		this.setSize(new Dimension(5, 15));
		this.setBackground(Color.RED);

		p.y -= this.getHeight();
		
		this.setLocation(p);
		
		fenetre.getPanelGame().add(this);
		fenetre.getPanelGame().repaint();
		fenetre.getPanelGame().revalidate();
	}

	public void removeProjectile()
	{
		fenetre.getPanelGame().remove(this);
		fenetre.getPanelGame().repaint();
		this.invalidate();
                
	}
}
