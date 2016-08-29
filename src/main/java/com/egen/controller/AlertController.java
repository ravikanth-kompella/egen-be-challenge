package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.bean.Alert;
import com.egen.service.AlertService;

@RequestMapping("/alerts")
@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping(value = "/read")
    public ResponseEntity<List<Alert>> read() {

        List<Alert> alerts = alertService.readAlerts();

        return (alerts.size() == 0) ?
            new ResponseEntity<List<Alert>>(alerts, HttpStatus.NO_CONTENT) :
            	new ResponseEntity<List<Alert>>(alerts, HttpStatus.OK);
    }

    @RequestMapping(value = "/readByTimeRange/{startTime}/{endTime}")
    public ResponseEntity<List<Alert>> readByTimeRange(@PathVariable Long startTime, @PathVariable Long endTime) {

        //bad requests are NOT handled

        //good requests
    	List<Alert> alertList = alertService.readAlertsByRange(startTime, endTime);

        return (alertList.size() == 0) ?
            new ResponseEntity<List<Alert>>(alertList, HttpStatus.NO_CONTENT) :
            	new ResponseEntity<List<Alert>>(alertList, HttpStatus.OK);
    }
}