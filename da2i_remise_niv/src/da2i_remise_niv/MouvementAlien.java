package da2i_remise_niv;

public class MouvementAlien extends Thread 
{
    private Game fenetre;
    private int v = 150;

    public MouvementAlien(Game fenetre) 
    {
        this.fenetre = fenetre;
    }

    @Override
    public void run() {
        checkNiv(fenetre.niveau);
        System.out.println(v);
        while (fenetre.isEnCours) {
            try {
                fenetre.moveAlien();
                Thread.sleep(v);
            } catch (Exception e) {
                System.out.println("MouvementAlien : " + e.getMessage());
            }
        }
    }
    
    public int checkNiv(int i){
        
        v -= (i-1)*10; 
        return v;
    }
}
