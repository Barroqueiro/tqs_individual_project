package tqs.projet.airquality;

public class CacheMetrics {

	private int count;
	private int misses;
	private int hits;
	
	public CacheMetrics() {
		this.count = 0;
		this.misses = 0;
		this.hits = 0;
	}

	public int getCount() {
		return count;
	}

	public int getMisses() {
		return misses;
	}

	public int getHits() {
		return hits;
	}

	public void addCount() {
		count++;
	}
	public void addMiss() {
		misses++;
	}
	public void addHit() {
		hits++;
	}

	@Override
	public String toString() {
		return "CacheMetrics [count=" + count + ", misses=" + misses + ", hits=" + hits + "]";
	}
	
}
