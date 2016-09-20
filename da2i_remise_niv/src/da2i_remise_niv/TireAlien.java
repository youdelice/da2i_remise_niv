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
    public void run() {
        while (fenetre.isEnCours) {
            Timer t = new Timer();
            try {
                Random rand = new Random();
                
                final int listAlien = (fenetre.colonneAlien.size()-1) == 0 ? 0 : rand.nextInt(fenetre.colonneAlien.size() - 1);
                
                t.schedule(new TimerTask() {
                    
                    @Override
                    public void run()
                    {
                        try{
                           fenetre.colonneAlien.get(listAlien).get(fenetre.colonneAlien.get(listAlien).size() - 1).tirer(); 
                        }catch(Exception e)
                        {
                            System.out.println("TireAlien task : " + e.getMessage());
                        }
                    }
                }, rand.nextInt(1250));

                Thread.sleep(250);
            } catch (Exception e) 
            {
                   System.out.println("TireAlien : " + e.getMessage());
            }
             t.cancel();
        }
    }
}
