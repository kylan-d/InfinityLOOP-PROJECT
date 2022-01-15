package fr.dauphine.JavaAvance.Solve;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.GUI.Grid;


public class Solver {

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
			Stack stack1 = new Stack();
			
			
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
		    		 System.out.println(si);
		    		 System.out.println(g3);
		    		 return true;
		    	 }
		     }
		}
		
		return a;
		
	}
}
