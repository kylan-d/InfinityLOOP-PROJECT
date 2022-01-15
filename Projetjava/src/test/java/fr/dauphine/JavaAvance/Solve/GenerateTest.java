package fr.dauphine.JavaAvance.Solve;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.dauphine.JavaAvance.Components.Orientation;
import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

public class GenerateTest {
Generator g;
	@Before
	public void setUpTests() {
		Grid grid=new Grid(4,3);
	    g=new Generator();
	    g.generateLevel(null, grid);

	    }
	
	@After
	public void resetAfterTests() {
		g=null;
	}
	
	@Test
	public void CheckOri() {
		System.out.println(g.filledGrid);
		int nbcon=0;
		for(int i=0;i<g.filledGrid.getHeight();i++) {
			for(int j=0;j<g.filledGrid.getWidth();j++) {
				LinkedList<Orientation> l=g.filledGrid.getPiece(i, j).getConnectors();
			
					nbcon+=l.size();
				
				
				assertTrue(g.filledGrid.getHeight()*g.filledGrid.getWidth()*4>nbcon);
			}
		}
	}
	
	@Test
	public void CheckerTest() {
		Grid grid2=new Grid(2,2);
		Piece p=new Piece(0,0,PieceType.LTYPE,Orientation.EAST);
		grid2.setPiece(0, 0, p);
		Piece p2=new Piece(0,1,PieceType.LTYPE,Orientation.SOUTH);
		grid2.setPiece(0, 1, p2);
		Piece p3=new Piece(1,0,PieceType.LTYPE,Orientation.NORTH);
		grid2.setPiece(1, 0, p3);
		Piece p4=new Piece(1,1,PieceType.LTYPE,Orientation.WEST);
		grid2.setPiece(1, 1, p4);
		
		Checker c=new Checker();
		assertEquals(true,c.check(grid2));
	}
	//@Test
	public void CheckerTestNULL() {
		Grid grid2=new Grid(200,200);	
		Checker c=new Checker();
		assertEquals(true,c.check(grid2));
	}
	@Test
	public void CheckerTestF() {
		Checker c=new Checker();
		System.out.println(c.check(g.filledGrid));
		assertEquals(false,c.check(g.filledGrid));
	}
	
	@Test
	public void turnTest() {
		Piece p=new Piece(0,0,PieceType.LTYPE,Orientation.EAST);
		p.turn();
		assertEquals(Orientation.SOUTH,p.getOrientation());
	}
	
	@Test
	public void testConnector() {
		Piece p=new Piece(0,0,PieceType.ONECONN,Orientation.EAST);
		p.turn();
		assertEquals(Orientation.SOUTH,p.getOrientation());
		
	}
	
	@Test
	public void solvet() {
		Solver s=new Solver();
		boolean t=s.solvePile(g.filledGrid);
		assertEquals(true,t);
	}
	
	@Test
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
}
