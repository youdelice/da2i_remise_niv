package metarion;

import java.awt.Point;

public class MouvementProjectile extends Thread 
{
	private Projectile projectile;
	
	public MouvementProjectile(Projectile p)
	{
		this.projectile = p;
	}
	
	public void run()
	{
		while(projectile.getLocation().y > 10)
		{
			Point p = projectile.getLocation();
			
			p.y -= 15;
			
			projectile.setLocation(p);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        
                        
                        
		}
		
		projectile.removeProjectile();
	}
}
