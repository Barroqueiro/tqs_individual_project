package tqs.projet.airquality;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

@ExtendWith(MockitoExtension.class)
public class AirQualityServiceTests {
	
    @Mock
    private CacheService cacheService;
	
	@InjectMocks
    private AirQualityService airQualityService;
	
	private String jsonResponse = "{\"data\":[{\"mold_level\":1,\"aqi\":82,\"pm10\":3.7231,\"co\":325.859,\"o3\":145.555,\"predominant_pollen_type\":\"Molds\",\"so2\":1.39698,\"pollen_level_tree\":1,\"pollen_level_weed\":1,\"no2\":1.0322,\"pm25\":2.19588,\"pollen_level_grass\":1}],\"city_name\":\"Aveiro\",\"lon\":\"-8.64554\",\"timezone\":\"Europe Lisbon\",\"lat\":\"40.64427\",\"country_code\":\"PT\",\"state_code\":\"02\"}";
	
    @Test
    public void whenValidLocation_ReturnValidAirQuality() {
    	AirQuality aq = new AirQuality("Aveiro","PT","02",40.64427,-8.64554,82,145,1,1,325,3,2);
    	
        String location = "Aveiro";
        
        given( cacheService.getObjectCached(location)).willReturn(jsonResponse);
        
        AirQuality aq_res = airQualityService.getAirQuality(location);

        assertThat(aq, is(samePropertyValuesAs(aq_res)));
        verify(cacheService, VerificationModeFactory.times(1)).getObjectCached(location);
    }
    
    @Test
    public void whenInvalidLocation_ReturnPollen() {
    	Pollen p = new Pollen("Aveiro","PT","02",40.64427,-8.64554,1,1,1,1,"Molds");
    	
        String location = "Aveiro";
        
        given( cacheService.getObjectCached(location)).willReturn(jsonResponse);
        
        Pollen p_res = airQualityService.getPollen(location);

        assertThat(p, is(samePropertyValuesAs(p_res)));
        verify(cacheService, VerificationModeFactory.times(1)).getObjectCached(location);
    }
    
    @Test
    public void whenInvalidLocation_ReturnAirQualityEmpty() {
    	AirQuality aq = new AirQuality();
    	
        String location = "SomeCityThatDoesntExist";
        
        given( cacheService.getObjectCached(location)).willReturn(null);
        
        AirQuality aq_res = airQualityService.getAirQuality(location);

        assertThat(aq, is(samePropertyValuesAs(aq_res)));
        verify(cacheService, VerificationModeFactory.times(1)).getObjectCached(location);
    }
    
    @Test
    public void whenInvalidLocation_ReturnPollenEmpty() {
    	Pollen p = new Pollen();
    	
        String location = "SomeCityThatDoesntExist";
        
        given( cacheService.getObjectCached(location)).willReturn(null);
        
        Pollen p_res = airQualityService.getPollen(location);

        assertThat(p, is(samePropertyValuesAs(p_res)));
        verify(cacheService, VerificationModeFactory.times(1)).getObjectCached(location);
    }
}
