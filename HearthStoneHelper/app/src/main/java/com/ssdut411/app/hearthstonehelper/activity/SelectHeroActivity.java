package com.ssdut411.app.hearthstonehelper.activity;

import android.content.Intent;
import android.view.View;

import com.ssdut411.app.hearthstonehelper.BaseActivity;
import com.ssdut411.app.hearthstonehelper.MainApplication;
import com.ssdut411.app.hearthstonehelper.R;
import com.ssdut411.app.hearthstonehelper.model.Record;
import com.ssdut411.app.hearthstonehelper.utils.CommonAdapter;
import com.ssdut411.app.hearthstonehelper.utils.T;
import com.ssdut411.app.hearthstonehelper.utils.ViewHolder;

import java.util.List;

/**
 * Created by LENOVO on 2016/3/27.
 */
public class SelectHeroActivity extends BaseActivity {
    public static int REQUEST_CODE = 0;
    private boolean selected;
    private int myHeroPosition;
    @Override
    protected int initMenu() {
        return 0;
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_select_hero;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadData() {
//        String myHero = MainApplication.getInstance().getNewRecord().getName();
//        if(myHero != null){
//            selected = true;
//            getRelativeLayout(R.id.rl_my_hero).setVisibility(View.VISIBLE);
//            getTextView(R.id.tv_my_select_hero).setText(myHero);
//        }
    }

    @Override
    protected void showView() {
        setTitle(getString(R.string.select_hero));
        setCanBack();
        List<Record> list = MainApplication.getInstance().getList();
        CommonAdapter<Record> adapter = new CommonAdapter<Record>(context,list,R.layout.item_grid) {
            @Override
            public void convert(ViewHolder viewHolder, final Record record, final int position) {
                viewHolder.getButton(R.id.bt_grid_name).setText(record.getName());
                viewHolder.getButton(R.id.bt_grid_name).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        if(selected){
                            MainApplication.getInstance().getNewRecord().setOtherName(record.getName());
                            intent = new Intent(context, PlayActivity.class);
                            intent.putExtra("my_position",myHeroPosition);
                            intent.putExtra("position",position);
                            startActivity(intent);
                            finish();
                        }else{
                            myHeroPosition = position;
                            intent = new Intent(context,SelectDeckActivity.class);
                            intent.putExtra("position",position);
                            startActivityForResult(intent,REQUEST_CODE);
                        }
                    }
                });
            }
        };
        getGridView(R.id.gv_view).setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            selected = true;
            String myHero = data.getStringExtra("select");
            getRelativeLayout(R.id.rl_my_hero).setVisibility(View.VISIBLE);
            getTextView(R.id.tv_my_select_hero).setText(myHero);
            MainApplication.getInstance().getNewRecord().setName(myHero);
        }else{
//            T.showShort(context,"result code error");
        }
    }
}
