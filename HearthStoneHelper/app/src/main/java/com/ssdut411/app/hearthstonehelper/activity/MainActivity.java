package com.ssdut411.app.hearthstonehelper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ssdut411.app.hearthstonehelper.BaseActivity;
import com.ssdut411.app.hearthstonehelper.MainApplication;
import com.ssdut411.app.hearthstonehelper.R;
import com.ssdut411.app.hearthstonehelper.model.Record;
import com.ssdut411.app.hearthstonehelper.utils.L;
import com.ssdut411.app.hearthstonehelper.utils.SPUtils;
import com.ssdut411.app.hearthstonehelper.utils.T;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity {
    @Override
    protected int initMenu() {
        return 0;
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        getButton(R.id.bt_main_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainApplication.getInstance().getNewRecord().setStartTime(new Date());
                Intent intent = new Intent(context, SelectHeroActivity.class);
                startActivity(intent);
            }
        });
        getButton(R.id.bt_main_record).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,MyRecordActivity.class));
            }
        });
        getButton(R.id.bt_clear_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.clear(context);
                T.showShort(context, "清除缓存");
                MainApplication.getInstance().reloadList();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void showView() {

    }
}
