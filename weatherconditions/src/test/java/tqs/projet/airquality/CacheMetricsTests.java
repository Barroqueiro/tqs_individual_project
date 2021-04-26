package tqs.projet.airquality;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class CacheMetricsTests {

	@Test
	public void test_counts() {
		CacheMetrics cm = new CacheMetrics();
		cm.addCount();
		cm.addCount();
		cm.addCount();
		assertThat(cm.getCount(),is(3));
	}
	
	@Test
	public void test_hits() {
		CacheMetrics cm = new CacheMetrics();
		cm.addHit();
		cm.addHit();
		assertThat(cm.getHits(),is(2));
	}
	
	@Test
	public void test_misses() {
		CacheMetrics cm = new CacheMetrics();
		cm.addMiss();
		cm.addMiss();
		cm.addMiss();
		cm.addMiss();
		assertThat(cm.getMisses(),is(4));
	}
}
