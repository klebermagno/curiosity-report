package com.klebermagno.curiosity.service;

import java.util.List;

import com.klebermagno.curiosity.model.MarsReport;
import com.klebermagno.curiosity.model.WeatherReport;
import com.klebermagno.curiosity.model.image.PhotoElement;

public interface CuriosityService {
    
    public MarsReport getLatestMarsReport();
    
    public MarsReport getMarsReportByEarthDate(String earthDate);
    
    public MarsReport getMarsImageByEarthDate(String earthDate);
    
    public List<WeatherReport> getLatestWeatherReports();
    
    public List<WeatherReport> getWeatherReportsByEarthDate(String earthDate);
    
    public List<PhotoElement> getMarsImagesByEarthDate(String earthDate);
    
}
