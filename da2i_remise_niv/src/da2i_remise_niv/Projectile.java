package da2i_remise_niv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class Projectile extends JPanel 
{
	private static final long serialVersionUID = 1L;

	private Game fenetre;

	public Projectile(Point p, Game fenetre, Boolean isVaisseau) //Point p, Game fenetre
	{
		this.fenetre = fenetre; 

		this.setSize(new Dimension(5, 15));
		this.setBackground(isVaisseau ? Color.BLUE : Color.RED);

		this.setLocation(p);

		fenetre.getPanelGame().add(this);
		fenetre.getPanelGame().repaint();
	}

	public void removeProjectile()
	{
		try
		{
			this.setLocation(1000, 1000);
			fenetre.getPanelGame().remove(this);
		} catch (Exception e)
		{
			System.out.println("removeProjectile : " + e.getMessage());
		}

	}
}
