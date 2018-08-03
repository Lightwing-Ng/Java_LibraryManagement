package com.lightwing.bean;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UserBean {
    private int users_ID;
    private String users_Name;
    private String users_Pwd;
    private String users_Class;
    private String users_Sex;
    private int users_Count;
    private String users_Phone;
    private String users_Adds;

    public UserBean() {
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public void setUsers_Name(String users_Name) {
        this.users_Name = users_Name;
    }

    public void setUsers_Pwd(String users_Pwd) {
        this.users_Pwd = users_Pwd;
    }

    public void setUsers_Class(String users_Class) {
        this.users_Class = users_Class;
    }

    public void setUsers_Sex(String users_Sex) {
        this.users_Sex = users_Sex;
    }

    public void setUsers_Count(int users_Count) {
        this.users_Count = users_Count;
    }

    public void setUsers_Phone(String users_Phone) {
        this.users_Phone = users_Phone;
    }

    public void setUsers_Adds(String users_Adds) {
        this.users_Adds = users_Adds;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public String getUsers_Name() {
        return users_Name;
    }

    public String getUsers_Pwd() {
        return users_Pwd;
    }

    public String getUsers_Class() {
        return users_Class;
    }

    public String getUsers_Sex() {
        return users_Sex;
    }

    public int getUsers_Count() {
        return users_Count;
    }

    public String getUsers_Phone() {
        return users_Phone;
    }

    public String getUsers_Adds() {
        return users_Adds;
    }
}
