package tqs.projet.airquality;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;

public class CacheMetricsTests {

	@Test
	public void testCounts() {
		CacheMetrics cm = new CacheMetrics();
		cm.addCount();
		cm.addCount();
		cm.addCount();
		assertThat(cm.getCount(),is(3));
	}
	
	@Test
	public void testHits() {
		CacheMetrics cm = new CacheMetrics();
		cm.addHit();
		cm.addHit();
		assertThat(cm.getHits(),is(2));
	}
	
	@Test
	public void testMisses() {
		CacheMetrics cm = new CacheMetrics();
		cm.addMiss();
		cm.addMiss();
		cm.addMiss();
		cm.addMiss();
		assertThat(cm.getMisses(),is(4));
	}
}
