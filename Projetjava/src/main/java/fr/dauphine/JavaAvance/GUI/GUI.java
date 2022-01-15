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
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Iterator;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.Icon;
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
	
	private JPanel jPanel;
	private static Grid grid;
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
		     aJLabel.setText("start game");
			 aJLabel.setFont(new Font("Serif", Font.PLAIN, 30));
			 jFrame.add(aJLabel,BorderLayout.NORTH);
			jPanel = new JPanel();
		    jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

			/**creerPiece();
			System.out.println("ok5");
			putIntoInterface();
				**/
		    for(int i=0;i<12;i++)
			   {
				   afficherPieces(jPanel);
			   }
		     jFrame.add(jPanel);
			   
		     
		     
			 start.addActionListener(new ActionListener() {
				 public void actionPerformed(java.awt.event.ActionEvent e) {
						// TODO Auto-generated method stub
  
					 jFrame.setVisible(true);
					}
			 });
			
	}
	public void afficherPieces( JPanel jPanel)
	{ 			 
		JLabel j = new JLabel();
		 ArrayList<JLabel> jl = new ArrayList<>();
		 ArrayList<ImageIcon> imdIcon = getImageIcon(null);

		 Iterator<ImageIcon> iterator1 = imdIcon.iterator();
		 while(iterator1.hasNext())
		 {
			 j.setIcon((Icon) iterator1.next());
			 jl.add(j);
		 }
		 Iterator<JLabel> iterator2 = jl.iterator();

		 while(iterator2.hasNext())
		 {
			 JLabel j1=iterator2.next();
			 jPanel.add(j1);
		 }
		 

	}
	
	

	/**
	 * Display the correct image from the piece's type and orientation
	 * 
	 * @param p
	 *            the piece
	 * @return an image icon
	 */
//Ce m¨¦thode il y a que de photo sans connecter avec la classe Pi¨¨ce
	private ArrayList<ImageIcon> getImageIcon(Piece p) {
		ArrayList<ImageIcon> listImg=createImageIcon();
		//Iterator iterator = listImg.iterator();
		int min = 1;
		int max = 10;
		int num = min + (int)(Math.random() * (max-min+1));
		ImageIcon img =null;
		ArrayList<ImageIcon> listImg2 = new ArrayList<ImageIcon>();
		for(int i = 0;i<12;i++)
		{
			img=listImg.get(num);
			listImg2.add(img);
		}
        return listImg2;
		
	}
	protected ArrayList<ImageIcon> createImageIcon() {
		ClassLoader cldr = this.getClass().getClassLoader();
		java.net.URL imgURL =null;
		ArrayList<ImageIcon> imageIcons = new ArrayList<>();
		//java.net.URL imgURL1 = cldr.getResource("fr/dauphine/JavaAvance/icons/io/1.png");
		for(int i = 1;i<16;i++)
		{
			imgURL = cldr.getResource("fr/dauphine/JavaAvance/icons/io/"+i+".png");
			
			if (imgURL != null) {
				ImageIcon imageIcon = new ImageIcon(imgURL, "ok");
				imageIcons.add(imageIcon);
				} 
			else {
				System.err.println("Couldn't find file: " );
				}
		}
		return imageIcons;
		
	
	}
	
	protected ImageIcon createImageIcon(int j) {
		ClassLoader cldr = this.getClass().getClassLoader();
		java.net.URL imgURL =null;
		ArrayList<ImageIcon> imageIcons = new ArrayList<>();
		java.net.URL imgURL1 = cldr.getResource("fr/dauphine/JavaAvance/icons/io/"+"j"+".png");
		ImageIcon imageIcon=null;
		for(int i = 1;i<16;i++)
		{
			imgURL = cldr.getResource("fr/dauphine/JavaAvance/icons/io/"+i+".png");
			
			if (imgURL != null) {
				imageIcon = new ImageIcon(imgURL, "ok");
				
				} 
			else {
				System.err.println("Couldn't find file: " );
				}
		}
		return imageIcon;
		
	
	}
	
	private ImageIcon getImageIcon1(Piece p) {
		ImageIcon imageIcon=null;
		System.out.println("KKKK");
		System.out.println(p.getType());
		if(p.getType()==PieceType.BAR)
		{
			if(p.getOrientation()==Orientation.NORTH)
			{
				imageIcon = createImageIcon(5);
			}
			if(p.getOrientation()==Orientation.EAST) {
				imageIcon = createImageIcon(6);
			}
		}
		if(p.getType()==PieceType.ONECONN)
		{
			if(p.getOrientation()==Orientation.NORTH)
			{
				imageIcon = createImageIcon(1);
			}
			if(p.getOrientation()==Orientation.SOUTH) {
				imageIcon = createImageIcon(3);
			}
			if(p.getOrientation()==Orientation.EAST) {
				imageIcon = createImageIcon(2);
			}
			if(p.getOrientation()==Orientation.WEST) {
				imageIcon = createImageIcon(4);
			}
			}
			if(p.getType()==PieceType.TTYPE)
			{
				if(p.getOrientation()==Orientation.NORTH)
				{
					imageIcon = createImageIcon(7);
				}
				if(p.getOrientation()==Orientation.SOUTH) {
					imageIcon = createImageIcon(9);
				}
				if(p.getOrientation()==Orientation.EAST) {
					imageIcon = createImageIcon(8);
				}
				if(p.getOrientation()==Orientation.WEST) {
					imageIcon = createImageIcon(10);
				}
			}
			if(p.getType()==PieceType.LTYPE)
			{
				if(p.getOrientation()==Orientation.NORTH)
				{
					imageIcon = createImageIcon(12);
				}
				if(p.getOrientation()==Orientation.SOUTH) {
					imageIcon = createImageIcon(14);
				}
				if(p.getOrientation()==Orientation.EAST) {
					imageIcon = createImageIcon(13);
				}
				if(p.getOrientation()==Orientation.WEST) {
					imageIcon = createImageIcon(15);
				}
			}
			if(p.getType()==PieceType.FOURCONN)
			{
				
					imageIcon = createImageIcon(11);
				}
			return imageIcon;
	}	
	
	public Grid putPiece(ArrayList<Piece> p)
	{
		int i = grid.getHeight();
		int j = grid.getWidth();
		boolean bool = false;
		Iterator<Piece> iterator = p.iterator();
		for (int a = 0;a<i;a++)
		{
			for(int b = 0;b<j;b++)
			{ 
					if(p!=null) {
					grid.setPiece(a, b, p.get(1));
				System.out.println(p.get(0).getOrientation());
				p.remove(1);

			}
					else {
						grid.setPiece(a, b, null);
					}
			
		}
		}
			System.out.println("ok1");
		return grid;
		
	}
	
	
	public void putIntoInterface()
	{
		ArrayList<JLabel> jl = new ArrayList<>();
		ImageIcon imageIcon=null;
		int i = grid.getHeight();
		int j = grid.getWidth();
		System.out.println(i+" "+j);
		JLabel label = new JLabel();
		for (int a = 0;a<i;a++)
		{
			for(int b = 0;b<j;b++)
			{
				
					
				imageIcon=getImageIcon1(grid.getPiece(a, b));
			//	System.out.println(grid.getPiece(a, b).getOrientation());
				label.setIcon(imageIcon);
				jl.add(label);
				
			}
		}

		 Iterator<JLabel> iterator2 = jl.iterator();
		 while(iterator2.hasNext())
		 {
			 JLabel j1=iterator2.next();
			 jPanel.add(j1);
		 }
		 
		 System.out.println("ok2");

	}
	
	public static void main(String[] args)
	{
		try {
			grid= new Grid(4, 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GUI gui = new GUI(grid);
		
		
	}
	public void creerPiece()
	{
		Piece p1 = new Piece(1, 1,PieceType.BAR,Orientation.NORTH);
		Piece p2 = new Piece(1, 1, PieceType.BAR, Orientation.SOUTH);
		Piece p3 = new Piece(1, 1,PieceType.BAR,Orientation.EAST);
		Piece p4 = new Piece(1, 1, PieceType.BAR, Orientation.WEST);
		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(p1);
		pieces.add(p2);
		pieces.add(p3);
		pieces.add(p4);
		grid = putPiece(pieces);

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
