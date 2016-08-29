package com.egen;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.egen.bean.Alert;
import com.egen.bean.Metric;
import com.egen.rule.MetricRule;
import com.egen.service.AlertService;
import com.egen.service.MetricService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Autowired
	private MetricService metricService;

	@Autowired
	private AlertService alertService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testUnderweight() {

		//Create a under weight Metrics
		long timeStamp = System.currentTimeMillis();
		Metric metric = new Metric();
		metric.setWeight((int)(0.7 * MetricRule.baseWeight));
		metric.setTimeStamp(timeStamp);
		metricService.createMetric(metric);

		//Make sure service recognizes them right
		List<Alert> alertList = alertService.readAlerts();
		for (Alert alert : alertList) {
			if (alert.getTimeStamp() == timeStamp && alert.getType().equals("UNDER_WEIGHT")) {
				assert (true);
				return;
			}
		}
		assert (false);
	}

	@Test
	public void testOverweight() {

		//Create Over Weight Metrics
		long timeStamp = System.currentTimeMillis();
		Metric metric = new Metric();
		metric.setWeight((int)(1.4 * MetricRule.baseWeight));
		metric.setTimeStamp(timeStamp);
		metricService.createMetric(metric);

		//Make sure service recognizes them right
		List<Alert> alertList = alertService.readAlerts();
		for (Alert alert : alertList) {
				if (alert.getTimeStamp() == timeStamp && alert.getType().equals("OVER_WEIGHT")) {
				assert (true);
				return;
			}
		}
		assert (false);
	}
}