package fr.dauphine.JavaAvance.Components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * Type of the piece enum
 * 
 */
public enum PieceType {
	VOID, ONECONN, BAR, TTYPE, LTYPE, FOURCONN
	;

	public LinkedList<Orientation> setConnectorsList(Object object) {
		LinkedList<Orientation> a=new LinkedList<Orientation>();

		switch(this) {
		case VOID :
			
			break;
		case ONECONN :
			
			switch((Orientation)object) {
			case NORTH :
				a.add(Orientation.NORTH);
				break;
			case EAST : 
				a.add(Orientation.EAST);
				break;
			case WEST:
				a.add(Orientation.WEST);
				break;
			case SOUTH:
				a.add(Orientation.SOUTH);
				break;
			
		}
			break;
		case BAR:
			
			switch((Orientation)object) {
			case NORTH :
				a.add(Orientation.NORTH);
				a.add(Orientation.SOUTH);
				break;
			case EAST : 
				a.add(Orientation.EAST);
				a.add(Orientation.WEST);
				break;
				
		}
			break;
		case TTYPE:
			switch((Orientation)object) {
			case NORTH :
				a.add(Orientation.NORTH);
				a.add(Orientation.EAST);
				a.add(Orientation.WEST);
				break;
			case EAST : 
				a.add(Orientation.NORTH);
				a.add(Orientation.EAST);
				a.add(Orientation.SOUTH);
				break;
			case WEST:
				a.add(Orientation.NORTH);
				a.add(Orientation.SOUTH);
				a.add(Orientation.WEST);
				break;
			case SOUTH:
				a.add(Orientation.EAST);
				a.add(Orientation.SOUTH);
				a.add(Orientation.WEST);
				break;
			
		}
			break;
		case LTYPE:
			
			switch((Orientation)object) {
			case NORTH :
				a.add(Orientation.NORTH);
				a.add(Orientation.EAST);
				break;
			case EAST : 
				a.add(Orientation.EAST);
				a.add(Orientation.SOUTH);
				break;
			case WEST:
				a.add(Orientation.NORTH);
				a.add(Orientation.WEST);
				break;
			case SOUTH:
				a.add(Orientation.SOUTH);
				a.add(Orientation.WEST);
				break;
			
		}
			break;
		case FOURCONN:
			
			a.add(Orientation.NORTH);
			a.add(Orientation.EAST);
			a.add(Orientation.SOUTH);
			a.add(Orientation.WEST);
			break;
		
	}
		return a;
	}
	// Each Type has a number of connectors and a specific value

	public Orientation getOrientation(Object orifromValue) {
		switch(this) {
		case VOID :
			return Orientation.NORTH;
		case ONECONN : 
			return (Orientation) orifromValue;
		case BAR:
			if((Orientation) orifromValue==Orientation.SOUTH || (Orientation) orifromValue==Orientation.NORTH ){
				return Orientation.NORTH;
			}
			else {
				return Orientation.EAST;
			}
		
		case TTYPE:
			return (Orientation) orifromValue;
		case LTYPE:
			return (Orientation) orifromValue;
		case FOURCONN:
			return Orientation.NORTH;
		default : return Orientation.NORTH;
	}
	}

	public static PieceType getTypefromValue(int typeValue) {
		return values()[typeValue];
	}

	public ArrayList<Orientation> getListOfPossibleOri() {
		ArrayList<Orientation> a=new ArrayList<Orientation>();
		switch(this) {
		case VOID :
			a.add(Orientation.NORTH);
			break;
		case ONECONN : 
			a.add(Orientation.NORTH);
			a.add(Orientation.EAST);
			a.add(Orientation.SOUTH);
			a.add(Orientation.WEST);
			break;
		case BAR:
			a.add(Orientation.NORTH);
			a.add(Orientation.EAST);
			break;
		case TTYPE:
			a.add(Orientation.NORTH);
			a.add(Orientation.EAST);
			a.add(Orientation.SOUTH);
			a.add(Orientation.WEST);
			break;
		case LTYPE:
			a.add(Orientation.NORTH);
			a.add(Orientation.EAST);
			a.add(Orientation.SOUTH);
			a.add(Orientation.WEST);
			break;
		case FOURCONN:
			a.add(Orientation.NORTH);
			break;
		
	}
		return a;
	}

	public int getNbConnectors() {
		switch(this) {
		case VOID :
			return 0;
		case ONECONN : 
			return 1;
		case BAR:
			return 2;
		case TTYPE:
			return 3;
		case LTYPE:
			return 2;
		case FOURCONN:
			return 4;
		default : return 0;
	}
	}


	

}
