package com.finalproject.softspec.check.model;

import java.util.Date;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class Task {
    private String name;
    private Date date;

    public Task (String inputName, Date inputDate) {
        name = inputName;
        date = inputDate;
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

}
