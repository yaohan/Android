package com.ssdut411.app.hearthstonehelper.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LENOVO on 2016/3/27.
 */
public class Record implements Serializable{
    public static String TYPE_WARRIOR = "战士";
    public static String TYPE_MAGE = "法师";
    public static String TYPE_PREIST = "牧师";
    public static String TYPE_ROUGE = "盗贼";
    public static String TYPE_PALADIN = "骑士";
    public static String TYPE_WARLOCK = "术士";
    public static String TYPE_DRUID = "德鲁伊";
    public static String TYPE_HUNTER = "猎人";
    public static String TYPE_SHAMAN = "萨满";

    private String id;
    private String name;
    private String otherName;
    private int victory;
    private int fail;
    private Date startTime;
    private Date endTime;
    private List<String> tips;
    private List<Record> list;

    public Record() {
        victory = 0;
        fail = 0;
        tips = new ArrayList<String>();
        list = new ArrayList<Record>();
    }

    public Record(String name) {
       this();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<String> getTips() {
        return tips;
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }

    public List<Record> getList() {
        return list;
    }

    public void setList(List<Record> list) {
        this.list = list;
    }

    public void addFail(){
        fail++;
    }
    public void addVictory(){
        victory++;
    }
}
