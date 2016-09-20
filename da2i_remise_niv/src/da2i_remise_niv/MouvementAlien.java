package da2i_remise_niv;

public class MouvementAlien extends Thread 
{
    private Game fenetre;

    public MouvementAlien(Game fenetre) 
    {
        this.fenetre = fenetre;
    }

    @Override
    public void run() {
        while (fenetre.isEnCours) {
            try {
                fenetre.moveAlien();
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("MouvementAlien : " + e.getMessage());
            }
        }
    }
}
