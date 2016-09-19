package da2i_remise_niv;

public class MouvementAlien extends Thread 
{
	private Game fenetre;
	
	public MouvementAlien(Game fenetre)
	{
		this.fenetre = fenetre;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{	
			try 
			{
				fenetre.moveAlien();
				Thread.sleep(100);
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
