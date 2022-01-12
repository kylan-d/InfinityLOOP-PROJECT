package fr.dauphine.JavaAvance.Solve;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;


@SuppressWarnings("unused")
public class Checker {

	public static Grid buildGrid(String inputFile) throws IOException {
		ArrayList<String[]> informations = new ArrayList<String[]>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(inputFile));
            String line = bf.readLine();
            while(line  !=null) {
                String[] tab = line.split(" ");
                informations.add(tab);
                line = bf.readLine();
            }
            bf.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Erreur lors de l'ouverture du ficher \n"+ e);
        }
        int w = Integer.parseInt(informations.get(0)[0]);
        int h = Integer.parseInt(informations.get(1)[0]);
        Grid g=new Grid(w,h);
        Piece p;
        int i=0;
        int j=0;
        for(int k = 2; k<informations.size(); k++) {
        	int type=Integer.parseInt(informations.get(k)[0]);
        	int ori=Integer.parseInt(informations.get(k)[1]);
        	switch(type) {
        		case(0):
        			switch(ori) {
						case(0):
	          				  p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	          				  g.setPiece(i, j, p);;
						default:
							System.out.println("erreur orientation piece ligne"+k);
        			}
        		case(1):
        			switch(ori) {
        				case(0):
        					p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
        				  	g.setPiece(i, j, p);
        				case(1):
        					p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
    				  		g.setPiece(i, j, p);
        				case(2):
        					p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
    				  		g.setPiece(i, j, p);
        				case(3):
        					p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
    				  		g.setPiece(i, j, p);
        				default:
        					System.out.println("erreur orientation piece ligne"+k);
        			}
        		case(2):
        			switch(ori) {
						case(0):
							p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
        				  	g.setPiece(i, j, p);;
						case(1):
							p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
	        				g.setPiece(i, j, p);;
						default:
							System.out.println("erreur orientation piece ligne"+k);
        			}
        		case(3):
        			switch(ori) {
    				case(0):
    					p=new Piece(i,j,PieceType.TTYPE,Orientation.NORTH);
    				  	g.setPiece(i, j, p);
    				case(1):
    					p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
				  		g.setPiece(i, j, p);
    				case(2):
    					p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
				  		g.setPiece(i, j, p);
    				case(3):
    					p=new Piece(i,j,PieceType.TTYPE,Orientation.WEST);
				  		g.setPiece(i, j, p);
						default:
							System.out.println("erreur orientation piece ligne"+k);
        			}
        		case(4):
        			switch(ori) {
						case(0):
        					p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
    				  		g.setPiece(i, j, p);
						default:
							System.out.println("erreur orientation piece ligne"+k);
        			}
        		case(5):
        			switch(ori) {
    				case(0):
    					p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
    				  	g.setPiece(i, j, p);
    				case(1):
    					p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
				  		g.setPiece(i, j, p);
    				case(2):
    					p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
				  		g.setPiece(i, j, p);
    				case(3):
    					p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
				  		g.setPiece(i, j, p);
						default:
							System.out.println("erreur orientation piece ligne"+k);
        			}
        		default :
        			System.out.println("erreur type piece ligne"+k);
        	}
        	if(j==w-1) {
        		i++;
        		j=0;
        	}
        	else {
        		j++;
        	}
        			
        }
		return g;
	

// To be implemented
	
}
	
public boolean check(Grid g) {
	int w=g.getWidth();
	int h=g.getHeight();
	boolean a=true;
	
	//pour chaque piece, on regarde toute les pièces à qui elle est coonnecté, puis on regarde la pièece à 
	//qui elle est censé etre connecté et on regarde si cette seconde piece est connecté a la premiere
	 for(int i=0;i<h;i++) {
   	  for(int j=0;j<w;j++) {
   		  Piece p=g.getPiece(i, j);
   		  if(p.hasLeftConnector()==true) {
   			  if(j==0) {
   				  a=false;
   			  }
   			  else if(g.getPiece(i, j-1).hasRightConnector()==false) {
   				  a=false;
   			  }
   		  }
   		  
   		  if(p.hasRightConnector()==true) {
   			  if(j==w-1) {
   				  a=false;
   			  }
   			  else if(g.getPiece(i, j+1).hasLeftConnector()==false) {
   				  a=false;
   			  }
   		  }
   		  
   		  if(p.hasTopConnector()==true) {
   			  if(i==0) {
   				  a=false;
   			  }
   			  else if(g.getPiece(i-1, j).hasBottomConnector()==false) {
   				  a=false;
   			  }
   		  }
   		  
   		  if(p.hasBottomConnector()==true) {
   			  if(i==h-1) {
   				  a=false;
   			  }
   			  else if(g.getPiece(i+1, j).hasTopConnector()==false) {
   				  a=false;
   			  }
   		  }
   	  }

	 }
		return a;
}
	

}
