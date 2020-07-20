
public class MasterMindHits {
	private int hits;
	private int psuedohits;
	
	public MasterMindHits(int thePsuedo, int theHits) {
		psuedohits = thePsuedo;
		hits = theHits;
	}
	
	public int getHits() {
		return hits;
	}
	
	public int getPsuedoHits() {
		return psuedohits;
	}
}
