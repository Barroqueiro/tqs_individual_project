package tqs.projet.airquality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	
	private TTLMap<String,String> t;
	private CacheMetrics cm;
	Logger logger = LoggerFactory.getLogger(AirQualityController.class);
	
	public CacheService() {
		t = new TTLMap<String,String>(2*60);
		cm = new CacheMetrics();
	}
	
	public CacheService(int s) {
		t = new TTLMap<String,String>(s);
		cm = new CacheMetrics();
	}
	
	public Object getObjectCached(String key) {
		String st = t.get(key);
		cm.addCount();
		if(st == null) {
			cm.addMiss();
			logger.info("Cache Request | Endpoint: getCached | Missed");
		}else {
			logger.info("Cache Request | Endpoint: getCached | Hit");
			cm.addHit();
		}
		return t.get(key);
	}
	
	public Object putObjectCached(String key, String value) {
		logger.info("Cache Request | Endpoint: putCached ");
		return t.put(key, value);
	}
	
	public CacheMetrics getMetrics() {
		logger.info("Cache Request | Endpoint: Metrics");
		return cm;
	}
	
}
