package com.github.pedrodimoura.firebasecloudmessagingsample.model;

import java.io.Serializable;

public class Settings implements Serializable {

    private String syncTimeInterval;
    private String gpsTimeInterval;
    private String gpsDistanceInterval;

    public String getSyncTimeInterval() {
        return syncTimeInterval;
    }

    public void setSyncTimeInterval(String syncTimeInterval) {
        this.syncTimeInterval = syncTimeInterval;
    }

    public String getGpsTimeInterval() {
        return gpsTimeInterval;
    }

    public void setGpsTimeInterval(String gpsTimeInterval) {
        this.gpsTimeInterval = gpsTimeInterval;
    }

    public String getGpsDistanceInterval() {
        return gpsDistanceInterval;
    }

    public void setGpsDistanceInterval(String gpsDistanceInterval) {
        this.gpsDistanceInterval = gpsDistanceInterval;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "syncTimeInterval=" + syncTimeInterval +
                ", gpsTimeInterval=" + gpsTimeInterval +
                ", gpsDistanceInterval=" + gpsDistanceInterval +
                '}';
    }
}
