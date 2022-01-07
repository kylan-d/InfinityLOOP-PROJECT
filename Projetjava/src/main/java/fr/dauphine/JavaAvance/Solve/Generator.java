package fr.dauphine.JavaAvance.Solve;


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

	private static Grid filledGrid;

	/**
	 * @param output
	 *            file name
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void generateLevel(String fileName, Grid inputGrid) {
      int w=inputGrid.getWidth();
      int h=inputGrid.getHeight();
      int[][] nbc=new int[h][w];
      int nbcc=inputGrid.getNbcc();
      //int nbcc=inputGrid.getNbcc();
      
      // sans nbcc
      for(int i=0;i<h;i++) {
    	  for(int j=0;j<w;j++) {
        	  if((i==0 && j==0)) {
        		  int t=new Random().nextInt(3);
        		  
        		  if(t==0) {
        			  int o=new Random().nextInt(1);
        			  if(o==0) {
        				 
        				  Piece p=new Piece(i,j,PieceType.VOID,Orientation.NORTH);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[0][0]=0;
        				  
        			  }

        		  }
        		  if(t==1) {
        			  int o=new Random().nextInt(2);
        			  if(o==1) {
        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.SOUTH);
        				  inputGrid.setPiece(i, j, p);
        				  nbc[0][0]=1;
        			  }
        			  if(o==0) {
        				  Piece p=new Piece(i,j,PieceType.ONECONN,Orientation.EAST);
        				  inputGrid.setPiece(i, j, p);
        				  nbc[0][0]=1;
        				 
        			  }
        		  }
        		  if(t==2) {

        				  Piece p=new Piece(i,j,PieceType.LTYPE,Orientation.EAST);
        				  inputGrid.setPiece(i, j, p);;
        				  nbc[0][0]=2;
        			  
        	  }
          
        	  }
        	  else if((i==0 && j==w-1)) {
          		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        			  // ONECON orientation ouest OU ltype south
          			  
        		  }
          		  else {
          			 // ONECON south  OU void
          			
          		  }
        	  }
        	  else if(i==0) {
          		  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        			  // ONECON orientation ouest OU bar east OU ltype south OU ttype south
          			  
        		  }
        		  else {
        			  //onecon south OU east OU ltype east
        		  }
        	  }
        	  else if(j==0 && i!=h-1) {
          		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()){
        			  // ONECON north OU ttype east OU bar north OU Ltype north
          			  
        		  }
        		  else {
        			  //onecon south ou east OU void OU Ltype east 
        		  }
        	  }
        	  else if(j==w-1 && i!=h-1) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				  //ttype west OU ltype west
        			  }
        			  else{
        				  //onecont north  OU bar north 
        			  }
        		  }
        		  else {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
            			  //onecon west OU Ltype south
        			  }
        			  else{
        				  //onecon south OU void 
        			  }
        		  }
        	  }        	  
        	  else if(j==0 && i==h-1) {
          		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()){
        			  // ONECON north OU Ltype north
          			  
        		  }
        		  else {
        			  //onecon east OU void 
        		  }
        	  }
        	  else if(j==w-1 && i==h-1) {
        		  if(inputGrid.getPiece(i-1, j).hasBottomConnector()) {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
        				  //ltype west
        			  }
        			  else{
        				  //onecont north
        			  }
        		  }
        		  else {
        			  if(inputGrid.getPiece(i, j-1).hasRightConnector()){
            			  //onecon west 
        			  }
        			  else {
        				//void  
        			  }
        			  
        		  }
        	  }
        	  else {
        		  //
        	  }
    	  }
      }
		
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

}