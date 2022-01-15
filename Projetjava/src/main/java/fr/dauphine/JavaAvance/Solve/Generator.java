package fr.dauphine.JavaAvance.Solve;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

/**
 * Generate a solution, number of connexe composant is not finished
 *
 */

public class Generator {

	public static Grid filledGrid;
	public static void generateLevel(String fileName, Grid inputGrid) {
		
		int nbcc=inputGrid.getNbcc();
	//	if(nbcc==-1) {
			
			generateLevelnonbcc(fileName,inputGrid);
	//	}
		/*else {
			
			generateLevelWnbcc(fileName,inputGrid);
		}*/
	}
	/**
	 * @param output
	 *            file name
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void generateLevelnonbcc(String fileName, Grid inputGrid) {
		
      int w=inputGrid.getWidth();
      int h=inputGrid.getHeight();
      int[][] nbc=new int[h][w];
      int nbcc=inputGrid.getNbcc();
      filledGrid=inputGrid;
      int nblink=0;
      
      // sans nbcc
      for(int i=0;i<h;i++) {
    	  for(int j=0;j<w;j++) {

        	  if((i==0 && j==0 && i!=h-1 && j!=w-1 )) {
        		  int t=new Random().nextInt(3);
        		  
        		  if(t==0) {
        			 
        				 
        				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[i][j]=0;
        				  
        				  
        			  

        		  }
        		  if(t==1) {
        			  nblink++;
        			  int o=new Random().nextInt(2);
        			  if(o==1) {
        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
        				  inputGrid.setPiece(i, j, p);
        				  nbc[i][j]=1;
        			  }
        			  if(o==0) {
        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
        				  inputGrid.setPiece(i, j, p);
        				  nbc[i][j]=1;
        				 
        			  }
        		  }
        		  if(t==2) {
        			  nblink++;
        			  nblink++;

        				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[i][j]=2;
        			  
        	  }
          
        	  }
        	  else if((i==0 && j==w-1&& i!=h-1 && j!=0)) {
          		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        			 
          			int t=new Random().nextInt(2);
          			if(t==0) {
          				nblink--;
          				
      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
      				  inputGrid.setPiece(i, j, p);
      				  nbc[i][j]=1;
          			}
          			if(t==1) {
          				
      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=2;
          			}

        		  }
          		  else {
          			 
            			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink++;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
              			if(t==1) {
          				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=0;
              			}

    				 
          			
          		  }
        	  }
        	  else if(i==0 && i!=h-1 && w!=1) {
          		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        			  
            			int t=new Random().nextInt(4);
              			if(t==0) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
              			if(t==1) {
              				
          				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=2;
              			}
              			if(t==2) {
              				
          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=2;
              			}
              			if(t==3) {
              				
              				nblink++;
          				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=3;
              			}
        		  }
        		  else {

          			int t=new Random().nextInt(3);
          			if(t==0) {
          				nblink++;
          			  int o=new Random().nextInt(2);
          			  if(o==1) {
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
          			  }
          			  if(o==0) {
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
          				 
          			  }
          			}
          			if(t==1) {
          				nblink++;
          				nblink++;
      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=2;
          			}
          			if(t==2) {
      				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=0;
          			}
        		  }
        	  }
        	  else if(j==0 && i!=h-1 && j!=w-1) {
          		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()){
        			 
          			int t=new Random().nextInt(4);
          			if(t==0) {
          				nblink--;
      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);
      				  nbc[i][j]=1;
          			}
          			if(t==1) {
          				
        				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[i][j]=2;
          			}
          			if(t==2) {
          				
          				nblink++;
      				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
      				  inputGrid.setPiece(i, j, p);
      				  nbc[i][j]=3;
          			}
          			if(t==3) {
          				
      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=2;
          			}
          			  
        		  }
        		  else {
        			 
          			int t=new Random().nextInt(3);
          			if(t==0) {
          				nblink++;
          			  int o=new Random().nextInt(2);
          			  if(o==1) {
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
          			  }
          			  if(o==0) {
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
          				 
          			  }
          			}
          			if(t==1) {
      				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=0;
          			}
          			if(t==2) {
          				nblink++;
          				nblink++;
      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=2;
          			}

        		  }
        	  }
        	  else if(j==w-1 && i!=h-1 && j!=0) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				  
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.WEST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=3;
              			}
              			if(t==1) {
              				nblink--;
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=2;
              			}
        			  }
        			  else{
        				  
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
              			if(t==1) {
              				
            				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
              				  inputGrid.setPiece(i, j, p);;
              				  nbc[i][j]=2;
              			}
        			  }
        		  }
        		  else {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
            			 
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
              			if(t==1) {
              				
          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=2;
              			}
        			  }
        			  else{
        				  
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink++;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
              			if(t==1) {
          				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=0;
              			}
        			  }
        		  }
        	  }        	  
        	  else if(j==0 && i==h-1 && i!=0 && j!=w-1) {
          		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()){
        			  
          			int t=new Random().nextInt(2);
          			if(t==0) {
          				
      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=2;
          			}
          			if(t==1) {
          				nblink--;
      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);
      				  nbc[i][j]=1;
          			}
          			  
        		  }
        		  else {
        			  
          			int t=new Random().nextInt(2);
          			if(t==0) {
          				nblink++;
      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
      				  inputGrid.setPiece(i, j, p);
      				  nbc[i][j]=1;
          			}
          			if(t==1) {
      				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
      				  inputGrid.setPiece(i, j, p);;
      				  nbc[i][j]=0;
          			}
        		  }
        	  }
        	  else if(j==w-1 && i==h-1 && i!=0 && j!=0) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				  nblink--;
        				  nblink--;
        				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[i][j]=2;
        			  }
        			  else{
        				  nblink--;
        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
        				  inputGrid.setPiece(i, j, p);
        				  nbc[i][j]=1;
        			  }
        		  }
        		  else {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				  nblink--;
        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
        				  inputGrid.setPiece(i, j, p);
        				  nbc[i][j]=1;
        			  }
        			  else {
        				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[i][j]=0; 
        			  }
        			  
        		  }
        	  }
        	  else if(i==h-1 && i!=0 && w!=1) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				  
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink--;
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=2;
              			}
              			if(t==1) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=3;
              			}
        			  }
        			  else{
        				  
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				
          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=2;
              			}
              			if(t==1) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
        			  }
        		  }
        		  else {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
            			  
              			int t=new Random().nextInt(2);
              			if(t==0) {
              				nblink--;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
              			if(t==1) {
              				nblink++;
            				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
              				  inputGrid.setPiece(i, j, p);;
              				  nbc[i][j]=2;
              			}
        			  }
        			  else {
        				
              			int t=new Random().nextInt(2);
              			if(t==0) {
          				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
          				  inputGrid.setPiece(i, j, p);;
          				  nbc[i][j]=0;
              			}
              			if(t==1) {
              				nblink++;
          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
          				  inputGrid.setPiece(i, j, p);
          				  nbc[i][j]=1;
              			}
        			  }
        			  
        		  }  
        	  }
        	  //w=1 1 seul colonne
        	  else if(w-1==0 && i==0) {
        		  int t=new Random().nextInt(2);
        		  
        		  if(t==0) {    				 
        				Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
        				inputGrid.setPiece(i, j, p);;
        				nbc[i][j]=0;
 
        		  }
        		  if(t==1) {
        			  nblink++;      			  
        			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
        				inputGrid.setPiece(i, j, p);
        				nbc[i][j]=1;
        				 
        			  
        		  }

        	  }
        	  else if(w-1==0 && i==h-1) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  nblink--;
      			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
      				inputGrid.setPiece(i, j, p);
      				nbc[i][j]=1;
        		  }
        		  else{
      				Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
      				inputGrid.setPiece(i, j, p);;
      				nbc[i][j]=0;  
        		  }
        	  }
        	  
        	  
        	  else if(w-1==0) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
            		  int t=new Random().nextInt(2);
            		  
            		  if(t==0) {    				 
            				Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
            				inputGrid.setPiece(i, j, p);;
            				nbc[i][j]=0;
     
            		  }
            		  if(t==1) {
            			  nblink++;      			  
            			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
            				inputGrid.setPiece(i, j, p);
            				nbc[i][j]=1;
            				 
            			  
            		  }
        		  }
        		  else {
            		  int t=new Random().nextInt(2);
            		  
            		  if(t==0) {    				 
            				Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
            				inputGrid.setPiece(i, j, p);;
            				nbc[i][j]=0;
     
            		  }
            		  if(t==1) {
            			  nblink++;      			  
            			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
            				inputGrid.setPiece(i, j, p);
            				nbc[i][j]=1;
            				 
            			  
            		  }
        		  }
        	  }
        	  
        	  
        	  
        	  //h=1 1 seule ligne
        	  else if(h-1==0 && j==0) {
        		  int t=new Random().nextInt(2);
        		  
        		  if(t==0) {    				 
        				Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
        				inputGrid.setPiece(i, j, p);;
        				nbc[i][j]=0;
 
        		  }
        		  if(t==1) {
        			  nblink++;      			  
        			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
        				inputGrid.setPiece(i, j, p);
        				nbc[i][j]=1;
        				 
        			  
        		  }
        	  }
        	  else if(h-1==0 && j==w-1) {
        		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        			  nblink--;
      			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
      				inputGrid.setPiece(i, j, p);
      				nbc[i][j]=1;
        		  }
        		  else{
      				Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
      				inputGrid.setPiece(i, j, p);;
      				nbc[i][j]=0;  
        		  }
        	  }
        	  
        	  
        	  
        	  else if(h-1==0) {
        		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
            		  int t=new Random().nextInt(2);
            		  
            		  if(t==0) {    				 
            				Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
            				inputGrid.setPiece(i, j, p);;
            				nbc[i][j]=0;
     
            		  }
            		  if(t==1) {
            			  nblink++;      			  
            			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
            				inputGrid.setPiece(i, j, p);
            				nbc[i][j]=1;
            				 
            			  
            		  }
        		  }
        		  else {
            		  int t=new Random().nextInt(2);
            		  
            		  if(t==0) {    				 
            				Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
            				inputGrid.setPiece(i, j, p);;
            				nbc[i][j]=0;
     
            		  }
            		  if(t==1) {
            			  nblink++;      			  
            			  	Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
            				inputGrid.setPiece(i, j, p);
            				nbc[i][j]=1;
            				 
            			  
            		  }
        		  }
        	  }
        	  
        	  
        	  
        	  else {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				
                			int t=new Random().nextInt(3);
                  			if(t==0) {
                  				nblink--;
                  				nblink--;
              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
            				  inputGrid.setPiece(i, j, p);;
            				  nbc[i][j]=2;
                  			}
                  			if(t==1) {
                  				nblink--;
                  			  int o=new Random().nextInt(2);
                			  if(o==1) {
                				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.NORTH);
                				  inputGrid.setPiece(i, j, p);
                				  nbc[i][j]=3;
                			  }
                			  if(o==0) {
                				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.WEST);
                				  inputGrid.setPiece(i, j, p);
                				  nbc[i][j]=3;
                				 
                			  }
                  			}
                  			if(t==2) {

                				  Piece p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
                  				  inputGrid.setPiece(i, j, p);;
                  				  nbc[i][j]=4;
                  			}
        			  }
        			  else{
        				  
                			int t=new Random().nextInt(4);
                  			if(t==0) {
                  				nblink--;
              				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
              				  inputGrid.setPiece(i, j, p);
              				  nbc[i][j]=1;
                  			}
                  			if(t==1) {
                  				
                				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
                  				  inputGrid.setPiece(i, j, p);;
                  				  nbc[i][j]=2;
                  			}
                  			if(t==2) {
                  				nblink++;
              				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
              				  inputGrid.setPiece(i, j, p);
              				  nbc[i][j]=3;
                  			}
                  			if(t==3) {
                  				
              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
            				  inputGrid.setPiece(i, j, p);;
            				  nbc[i][j]=2;
                  			}
        			  }
        		  }
        		  else {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
            			 
                			int t=new Random().nextInt(4);
                  			if(t==0) {
                  				
                				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
                  				  inputGrid.setPiece(i, j, p);;
                  				  nbc[i][j]=2;
                  			}
                  			if(t==1) {
                  				nblink++;
                  				
              				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
              				  inputGrid.setPiece(i, j, p);
              				  nbc[i][j]=3;
                  			}
                  			if(t==2) {
                  				
              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
            				  inputGrid.setPiece(i, j, p);;
            				  nbc[i][j]=2;
                  			}
                  			if(t==3) {
                  				nblink--;
              				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
              				  inputGrid.setPiece(i, j, p);
              				  nbc[i][j]=1;
                  			}
        			  }
        			  else {
        				
                			int t=new Random().nextInt(3);
                  			if(t==0) {
              				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
            				  inputGrid.setPiece(i, j, p);;
            				  nbc[i][j]=0;
                  			}
                  			if(t==1) {
                  				nblink++;
                  				nblink++;
              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
            				  inputGrid.setPiece(i, j, p);;
            				  nbc[i][j]=2;
                  			}
                  			if(t==2) {
                  				nblink++;
                  			  int o=new Random().nextInt(2);
                			  if(o==1) {
                				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
                				  inputGrid.setPiece(i, j, p);
                				  nbc[i][j]=1;
                			  }
                			  if(o==0) {
                				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
                				  inputGrid.setPiece(i, j, p);
                				  nbc[i][j]=1;
                				 
                			  }
                  			}
        			  }
        			  
        		  }
        	  }
    	  }
      }
      System.out.println("de baqe :  ");
      System.out.println(filledGrid);
      for(int i=0;i<h;i++) {
    	  for(int j=0;j<w;j++) {
  			int t=new Random().nextInt(4);
  			if(t==0) {
				
  			}
  			if(t==1) {
  				inputGrid.getPiece(i, j).turn(); 
  			}
  			if(t==2) {
  				inputGrid.getPiece(i, j).turn();
  				inputGrid.getPiece(i, j).turn();
  			}
  			if(t==3) {
  				inputGrid.getPiece(i, j).turn();
  				inputGrid.getPiece(i, j).turn();
  				inputGrid.getPiece(i, j).turn();
  			}
    	  }
      }
     // copyfile(fileName,filledGrid);
    
	}

	
	
/*	
	
	
	public static void generateLevelWnbcc(String fileName, Grid inputGrid) {
	      int w=inputGrid.getWidth();
	      int h=inputGrid.getHeight();
	      int[][] nbc=new int[h][w];
	      int nbcc=inputGrid.getNbcc();
	      filledGrid=inputGrid;
	      
	      
	      
	      int nblink=0;
	      // sans nbcc
	      for(int i=0;i<h;i++) {
	    	  for(int j=0;j<w;j++) {
	    		  	System.out.println((nblink));
	        	  if((i==0 && j==0)) {
	        		  int t=new Random().nextInt(3);
	        		  
	        		  if(t==0) {
	        			 
	        				 
	        				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	        				  inputGrid.setPiece(i, j, p);;
	        				  nbc[i][j]=0;
	        				  
	        				  
	        			  

	        		  }
	        		  if(t==1) {
	        			  nblink++;
	        			  int o=new Random().nextInt(2);
	        			  if(o==1) {
	        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
	        				  inputGrid.setPiece(i, j, p);
	        				  nbc[i][j]=1;
	        			  }
	        			  if(o==0) {
	        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
	        				  inputGrid.setPiece(i, j, p);
	        				  nbc[i][j]=1;
	        				 
	        			  }
	        		  }
	        		  if(t==2) {
	        			  nblink++;
	        			  nblink++;

	        				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
	        				  inputGrid.setPiece(i, j, p);;
	        				  nbc[i][j]=2;
	        			  
	        	  }
	          
	        	  }
	        	  else if((i==0 && j==w-1)) {
	          		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        			 
	          			int t=new Random().nextInt(2);
	          			if(nblink==1) {
	          				t=1;
	          			}
	          			if(t==0) {
	          				nblink--;
	          				
	      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
	      				  inputGrid.setPiece(i, j, p);
	      				  nbc[i][j]=1;
	          			}
	          			if(t==1) {
	          				
	      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=2;
	          			}

	        		  }
	          		  else {
	          			 
	            			int t=new Random().nextInt(2);
	              			if(t==0) {
	              				nblink++;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	              			if(t==1) {
	          				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=0;
	              			}

	    				 
	          			
	          		  }
	        	  }
	        	  else if(i==0) {
	          		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        			  
	            			int t=new Random().nextInt(4);
		          			if(nblink==1) {
		          				t=new Random().nextInt(3)+1;
		          			}
	              			if(t==0) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	              			if(t==1) {
	              				
	          				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=2;
	              			}
	              			if(t==2) {
	              				
	          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=2;
	              			}
	              			if(t==3) {
	              				
	              				nblink++;
	          				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=3;
	              			}
	        		  }
	        		  else {

	          			int t=new Random().nextInt(3);
	          			if(t==0) {
	          				nblink++;
	          			  int o=new Random().nextInt(2);
	          			  if(o==1) {
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	          			  }
	          			  if(o==0) {
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	          				 
	          			  }
	          			}
	          			if(t==1) {
	          				nblink++;
	          				nblink++;
	      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=2;
	          			}
	          			if(t==2) {
	      				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=0;
	          			}
	        		  }
	        	  }
	        	  else if(j==0 && i!=h-1) {
	          		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()){
	        			 
	          			int t=new Random().nextInt(4);
	          			if(nblink==1) {
	          				t=new Random().nextInt(3)+1;
	          			}
	          			if(t==0) {
	          				nblink--;
	      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);
	      				  nbc[i][j]=1;
	          			}
	          			if(t==1) {
	          				
	        				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
	        				  inputGrid.setPiece(i, j, p);;
	        				  nbc[i][j]=2;
	          			}
	          			if(t==2) {
	          				
	          				nblink++;
	      				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
	      				  inputGrid.setPiece(i, j, p);
	      				  nbc[i][j]=3;
	          			}
	          			if(t==3) {
	          				
	      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=2;
	          			}
	          			  
	        		  }
	        		  else {
	        			 
	          			int t=new Random().nextInt(3);
	          			if(t==0) {
	          				nblink++;
	          			  int o=new Random().nextInt(2);
	          			  if(o==1) {
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	          			  }
	          			  if(o==0) {
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	          				 
	          			  }
	          			}
	          			if(t==1) {
	      				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=0;
	          			}
	          			if(t==2) {
	          				nblink++;
	          				nblink++;
	      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=2;
	          			}

	        		  }
	        	  }
	        	  else if(j==w-1 && i!=h-1) {
	        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        				  
	              			int t=new Random().nextInt(2);
		          			if(nblink==2) {
		          				t=0;
		          			}
	              			if(t==0) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.WEST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=3;
	              			}
	              			if(t==1) {
	              				nblink--;
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=2;
	              			}
	        			  }
	        			  else{
	        				  
	              			int t=new Random().nextInt(2);
		          			if(nblink==1) {
		          				t=1;
		          			}
	              			if(t==0) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	              			if(t==1) {
	              				
	            				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
	              				  inputGrid.setPiece(i, j, p);;
	              				  nbc[i][j]=2;
	              			}
	        			  }
	        		  }
	        		  else {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	            			 
	              			int t=new Random().nextInt(2);
		          			if(nblink==1) {
		          				t=1;
		          			}
	              			if(t==0) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	              			if(t==1) {
	              				
	          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=2;
	              			}
	        			  }
	        			  else{
	        				  
	              			int t=new Random().nextInt(2);
	              			if(t==0) {
	              				nblink++;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	              			if(t==1) {
	          				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=0;
	              			}
	        			  }
	        		  }
	        	  }        	  
	        	  else if(j==0 && i==h-1) {
	          		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()){
	        			  
	          			int t=new Random().nextInt(2);
	          			if(nblink==1) {
	          				t=0;
	          			}
	          			if(t==0) {
	          				
	      				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=2;
	          			}
	          			if(t==1) {
	          				nblink--;
	      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);
	      				  nbc[i][j]=1;
	          			}
	          			  
	        		  }
	        		  else {
	        			  
	          			int t=new Random().nextInt(2);
	          			if(t==0) {
	          				nblink++;
	      				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
	      				  inputGrid.setPiece(i, j, p);
	      				  nbc[i][j]=1;
	          			}
	          			if(t==1) {
	      				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	      				  inputGrid.setPiece(i, j, p);;
	      				  nbc[i][j]=0;
	          			}
	        		  }
	        	  }
	        	  else if(j==w-1 && i==h-1) {
	        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        				  nblink--;
	        				  nblink--;
	        				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
	        				  inputGrid.setPiece(i, j, p);;
	        				  nbc[i][j]=2;
	        			  }
	        			  else{
	        				  nblink--;
	        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
	        				  inputGrid.setPiece(i, j, p);
	        				  nbc[i][j]=1;
	        			  }
	        		  }
	        		  else {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        				  nblink--;
	        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
	        				  inputGrid.setPiece(i, j, p);
	        				  nbc[i][j]=1;
	        			  }
	        			  else {
	        				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	        				  inputGrid.setPiece(i, j, p);;
	        				  nbc[i][j]=0; 
	        			  }
	        			  
	        		  }
	        	  }
	        	  else if(i==h-1) {
	        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        				  
	              			int t=new Random().nextInt(2);
		          			if(nblink==2) {
		          				t=1;
		          			}
	              			if(t==0) {
	              				nblink--;
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=2;
	              			}
	              			if(t==1) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=3;
	              			}
	        			  }
	        			  else{
	        				  
	              			int t=new Random().nextInt(2);
		          			if(nblink==1) {
		          				t=0;
		          			}
	              			if(t==0) {
	              				
	          				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=2;
	              			}
	              			if(t==1) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	        			  }
	        		  }
	        		  else {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	            			  
	              			int t=new Random().nextInt(2);
		          			if(nblink==1) {
		          				t=1;
		          			}
	              			if(t==0) {
	              				nblink--;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	              			if(t==1) {
	              				nblink++;
	            				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
	              				  inputGrid.setPiece(i, j, p);;
	              				  nbc[i][j]=2;
	              			}
	        			  }
	        			  else {
	        				
	              			int t=new Random().nextInt(2);
	              			if(t==0) {
	          				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	          				  inputGrid.setPiece(i, j, p);;
	          				  nbc[i][j]=0;
	              			}
	              			if(t==1) {
	              				nblink++;
	          				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
	          				  inputGrid.setPiece(i, j, p);
	          				  nbc[i][j]=1;
	              			}
	        			  }
	        			  
	        		  }  
	        	  }
	        	  else {
	        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	        				
	                			int t=new Random().nextInt(3);
			          			if(nblink==2) {
			          				t=new Random().nextInt(2)+1;
			          			}
			          			if(nblink==1) {
			          				t=2;
			          			}
	                  			if(t==0) {
	                  				nblink--;
	                  				nblink--;
	              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.WEST);
	            				  inputGrid.setPiece(i, j, p);;
	            				  nbc[i][j]=2;
	                  			}
	                  			if(t==1) {
	                  				nblink--;
	                  			  int o=new Random().nextInt(2);
	                			  if(o==1) {
	                				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.NORTH);
	                				  inputGrid.setPiece(i, j, p);
	                				  nbc[i][j]=3;
	                			  }
	                			  if(o==0) {
	                				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.WEST);
	                				  inputGrid.setPiece(i, j, p);
	                				  nbc[i][j]=3;
	                				 
	                			  }
	                  			}
	                  			if(t==2) {

	                				  Piece p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
	                  				  inputGrid.setPiece(i, j, p);;
	                  				  nbc[i][j]=4;
	                  			}
	        			  }
	        			  else{
	        				  
	                			int t=new Random().nextInt(4);
			          			if(nblink==1) {
			          				t=new Random().nextInt(3)+1;
			          			}
	                  			if(t==0) {
	                  				nblink--;
	              				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.NORTH);
	              				  inputGrid.setPiece(i, j, p);
	              				  nbc[i][j]=1;
	                  			}
	                  			if(t==1) {
	                  				
	                				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.NORTH);
	                  				  inputGrid.setPiece(i, j, p);;
	                  				  nbc[i][j]=2;
	                  			}
	                  			if(t==2) {
	                  				nblink++;
	              				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
	              				  inputGrid.setPiece(i, j, p);
	              				  nbc[i][j]=3;
	                  			}
	                  			if(t==3) {
	                  				
	              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.NORTH);
	            				  inputGrid.setPiece(i, j, p);;
	            				  nbc[i][j]=2;
	                  			}
	        			  }
	        		  }
	        		  else {
	        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
	            			 
	                			int t=new Random().nextInt(4);
			          			if(nblink==1) {
			          				t=new Random().nextInt(3);
			          			}
	                  			if(t==0) {
	                  				
	                				  Piece p=new Piece(i,j,PieceType.BAR,Orientation.EAST);
	                  				  inputGrid.setPiece(i, j, p);;
	                  				  nbc[i][j]=2;
	                  			}
	                  			if(t==1) {
	                  				nblink++;
	                  				
	              				  Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
	              				  inputGrid.setPiece(i, j, p);
	              				  nbc[i][j]=3;
	                  			}
	                  			if(t==2) {
	                  				
	              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.SOUTH);
	            				  inputGrid.setPiece(i, j, p);;
	            				  nbc[i][j]=2;
	                  			}
	                  			if(t==3) {
	                  				nblink--;
	              				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.WEST);
	              				  inputGrid.setPiece(i, j, p);
	              				  nbc[i][j]=1;
	                  			}
	        			  }
	        			  else {
	        				
	                			int t=new Random().nextInt(3);
	                  			if(t==0) {
	              				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
	            				  inputGrid.setPiece(i, j, p);;
	            				  nbc[i][j]=0;
	                  			}
	                  			if(t==1) {
	                  				nblink++;
	                  				nblink++;
	              				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
	            				  inputGrid.setPiece(i, j, p);;
	            				  nbc[i][j]=2;
	                  			}
	                  			if(t==2) {
	                  				nblink++;
	                  			  int o=new Random().nextInt(2);
	                			  if(o==1) {
	                				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
	                				  inputGrid.setPiece(i, j, p);
	                				  nbc[i][j]=1;
	                			  }
	                			  if(o==0) {
	                				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
	                				  inputGrid.setPiece(i, j, p);
	                				  nbc[i][j]=1;
	                				 
	                			  }
	                  			}
	        			  }
	        			  
	        		  }
	        	  }
	    	  }
	      }
	      for(int i=0;i<h;i++) {
	    	  for(int j=0;j<w;j++) {
	  			int t=new Random().nextInt(4);
	  			if(t==0) {
					
	  			}
	  			if(t==1) {
	  				inputGrid.getPiece(i, j).turn(); 
	  			}
	  			if(t==2) {
	  				inputGrid.getPiece(i, j).turn();
	  				inputGrid.getPiece(i, j).turn();
	  			}
	  			if(t==3) {
	  				inputGrid.getPiece(i, j).turn();
	  				inputGrid.getPiece(i, j).turn();
	  				inputGrid.getPiece(i, j).turn();
	  			}
	    	  }
	      }
	      copyfile(fileName,filledGrid);
		}

		*/
	
	
	
	public static int[] copyGrid(Grid filledGrid, Grid inputGrid, int i, int j) {
		Piece p;
		int hmax = inputGrid.getHeight();
		int wmax = inputGrid.getWidth();

		if (inputGrid.getHeight() != filledGrid.getHeight())
			hmax = filledGrid.getHeight() + i; // we must adjust hmax to have the height of the original grid
		if (inputGrid.getWidth() != filledGrid.getWidth())
			wmax = filledGrid.getWidth() + j;

		int tmpi = 0;// temporary variable to stock the last index
		int tmpj = 0;

		// DEBUG System.out.println("copyGrid : i =" + i + " & j = " + j);
		// DEBUG System.out.println("hmax = " + hmax + " - wmax = " + wmax);
		for (int x = i; x < hmax; x++) {
			for (int y = j; y < wmax; y++) {
				// DEBUG System.out.println("x = " + x + " - y = " + y);
				p = filledGrid.getPiece(x - i, y - j);
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(p);
				inputGrid.setPiece(x, y, new Piece(x, y, p.getType(), p.getOrientation()));
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(inputGrid.getPiece(x, y));
				tmpj = y;
			}
			tmpi = x;
		}
		//DEBUGSystem.out.println("tmpi =" + tmpi + " & tmpj = " + tmpj);
		return new int[] { tmpi, tmpj };
	}
	
	
	
	public static void copyfile(String fileName, Grid inputGrid) {
		
		try{
			Path file= Paths.get(fileName);

		
		Charset charset = Charset.forName("US-ASCII");
		
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		
			String w="";
			w=w+inputGrid.getWidth();
			String h="";
			h=h+inputGrid.getHeight();
		      writer.write(w, 0, w.length());
		      writer.newLine();
		      writer.write(h, 0, h.length());
		      writer.newLine();
		      for(int i=0;i<inputGrid.getHeight();i++) {
		    	  for(int j=0;j<inputGrid.getWidth();j++) {
		    		  String Piece="";
		    		  PieceType t=inputGrid.getPiece(i, j).getType();
		    		  Orientation o=inputGrid.getPiece(i, j).getOrientation();
		    			switch(t) {
		    			case VOID :
		    				Piece=Piece+0+" ";
		    				break;
		    			case ONECONN : 
		    				Piece=Piece+1+" ";
		    				break;
		    			case BAR:
		    				Piece=Piece+2+" ";
		    				break;
		    			case TTYPE:
		    				Piece=Piece+3+" ";
		    				break;
		    			case LTYPE:
		    				Piece=Piece+5+" ";
		    				break;
		    			case FOURCONN:
		    				Piece=Piece+4+" ";
		    				break;
		    			
		    		}
		    			
		    			switch(o) {
		    			case NORTH :
		    				Piece=Piece+0;;
		    				break;
		    			case EAST : 
		    				Piece=Piece+1;
		    				break;
		    			case WEST:
		    				Piece=Piece+2;
		    				break;
		    			case SOUTH:
		    				Piece=Piece+3;
		    				break;	
		    		}
		    		writer.write(Piece, 0, Piece.length());	
		    		writer.newLine();
		    	  }
		      	}
		      writer.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		}
		catch(NullPointerException E) {
			E.printStackTrace();
		}
		catch(Exception E) {
			 E.printStackTrace();
		}
	
	}

}