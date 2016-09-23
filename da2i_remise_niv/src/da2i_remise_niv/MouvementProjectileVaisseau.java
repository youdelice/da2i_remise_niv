package da2i_remise_niv;

import java.awt.Point;
import java.util.List;

public class MouvementProjectileVaisseau extends Thread {

	private Projectile projectile;
	private Game fenetre;
	Boolean toucher = false;
	Boolean isOk = true;

	public MouvementProjectileVaisseau(Projectile p, Game fenetre)
	{
		this.projectile = p;
		this.fenetre = fenetre;
	}

	public void run()
	{
		while (projectile.getY() >= 10 && !toucher && isOk)
		{
			Point location = projectile.getLocation();

			location.y -= 15;

			projectile.setLocation(location);
			colision();

			try
			{
				Thread.sleep(50);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		fenetre.listProjectileVaisseau.remove(this);
		projectile.removeProjectile();
	}

	public void colision()
	{
		int index1 = -1;
		int index2 = -1;

		boucle:
		for(List<Alien> aliens : fenetre.listAlien)
		{
			for(Alien alien : aliens)
			{
				if ((projectile.getY() <= (alien.getY() + 40)) && (projectile.getY() >= alien.getY()))
				{
					if ((projectile.getX() >= alien.getX()) && (projectile.getX() <= (alien.getX() + 40)))
					{
						index1 = fenetre.listAlien.indexOf(aliens);
						index2 = aliens.indexOf(alien);
						alien.setLocation(1000, 1000);
						projectile.removeProjectile();
						toucher = true;
						fenetre.upScore();
						break boucle;
					}
				}
			}
		}

		if (toucher)
		{
			fenetre.listAlien.get(index1).remove(index2);

			if (fenetre.listAlien.get(index1).isEmpty())
			{
				fenetre.listAlien.remove(index1);

				if (fenetre.listAlien.isEmpty())
					fenetre.finNiveau();
			}

		}

	}

	public void stopThread()
	{
		this.isOk = false;
	}
}
