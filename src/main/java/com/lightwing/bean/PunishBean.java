package com.lightwing.bean;

public class PunishBean {
    private int punish_ID;
    private int users_ID;
    private int books_ID;
    private int punish_Day;
    private int punish_Money;

    public PunishBean() {
    }

    public void setPunish_ID(int punish_ID) {
        this.punish_ID = punish_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public void setBooks_ID(int books_ID) {
        this.books_ID = books_ID;
    }

    public void setPunish_Day(int punish_Day) {
        this.punish_Day = punish_Day;
    }

    public void setPunish_Money(int punish_Money) {
        this.punish_Money = punish_Money;
    }

    public int getPunish_ID() {
        return punish_ID;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public int getBooks_ID() {
        return books_ID;
    }

    public int getPunish_Day() {
        return punish_Day;
    }

    public int getPunish_Money() {
        return punish_Money;
    }
}
