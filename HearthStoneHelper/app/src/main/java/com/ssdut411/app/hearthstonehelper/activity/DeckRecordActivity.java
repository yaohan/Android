package com.ssdut411.app.hearthstonehelper.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.ssdut411.app.hearthstonehelper.BaseActivity;
import com.ssdut411.app.hearthstonehelper.MainApplication;
import com.ssdut411.app.hearthstonehelper.R;
import com.ssdut411.app.hearthstonehelper.model.Record;
import com.ssdut411.app.hearthstonehelper.utils.CommonAdapter;
import com.ssdut411.app.hearthstonehelper.utils.L;
import com.ssdut411.app.hearthstonehelper.utils.T;
import com.ssdut411.app.hearthstonehelper.utils.ViewHolder;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by LENOVO on 2016/3/27.
 */
public class DeckRecordActivity extends BaseActivity {
    private List<Record> list;
    private CommonAdapter<Record> adapter;

    @Override
    protected int initMenu() {
        return 0;
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_listview;
    }

    @Override
    protected void initViews() {
        int position = getIntent().getIntExtra("position",-1);
        if(position == -1){
            T.showShort(context,"position　error");
        }
        list = MainApplication.getInstance().getList().get(position).getList();
        adapter = new CommonAdapter<Record>(context, list, R.layout.item_list) {

            @Override
            public void convert(ViewHolder viewHolder, Record record, int position) {
                if(record.getVictory()+record.getFail()!=0){
                    viewHolder.getTextView(R.id.tv_item_count).setText((record.getVictory() + record.getFail()) + "场");
                    viewHolder.getTextView(R.id.tv_item_name).setText(record.getName());
                    viewHolder.getTextView(R.id.tv_item_right).setText(getRate(record));
                }
            }
        };
        getListView(R.id.lv_list).setAdapter(adapter);
    }
    public String getRate(Record record) {
        double victory = record.getVictory();
        double fail = record.getFail();
        if (victory == 0) {
            return "0.00%";
        }
        DecimalFormat format = new DecimalFormat("#.00%");
        L.i("victory:" + victory + " fail:" + fail + " format" + format.format(victory / (victory + fail)));
        return format.format(victory / (victory + fail));
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void showView() {
        setCanBack();
        setTitle("我的战绩");
    }
}
