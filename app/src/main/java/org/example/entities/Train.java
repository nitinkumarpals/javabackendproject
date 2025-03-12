package org.example.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String, String> stationTimes;

    private List<String> stations;

    public Train(List<List<Integer>> seats, List<String> stations, Map<String, String> stationTimes, String trainId, String trainNo) {
        this.seats = seats;
        this.stations = stations;
        this.stationTimes = stationTimes;
        this.trainId = trainId;
        this.trainNo = trainNo;
    }

    public Train() {
    }

    public String getTrainInfo(){
        return String.format("Train Id: %s Train No: %s",trainId,trainNo);
    }
    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public Map<String, String> getStationTimes() {
        return stationTimes;
    }

    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
}
