package tqs.projet.airquality;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;

public class TTLMapTests {

	@Test
	public void testSize() {
		TTLMap<String, String> ttlm = new TTLMap<>(2*60);
		ttlm.put("test_key1", "test_value1");
		ttlm.put("test_key2", "test_value2");
		ttlm.put("test_key3", "test_value3");
		ttlm.put("test_key4", "test_value4");
		assertThat(ttlm.size(),is(4));
	}
	
	@Test
	public void testIsEmpty() {
		TTLMap<String, String> ttlm = new TTLMap<>(2*60);
		assertThat(ttlm.isEmpty(),is(true));
		ttlm.put("test_key1", "test_value1");
		assertThat(ttlm.isEmpty(),is(false));
	}
	
	@Test
	public void testGetInTime() {
		TTLMap<String, String> ttlm = new TTLMap<>(2*60);
		ttlm.put("test_key1", "test_value1");
		String result = (String) ttlm.get("test_key1");
		assertThat(result,is("test_value1"));
	}
	
	@Test
	public void testGetOutTime() {
		TTLMap<String, String> ttlm = new TTLMap<>(1);
		ttlm.put("test_key1", "test_value1");
		LocalDateTime time_after = LocalDateTime.now().plusSeconds(1);
		while (LocalDateTime.now().isBefore(time_after)){
		}
		String result = (String) ttlm.get("test_key1");
		assertThat(result,is((String) null));
	}
}
