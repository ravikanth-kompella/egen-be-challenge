package com.egen.rule;

public interface MetricRule {

    enum Type {UNDER_WEIGHT, OVER_WEIGHT}
    short baseWeight = 150;

    boolean when();
    void then();
}