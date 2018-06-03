package com.klebermagno.curiosity.service;

import com.klebermagno.curiosity.model.MarsWeatherFeed;
import com.klebermagno.curiosity.model.image.MarsImage;

public interface NASAService {
    
    public MarsWeatherFeed getMarsWeatherFeed();
    
    public MarsWeatherFeed getMarsWeatherFeedByEarthDate(String earthDate);
    
    public MarsImage getMarsImage(String earthDate);
    
}
