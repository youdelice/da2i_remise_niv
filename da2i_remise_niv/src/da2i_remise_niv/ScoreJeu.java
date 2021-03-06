/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da2i_remise_niv;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import bdd.Bdd;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author lambertc
 */
public class ScoreJeu extends JFrame implements WindowListener
{
	private Bdd dd;
	private List<String> liste;
	private List<String> listScore;
	private Menu fenetre;

	JPanel jp;
	JLabel jl;
	JList list, list2;

	public ScoreJeu(Menu fenetre)
	{
		this.fenetre = fenetre;
		this.setTitle("SCORE");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.addWindowListener(this);
		setVisible(true);
		affichScore();
	}

	public void affichScore()
	{ // ((DefaultListModel)list2.getModel()).addElement(String.valueOf(liste.get(i).getScore()));
		try
		{
			 dd = new Bdd();

			 liste = dd.getAllScore();
			System.out.println(liste.size());
			String[] nomJoueur = new String[liste.size()];
			String[] scoreJoueur = new String[liste.size()];

			for (int i = 0; i < nomJoueur.length; i++)
			{
				nomJoueur[i] = liste.get(i);
			}
			list = new JList(nomJoueur);
			list.setSize(200, 500);
			list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(-1);
			list.addMouseListener(new MouseListener()
			{

				@Override
				public void mouseClicked(MouseEvent e)
				{
					DefaultListModel listmodel = (DefaultListModel) list2.getModel();
					listmodel.removeAllElements();
					int a = list.getSelectedIndex();
					String pseudo = liste.get(a);
					try
					{
						// listScore = dd.getScore(pseudo);
						for (String score : listScore)
						{
							((DefaultListModel) list2.getModel()).addElement(score);
						}
					} catch (Exception z)
					{
						z.printStackTrace();
					}
					// list2.remo

				}

				@Override
				public void mousePressed(MouseEvent e)
				{
					// throw new UnsupportedOperationException("Not supported
					// yet."); //To change body of generated methods, choose
					// Tools | Templates.
				}

				@Override
				public void mouseReleased(MouseEvent e)
				{
					// throw new UnsupportedOperationException("Not supported
					// yet."); //To change body of generated methods, choose
					// Tools | Templates.
				}

				@Override
				public void mouseEntered(MouseEvent e)
				{
					// throw new UnsupportedOperationException("Not supported
					// yet."); //To change body of generated methods, choose
					// Tools | Templates.
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					// throw new UnsupportedOperationException("Not supported
					// yet."); //To change body of generated methods, choose
					// Tools | Templates.
				}
			});

			list2 = new JList();
			DefaultListModel model = new DefaultListModel();
			list2.setModel(model);

			list2.setSize(200, 500);
			list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			list2.setLayoutOrientation(JList.VERTICAL);
			list2.setVisibleRowCount(-1);

			JScrollPane listScroller2 = new JScrollPane(list2);
			listScroller2.setSize(200, 500);
			listScroller2.setLocation(200, 0);
			this.getContentPane().add(listScroller2);

			JScrollPane listScroller = new JScrollPane(list);
			listScroller.setSize(200, 500);
			listScroller.setLocation(0, 0);
			this.getContentPane().add(listScroller);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		fenetre.setVisible(true);
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}
}
