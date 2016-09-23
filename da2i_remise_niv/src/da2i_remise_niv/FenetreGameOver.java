package da2i_remise_niv;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class FenetreGameOver extends JFrame {

	private JPanel contentPane;
	private JSplitPane panel_button;
	private JLabel lb_gameOver;
	private JButton bt_rejouer;
	private JButton bt_quitter;

	private Game fenetreGame;

	public FenetreGameOver(Game fenetre)
	{

		try
		{
			this.fenetreGame = fenetre;

			this.setSize(220, 140);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			contentPane = new JPanel();
			contentPane.setLayout(new BorderLayout());
			this.setContentPane(contentPane);

			panel_button = new JSplitPane();
			panel_button.setDividerSize(0);
			panel_button.setDividerLocation(110);
			contentPane.add(panel_button, BorderLayout.SOUTH);

			lb_gameOver = new JLabel("Game Over");
			lb_gameOver.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lb_gameOver, BorderLayout.CENTER);

			bt_rejouer = new JButton("Rejouer");
			bt_rejouer.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					fenetreGame.rejouer();
					dispose();
				}
			});

			bt_quitter = new JButton("Quitter");
			bt_quitter.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});

			panel_button.setLeftComponent(bt_rejouer);
			panel_button.setRightComponent(bt_quitter);

			this.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
