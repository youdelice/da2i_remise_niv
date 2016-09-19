package metarion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Alien extends JPanel 
{
	private static final long serialVersionUID = 1L;

	public Alien()
	{
		//this.setBorder(new LineBorder(Color.black));
		this.setSize(new Dimension(40,40));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Image img = new ImageIcon(getClass().getClassLoader().getResource("Ressources/alien.png")).getImage();
		
		g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), null);
	}
}
