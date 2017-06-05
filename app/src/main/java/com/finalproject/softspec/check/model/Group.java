package com.finalproject.softspec.check.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class Group implements Parcelable {
    private int id;
    private String name;
    private ArrayList<Task> list;
    private static int groupConut;

    public Group (String inputName) {
        id = groupConut++;
        name = inputName;
        list = new ArrayList<Task>();
    }

    protected Group(Parcel in) {
        id = in.readInt();
        name = in.readString();
        list = new ArrayList<Task>();
        in.readList(list, Task.class.getClassLoader());
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void setList(ArrayList<Task> list) {
        this.list = list;
    }

    public void addTask(Task t) {
        list.add(t);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return name;
    }

    public void clean(){
        list.clear();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeList(list);
    }
}
