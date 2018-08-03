package com.lightwing.bean;

public class AdminBean {
    private int admin_ID;
    private String admin_Name;
    private String admin_Pwd;
    private String admin_Flag;

    public AdminBean() {
    }

    public void setAdmin_ID(int admin_ID) {
        this.admin_ID = admin_ID;
    }

    public void setAdmin_Name(String admin_Name) {
        this.admin_Name = admin_Name;
    }

    public void setAdmin_Pwd(String admin_Pwd) {
        this.admin_Pwd = admin_Pwd;
    }

    public void setAdmin_Flag(String admin_Flag) {
        this.admin_Flag = admin_Flag;
    }

    public int getAdmin_ID() {
        return admin_ID;
    }

    public String getAdmin_Name() {
        return admin_Name;
    }

    public String getAdmin_Pwd() {
        return admin_Pwd;
    }

    public String getAdmin_Flag() {
        return admin_Flag;
    }
}
