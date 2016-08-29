package com.egen.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import com.egen.MorphiaConfiguration;
import com.egen.bean.Alert;

@Component
public class AlertDao {

	Datastore dataStore;

	public AlertDao() {
		dataStore = MorphiaConfiguration.getInstance().getDatastore();
	}

	public void createAlert(Alert alert) {
		dataStore.save(alert);
	}

	public List<Alert> readAlerts() {
		Query<Alert> query = dataStore.createQuery(Alert.class);
		return query.asList();
	}

	public List<Alert> readAlertsByRange(long startTime, long endTime) {
		Query<Alert> query = dataStore.createQuery(Alert.class).filter("timeStamp >=", startTime).filter("timeStamp <=",
				endTime);
		return query.asList();
	}
}