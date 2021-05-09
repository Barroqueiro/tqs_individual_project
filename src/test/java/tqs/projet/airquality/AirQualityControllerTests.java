package tqs.projet.airquality;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirQualityController.class)
public class AirQualityControllerTests {
	
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AirQualityService service;
    
    @Test
    public void whenGetAirQualityCityExists_theReturnIt( ) throws Exception {
    	AirQuality aq = new AirQuality("Aveiro","PT","02",40.64427,-8.64554,82,145,1,1,325,3,2);

        when( service.getAirQuality(Mockito.any()) ).thenReturn(aq);

        mvc.perform(get("/api/air_quality/aveiro").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("city_name", is("Aveiro")));

        verify(service, times(1)).getAirQuality(Mockito.any());

    }
    
    @Test
    public void whenGetPollenCityExists_theReturnIt( ) throws Exception {
    	Pollen p = new Pollen("Aveiro","PT","02",40.64427,-8.64554,1,1,1,1,"Molds");

        when( service.getPollen(Mockito.any()) ).thenReturn(p);

        mvc.perform(get("/api/pollen/aveiro").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("city_name", is("Aveiro")));

        verify(service, times(1)).getPollen(Mockito.any());

    }
    
    @Test
    public void whenGetPollenCityNoExists_theReturn404( ) throws Exception {
    	Pollen p = new Pollen();

        when( service.getPollen(Mockito.any()) ).thenReturn(p);

        mvc.perform(get("/api/pollen/city_that_doesnt_exist").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(service, times(1)).getPollen(Mockito.any());

    }
    
    @Test
    public void whenGetAirQualityCityNoExists_theReturn404( ) throws Exception {
    	AirQuality aq = new AirQuality();

        when( service.getAirQuality(Mockito.any()) ).thenReturn(aq);

        mvc.perform(get("/api/air_quality/city_that_doesnt_exist").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(service, times(1)).getAirQuality(Mockito.any());

    }
    
    @Test
    public void whenGetLocationPage_theReturnPage( ) throws Exception {
    	 AirQuality aq = new AirQuality("Aveiro","PT","02",40.64427,-8.64554,82,145,1,1,325,3,2);
    	 Pollen p = new Pollen("Aveiro","PT","02",40.64427,-8.64554,1,1,1,1,"Molds");
    	 
    	 when( service.getPollen(Mockito.any()) ).thenReturn(p);
    	 when( service.getAirQuality(Mockito.any()) ).thenReturn(aq);
    	 
    	 mvc.perform(get("/aveiro")).andExpect(status().isOk());
    	 

    }
    
    @Test
    public void whenGetSearchPage_theReturnPage( ) throws Exception {

        mvc.perform(get("/")).andExpect(status().isOk());

    }
    
    @Test
    public void whenGetCachemetrics_theReturnMetrics( ) throws Exception {
    	CacheMetrics cm = new CacheMetrics();
    	cm.addCount();
    	cm.addHit();
    	
    	when( service.getCacheMetrics() ).thenReturn(cm);
        mvc.perform(get("/api/cache").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("hits", is(1))).andExpect(jsonPath("count", is(1))).andExpect(jsonPath("misses", is(0)));

    }

}