package com.finalproject.softspec.check.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class Task implements Parcelable {
    private int id, date, month, year, minute, hour;
    private String name;
    private static int taskCount;

    public Task (String inputName, int inputDate, int inputMonth, int inputYear, int inputMinute, int inputHour) {
        id = taskCount++;
        date = inputDate;
        month = inputMonth;
        year = inputYear;
        minute = inputMinute;
        hour = inputHour;
        name = inputName;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        date = in.readInt();
        month = in.readInt();
        year = in.readInt();
        minute = in.readInt();
        hour = in.readInt();
        name = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString () {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(date);
        dest.writeInt(month);
        dest.writeInt(year);
        dest.writeInt(minute);
        dest.writeInt(hour);
        dest.writeString(name);
    }
}
