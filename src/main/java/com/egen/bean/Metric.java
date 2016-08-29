package com.egen.bean;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

@Entity("metrics")
public class Metric {

    @Property("timeStamp")
    private long timeStamp;

    @Property("weight")
    private int weight;
    
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "timeStamp = " + timeStamp + "; weight = " + weight;
    }
}