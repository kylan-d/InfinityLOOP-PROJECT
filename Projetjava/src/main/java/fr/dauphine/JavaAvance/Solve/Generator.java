package fr.dauphine.JavaAvance.Solve;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

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
      copyfile(fileName,filledGrid);
    
	}

	
	

	
	
	
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
	
	public static void generateLevelWnbcc(String fileName, Grid inputGrid) {
	      int w=inputGrid.getWidth();
	      int h=inputGrid.getHeight();
	      int[][] nbc=new int[h][w];
	      int nbcc=inputGrid.getNbcc();
	      filledGrid=inputGrid;
	      int nblink=0;
	      Stack pi = new Stack<Integer>();
	      Stack pj = new Stack<Integer>();
	      
	      ArrayList<Place> thisComp=new ArrayList<Place>();

	      ArrayList<Place> OtherComp=new ArrayList<Place>();
		  int t2=new Random().nextInt(3);
		  
		  if(t2==0) {
			 
				 
				  Piece p=new Piece(0,0,PieceType.VOID,Orientation.NORTH);
				  inputGrid.setPiece(0, 0, p);;
				  
				  
				  
			  

		  }
		  if(t2==1) {
			  nblink++;
			  int o=new Random().nextInt(2);
			  if(o==1) {
				  Piece p=new Piece(0,0,PieceType.ONECONN,Orientation.SOUTH);
				  inputGrid.setPiece(0,0, p);
				  pi.push(0);
				  pj.push(1);
				  
			  }
			  if(o==0) {
				  Piece p=new Piece(0,0,PieceType.ONECONN,Orientation.EAST);
				  inputGrid.setPiece(0,0, p);
				  pi.push(1);
				  pj.push(0);
				 
			  }
		  }
		  if(t2==2) {
			  nblink++;
			  nblink++;

				  Piece p=new Piece(0,0,PieceType.LTYPE,Orientation.EAST);
				  inputGrid.setPiece(0,0, p);;
				  pi.push(0);
				  pj.push(1);
				  
				  pi.push(1);
				  pj.push(0);
			  
	  }
	thisComp.add(new Place(0,0));

	int i=0;
	int j=0;
	while(nbcc!=0) {
		if(pi.size()==0) {
			break;
		}
		while(pi.size()!=0) {
			i=(int) pi.pop();
			j=(int) pj.pop();
			int vh=0;
			int vg=0;
			int vb=0;
			int vd=0;
			// voison haut, voisin gauche, voisin bas, voisin droit
			//-1 ne doit pas etre connecté
			//0 peut importe
			//1 doit etre connecté
			Place ph=new Place(i-1,j);
			Place pb=new Place(i+1,j);
			Place pd=new Place(i,j+1);
			Place pg=new Place(i,j-1);
			if(j==w-1 && i==0) {
				vd=-1;
				
				vh=-1;
				
				if(OtherComp.contains(pg)) {
					vg=-1;
				}
				else if(thisComp.contains(pg)) {
					if(inputGrid.getPiece(pg.i, pg.j).hasRightConnector()) {
						vg=1;
					}
					else {
						vg=-1;
					}
				}
				else {
					vg=0;
				}
				
				if(OtherComp.contains(pb)) {
					vb=-1;
				}
				else if(thisComp.contains(pb)) {
					if(inputGrid.getPiece(pb.i, pb.j).hasTopConnector()) {
						vb=1;
					}
					else {
						vb=-1;
					}
				}
				else {
					vb=0;
				}
				
			}
			else if(j==0 &&i==h-1) {
				vg=-1;
				
				vb=-1;
				
				if(OtherComp.contains(ph)) {
					vh=-1;
				}
				else if(thisComp.contains(ph)) {
					if(inputGrid.getPiece(ph.i, ph.j).hasBottomConnector()) {
						vh=1;
					}
					else {
						vh=-1;
					}
				}
				else {
					vh=0;
				}
				
				if(OtherComp.contains(pd)) {
					vd=-1;
				}
				else if(thisComp.contains(pd)) {
					if(inputGrid.getPiece(pd.i, pd.j).hasLeftConnector()) {
						vd=1;
					}
					else {
						vd=-1;
					}
				}
				else {
					vd=0;
				}
			}
			
			
			else if(j==w-1 &&i==h-1) {
				vd=-1;
				
				vb=-1;
				
				if(OtherComp.contains(pg)) {
					vg=-1;
				}
				else if(thisComp.contains(pg)) {
					if(inputGrid.getPiece(pg.i, pg.j).hasRightConnector()) {
						vg=1;
					}
					else {
						vg=-1;
					}
				}
				else {
					vg=0;
				}
				
				if(OtherComp.contains(ph)) {
					vh=-1;
				}
				else if(thisComp.contains(ph)) {
					if(inputGrid.getPiece(ph.i, ph.j).hasBottomConnector()) {
						vh=1;
					}
					else {
						vh=-1;
					}
				}
				else {
					vh=0;
				}
			}
			
			
			else if(j==0 && i!=h-1) {
				vg=-1;
				
				if(OtherComp.contains(pb)) {
					vb=-1;
				}
				else if(thisComp.contains(pb)) {
					if(inputGrid.getPiece(pb.i, pb.j).hasTopConnector()) {
						vb=1;
					}
					else {
						vb=-1;
					}
				}
				else {
					vb=0;
				}
				
				if(OtherComp.contains(ph)) {
					vh=-1;
				}
				else if(thisComp.contains(ph)) {
					if(inputGrid.getPiece(ph.i, ph.j).hasBottomConnector()) {
						vh=1;
					}
					else {
						vh=-1;
					}
				}
				else {
					vh=0;
				}
				
				
				if(OtherComp.contains(pd)) {
					vd=-1;
				}
				else if(thisComp.contains(pd)) {
					if(inputGrid.getPiece(pd.i, pd.j).hasLeftConnector()) {
						vd=1;
					}
					else {
						vd=-1;
					}
				}
				else {
					vd=0;
				}
			}
			
			
			else if(i==0 && j!=w-1) {
				vh=-1;
				
				if(OtherComp.contains(pg)) {
					vg=-1;
				}
				else if(thisComp.contains(pg)) {
					if(inputGrid.getPiece(pg.i, pg.j).hasRightConnector()) {
						vg=1;
					}
					else {
						vg=-1;
					}
				}
				else {
					vg=0;
				}
				
				if(OtherComp.contains(pb)) {
					vb=-1;
				}
				else if(thisComp.contains(pb)) {
					if(inputGrid.getPiece(pb.i, pb.j).hasTopConnector()) {
						vb=1;
					}
					else {
						vb=-1;
					}
				}
				else {
					vb=0;
				}
				
				
				if(OtherComp.contains(pd)) {
					vd=-1;
				}
				else if(thisComp.contains(pd)) {
					if(inputGrid.getPiece(pd.i, pd.j).hasLeftConnector()) {
						vd=1;
					}
					else {
						vd=-1;
					}
				}
				else {
					vd=0;
				}
			}
			
			
			else if(j==w-1 && i!=h-1) {
				vd=-1;
				
				if(OtherComp.contains(pg)) {
					vg=-1;
				}
				else if(thisComp.contains(pg)) {
					if(inputGrid.getPiece(pg.i, pg.j).hasRightConnector()) {
						vg=1;
					}
					else {
						vg=-1;
					}
				}
				else {
					vg=0;
				}
				
				if(OtherComp.contains(pb)) {
					vb=-1;
				}
				else if(thisComp.contains(pb)) {
					if(inputGrid.getPiece(pb.i, pb.j).hasTopConnector()) {
						vb=1;
					}
					else {
						vb=-1;
					}
				}
				else {
					vb=0;
				}
				
				if(OtherComp.contains(ph)) {
					vh=-1;
				}
				else if(thisComp.contains(ph)) {
					if(inputGrid.getPiece(ph.i, ph.j).hasBottomConnector()) {
						vh=1;
					}
					else {
						vh=-1;
					}
				}
				else {
					vh=0;
				}
			}
			
			
			else if(i==h-1 && j!=w-1) {
				vb=-1;
				
				if(OtherComp.contains(pg)) {
					vg=-1;
				}
				else if(thisComp.contains(pg)) {
					if(inputGrid.getPiece(pg.i, pg.j).hasRightConnector()) {
						vg=1;
					}
					else {
						vg=-1;
					}
				}
				else {
					vg=0;
				}
				
				if(OtherComp.contains(ph)) {
					vh=-1;
				}
				else if(thisComp.contains(ph)) {
					if(inputGrid.getPiece(ph.i, ph.j).hasBottomConnector()) {
						vh=1;
					}
					else {
						vh=-1;
					}
				}
				else {
					vh=0;
				}
				
				if(OtherComp.contains(pd)) {
					vd=-1;
				}
				else if(thisComp.contains(pd)) {
					if(inputGrid.getPiece(pd.i, pd.j).hasLeftConnector()) {
						vd=1;
					}
					else {
						vd=-1;
					}
				}
				else {
					vd=0;
				}
			}
			thisComp.add(new Place(i,j));
			
			
      	 if(vb==1 && vd== 1 && vh==1 && vg==1) {
			  Piece p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
				  inputGrid.setPiece(i, j, p);;
      	 }
      	 
      	 
      	 if(vb==1 && vd== 1 && vh==1 && vg==0) {
      		int t=new Random().nextInt(2);
      		if(t==0) {
  			  Piece p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
			  inputGrid.setPiece(i, j, p);;
			  pi.push(i);
			  pj.push(j-1);
      		}
      		if(t==1) {
      			Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
  			  inputGrid.setPiece(i, j, p);;
      		}
      	 }
      	 
      	 
      	 
      	 if(vb==1 && vd== 1 && vh==1 && vg==-1) {
   			Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
			  inputGrid.setPiece(i, j, p);;
      	 }
      	 
      	 if(vb==1 && vd== 1 && vh==0 && vg==1) {
       		int t=new Random().nextInt(2);
       		if(t==0) {
   			  Piece p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
 			  inputGrid.setPiece(i, j, p);;
 			  pi.push(i);
 			  pj.push(j-1);
       		}
       		if(t==1) {
       			Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
   			  inputGrid.setPiece(i, j, p);;
       		}
      	 }
      	 
      	 if(vb==1 && vd== 1 && vh==0 && vg==0) {
        		int t=new Random().nextInt(2);
           		if(t==0) {
       			  Piece p=new Piece(i,j,PieceType.FOURCONN,Orientation.NORTH);
     			  inputGrid.setPiece(i, j, p);;
     			  pi.push(i);
     			  pj.push(j-1);
     			 pi.push(i-1);
    			  pj.push(j);
           		}
           		if(t==1) {
           			int o=new Random().nextInt(2);
           			if(o==0) {
           				Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
             			  inputGrid.setPiece(i, j, p);;
             			  pi.push(i);
             			  pj.push(j-1);
           			}
           			
           			if(o==1) {
           				Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
             			  inputGrid.setPiece(i, j, p);;
              			 pi.push(i-1);
              			 pj.push(j);
           			}
           			
           		}
           		if(t==2) {
         			  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
         			  inputGrid.setPiece(i, j, p);;
           		}
      	 }
      	 
      	 if(vb==1 && vd== 1 && vh==0 && vg==-1) {
        		int t=new Random().nextInt(2);
           		if(t==0) {
       			  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
     			  inputGrid.setPiece(i, j, p);;

           		}
           		if(t==1) {
           			Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.EAST);
       			  inputGrid.setPiece(i, j, p);;
     			  pi.push(i-1);
     			  pj.push(j);
           		}
      	 }
      	 
      	 if(vb==1 && vd== 1 && vh==-1 && vg==1) {
				Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
   			  inputGrid.setPiece(i, j, p);;
      	 }
      	 //pas fini mais meme principe pour la suite
      	 if(vb==1 && vd== 1 && vh==-1 && vg==0) {
     		int t=new Random().nextInt(2);
       		if(t==0) {
   			  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
 			  inputGrid.setPiece(i, j, p);;

       		}
       		if(t==1) {
       			Piece p=new Piece(i,j,PieceType.TTYPE,Orientation.SOUTH);
   			  inputGrid.setPiece(i, j, p);;
 			  pi.push(i);
 			  pj.push(j-1);
       		}
      	 }
      	 
      	 if(vb==1 && vd== 1 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 if(vb==1 && vd== 0 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== 0 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== 0 && vh==1 && vg==-1) {
      		 
      	 }
      	 if(vb==1 && vd== 0 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== 0 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== 0 && vh==0 && vg==-1) {
      		 
      	 }
      	 if(vb==1 && vd== 0 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== 0 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== 0 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 if(vb==1 && vd== -1 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== -1 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== -1 && vh==1 && vg==-1) {
      		 
      	 }
      	 if(vb==1 && vd== -1 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== -1 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== -1 && vh==0 && vg==-1) {
      		 
      	 }
      	 if(vb==1 && vd== -1 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== -1 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==1 && vd== -1 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 
      	 
      	 
      	 
      	 if(vb==0 && vd== 1 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==1 && vg==-1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==0 && vg==-1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 1 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 if(vb==0 && vd== 0 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 0 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 0 && vh==1 && vg==-1) {
      		 
      	 }
      	 if(vb==0 && vd== 0 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 0 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 0 && vh==0 && vg==-1) {
      		 
      	 }
      	 if(vb==0 && vd== 0 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 0 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== 0 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 if(vb==0 && vd== -1 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== -1 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== -1 && vh==1 && vg==-1) {
      		 
      	 }
      	 if(vb==0 && vd== -1 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== -1 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== -1 && vh==0 && vg==-1) {
      		 
      	 }
      	 if(vb==0 && vd== -1 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== -1 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==0 && vd== -1 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 
      	 
      	 if(vb==-1 && vd== 1 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==1 && vg==-1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==0 && vg==-1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 1 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 if(vb==-1 && vd== 0 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 0 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 0 && vh==1 && vg==-1) {
      		 
      	 }
      	 if(vb==-1 && vd== 0 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 0 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 0 && vh==0 && vg==-1) {
      		 
      	 }
      	 if(vb==-1 && vd== 0 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 0 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== 0 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
      	 if(vb==-1 && vd== -1 && vh==1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== -1 && vh==1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== -1 && vh==1 && vg==-1) {
      		 
      	 }
      	 if(vb==-1 && vd== -1 && vh==0 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== -1 && vh==0 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== -1 && vh==0 && vg==-1) {
      		 
      	 }
      	 if(vb==-1 && vd== -1 && vh==-1 && vg==1) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== -1 && vh==-1 && vg==0) {
      		 
      	 }
      	 
      	 if(vb==-1 && vd== -1 && vh==-1 && vg==-1) {
      		 
      	 }
      	 
      	 
		}
		nbcc--;
		OtherComp.addAll(thisComp);
		thisComp=new ArrayList<Place>();
		int itemp=0;
		int jtemp=0;
	      for(int i2=0;i2<h;i2++) {
	    	  for(int j2=0;j2<w;j2++) {
	    		  Place pa=new Place(i2,j2);
	    		  if(OtherComp.contains(pa)==false) {
	    			  itemp=i2;
	    			  jtemp=j2;
	    			  break;
	    		  }
	    	  }
    		  if(OtherComp.contains(new Place(itemp,jtemp))==false) {
    			  i=itemp;
    			  j=jtemp;
    			  break;
    		  }

	    	  }
	      pi.push(i);
	      pj.push(j);
	      
	      
	}
	}
}