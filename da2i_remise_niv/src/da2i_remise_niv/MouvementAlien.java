package da2i_remise_niv;

import java.util.List;

public class MouvementAlien extends Thread
{
	private Game fenetre;
	private int v = 150;

	public MouvementAlien(Game fenetre)
	{
		this.fenetre = fenetre;
	}

	@Override
	public void run()
	{
		checkNiv(fenetre.niveau);

		while (fenetre.isEnCours)
		{

			try
			{
				int changementLigne = 0;
				int sizeListAlien = fenetre.listAlien.size() - 1;

				if (sizeListAlien != -1)
				{
					List<Alien> derniereColonne = fenetre.listAlien.get(sizeListAlien);
					List<Alien> premiereColonne = fenetre.listAlien.get(0);

					if (fenetre.SENS_ALIEN > 0)
					{
						int x = derniereColonne.get(derniereColonne.size() - 1).getX() + 40;

						if (x >= fenetre.getPanelGame().getWidth() - 10)
						{
							fenetre.SENS_ALIEN = -8;
							changementLigne = 10;
						}

					} else
					{
						int x = premiereColonne.get(premiereColonne.size() - 1).getX();

						if (x <= 10)
						{
							fenetre.SENS_ALIEN = 8;
							changementLigne = 12;
						}
					}

					for (List<Alien> aliens : fenetre.listAlien)
					{
						for (Alien alien : aliens)
							alien.setLocation(alien.getLocation().x + fenetre.SENS_ALIEN,
									alien.getLocation().y + changementLigne);
					}

					Thread.sleep(v);
				}

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// System.out.println(fenetre.isEnCours);
	}

	public int checkNiv(int i)
	{
		v -= (i - 1) * 10;
		return v;
	}
}
