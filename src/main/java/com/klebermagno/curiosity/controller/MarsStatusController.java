package com.klebermagno.curiosity.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.klebermagno.curiosity.service.CuriosityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klebermagno.curiosity.model.MarsReport;

@RestController
public class MarsStatusController {
    
    @Autowired
    CuriosityService curiosityService;

    @RequestMapping("/api/mars/report")
    @CrossOrigin
    public MarsReport getMarsReport() {
        return curiosityService.getLatestMarsReport();
    }

    @RequestMapping("/api/mars/reportByEarthDate")
    @CrossOrigin
    public MarsReport getMarsReporByEarthDatet(@RequestParam(value="earthdate",required=false) String earthDate) {

    	if(earthDate == null){
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		
    		earthDate = sdf.format(new Date());
    	}
        return curiosityService.getMarsReportByEarthDate(earthDate);
    }
    
}