package com.egen;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaConfiguration {

    private static final String packageName = "com.egen.bean";
    private static MorphiaConfiguration morphiaConfig = new MorphiaConfiguration();
    private Datastore dataStore = null;

    private MorphiaConfiguration() {
        Morphia morphia = new Morphia();
        dataStore = morphia.createDatastore(new MongoClient(), "mongoClient");
        dataStore.ensureIndexes();
    }
    
    public String getPackageName() {
        return packageName;
    }

    public static MorphiaConfiguration getInstance() {
        return morphiaConfig;
    }    

    public Datastore getDatastore() {
        return dataStore;
    }

    public void setDatastore(Datastore dataStore) {
        this.dataStore = dataStore;
    }
}