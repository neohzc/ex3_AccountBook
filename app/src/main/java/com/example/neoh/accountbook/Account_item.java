package com.example.neoh.accountbook;

public class Account_item {

    private String money;
    private String classify;
    private String time;
    private int id;


    Account_item(String money, String classify, String time, int id) {
        this.money = money;
        this.classify = classify;
        this.time = time;
        this.id = id;


    }

    Account_item(int id) {
        this.money = "";
        this.classify = "";
        this.time = "";
        this.id = id;


    }

    public void setmoney(String money) {
        this.money = money;
    }

    public void setclassify(String classify) {
        this.classify = classify;
    }

    public void settime(String time) {
        this.time = time;
    }

    public String getmoney() {
        return money;
    }

    public String getclassify() {
        return classify;
    }

    public String gettime() {
        return time;
    }

    public int getId() {
        return id;
    }


}
