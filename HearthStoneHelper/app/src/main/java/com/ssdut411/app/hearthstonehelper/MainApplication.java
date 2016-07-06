package com.ssdut411.app.hearthstonehelper;

import android.app.Application;
import android.content.Context;

import com.ssdut411.app.hearthstonehelper.model.Record;
import com.ssdut411.app.hearthstonehelper.utils.GsonUtils;
import com.ssdut411.app.hearthstonehelper.utils.L;
import com.ssdut411.app.hearthstonehelper.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2016/3/27.
 */
public class MainApplication extends Application {
    private List<Record> list;
    private Context context;
    private Record newRecord;


    // 单例一个MainApplication
    private static MainApplication instance;

    public static MainApplication getInstance() {
        return MainApplication.instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        list = getRecord();
    }

    public List<Record> getRecord() {
        List<Record> record;
//        SPUtils.clear(context);
        String strRecord = SPUtils.get(context,"record","").toString();
        L.i("record："+strRecord);
        if(strRecord.equals("")){
           record = initList();
            setList(record);
        }else{
            L.i("record:"+strRecord);
            record = GsonUtils.gsonToList(strRecord,Record.class);
        }
        return record;
    }

    private List<Record> initList() {
        List<Record> list = new ArrayList<Record>();
        list.add(new Record(Record.TYPE_DRUID));
        list.add(new Record(Record.TYPE_HUNTER));
        list.add(new Record(Record.TYPE_MAGE));
        list.add(new Record(Record.TYPE_PALADIN));
        list.add(new Record(Record.TYPE_PREIST));
        list.add(new Record(Record.TYPE_ROUGE));
        list.add(new Record(Record.TYPE_SHAMAN));
        list.add(new Record(Record.TYPE_WARLOCK));
        list.add(new Record(Record.TYPE_WARRIOR));
        return list;
    }

    public List<Record> getList() {
        return list;
    }

    public void setList(List<Record> list) {
        SPUtils.put(context,"record",GsonUtils.gsonToJsonString(list));
        this.list = list;
    }

    public void updateList(){
        setList(list);
    }

    public Record getNewRecord() {
        if(newRecord == null){
            newRecord = new Record();
        }
        return newRecord;
    }

    public void setNewRecord(Record newRecord) {
        this.newRecord = newRecord;
    }

    public void resetNewRecord(){
        newRecord = new Record();
    }

    public void reloadList(){
        list = getRecord();
    }
}
