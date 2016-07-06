package com.example.lenovo.crazyandroid.chapter4;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by LENOVO on 2015/12/21.
 */
public class LauncherTestActivity extends LauncherActivity{
    String[] names = {"设置程序参数","查看星际兵种"};
    Class<?>[] clazzs = {PreferenceTestActivity.class,ExpandableListTestActivity.class};

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(LauncherTestActivity.this,clazzs[position]);
    }
}
