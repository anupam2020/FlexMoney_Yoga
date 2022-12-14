package com.sbdev.flexmoney_yoga;

public class UsersModel {

    String Name, Date;

    public UsersModel()
    {

    }

    public UsersModel(String name, String date) {
        Name = name;
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
