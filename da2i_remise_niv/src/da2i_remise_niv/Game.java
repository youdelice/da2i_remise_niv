package metarion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.BevelBorder;

public class Game extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel_game;
	private JLabel lb_level;
	private List<Alien> aliens;
	private Boolean cooldownTirer = false;
	private MouvementVaisseau mv;

	public Vaisseau vaisseau;
	public int SENS_ALIEN = 10; // -10 = gauche     10 = droite
	public int SENS_VAISSEAU = 0;  // -8 = gauche   0 = immobile    8 = droite

	Set<String> keyPressed = new HashSet<String>();

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e)
				{
					e.printStackTrace();
				}

				try 
				{
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Game() 
	{
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_game = new JPanel();
		panel_game.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_game, BorderLayout.CENTER);
		panel_game.setLayout(null);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane.setDividerSize(0);
		contentPane.add(splitPane, BorderLayout.NORTH);

		JLabel lb_score = new JLabel("Score : 0000");
		splitPane.setLeftComponent(lb_score);

		JPanel panel_level = new JPanel();
		splitPane.setRightComponent(panel_level);
		panel_level.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lb_level = new JLabel("Niveau : 1");
		panel_level.add(lb_level);

		creerPlateau();

		this.addKeyListener(this);

		lancerJeu();
	}

	private void creerPlateau() 
	{
		ajoutAlien();
		ajoutVaisseau();
	}

	private void ajoutVaisseau() 
	{
		vaisseau = new Vaisseau(this);
		vaisseau.setLocation(200, 580);
		panel_game.add(vaisseau);
	}

	private void ajoutAlien() 
	{
		aliens = new ArrayList<Alien>();

		for(int i = 0; i < 4; i++)
		{
			Alien alien = new Alien();
			alien.setLocation(5 + i*45, 10);
			panel_game.add(alien);
			aliens.add(alien);
		}	
	}

	private void lancerJeu() 
	{
		MouvementAlien ma = new MouvementAlien(this);
		ma.start();

		mv = new MouvementVaisseau(this);
		mv.start();
	}  

	public void moveAlien()
	{
		int descendre = 0;

		for(Alien alien : aliens)
		{
			if(panel_game.getWidth() <= alien.getX() + 50)
			{
				SENS_ALIEN = -10;
				descendre = 15;
			}			
			else if(10 >= alien.getX())
			{
				SENS_ALIEN = 10;
				descendre = 15;
			}		
		}

		for(Alien alien : aliens)
		{
			alien.setLocation(alien.getLocation().x + SENS_ALIEN, alien.getLocation().y + descendre);
		}
	}

	public JPanel getPanelGame()
	{
		return panel_game;
	}

	@Override
	public void keyPressed(KeyEvent e) // q = 81      d = 68		espace = 32
	{		
		this.keyPressed.add(String.valueOf(e.getKeyChar()));
		
		if(e.getKeyCode() == 32 && !cooldownTirer)
		{
			vaisseau.tirer();
			cooldownTirer = true;
			Timer t = new Timer();
			t.schedule(new TimerTask() {

				@Override
				public void run() {
					cooldownTirer();
				}

			}, 1000);
		}		

		if(e.getKeyCode() == 81)
			this.SENS_VAISSEAU = -8;

		if(e.getKeyCode() == 68)
			this.SENS_VAISSEAU = 8;
	}		

	private void cooldownTirer() 
	{
		cooldownTirer = false;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
			this.keyPressed.remove(String.valueOf(e.getKeyChar()));

			if(this.keyPressed.isEmpty())
				SENS_VAISSEAU = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
	}
}