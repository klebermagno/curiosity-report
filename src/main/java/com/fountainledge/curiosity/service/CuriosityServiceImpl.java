package com.fountainledge.curiosity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.model.MarsWeatherFeed;
import com.fountainledge.curiosity.model.WeatherReport;
import com.fountainledge.curiosity.model.image.MarsImage;
import com.fountainledge.curiosity.model.image.PhotoElement;

@Service
public class CuriosityServiceImpl implements CuriosityService {
    
    @Autowired
    protected NASAService nasaService;
    
    public MarsReport getLatestMarsReport() {
        
        MarsReport marsReport = new MarsReport();
        List<WeatherReport> latestWeatherReports = this.getLatestWeatherReports();
        if (latestWeatherReports.size() > 0) {
            marsReport.setWeatherReport(latestWeatherReports.get(0));
        }
        
        return marsReport;
    }

    public MarsReport getMarsReportByEarthDate(String earthDate) {
        
        MarsReport marsReport = new MarsReport();
        
        //set the wheather in marsReport
        List<WeatherReport> latestWeatherReports = this.getWeatherReportsByEarthDate(earthDate);
        if (latestWeatherReports.size() > 0) {
            marsReport.setWeatherReport(latestWeatherReports.get(0));
        }
        
        //set the photo Element in the marsReport
        List<PhotoElement> photoElement = this.getMarsImagesByEarthDate(earthDate);
        if (photoElement.size() > 0) {
        	marsReport.setPhotoElement(photoElement.get(0));
        }
        
        return marsReport;
    }
    
    public List<WeatherReport> getLatestWeatherReports() {
        MarsWeatherFeed marsWeatherFeed = nasaService.getMarsWeatherFeed();
        return marsWeatherFeed.getResults();
    }
    
    public List<WeatherReport> getWeatherReportsByEarthDate(String earthDate) {
        MarsWeatherFeed marsWeatherFeed = nasaService.getMarsWeatherFeedByEarthDate(earthDate);
        return marsWeatherFeed.getResults();
    }
    
	@Override
	public MarsReport getMarsImageByEarthDate(String earthDate) {
		
		MarsReport marsReport = new MarsReport();
	        List<PhotoElement> photoElement = this.getMarsImagesByEarthDate(earthDate);
	        if (photoElement.size() > 0) {
	        	marsReport.setPhotoElement(photoElement.get(0));
	        }
	        
	        return marsReport;
	}

	@Override
	public List<PhotoElement> getMarsImagesByEarthDate(String earthDate) {
		MarsImage marsImage = nasaService.getMarsImage(earthDate);
		if(marsImage != null)
			return Arrays.asList(marsImage.getPhotos());
		else
			return new ArrayList();
	}
        
}
