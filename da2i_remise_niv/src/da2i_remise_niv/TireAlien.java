package da2i_remise_niv;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TireAlien extends Thread {

    private Game fenetre;

    public TireAlien(Game fenetre) {
        this.fenetre = fenetre;
    }

    @Override
	public void run()
	{
        while (fenetre.isEnCours) 
        {
			int nombreColonne = fenetre.listAlien.size() - 1;
			
			if(nombreColonne != -1)
			{
				Random rand = new Random();
				int colonne = rand.nextInt(nombreColonne);

				final List<Alien> aliens = fenetre.listAlien.get(colonne);

				Timer t = new Timer();
				t.schedule(new TimerTask()
				{

					@Override
					public void run()
					{
						if (fenetre.isEnCours)
							aliens.get(aliens.size() - 1).tirer();
					}

				}, rand.nextInt(1000));

			}
			
			try
			{
				Thread.sleep(1250);
			} catch (Exception e)
			{

			}
        }
		System.out.println("ta");
    }
}
