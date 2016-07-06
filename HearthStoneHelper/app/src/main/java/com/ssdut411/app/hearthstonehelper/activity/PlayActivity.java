package com.ssdut411.app.hearthstonehelper.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.ssdut411.app.hearthstonehelper.BaseActivity;
import com.ssdut411.app.hearthstonehelper.MainApplication;
import com.ssdut411.app.hearthstonehelper.R;
import com.ssdut411.app.hearthstonehelper.model.Record;
import com.ssdut411.app.hearthstonehelper.utils.L;
import com.ssdut411.app.hearthstonehelper.utils.T;

import java.util.Date;
import java.util.List;

/**
 * Created by LENOVO on 2016/3/27.
 */
public class PlayActivity extends BaseActivity {
    private static int REQUEST_CODE = 0;
    private boolean select;
    private boolean victory;
    private Record newRecord;
    private Record myRecord;
    private EditText etTips;
    private Record existRecord;

    @Override
    protected int initMenu() {
        return 0;
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_play;
    }

    @Override
    protected void initViews() {
        etTips = getEditText(R.id.et_tips);
        getButton(R.id.bt_play_victory).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                victory = true;
                update(victory);
            }

        });
        
        getButton(R.id.bt_play_fail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                victory = false;
                update(victory);
            }
        });

        getButton(R.id.bt_select_other_deck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOtherDeck();
            }
        });
    }

    @Override
    protected void loadData() {
        int position = getIntent().getIntExtra("my_position",-1);
        if(position == -1){
            T.showShort(context,"position error");
            finish();
        }else{
            myRecord = MainApplication.getInstance().getList().get(position);
        }
        newRecord = MainApplication.getInstance().getNewRecord();
        getTextView(R.id.tv_my_hero).setText(newRecord.getName());
        getTextView(R.id.tv_other_hero).setText(newRecord.getOtherName());
    }

    @Override
    protected void showView() {

    }

    private void selectOtherDeck() {
        Intent intent = new Intent(context,SelectDeckActivity.class);
        intent.putExtra("position",getIntent().getIntExtra("position",-1));
        startActivityForResult(intent,REQUEST_CODE);
    }

    private void update(boolean victory) {
        if(!select){
            T.showShort(context,"请选择对方卡组");
        }else{
            Record record = getExistRecord();
            if(record !=null){
                if(victory){
                    record.addVictory();
                    myRecord.addVictory();
                }else{
                    record.addFail();
                    myRecord.addFail();
                }
            }else{
                newRecord.setEndTime(new Date());
                if(!etTips.getText().equals("")){
                    newRecord.getTips().add(etTips.getText().toString());
                }
                if(myRecord.getList().size() == 1){
                    Record record1 = myRecord.getList().get(0);
                    if(record1.getVictory() == 0 && record1.getFail() == 0){
                        if(victory){
                            record1.addVictory();
                        }else{
                            record1.addVictory();
                        }
                    }else{
                        myRecord.getList().add(newRecord);
                    }
                }
                if(victory){
                    newRecord.addVictory();
                    myRecord.addVictory();
                }else{
                    newRecord.addFail();
                    myRecord.addFail();
                }

            }

            MainApplication.getInstance().resetNewRecord();
            MainApplication.getInstance().updateList();
//            L.i("newRecord:"+newRecord);
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            select = true;
            String otherHero = data.getStringExtra("select");
            getTextView(R.id.tv_other_hero).setText(otherHero);
            newRecord.setOtherName(otherHero);
        }else{
//            T.showShort(context, "result code error");
        }
    }

    public Record getExistRecord() {
        List<Record> list = myRecord.getList();
        for(Record record:list){
            if(record.getName().equals(newRecord.getName())){
                return record;
            }
        }
        return null;
    }
}
