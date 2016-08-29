package com.egen.rule;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.egen.dao.AlertDao;
import com.egen.bean.Alert;
import com.egen.bean.Metric;


@Rule (name = "UnderWeight")
public class MetricUnderweightRule implements MetricRule {

    private AlertDao alertDao = new AlertDao();

    private Metric metric;

    public MetricUnderweightRule(Metric metric) {
        this.metric = metric;
    }

    @Override
    @Condition
    public boolean when() {
        return metric.getWeight() < (0.9 * baseWeight);
    }

    @Override
    @Action
    public void then() {
        Alert alert = new Alert(MetricRule.Type.UNDER_WEIGHT.toString(), metric);
        alertDao.createAlert(alert);
    }
}
