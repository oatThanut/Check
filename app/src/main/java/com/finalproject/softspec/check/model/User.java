package com.finalproject.softspec.check.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class User {
    private static User instant;
    private String name;
    private int completed;
    private int overdue;
    private ArrayList<Task> primaryList;
    private ArrayList<Group> groupList;

    private User () {
        name = "Mockup name";
        completed = 0;
        overdue = 0;
        primaryList = new ArrayList<Task>();
        groupList = new ArrayList<Group>();

        primaryList.add(new Task("Demo"));
    }

    public static User getInstance() {
        if (instant == null) {
            instant = new User();
        }
        return instant;
    }

    public ArrayList<Task> getPrimaryList() {
        return primaryList;
    }

    public void setPrimaryList(ArrayList<Task> primaryList) {
        this.primaryList = primaryList;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getOverdue() {
        return overdue;
    }

    public void setOverdue(int overdue) {
        this.overdue = overdue;
    }
}
