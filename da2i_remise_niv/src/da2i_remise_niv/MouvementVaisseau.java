package metarion;

public class MouvementVaisseau extends Thread 
{
	private Game fenetre;

	public MouvementVaisseau(Game fenetre)
	{
		this.fenetre = fenetre;
	}

	public void run()
	{
		while(true)
		{
			if((15 >= fenetre.vaisseau.getX())  && (fenetre.SENS_VAISSEAU == -8))
				fenetre.SENS_VAISSEAU = 0;

			if( (fenetre.getPanelGame().getWidth() <= (fenetre.vaisseau.getX() + 85)) && (fenetre.SENS_VAISSEAU == 8))
				fenetre.SENS_VAISSEAU = 0;
			
			fenetre.vaisseau.setLocation(fenetre.vaisseau.getLocation().x + fenetre.SENS_VAISSEAU, fenetre.vaisseau.getLocation().y);
			
			try 
			{
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}