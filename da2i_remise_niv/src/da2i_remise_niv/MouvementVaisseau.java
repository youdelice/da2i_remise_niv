package da2i_remise_niv;

public class MouvementVaisseau extends Thread {

    private Game fenetre;

    public MouvementVaisseau(Game fenetre) {
        this.fenetre = fenetre;
    }

    public void run() {
        while (fenetre.isEnCours) {
            try {
                if ((15 >= fenetre.vaisseau.getX()) && (fenetre.SENS_VAISSEAU == -8)) {
                    fenetre.SENS_VAISSEAU = 0;
                }

                if ((fenetre.getPanelGame().getWidth() <= (fenetre.vaisseau.getX() + 85)) && (fenetre.SENS_VAISSEAU == 8)) {
                    fenetre.SENS_VAISSEAU = 0;
                }

                fenetre.vaisseau.setLocation(fenetre.vaisseau.getLocation().x + fenetre.SENS_VAISSEAU, fenetre.vaisseau.getLocation().y);

                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
