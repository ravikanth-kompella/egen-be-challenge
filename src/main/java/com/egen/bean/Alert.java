package com.egen.bean;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

@Entity("alerts")
public class Alert {

    @Property("type")
    private String type;
    
    @Property("timeStamp")
    private long timeStamp;
    
    @Property("weight")
    private int weight;
    
    public Alert() {
    	// Morphia needs it; please don't delete.
    }
    
	public Alert(String type, long timeStamp, int weight) {
        this.type = type;
        this.timeStamp = timeStamp;
        this.weight = weight;
    }
    
    public Alert(String type, Metric metric) {
        this(type, metric.getTimeStamp(), metric.getWeight());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
        return "type = " + type + "; timeStamp = " + timeStamp + "; weight = " + weight;
    }
}