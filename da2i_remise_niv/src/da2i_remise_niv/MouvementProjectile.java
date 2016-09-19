package da2i_remise_niv;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MouvementProjectile extends Thread 
{
	private Projectile projectile;
        private Game game;
	
	public MouvementProjectile(Projectile p,Game game)
	{
		this.projectile = p;
                this.game = game;
	}
	
	public void run()
	{
            Point p = projectile.getLocation();
            p.y -= 15;
            
		while(projectile.getLocation().y > 10)
		{
                    System.out.println(projectile.getX() + " " + projectile.getY());
			p = projectile.getLocation();
			
			p.y -= 10;
			
			projectile.setLocation(p);
			Alien alien;
                        int coX = -1;
                        int coY = -1;
                        
                        for (int i = 0; i < 8; i++) 
                        {
                            switch(i)
                            {
                                case 0:
                                    if(!game.aliensCol0.isEmpty()){
                                    alien = game.aliensCol0.get(game.aliensCol0.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol0,coX,coY);
                                    }
                                break;
                                case 1:
                                     if(!game.aliensCol1.isEmpty()){
                                    alien = game.aliensCol1.get(game.aliensCol1.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol1,coX,coY);
                                     }
                                break;
                                case 2:
                                     if(!game.aliensCol2.isEmpty()){
                                    alien = game.aliensCol2.get(game.aliensCol2.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol2,coX,coY);
                                     }
                                break;
                                case 3:
                                 if(!game.aliensCol3.isEmpty()){
                                    alien = game.aliensCol3.get(game.aliensCol3.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol3,coX,coY);
                                     }
                                break;
                                case 4:
                                     if(!game.aliensCol4.isEmpty()){
                                    alien = game.aliensCol4.get(game.aliensCol4.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol4,coX,coY);
                                     }
                                break;                                    
                                case 5:
                                     if(!game.aliensCol5.isEmpty()){
                                    alien = game.aliensCol5.get(game.aliensCol5.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol5,coX,coY);
                                     }
                                break;
                                case 6:
                                     if(!game.aliensCol6.isEmpty()){
                                    alien = game.aliensCol6.get(game.aliensCol6.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol6,coX,coY);
                                     }
                                break;
                                case 7:
                                     if(!game.aliensCol7.isEmpty()){
                                    alien = game.aliensCol7.get(game.aliensCol7.size()-1);
                                    coX = alien.getX();
                                    coY = alien.getY();
                                    colision(game.aliensCol7,coX,coY); 
                                    }
                                break;   
                            }
                        }
                        
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        
                        
                        
		}
		
                if(!projectile.isValid())
                    projectile.removeProjectile();
	}
        
        public void colision(List<Alien> aliens , int coX, int coY){
            
            if(coY != -1)
                if((projectile.getY() >= coY) && (projectile.getY() <= coY + 40))
                    if((projectile.getX() >= coX) && (projectile.getX() <= coX + 40))
                    {
                        System.out.println("touché ");
                                            
                        this.game.getPanelGame().remove(aliens.get(aliens.size() - 1));
                        this.game.aliensLigne.remove(aliens.get(aliens.size() - 1));
                        
                        aliens.remove(aliens.size()-1);
                        this.projectile.removeProjectile();
                        this.game.getPanelGame().repaint();
                        this.game.getPanelGame().revalidate();          
                        
                        try {
                            this.join();
                            projectile = null;
                        }catch(Exception e)
                        {
                            
                        }
                        
                        
                    }
        }
        
}
