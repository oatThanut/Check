package com.finalproject.softspec.check.model;

import java.util.ArrayList;

/**
 * Created by oatThanut on 6/2/2017 AD.
 */

public class User  {
    private static User instant;
    private String name;
    private int completed;
    private int overdue;
    private ArrayList<Task> primaryList;
    private ArrayList<Group> groupList;

    private User () {
        name = "Mr.Mockup name";
        completed = 0;
        overdue = 0;
        primaryList = new ArrayList<Task>();
        groupList = new ArrayList<Group>();
//        mockUp();
    }

    private void mockUp(){
        primaryList.add(new Task("Demo 1", 5,5,2017,0,0));
        primaryList.add(new Task("Demo 2", 5,5,2017,0,0));
        primaryList.add(new Task("Demo 3", 5,5,2017,0,0));
        groupList.add(new Group("Demo group1"));
        groupList.get(0).addTask(new Task("Demo 1.1", 5,5,2017,0,0));
        groupList.get(0).addTask(new Task("Demo 1.2", 5,5,2017,0,0));
        groupList.add(new Group("Demo group2"));
        groupList.get(1).addTask(new Task("Demo 2.1", 5,5,2017,0,0));
        groupList.add(new Group("Demo group3"));
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

    public void addTask(Task t) {
        primaryList.add(t);
    }

    public void changePTask(int id, String name) {
        for(Task t : primaryList){
            if(t.getId() == id) {
                t.setName(name);
            }
        }
    }

    public void changeGTask(int id, int groupID, String name) {
        for(Group g : groupList) {
            for(Task t : g.getList()){
                if(t.getId() == id) {
                    t.setName(name);
                }
            }
        }

    }

    public void addGroup(Group g) {
        groupList.add(g);
    }

    public void deleteGroup(int groupID) {
        for(Group g : groupList) {
            if(g.getId() == groupID) {
                g.clean();
                groupList.remove(g);
            }
        }
    }

    public void completePTask(int id) {
        deletePTask(id);
        completed++;
    }

    public void completeGTask(int id, int groupID) {
        deleteGTask(id, groupID);
        completed++;
    }

    public void deleteGTask(int id, int groupID) {
        for(Group g : groupList) {
            if(g.getId() == groupID) {
                for(Task t : g.getList()){
                    if(t.getId() == id) {
                        g.getList().remove(t);
                    }
                }
            }
        }
    }

    public void deletePTask(int id) {
        for(Task t : primaryList){
            if(t.getId() == id) {
                primaryList.remove(t);
            }
        }
    }


}
