package com.example.lenovo.crazyandroid.chapter4;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.crazyandroid.R;

/**
 * Created by LENOVO on 2015/12/21.
 */
public class ExpandableListTestActivity extends ExpandableListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = {
                    R.drawable.icon1,
                    R.drawable.icon2,
                    R.drawable.icon3
            };

            private String[] armTypes = new String[]{
                    "神族兵种","虫族兵种","人族兵种"
            };

            private String[][] arms = new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","电兵"},
                    {"小狗","刺蛇","飞龙","自爆飞机"},
                    {"机枪兵","护士MM","幽灵"}
            };


            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armTypes[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
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
                LinearLayout linearLayout = new LinearLayout(ExpandableListTestActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(ExpandableListTestActivity.this);
                imageView.setImageResource(logos[groupPosition]);
                linearLayout.addView(imageView);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(textView);
                return linearLayout;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView = new TextView(ExpandableListTestActivity.this);
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
    }
}
