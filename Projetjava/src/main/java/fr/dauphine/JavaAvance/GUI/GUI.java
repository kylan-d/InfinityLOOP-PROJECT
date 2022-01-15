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
import java.net.URL;
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
import java.awt.Font;
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
//import javafx.scene.text.Font;
import java.awt.FlowLayout;


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
	private JFrame jFrame;
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
	    
		 
	     headerLaberJLabel = new JLabel("Welcome tu game Infinite Loop", JLabel.CENTER);        
	     headerLaberJLabel.setSize(350,100);
	     controlPanel.add(headerLaberJLabel,BorderLayout.CENTER);
	     Dimension size = new Dimension(30,10);
	         showEvent();
			 frame.setContentPane(controlPanel);
			//frame.add(start);
	}
	private void showEvent()
	{
		jFrame = new JFrame();
	     jFrame.setSize(400,400);
	     jFrame.setTitle("Stating");
	     jFrame.setLayout(new BorderLayout()); 
			final JLabel aJLabel = new JLabel("",JLabel.CENTER);
			 start = new JButton("Start Game");
			 
			 Dimension size = new Dimension(30,10);
		     start.setPreferredSize(size); 
		     controlPanel.add(start);
		     
			 start.addActionListener(new ActionListener() {
				 public void actionPerformed(java.awt.event.ActionEvent e) {
						// TODO Auto-generated method stub
					 aJLabel.setText("start game");
					 aJLabel.setFont(new Font("Serif", Font.PLAIN, 30));
					 jFrame.add(aJLabel,BorderLayout.NORTH);
					 //jFrame.add(aJLabel);
					 JLabel j = new JLabel();
					 ImageIcon imdIcon = getImageIcon(null);
					 j.setIcon(imdIcon);
					 
					
					 jFrame.setVisible(true);
					}
			 });
			 ImageIcon imdIcon=createImageIcon();
	}

	/**
	 * Display the correct image from the piece's type and orientation
	 * 
	 * @param p
	 *            the piece
	 * @return an image icon
	 */
	private ImageIcon getImageIcon(Piece p) {
		
		ImageIcon img = new ImageIcon("/Projetjava/src/main/resources/fr/dauphine/JavaAvance/icons/io");// 创建图片对象


        return img;
		
	}
	protected ImageIcon createImageIcon() {
java.net.URL imgURL = getClass().getResource("1.png");
if (imgURL != null) {
return new ImageIcon(imgURL, "ok");
} else {
System.err.println("Couldn't find file: " );
return null;
}
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
