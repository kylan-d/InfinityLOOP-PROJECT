package fr.dauphine.JavaAvance.Solve;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.GUI.Grid;
import java.lang.Math;

public class Solver {
	Grid g4;
	public static void main(String[] args) {

		// To be implemented

	}
	
	public boolean solvePile(Grid g) {
		boolean a=false;
		Checker c= new Checker();
		if(c.check(g)==true) {
			return true;
		}
		else {
			Grid g2= new Grid(g.getWidth(),g.getHeight());
			Generator gen=new Generator();
			gen.copyGrid(g, g2, 0, 0);
			Stack stack1 = new Stack<ArrayList<Piece>>();
			
			
			Piece p=g2.getPiece(0,0);
			
			for(int k=0;k<4;k++) {
				p.turn();
				Piece p2=new Piece(p.getPosY(),p.getPosX(),p.getType(),p.getOrientation());
				ArrayList<Piece> sol=new ArrayList<>();
				sol.add(p2);
				stack1.push(sol);
				
			}
			ArrayList<Orientation> possibleOrientations=p.getPossibleOrientations();
			for (Orientation ori : possibleOrientations) {
				Piece p2=new Piece(p.getPosY(),p.getPosX(),p.getType(),ori);
				ArrayList<Piece> sol=new ArrayList<>();
				sol.add(p2);
				stack1.push(sol);
			}
			
			
		      for(int i=0;i<g2.getHeight();i++) {
		    	  for(int j=0;j<g2.getWidth();j++) {
		    		  if(i!=0 || j!=0) {
		    			  Stack stack2 = new Stack();
		    			  while(stack1.size()!=0) {
		    				  ArrayList<Piece> sol2=(ArrayList<Piece>) stack1.pop();
		    				  Piece p3=g2.getPiece(i,j);
		    				  possibleOrientations=p3.getPossibleOrientations();
		    				  for (Orientation ori : possibleOrientations) {
		    					  
		    					  Piece p4=new Piece(p3.getPosY(),p3.getPosX(),p3.getType(),ori);
		    					  if((i!=0 && i!=g2.getHeight()-1 && j!=0 && j!=g2.getWidth()-1) ||(i==0 &&p.hasTopConnector()==false) ||(i==g2.getHeight()-1 &&p.hasBottomConnector()==false) ||(j==0 &&p.hasLeftConnector()==false) ||(j==g2.getWidth()-1 &&p.hasRightConnector()==false)) {
		    					  ArrayList<Piece> sol=(ArrayList<Piece>) sol2.clone();
		    					  int v=0;
		    					  Piece pg=null;
		    					  Piece ph=null;
		    					/*  for(int k=0;k<sol.size();k++) {
		    						  if(sol.get(i).getPosX()==p4.getPosX()-1 && sol.get(i).getPosY()==p4.getPosY() ) {
		    							  pg=sol.get(i);
		    						  }
		    						  if(sol.get(i).getPosX()==p4.getPosX() && sol.get(i).getPosY()==p4.getPosY()-1 ) {
		    							  ph=sol.get(i);
		    						  }
		    					  }*/
		    					//  if(pg==null &&ph==null) {
		    						  sol.add(p4);
			    					  stack2.push(sol);
		    					  }
		    					 /* }
		    					  else if(pg!= null && ph==null) {
		    						  if(p4.hasLeftConnector()==true && pg.hasRightConnector()==true) {
		    							  sol.add(p4);
				    					  stack2.push(sol);
		    						  }
		    					  }
		    					  else if(pg== null && ph!=null) {
		    						  if(p4.hasTopConnector()==true && ph.hasBottomConnector()==true) {
		    							  sol.add(p4);
				    					  stack2.push(sol);
		    						  }
		    					  }
		    					  else if(pg!= null && ph!=null) {
		    						  if(p4.hasLeftConnector()==true && pg.hasRightConnector()==true && p4.hasTopConnector()==true && ph.hasBottomConnector()==true) {
		    							  sol.add(p4);
				    					  stack2.push(sol);
		    						  }
		    					  }*/
		    						  
		    					  
		    				  }
		    			  }
		    			  stack1=(Stack) stack2.clone();
		    		  }
		    		  
		    	  }
		    }
		      int si=stack1.size();
		     while(stack1.size()!=0) {
		    	 ArrayList<Piece> sol2=(ArrayList<Piece>) stack1.pop();
		    	 Grid g3=new Grid(g.getWidth(),g.getHeight());
		    	 System.out.println(sol2);
		    	 for(int i=0;i<sol2.size();i++) {
		    		 Piece ps=sol2.get(i);
		    		 g3.setPiece(ps.getPosY(),ps.getPosX(),ps);
		    		 
		    	 }
		    	
		    	 if(c.check(g3)==true) {
		    		 g4=g3;
		    		 System.out.println(si);
		    		 System.out.println(g3);
		    		 return true;
		    	 }
		     }
		}
		
		return a;
		
	}
	
	/*public boolean solve2(Grid g) {
		boolean a=false;
		Checker c= new Checker();
		if(c.check(g)==true) {
			return true;
		}
		else {
			Grid g2= new Grid(g.getWidth(),g.getHeight());
			Generator gen=new Generator();
			gen.copyGrid(g, g2, 0, 0);
			
		int nbocc=0;
		while(nbocc<Math.pow(4,g.getWidth()*g.getHeight())) {
			nbocc++;
			System.out.println(nbocc);
			System.out.println(g2);
		
	      for(int i=0;i<g2.getHeight();i++) {
	    	  for(int j=0;j<g2.getWidth();j++) {
	    		  
	    		  if(g2.isTotallyConnected(g2.getPiece(i, j))==false) {
	    			  
	    			  g2.getPiece(i, j).turn();
	    		  }
	    	  }
	      }
			if(c.check(g2)==true) {
				System.out.println(g2);
				return true;
			}
		}
		}
		return a;
	}*/
	
	
	
	/**
	//J'ai pas reussi �� faire le solver
//		On a d��j�� fait le input de file dans la classe de Checker
		private static BufferedReader bf;
		private static ArrayList<String[]> informations;
		public Grid grid;
		public Checker checker;
		public String inputFile;
		public static void inputFile(String inputFile) throws IOException { 
		
			informations = new ArrayList<String[]>();
	    try {
	        bf = new BufferedReader(new FileReader(inputFile));
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
		}	
		 * @throws IOException 
		
	//On va au d��but v��rifier s'il est d��j�� connect��
		public Solver(String inputFile) throws IOException {
			this.grid = checker.buildGrid(inputFile);
			Checker checker =new Checker();
			Boolean success = checker.check(grid);
			if(success==true)
			{
				checker.print(success);
			}
			else {
				//touner les pi��ces et r��p��ter l'etape checker
			}
		}

		public Grid tournerGrid()
		{
			int w = grid.getWidth();
			int h = grid.getHeight();
			
			 for(int i=0;i<h;i++) {
			   	  for(int j=0;j<w;j++) {
			   		 Piece p=grid.getPiece(i, j); 
			   		 Piece nextP = grid.getNextPiece(p); 
			   		 if(p.hasLeftConnector()==true)
			   		  {
			   			  if(nextP.hasRightConnector()==true)
			   			  {
			   				  
			   			  }
			   				  
			   		  }
			   	  }
			   	  }

		
	}
		**/
}
