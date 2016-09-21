package da2i_remise_niv;

public class MouvementAlien extends Thread 
{
    private Game fenetre;
    private int v;

    public MouvementAlien(Game fenetre) 
    {
        this.fenetre = fenetre;
    }

    @Override
    public void run() {
        checkNiv(fenetre.niv);
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
        switch(i){
            case 1 :
                v= Vitesse.DEBUTANT.getVitesse();
                break;
            case 2 :
                v= Vitesse.NOVICE.getVitesse();
                break;
            case 3:
                v = Vitesse.MAITRE.getVitesse();
                break;
        }
        return v;
    }
}
