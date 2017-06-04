package com.finalproject.softspec.check.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class Group {
    private String name;
    private ArrayList<Task> list;

    public Group (String inputName) {
        name = inputName;
        list = new ArrayList<Task>();
    }

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

}
