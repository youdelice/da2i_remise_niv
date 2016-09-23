package da2i_remise_niv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import bdd.Bdd;

public class Game extends JFrame implements KeyListener
{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel_game;
	private JLabel lb_level;
	public JLabel lb_score;
	public JLabel lb_niveauSuivant;

	public int SENS_ALIEN = 10; // -10 = gauche 10 = droite
	public int SENS_VAISSEAU = 0; // -8 = gauche 0 = immobile 8 = droite
	private int score = 0;
	public int niveau = 1;
	public Boolean isEnCours = true;
	private Boolean cooldownTirer = false;
	private Date date;
	private int year, month, day;
	private Calendar cal;
	private Bdd bdd;
	private String dateAuj;
	public String name;
	public List<List<Alien>> listAlien = new ArrayList<List<Alien>>();

	private MouvementVaisseau mv;
	private MouvementAlien ma;
	private TireAlien ta;

	public List<MouvementProjectileAlien> listProjectileAlien = new ArrayList<MouvementProjectileAlien>();
	public List<MouvementProjectileVaisseau> listProjectileVaisseau = new ArrayList<MouvementProjectileVaisseau>();

	public Vaisseau vaisseau;

	Set<String> keyPressed = new HashSet<String>();

	public void nom()
	{
		name = JOptionPane.showInputDialog("");
		if (name.isEmpty())
		{
			System.exit(0);
		}

	}

	public Game()
	{
		nom();
		setLocationRelativeTo(null);
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_game = new JPanel();
		panel_game.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_game.setLayout(null);
		contentPane.add(panel_game, BorderLayout.CENTER);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(400);
		contentPane.add(splitPane, BorderLayout.NORTH);

		JPanel panel_level = new JPanel();
		splitPane.setRightComponent(panel_level);
		panel_level.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lb_score = new JLabel("Score :" + score);
		splitPane.setLeftComponent(lb_score);
		lb_score.setSize(350, 50);

		lb_level = new JLabel("Niveau : " + niveau);

		lb_niveauSuivant = new JLabel("Niveau : " + niveau);
		lb_niveauSuivant.setLocation(203, 297);
		lb_niveauSuivant.setSize(200, 25);
		panel_game.add(lb_niveauSuivant);

		panel_level.add(lb_level);

		
		this.addKeyListener(this);

		Timer t = new Timer();
		t.schedule(new TimerTask()
		{

			@Override
			public void run()
			{
				creerPlateau();
				lancerJeu();
			}

		}, 1500);

	}

	public void creerPlateau()
	{
		this.panel_game.removeAll();
		this.panel_game.repaint();
		ajoutVaisseau();
		ajoutAlien();
	}

	private void ajoutVaisseau()
	{
		listProjectileVaisseau.clear();
		vaisseau = new Vaisseau(this);
		vaisseau.setLocation(200, 580);
		panel_game.add(vaisseau);

	}

	private void ajoutAlien()
	{
		listAlien.clear();
		listProjectileAlien.clear();

		for (int i = 0; i < 5; i++)
		{
			List<Alien> colonne = new ArrayList<Alien>();

			for (int ii = 0; ii < 5; ii++)
			{
				Alien alien = new Alien(this);
				alien.setLocation(10 + 40 * i, 10 + 40 * ii);
				panel_game.add(alien);
				colonne.add(alien);
			}
			this.listAlien.add(colonne);
		}
	}

	public void lancerJeu()
	{
		isEnCours = true;

		ma = new MouvementAlien(this);
		mv = new MouvementVaisseau(this);
		ta = new TireAlien(this);

		ta.start();
		ma.start();
		mv.start();
	}

	public void stopJeu()
	{
		isEnCours = false;
		this.keyPressed.clear();
		this.SENS_VAISSEAU = 0;
		this.SENS_ALIEN = 8;

		for (MouvementProjectileAlien pa : listProjectileAlien)
		{
			pa.stopThread();
		}

		for (MouvementProjectileVaisseau pv : listProjectileVaisseau)
		{
			pv.stopThread();
		}
	}

	public JPanel getPanelGame()
	{
		return panel_game;
	}

	@Override
	public void keyPressed(KeyEvent e) // q = 81 d = 68 espace = 32
	{
		this.keyPressed.add(String.valueOf(e.getKeyChar()));

		if (e.getKeyCode() == 32 && !cooldownTirer)
		{
			vaisseau.tirer();
			cooldownTirer = true;
			Timer t = new Timer();
			t.schedule(new TimerTask()
			{

				@Override
				public void run()
				{
					cooldownTirer();
				}

			}, 500);
		}

		if (e.getKeyCode() == 81)
		{
			this.SENS_VAISSEAU = -8;
		}

		if (e.getKeyCode() == 27)
		{
			stopJeu();
		}

		if (e.getKeyCode() == 68)
		{
			this.SENS_VAISSEAU = 8;
		}
	}

	private void cooldownTirer()
	{
		cooldownTirer = false;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		this.keyPressed.remove(String.valueOf(e.getKeyChar()));

		if (this.keyPressed.isEmpty())
		{
			SENS_VAISSEAU = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	public void upScore()
	{
		this.score += 5;
		this.lb_score.setText("Score : " + score);
	}

	public int getScore()
	{
		return this.score;
	}

	public void gameOver() throws SQLException
	{
		stopJeu();
		FenetreGameOver fgo = new FenetreGameOver(this);

		date = new Date();
		bdd = new Bdd();

		cal = Calendar.getInstance();
		cal.setTime(date);
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		dateAuj = year + "-" + month + "-" + day;
		System.out.println(name + " " + score + " " + dateAuj);
		this.bdd.addScore(name, score, dateAuj);
	}

	public void finNiveau()
	{
		try
		{
			stopJeu();

			lb_level.setText("Niveau : " + ++niveau);
			lb_niveauSuivant.setText("Niveau : " + niveau);
			panel_game.add(lb_niveauSuivant);
			panel_game.repaint();

			Timer t = new Timer();
			t.schedule(new TimerTask()
			{

				@Override
				public void run()
				{
					creerPlateau();
					lancerJeu();
				}

			}, 1500);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void rejouer()
	{
		niveau = 1;
		score = 0;
		lb_level.setText("Niveau : " + niveau);
		lb_niveauSuivant.setText("Niveau : " + niveau);
		panel_game.add(lb_niveauSuivant);
		panel_game.repaint();

		Timer t = new Timer();
		t.schedule(new TimerTask()
		{

			@Override
			public void run()
			{
				creerPlateau();
				lancerJeu();
			}

		}, 1500);
	}
}
