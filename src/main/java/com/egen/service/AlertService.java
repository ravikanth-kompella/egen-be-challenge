package com.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.dao.AlertDao;
import com.egen.bean.Alert;

@Component
public class AlertService {

    @Autowired
    private AlertDao alertDao;

    public void createAlert (Alert alert) {
        alertDao.createAlert(alert);
    }

    public List<Alert> readAlerts () {
        return alertDao.readAlerts();
    }

    public List<Alert> readAlertsByRange(long startTime, long endTime) {
        return alertDao.readAlertsByRange(startTime, endTime);
    }
}
