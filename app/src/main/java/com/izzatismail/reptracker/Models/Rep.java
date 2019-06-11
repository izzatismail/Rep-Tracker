package com.izzatismail.reptracker.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rep_table")
public class Rep implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "timestamp")
    private String timestamp;

    @ColumnInfo(name = "bodyweight")
    private String bodyweight;

    @ColumnInfo(name = "bench weight")
    private String benchWeight;

    @ColumnInfo(name = "deadlift weight")
    private String deadliftWeight;

    @ColumnInfo(name = "squat weight")
    private String squatWeight;

    @ColumnInfo(name = "ohp weight")
    private String OHPWeight;

    @ColumnInfo(name = "row weight")
    private String rowWeight;

    @ColumnInfo(name = "bench rep")
    private String benchRep;

    @ColumnInfo(name = "deadlift rep")
    private String deadliftRep;

    @ColumnInfo(name = "squat rep")
    private String squatRep;

    @ColumnInfo(name = "ohp rep")
    private String OHPRep;

    @ColumnInfo(name = "row rep")
    private String rowRep;

    @ColumnInfo(name = "bench set")
    private String benchSet;

    @ColumnInfo(name = "deadlift set")
    private String deadliftSet;

    @ColumnInfo(name = "squat set")
    private String squatSet;

    @ColumnInfo(name = "ohp set")
    private String OHPSet;

    @ColumnInfo(name = "row set")
    private String rowSet;

    @ColumnInfo(name = "pullup rep")
    private String pullupRep;

    @ColumnInfo(name = "pullup set")
    private String pullupSet;

    @ColumnInfo(name = "pushup rep")
    private String pushupRep;

    @ColumnInfo(name = "pushup set")
    private String pushupSet;

    @ColumnInfo(name = "curl weight")
    private String curlWeight;

    @ColumnInfo(name = "curl rep")
    private String curlRep;

    @ColumnInfo(name = "curl set")
    private String curlSet;

    @ColumnInfo(name = "extension weight")
    private String extWeight;

    @ColumnInfo(name = "extension rep")
    private String extRep;

    @ColumnInfo(name = "extension set")
    private String extSet;

    public Rep(String title, String timestamp, String bodyweight, String benchWeight, String deadliftWeight, String squatWeight, String OHPWeight, String rowWeight, String benchRep, String deadliftRep, String squatRep, String OHPRep, String rowRep, String benchSet, String deadliftSet, String squatSet, String OHPSet, String rowSet, String pullupRep, String pullupSet, String pushupRep, String pushupSet, String curlWeight, String curlRep, String curlSet, String extWeight, String extRep, String extSet) {
        this.title = title;
        this.timestamp = timestamp;
        this.bodyweight = bodyweight;
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
        this.benchSet = benchSet;
        this.deadliftSet = deadliftSet;
        this.squatSet = squatSet;
        this.OHPSet = OHPSet;
        this.rowSet = rowSet;
        this.pullupRep = pullupRep;
        this.pullupSet = pullupSet;
        this.pushupRep = pushupRep;
        this.pushupSet = pushupSet;
        this.curlWeight = curlWeight;
        this.curlRep = curlRep;
        this.curlSet = curlSet;
        this.extWeight = extWeight;
        this.extRep = extRep;
        this.extSet = extSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBodyweight() { return bodyweight; }

    public void setBodyweight(String bodyweight) { this.bodyweight = bodyweight; }

    public String getBenchWeight() {
        return benchWeight;
    }

    public void setBenchWeight(String benchWeight) {
        this.benchWeight = benchWeight;
    }

    public String getDeadliftWeight() {
        return deadliftWeight;
    }

    public void setDeadliftWeight(String deadliftWeight) {
        this.deadliftWeight = deadliftWeight;
    }

    public String getSquatWeight() {
        return squatWeight;
    }

    public void setSquatWeight(String squatWeight) {
        this.squatWeight = squatWeight;
    }

    public String getOHPWeight() {
        return OHPWeight;
    }

    public void setOHPWeight(String OHPWeight) {
        this.OHPWeight = OHPWeight;
    }

    public String getRowWeight() {
        return rowWeight;
    }

    public void setRowWeight(String rowWeight) {
        this.rowWeight = rowWeight;
    }

    public String getBenchRep() { return benchRep; }

    public void setBenchRep(String benchRep) {
        this.benchRep = benchRep;
    }

    public String getDeadliftRep() {
        return deadliftRep;
    }

    public void setDeadliftRep(String deadliftRep) {
        this.deadliftRep = deadliftRep;
    }

    public String getSquatRep() { return squatRep; }

    public void setSquatRep(String squatRep) {
        this.squatRep = squatRep;
    }

    public String getOHPRep() {
        return OHPRep;
    }

    public void setOHPRep(String OHPRep) {
        this.OHPRep = OHPRep;
    }

    public String getRowRep() {
        return rowRep;
    }

    public void setRowRep(String rowRep) {
        this.rowRep = rowRep;
    }

    public String getBenchSet() { return benchSet; }

    public void setBenchSet(String benchSet) {
        this.benchSet = benchSet;
    }

    public String getDeadliftSet() {
        return deadliftSet;
    }

    public void setDeadliftSet(String deadliftSet) {
        this.deadliftSet = deadliftSet;
    }

    public String getSquatSet() { return squatSet; }

    public void setSquatSet(String squatSet) {
        this.squatSet = squatSet;
    }

    public String getOHPSet() {
        return OHPSet;
    }

    public void setOHPSet(String OHPSet) {
        this.OHPSet = OHPSet;
    }

    public String getRowSet() {
        return rowSet;
    }

    public void setRowSet(String rowSet) {
        this.rowSet = rowSet;
    }

    public String getPullupRep() {
        return pullupRep;
    }

    public void setPullupRep(String pullupRep) {
        this.pullupRep = pullupRep;
    }

    public String getPullupSet() {
        return pullupSet;
    }

    public void setPullupSet(String pullupSet) {
        this.pullupSet = pullupSet;
    }

    public String getPushupRep() {
        return pushupRep;
    }

    public void setPushupRep(String pushupRep) {
        this.pushupRep = pushupRep;
    }

    public String getPushupSet() {
        return pushupSet;
    }

    public void setPushupSet(String pushupSet) { this.pushupSet = pushupSet; }

    public String getCurlWeight() {
        return curlWeight;
    }

    public void setCurlWeight(String curlWeight) {
        this.curlWeight = curlWeight;
    }

    public String getCurlRep() {
        return curlRep;
    }

    public void setCurlRep(String curlRep) {
        this.curlRep = curlRep;
    }

    public String getCurlSet() {
        return curlSet;
    }

    public void setCurlSet(String curlSet) {
        this.curlSet = curlSet;
    }

    public String getExtWeight() {
        return extWeight;
    }

    public void setExtWeight(String extWeight) {
        this.extWeight = extWeight;
    }

    public String getExtRep() {
        return extRep;
    }

    public void setExtRep(String extRep) {
        this.extRep = extRep;
    }

    public String getExtSet() {
        return extSet;
    }

    public void setExtSet(String extSet) {
        this.extSet = extSet;
    }

    @Override
    public String toString() {
        return "Rep{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", bodyweight='" + bodyweight + '\'' +
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
                ", benchSet='" + benchSet + '\'' +
                ", deadliftSet='" + deadliftSet + '\'' +
                ", squatSet='" + squatSet + '\'' +
                ", OHPSet='" + OHPSet + '\'' +
                ", rowSet='" + rowSet + '\'' +
                ", pullupRep='" + pullupRep + '\'' +
                ", pullupSet='" + pullupSet + '\'' +
                ", pushupRep='" + pushupRep + '\'' +
                ", pushupSet='" + pushupSet + '\'' +
                ", curlWeight='" + curlWeight + '\'' +
                ", curlRep='" + curlRep + '\'' +
                ", curlSet='" + curlSet + '\'' +
                ", extWeight='" + extWeight + '\'' +
                ", extRep='" + extRep + '\'' +
                ", extSet='" + extSet + '\'' +
                '}';
    }

    protected Rep(Parcel in){
        id = in.readInt();
        title = in.readString();
        timestamp = in.readString();
        bodyweight = in.readString();
        benchRep = in.readString();
        benchSet = in.readString();
        benchWeight = in.readString();
        deadliftRep = in.readString();
        deadliftSet = in.readString();
        deadliftWeight = in.readString();
        squatRep = in.readString();
        squatSet = in.readString();
        squatWeight = in.readString();
        OHPRep = in.readString();
        OHPSet = in.readString();
        OHPWeight = in.readString();
        rowRep = in.readString();
        rowSet = in.readString();
        rowWeight = in.readString();
        pullupRep = in.readString();
        pullupSet = in.readString();
        pushupRep = in.readString();
        pushupSet = in.readString();
        curlRep = in.readString();
        curlWeight = in.readString();
        curlSet = in.readString();
        extRep = in.readString();
        extSet = in.readString();
        extWeight = in.readString();
    }

    public static final Creator<Rep> CREATOR = new Creator<Rep>() {
        @Override
        public Rep createFromParcel(Parcel source) {
            return new Rep(source);
        }

        @Override
        public Rep[] newArray(int size) {
            return new Rep[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(timestamp);
        dest.writeString(bodyweight);
        dest.writeString(benchRep);
        dest.writeString(benchSet);
        dest.writeString(benchWeight);
        dest.writeString(OHPRep);
        dest.writeString(OHPSet);
        dest.writeString(OHPWeight);
        dest.writeString(squatRep);
        dest.writeString(squatSet);
        dest.writeString(squatWeight);
        dest.writeString(deadliftRep);
        dest.writeString(deadliftSet);
        dest.writeString(deadliftWeight);
        dest.writeString(rowRep);
        dest.writeString(rowSet);
        dest.writeString(rowWeight);
        dest.writeString(pushupRep);
        dest.writeString(pushupSet);
        dest.writeString(pullupRep);
        dest.writeString(pullupSet);
        dest.writeString(curlRep);
        dest.writeString(curlSet);
        dest.writeString(curlWeight);
        dest.writeString(extRep);
        dest.writeString(extSet);
        dest.writeString(extWeight);
    }
}
