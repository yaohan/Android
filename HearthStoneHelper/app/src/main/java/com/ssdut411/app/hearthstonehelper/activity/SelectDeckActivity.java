package com.ssdut411.app.hearthstonehelper.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ssdut411.app.hearthstonehelper.BaseActivity;
import com.ssdut411.app.hearthstonehelper.MainApplication;
import com.ssdut411.app.hearthstonehelper.R;
import com.ssdut411.app.hearthstonehelper.model.Record;
import com.ssdut411.app.hearthstonehelper.utils.CommonAdapter;
import com.ssdut411.app.hearthstonehelper.utils.T;
import com.ssdut411.app.hearthstonehelper.utils.ViewHolder;
import com.ssdut411.app.hearthstonehelper.widget.EmptyLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2016/3/27.
 */
public class SelectDeckActivity extends BaseActivity {
    private ListView lvList;
    private EmptyLayout emptyLayout;
    private RelativeLayout rlAdd;
    private List<Record> list;
    private List<String> stringList;
    private EditText etAdd;
    private CommonAdapter<String> adapter;
    @Override
    protected int initMenu() {
        return R.menu.menu_new;
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_listview;
    }

    @Override
    protected void initViews() {
        lvList = getListView(R.id.lv_list);
        rlAdd = getRelativeLayout(R.id.rl_add);
        etAdd = getEditText(R.id.et_add);
        emptyLayout = new EmptyLayout(context,lvList);
        emptyLayout.showLoading();

        getTextView(R.id.bt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etAdd.getText().toString().equals("")) {
                    T.showShort(context, "牌组名不能为空");
                } else {
                    addNewDeck();
                }
            }

        });

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String select = list.get(position).getName();
                MainApplication.getInstance().getNewRecord().setName(select);
                Intent intent = getIntent();
                intent.putExtra("select",select);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.actions_add:
                        rlAdd.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void loadData() {
        int position = getIntent().getIntExtra("position", -1);
        if(position == -1){
            T.showShort(context,"error!");
        }else{
            list = MainApplication.getInstance().getList().get(position).getList();
            stringList = getStringList();
            adapter = new CommonAdapter<String>(context,stringList,R.layout.item_list) {
                @Override
                public void convert(ViewHolder viewHolder, String s, int position) {
                    viewHolder.getTextView(R.id.tv_item_name).setText(s);
                }
            };
            if(list.size() == 0){
                emptyLayout.showEmpty();
            }
                lvList.setAdapter(adapter);
        }

    }

    @Override
    protected void showView() {
        setCanBack();
        setTitle("选择卡组");
    }

    private void addNewDeck() {
        String name = etAdd.getText().toString();
        rlAdd.setVisibility(View.GONE);
        list.add(new Record(name));
        stringList.add(name);
        MainApplication.getInstance().updateList();
        adapter.notifyDataSetChanged();
        MainApplication.getInstance().getNewRecord().setName(etAdd.getText().toString());
    }

    public List<String> getStringList() {
        List<String> stringList = new ArrayList<String>();
        for(Record record:list){
            String name = record.getName();
            if(!stringList.contains(name)){
                stringList.add(name);
            }
        }
        return stringList;
    }
}
