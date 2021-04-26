package tqs.projet.airquality;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.time.LocalDateTime;

public class CacheServiceTests {

	@Test
	public void whenNoCache_returnNull() {
		CacheService cs = new CacheService();
		assertThat(cs.getObjectCached("SomeString"), is((String) null));
	}
	
	@Test
	public void whenCache_returnCachedValue() {
		CacheService cs = new CacheService();
		cs.putObjectCached("Some String", "Some value");
		assertThat(cs.getObjectCached("Some String"), is("Some value"));
	}
	
	@Test
	public void whenTimeRunsOut_returnReturnNull() {
		CacheService cs = new CacheService(2);
		cs.putObjectCached("Some String", "Some value");
		LocalDateTime time_after = LocalDateTime.now().plusSeconds(2);
		while (LocalDateTime.now().isBefore(time_after)){
			continue;
		}
		assertThat(cs.getObjectCached("Some String"), is((String) null));
	}
	
	@Test
	public void testCacheMetrics() {
		CacheService cs = new CacheService();
		cs.putObjectCached("Some String", "Some value");
		cs.putObjectCached("Another String", "Another value");
		cs.putObjectCached("And another one", "And another");
		cs.getObjectCached("Some String");
		cs.getObjectCached("Another String");
		cs.getObjectCached("And another one");
		cs.getObjectCached("Some string not in cache");
		CacheMetrics cm = cs.getMetrics();
		assertThat(cm.getCount(), is(4));
		assertThat(cm.getMisses(), is(1));
		assertThat(cm.getHits(), is(3));
	}
	
}
