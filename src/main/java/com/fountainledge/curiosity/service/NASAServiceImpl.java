package com.fountainledge.curiosity.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.image.MarsImage;

@Service
public class NASAServiceImpl implements NASAService {
						 
	private static final String urlMarsWeather =  "http://marsweather.ingenology.com/v1/archive/";
	
	private static final String urlMarsImage =  "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/";
	
	private static final String apiKey = "api_key=AOY1JmnKuMubwVpC2PpP0xtCwf4UaQLLZkG9PpB6";
    
	public MarsWeatherFeed getMarsWeatherFeed() {
        MarsWeatherFeed weatherFeed = null;
        RestTemplate restTemplate  = new RestTemplate();
        try {
             weatherFeed = restTemplate.getForObject(new URI(urlMarsWeather), MarsWeatherFeed.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return weatherFeed;
    }

    public MarsWeatherFeed getMarsWeatherFeedByEarthDate(String earthDate) {
        MarsWeatherFeed weatherFeed = null;
        RestTemplate restTemplate  = new RestTemplate();
        try {
             weatherFeed = restTemplate.getForObject(new URI(urlMarsWeather + "?terrestrial_date_end=" + earthDate ), MarsWeatherFeed.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return weatherFeed;
    }
    
    public MarsImage getMarsImage(String earthDate){
    	MarsImage marsImage = null ;
    	
    	 RestTemplate restTemplate  = new RestTemplate();
         try {
        	 marsImage = restTemplate.getForObject(new URI(urlMarsImage + "photos?earth_date=" + earthDate + "&" + apiKey ), MarsImage.class);
         } catch (RestClientException e) {
             e.printStackTrace();
         } catch (URISyntaxException e) {
             e.printStackTrace();
         }
         
		return marsImage;
    	
    }
    
}
