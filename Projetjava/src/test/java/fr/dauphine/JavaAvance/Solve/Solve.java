package fr.dauphine.JavaAvance.Solve;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

public class Solve {

	Generator g;
	@Before
	public void setUpTests() {
		Grid grid=new Grid(4,4);
	    g=new Generator();
	    g.generateLevel(null, grid);

	    }
	
	@After
	public void resetAfterTests() {
		g=null;
	}
	
	@Test
	public void solvet() {
		Solver s=new Solver();
		boolean t=s.solvePile(g.filledGrid);
		assertEquals(true,t);
	}
	
	//@Test
	public void solvef() {
		Solver s=new Solver();
		Grid grid2=new Grid(2,2);
		Piece p=new Piece(0,0,PieceType.ONECONN,Orientation.EAST);
		grid2.setPiece(0, 0, p);
		Piece p2=new Piece(0,1,PieceType.LTYPE,Orientation.SOUTH);
		grid2.setPiece(0, 1, p2);
		Piece p3=new Piece(1,0,PieceType.LTYPE,Orientation.NORTH);
		grid2.setPiece(1, 0, p3);
		Piece p4=new Piece(1,1,PieceType.LTYPE,Orientation.WEST);
		grid2.setPiece(1, 1, p4);
		boolean t=s.solvePile(grid2);
		assertEquals(false,t);
	}
	
/*	@Test
	public void solv2et() {
		Solver s=new Solver();
		boolean t=s.solve2(g.filledGrid);
		assertEquals(true,t);
	}
	
	@Test
	public void solve2f() {
		Solver s=new Solver();
		Grid grid2=new Grid(2,2);
		Piece p=new Piece(0,0,PieceType.ONECONN,Orientation.EAST);
		grid2.setPiece(0, 0, p);
		Piece p2=new Piece(0,1,PieceType.LTYPE,Orientation.SOUTH);
		grid2.setPiece(0, 1, p2);
		Piece p3=new Piece(1,0,PieceType.LTYPE,Orientation.NORTH);
		grid2.setPiece(1, 0, p3);
		Piece p4=new Piece(1,1,PieceType.LTYPE,Orientation.WEST);
		grid2.setPiece(1, 1, p4);
		boolean t=s.solve2(grid2);
		assertEquals(false,t);
	}*/
}
