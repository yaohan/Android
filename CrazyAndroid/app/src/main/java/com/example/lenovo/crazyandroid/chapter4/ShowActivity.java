package com.example.lenovo.crazyandroid.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lenovo.crazyandroid.R;

/**
 * Created by LENOVO on 2015/12/21.
 */
public class ShowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        Person p = (Person)intent.getSerializableExtra("person");
        ((TextView)findViewById(R.id.name)).setText("您的用户名为"+p.getName());
        ((TextView)findViewById(R.id.password)).setText("您的密码为"+p.getPassword());
        ((TextView)findViewById(R.id.gender)).setText("您的性别为"+p.getGender());
    }
}
