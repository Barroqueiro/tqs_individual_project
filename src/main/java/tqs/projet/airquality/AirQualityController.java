package tqs.projet.airquality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AirQualityController {
	
    @Autowired
	private AirQualityService airQualityService;
	
	Logger logger = LoggerFactory.getLogger(AirQualityController.class);
	
	@GetMapping("/api/air_quality/{location}")
	public ResponseEntity<AirQuality> getAirQuality(@PathVariable String location) {
		AirQuality ser_res = airQualityService.getAirQuality(location);
		logger.info("API Request | Endpoint : /api/airquality/"+location+" | Result: "+ser_res);
		if (ser_res.getCity_name()==null) {
			return new ResponseEntity<AirQuality>(new AirQuality(),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<AirQuality>(ser_res,HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/cache")
	public ResponseEntity<CacheMetrics> getCacheMetrics(){
		CacheMetrics cm = airQualityService.getCacheMetrics();
		logger.info("API Request | Endpoint : /api/cache | Result: "+cm);
		return new ResponseEntity<CacheMetrics>(cm,HttpStatus.OK);
	}
	
	@GetMapping("/api/pollen/{location}")
	public ResponseEntity<Pollen> getPollen(@PathVariable String location) {
		Pollen ser_res = airQualityService.getPollen(location);
		logger.info("API Request | Endpoint : /api/pollen/"+location+" | Result: "+ser_res);
		if (ser_res.getCity_name()==null) {
			return new ResponseEntity<Pollen>(new Pollen(),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Pollen>(ser_res,HttpStatus.OK);
		}
	}
	
	@GetMapping("/{location}")
    public String getAirQualityFromCity(@PathVariable String location,Model model) {
		AirQuality ser_res_air = airQualityService.getAirQuality(location);
		Pollen ser_res_pol = airQualityService.getPollen(location);
		
		logger.info("HTML Request | /"+location+" | With result");
		
		if(ser_res_pol.getCity_name()==null || ser_res_air.getCity_name() == null) {
			logger.warn("HTML Request | Endpoint : /"+location+" | Without Result");
			return "error";
		}
		
        model.addAttribute("AirQuality", ser_res_air);
        model.addAttribute("Pollen", ser_res_pol);
        

        return "location_AirQuality";
    }
	
	@GetMapping("/")
    public String getAirQualitySearch(Model model) {
		logger.info("HTML Request | Endpoint : / | With result");
        return "search_AirQuality";
    }
}
