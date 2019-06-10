package com.izzatismail.reptracker.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "rep_table")
public class Rep {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title, timestamp,
            benchWeight, deadliftWeight, squatWeight, OHPWeight, rowWeight,
            benchRep, deadliftRep, squatRep, OHPRep, rowRep,
            benchFailure, deadliftFailure, squatFailure, OHPFailure, rowFailure,
            pullupRep, pullupFailure, curlWeight, curlRep, extWeight, extRep;

    public Rep(String title, String timestamp, String benchWeight, String deadliftWeight, String squatWeight, String OHPWeight, String rowWeight,
               String benchRep, String deadliftRep, String squatRep, String OHPRep, String rowRep,
               String benchFailure, String deadliftFailure, String squatFailure, String OHPFailure, String rowFailure,
               String pullupRep, String pullupFailure, String curlWeight, String curlRep, String extWeight, String extRep) {
        this.title = title;
        this.timestamp = timestamp;
        this.benchWeight = benchWeight;
        this.deadliftWeight = deadliftWeight;
        this.squatWeight = squatWeight;
        this.OHPWeight = OHPWeight;
        this.rowWeight = rowWeight;
        this.benchRep = benchRep;
        this.deadliftRep = deadliftRep;
        this.squatRep = squatRep;
        this.OHPRep = OHPRep;
        this.rowRep = rowRep;
        this.benchFailure = benchFailure;
        this.deadliftFailure = deadliftFailure;
        this.squatFailure = squatFailure;
        this.OHPFailure = OHPFailure;
        this.rowFailure = rowFailure;
        this.pullupRep = pullupRep;
        this.pullupFailure = pullupFailure;
        this.curlWeight = curlWeight;
        this.curlRep = curlRep;
        this.extWeight = extWeight;
        this.extRep = extRep;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getBenchWeight() {
        return benchWeight;
    }

    public String getDeadliftWeight() {
        return deadliftWeight;
    }

    public String getSquatWeight() {
        return squatWeight;
    }

    public String getOHPWeight() {
        return OHPWeight;
    }

    public String getRowWeight() {
        return rowWeight;
    }

    public String getBenchRep() {
        return benchRep;
    }

    public String getDeadliftRep() {
        return deadliftRep;
    }

    public String getSquatRep() {
        return squatRep;
    }

    public String getOHPRep() {
        return OHPRep;
    }

    public String getRowRep() {
        return rowRep;
    }

    public String getBenchFailure() {
        return benchFailure;
    }

    public String getDeadliftFailure() {
        return deadliftFailure;
    }

    public String getSquatFailure() {
        return squatFailure;
    }

    public String getOHPFailure() {
        return OHPFailure;
    }

    public String getRowFailure() {
        return rowFailure;
    }

    public String getPullupRep() {
        return pullupRep;
    }

    public String getPullupFailure() {
        return pullupFailure;
    }

    public String getCurlWeight() {
        return curlWeight;
    }

    public String getCurlRep() {
        return curlRep;
    }

    public String getExtWeight() {
        return extWeight;
    }

    public String getExtRep() {
        return extRep;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setBenchWeight(String benchWeight) {
        this.benchWeight = benchWeight;
    }

    public void setDeadliftWeight(String deadliftWeight) {
        this.deadliftWeight = deadliftWeight;
    }

    public void setSquatWeight(String squatWeight) {
        this.squatWeight = squatWeight;
    }

    public void setOHPWeight(String OHPWeight) {
        this.OHPWeight = OHPWeight;
    }

    public void setRowWeight(String rowWeight) {
        this.rowWeight = rowWeight;
    }

    public void setBenchRep(String benchRep) {
        this.benchRep = benchRep;
    }

    public void setDeadliftRep(String deadliftRep) {
        this.deadliftRep = deadliftRep;
    }

    public void setSquatRep(String squatRep) {
        this.squatRep = squatRep;
    }

    public void setOHPRep(String OHPRep) {
        this.OHPRep = OHPRep;
    }

    public void setRowRep(String rowRep) {
        this.rowRep = rowRep;
    }

    public void setBenchFailure(String benchFailure) {
        this.benchFailure = benchFailure;
    }

    public void setDeadliftFailure(String deadliftFailure) {
        this.deadliftFailure = deadliftFailure;
    }

    public void setSquatFailure(String squatFailure) {
        this.squatFailure = squatFailure;
    }

    public void setOHPFailure(String OHPFailure) {
        this.OHPFailure = OHPFailure;
    }

    public void setRowFailure(String rowFailure) {
        this.rowFailure = rowFailure;
    }

    public void setPullupRep(String pullupRep) {
        this.pullupRep = pullupRep;
    }

    public void setPullupFailure(String pullupFailure) {
        this.pullupFailure = pullupFailure;
    }

    public void setCurlWeight(String curlWeight) {
        this.curlWeight = curlWeight;
    }

    public void setCurlRep(String curlRep) {
        this.curlRep = curlRep;
    }

    public void setExtWeight(String extWeight) {
        this.extWeight = extWeight;
    }

    public void setExtRep(String extRep) {
        this.extRep = extRep;
    }

    @Override
    public String toString() {
        return "Rep{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", benchWeight='" + benchWeight + '\'' +
                ", deadliftWeight='" + deadliftWeight + '\'' +
                ", squatWeight='" + squatWeight + '\'' +
                ", OHPWeight='" + OHPWeight + '\'' +
                ", rowWeight='" + rowWeight + '\'' +
                ", benchRep='" + benchRep + '\'' +
                ", deadliftRep='" + deadliftRep + '\'' +
                ", squatRep='" + squatRep + '\'' +
                ", OHPRep='" + OHPRep + '\'' +
                ", rowRep='" + rowRep + '\'' +
                ", benchFailure='" + benchFailure + '\'' +
                ", deadliftFailure='" + deadliftFailure + '\'' +
                ", squatFailure='" + squatFailure + '\'' +
                ", OHPFailure='" + OHPFailure + '\'' +
                ", rowFailure='" + rowFailure + '\'' +
                ", pullupRep='" + pullupRep + '\'' +
                ", pullupFailure='" + pullupFailure + '\'' +
                ", curlWeight='" + curlWeight + '\'' +
                ", curlRep='" + curlRep + '\'' +
                ", extWeight='" + extWeight + '\'' +
                ", extRep='" + extRep + '\'' +
                '}';
    }
}
