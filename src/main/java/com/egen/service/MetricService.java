package com.egen.service;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import java.util.List;

import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.dao.MetricDao;
import com.egen.rule.MetricOverweightRule;
import com.egen.rule.MetricUnderweightRule;
import com.egen.bean.Metric;

@Component
public class MetricService {

    private RulesEngine rulesEngine;

    @Autowired
    private MetricDao metricDao;

    MetricService() {
        rulesEngine = aNewRulesEngine().build();
    }

    public void createMetric(Metric metric) {
        rulesEngine.registerRule(new MetricUnderweightRule(metric));
        rulesEngine.registerRule(new MetricOverweightRule(metric));
        rulesEngine.fireRules();
        rulesEngine.clearRules();
        metricDao.createMetric(metric);
    }

    public List<Metric> readMetrics () {
        return metricDao.readMetrics();
    }

    public List<Metric> readMetricsByRange(long startTime, long endTime) {
        return metricDao.readMetricsByRange(startTime, endTime);
    }
}