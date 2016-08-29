package com.egen.dao;

import com.egen.MorphiaConfiguration;
import com.egen.bean.Metric;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetricDao {

	Datastore dataStore;

	MetricDao() {
		dataStore = MorphiaConfiguration.getInstance().getDatastore();
	}

	public void createMetric(Metric metric) {
		dataStore.save(metric);
	}

	public List<Metric> readMetrics() {
		Query<Metric> query = dataStore.createQuery(Metric.class);
		return query.asList();
	}

	public List<Metric> readMetricsByRange(long startTime, long endTime) {
		Query<Metric> query = dataStore.createQuery(Metric.class).filter("timeStamp >=", startTime)
				.filter("timeStamp <=", endTime);
		return query.asList();
	}
}
