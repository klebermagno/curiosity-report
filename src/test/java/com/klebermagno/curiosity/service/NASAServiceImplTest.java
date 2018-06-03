package com.klebermagno.curiosity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.klebermagno.curiosity.model.image.MarsImage;
import com.klebermagno.curiosity.model.image.PhotoElement;
import org.junit.Before;
import org.junit.Test;

import com.klebermagno.curiosity.model.MarsWeatherFeed;
import com.klebermagno.curiosity.model.WeatherReport;

public class NASAServiceImplTest {
    
    private NASAService nasaService;
    
    @Before
    public void setUp() {
        nasaService = new NASAServiceImpl();
    }
    
    @Test
    public void testGetMarsWeatherFeed() {
        MarsWeatherFeed result = nasaService.getMarsWeatherFeed();
        List<WeatherReport> weatherReports = result.getResults();
        
        assertNotNull("Should return a deserialised weather feed", result);
    }
    
    @Test
    public void testGetMarsWeatherFeedByEarthDate(){
    	
        String earthDate = "2015-09-30";
        String sunny = "Sunny";
		MarsWeatherFeed result = nasaService.getMarsWeatherFeedByEarthDate(earthDate );
        List<WeatherReport> weatherReports = result.getResults();
        
        assertNotNull("Should return a deserialised weather feed", result);
        
        for (WeatherReport weatherReport : weatherReports) {
        	
        	assertEquals(sunny,weatherReport.getAtmo_opacity());
        	
		}
        
    }

    @Test
    public void testGetMarsImage(){
    	
        String earthDate = "2016-07-30";
       
        MarsImage result = nasaService.getMarsImage(earthDate);
        PhotoElement[] photos = result.getPhotos();
        
        assertNotNull("Should return a deserialised weather feed", result);
        
        for (int i = 0; i < photos.length; i++) {
        	assertEquals(earthDate, photos[i].getEarth_date());
        	assertNotNull(photos[i].getImg_src());
		}
        
     
    
    }
    
}
