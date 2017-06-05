package com.finalproject.softspec.check.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class Task implements Parcelable {
    private int id;
    private String name;
    private Date date;
    private static int taskCount;

    public Task (String inputName) {
        id = taskCount++;
        name = inputName;
//        date = new Date();
//        date = inputDate;
    }

    protected Task(Parcel in) {
        id = in.readInt();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void completeTask(){

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
        dest.writeString(name);
    }
}
