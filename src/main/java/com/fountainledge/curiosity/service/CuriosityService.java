package com.fountainledge.curiosity.service;

import java.util.List;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.model.WeatherReport;
import com.fountainledge.curiosity.model.image.PhotoElement;

public interface CuriosityService {
    
    public MarsReport getLatestMarsReport();
    
    public MarsReport getMarsReportByEarthDate(String earthDate);
    
    public MarsReport getMarsImageByEarthDate(String earthDate);
    
    public List<WeatherReport> getLatestWeatherReports();
    
    public List<WeatherReport> getWeatherReportsByEarthDate(String earthDate);
    
    public List<PhotoElement> getMarsImagesByEarthDate(String earthDate);
    
}
