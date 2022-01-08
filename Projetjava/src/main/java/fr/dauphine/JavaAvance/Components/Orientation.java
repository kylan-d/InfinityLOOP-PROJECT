package fr.dauphine.JavaAvance.Components;

import java.util.HashMap;

/**
 * 
 * Orientation of the piece enum
 * 
 */
public enum Orientation {
	NORTH, EAST, SOUTH, WEST
	;

	public static Object getOrifromValue(int orientationValue) {
		
		return values()[orientationValue];
	}
	/* Implement all the possible orientations and 
	 *  required methods to rotate
	 */

	public Object turn90() {
		switch(this) {
		case NORTH :
			return EAST;
		case EAST : 
			return SOUTH;
		case WEST:
			return NORTH;
		case SOUTH:
			return WEST;
		default : return this;
	}
	}

	public int[] getOpposedPieceCoordinates(Piece p) {
		// TODO Auto-generated method stub
		return null;
	}

	public Orientation getOpposedOrientation() {
		switch(this) {
		case NORTH :
			return SOUTH;
		case EAST : 
			return WEST;
		case WEST:
			return EAST;
		case SOUTH:
			return NORTH;
		default : return this;
	}
	}

}
