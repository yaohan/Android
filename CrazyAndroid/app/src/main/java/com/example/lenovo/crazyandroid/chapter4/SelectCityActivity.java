package com.example.lenovo.crazyandroid.chapter4;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by LENOVO on 2016/1/4.
 */
public class SelectCityActivity extends ExpandableListActivity {
    private String[] provinces = new String[]{"广东","广西","湖南"};
    private String[][] cities = new String[][]{
        {"广州","深圳","珠海","中山"},{"桂林","柳州","南宁","北海"},{"长沙","岳阳","衡阳","株洲"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("yao", "task id:" + getTaskId());
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(SelectCityActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(SelectCityActivity.this);
                linearLayout.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(textView);
                return linearLayout;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView = new TextView(SelectCityActivity.this);
                textView.setLayoutParams(layoutParams);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = getIntent();
                intent.putExtra("city", cities[groupPosition][childPosition]);
                setResult(0, intent);
                finish();
                return false;
            }
        });
    }
}
