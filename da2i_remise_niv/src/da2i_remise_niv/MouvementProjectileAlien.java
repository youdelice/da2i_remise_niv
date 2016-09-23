package da2i_remise_niv;

import java.awt.Point;

public class MouvementProjectileAlien extends Thread {

	private Game fenetre;
	private Projectile projectile;
	private Boolean toucher;
	private int v = 100;
	private Boolean isOk = true;

	public MouvementProjectileAlien(Projectile projectile, Game fenetre)
	{
		this.fenetre = fenetre;
		this.projectile = projectile;
	}

	public int checkNiv(int i)
	{
		v -= (i - 1) * 5;
		System.out.println(v);
		return v;
	}

	@Override
	public void run()
	{
		checkNiv(fenetre.niveau);
		while ((projectile.getY() + 15) < (fenetre.getPanelGame().getHeight() - 10) && isOk)
		{
			try
			{
				Point p = projectile.getLocation();

				p.y += 15;

				projectile.setLocation(p);
				colision();

				Thread.sleep(v);
			} catch (Exception e)
			{
				System.out.println("MouvementProjectileAlien : " + e.getMessage());
			}
		}

		fenetre.listProjectileAlien.remove(this);
		projectile.removeProjectile();
	}

	public void colision()
	{
		try
		{
			if ((projectile.getY() >= fenetre.vaisseau.getY()) && (projectile.getY() <= (fenetre.vaisseau.getY() + fenetre.vaisseau.getHeight())))
			{
				if (((projectile.getX() >= fenetre.vaisseau.getX()) && (projectile.getX() <= fenetre.vaisseau.getX() + fenetre.vaisseau.getWidth()))
				)
				{
					fenetre.gameOver();
				}
			}
		} catch (Exception e)
		{
			System.out.println("MouvementProjectileAlien colision : " + e.getMessage());
		}
	}

	public void stopThread()
	{
		isOk = false;
	}
}
