package tqs.projet.airquality;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class AirQualityService {

    private String apiKey = "cc40fc238be447e5864ee3dc3781908a";
	
	@Autowired
	private CacheService cacheService;
	
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(AirQualityController.class);
	
	public AirQuality getAirQuality(String location) {
		String str_res = (String) cacheService.getObjectCached(location);
		if (str_res == null) {
			restTemplate = new RestTemplate();
			String url = "https://api.weatherbit.io/v2.0/current/airquality?city="+location+"&key="+apiKey;
			str_res = restTemplate.getForObject(url, String.class);
			cacheService.putObjectCached(location, str_res);
		    logger.info("Service Request | Endpoint: AirQuality | Miss on cache");
		}else {
			logger.info("Service Request | Endpoint: AirQuality | Hit on cache");
		}
		Gson g = new Gson();
		if (str_res == null) {
			return new AirQuality();
		}
		JsonObject convertedObject = new Gson().fromJson(str_res, JsonObject.class);
		JsonArray ar = convertedObject.getAsJsonArray("data");
		JsonObject data = (JsonObject) ar.get(0);
		convertedObject.remove("data");
		Set<String> keys = data.keySet();
		for(Object s : keys) {
			convertedObject.add((String) s, data.get((String) s));
		}
		return g.fromJson(convertedObject, AirQuality.class);
	}
	
	public Pollen getPollen(String location) {
		String str_res = (String) cacheService.getObjectCached(location);
		if (str_res == null) {
			restTemplate = new RestTemplate();
			String url = "https://api.weatherbit.io/v2.0/current/airquality?city="+location+"&key="+apiKey;
			str_res = restTemplate.getForObject(url, String.class);
			cacheService.putObjectCached(location, str_res);
		    logger.info("Service Request | Endpoint: Pollen | Miss on cache");
		}else {
			logger.info("Service Request | Endpoint: Pollen | Hit on cache");
		}
		Gson g = new Gson();
		if (str_res == null) {
			return new Pollen();
		}
		JsonObject convertedObject = new Gson().fromJson(str_res, JsonObject.class);
		JsonArray ar = convertedObject.getAsJsonArray("data");
		JsonObject data = (JsonObject) ar.get(0);
		convertedObject.remove("data");
		Set<String> keys = data.keySet();
		for(Object s : keys) {
			convertedObject.add((String) s, data.get((String) s));
		}
		return g.fromJson(convertedObject, Pollen.class);
	}
	
	public CacheMetrics getCacheMetrics() {
		logger.info("Service Request | Endpoint: CacheMetrics ");
		return cacheService.getMetrics();
	}
}
