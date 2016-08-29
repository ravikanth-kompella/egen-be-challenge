package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.bean.Metric;
import com.egen.service.MetricService;

@RequestMapping("/metrics")
@RestController
public class MetricsController {

	@Autowired
	private MetricService metricService;

	MetricsController() {
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Metric> create(@RequestBody Metric metric) {

		//bad requests are NOT handled

		//good requests
		metricService.createMetric(metric);
		return new ResponseEntity<Metric>(metric, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/read")
	public ResponseEntity<List<Metric>> read() {

		List<Metric> metricList = metricService.readMetrics();

		return (metricList.size() == 0) ?
			new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT) :
				new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
	}

	@RequestMapping(value = "/readByTimeRange/{startTime}/{endTime}")
	public ResponseEntity<List<Metric>> readByTimeRange(@PathVariable Long startTime, @PathVariable Long endTime) {

		//bad requests are NOT handled
		
		//good requests
		List<Metric> metricList = metricService.readMetricsByRange(startTime, endTime);

		return (metricList.size() == 0) ?
			new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT) :
				new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
	}
}