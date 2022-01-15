package fr.dauphine.JavaAvance.Solve;

public class Place {
	public int i;
	public int j;
	
	public Place(int i, int j) {
		this.i=i;
		this.j=j;
	}
	
	@Override
	public boolean equals(Object p) {
		Place p2=(Place) p;
		if(p2.i== this.i &&p2.j==this.j) {
			return true;
		}
		return false;
		
	}
}
