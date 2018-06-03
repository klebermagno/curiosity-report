package com.fountainledge.curiosity.service;

import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.image.MarsImage;

public interface NASAService {
    
    public MarsWeatherFeed getMarsWeatherFeed();
    
    public MarsWeatherFeed getMarsWeatherFeedByEarthDate(String earthDate);
    
    public MarsImage getMarsImage(String earthDate);
    
}
