package fr.dauphine.JavaAvance.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.Thread.State;
import java.security.PublicKey;
import java.security.DrbgParameters.NextBytes;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.nimbus.AbstractRegionPainter;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.Solve.Checker;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Dimension2D;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



/**
 * This class handles the GUI
 * 
 *
 */
public class GUI extends JFrame implements ActionListener{

	private JFrame frame;
	private JLabel headerLaberJLabel;
	private JPanel controlPanel;
	private JButton start;
	/**
	 * 
	 * @param inputFile
	 *            String from IO
	 * @throws IOException
	 *             if there is a problem with the gui
	 */
	public static void startGUI(final String inputFile) throws NullPointerException {
		// We have to check that the grid is generated before to launch the GUI
		// construction
		Runnable task = new Runnable() {
			public void run() {

				
				try {
					final Grid grid = Checker.buildGrid(inputFile);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							GUI window;
							window = new GUI(grid);
							window.frame.setVisible(true);
						}
					});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		};
		new Thread(task).start();

	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public GUI(Grid grid) {

		initialize(grid);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize(Grid grid) {
		// To implement:
		// creating frame, labels
		// Implementing method mouse clicked of interface MouseListener.
		 frame = new JFrame("Infinite loop");
	     frame.setSize(400,400);
	     //frame.setLayout(new GridLayout(3, 1));
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	     controlPanel = new JPanel();
		 controlPanel.setLayout(new GridLayout(4,4));
		 controlPanel.setMaximumSize(new Dimension(400,400));
	     Dimension size = new Dimension(30,10);
		 
	     headerLaberJLabel = new JLabel("Welcome tu game Infinite Loop", JLabel.CENTER);        
	     headerLaberJLabel.setSize(350,100);
	     controlPanel.add(headerLaberJLabel);
	     
	     final JFrame jFrame = new JFrame();
	     jFrame.setSize(400,400);
	     jFrame.setLayout(new BorderLayout()); 
			final JLabel aJLabel = new JLabel("",JLabel.CENTER);
			 start = new JButton("Start Game");
		     start.setPreferredSize(size); 
		     controlPanel.add(start);
		     
			 start.addActionListener(new ActionListener() {
				 public void actionPerformed(java.awt.event.ActionEvent e) {
						// TODO Auto-generated method stub
					 aJLabel.setText("start game");
					 
					 jFrame.add(aJLabel,BorderLayout.NORTH);
					 //jFrame.add(aJLabel);
					 jFrame.setVisible(true);

					}
			 });
			 frame.setContentPane(controlPanel);
			//frame.add(start);
	}
	private void showEvent()
	{
		final JFrame jFrame = new JFrame();
		final JLabel aJLabel = new JLabel("");
		 start = new JButton("Start Game");
		 start.addActionListener(new ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent e) {
					// TODO Auto-generated method stub
				 aJLabel.setText("A Frame shown to the user.");
		            frame.setVisible(true);

				}
		 });
		 controlPanel.add(start);
	}

	/**
	 * Display the correct image from the piece's type and orientation
	 * 
	 * @param p
	 *            the piece
	 * @return an image icon
	 */
	private ImageIcon getImageIcon(Piece p) {
		return null;
		//To be implemented
		
		
	}
	public static void main(String[] args)
	{
		Grid grid=new Grid(10, 10);
		GUI gui = new GUI(grid);
		
		
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
