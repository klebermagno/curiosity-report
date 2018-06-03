package com.fountainledge.curiosity.model;

import javax.annotation.Resource;

import com.fountainledge.curiosity.model.image.PhotoElement;

@Resource
public class MarsReport {
    
    private WeatherReport weatherReport;
    
    private PhotoElement photoElement;

	public PhotoElement getPhotoElement() {
		return photoElement;
	}

	public void setPhotoElement(PhotoElement photoElement) {
		this.photoElement = photoElement;
	}
    
    public WeatherReport getWeatherReport() {
        return weatherReport;
    }

    public void setWeatherReport(WeatherReport weatherReport) {
        this.weatherReport = weatherReport;
    }

}
