package da2i_remise_niv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bt_showFenetreScore implements ActionListener {
    
    private Menu fenetre;
    
    public Bt_showFenetreScore(Menu fenetre)
    {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVisible(false);
        
        ScoreJeu score = new ScoreJeu(fenetre);
        
    }
}
