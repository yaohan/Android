package com.example.lenovo.crazyandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.crazyandroid.chapter4.LauncherTestActivity;
import com.example.lenovo.crazyandroid.chapter4.LifeCycleActivity;
import com.example.lenovo.crazyandroid.chapter4.PreferenceTestActivity;
import com.example.lenovo.crazyandroid.chapter4.RegisterActivity;
import com.example.lenovo.crazyandroid.chapter4.SelectActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.bt_activity_1)).setOnClickListener(this);
        ((Button)findViewById(R.id.bt_activity_2)).setOnClickListener(this);
        ((Button)findViewById(R.id.bt_activity_3)).setOnClickListener(this);
        ((Button)findViewById(R.id.bt_activity_4)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_activity_1:
                startActivity(new Intent(MainActivity.this, LauncherTestActivity.class));
                break;
            case R.id.bt_activity_2:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
            case R.id.bt_activity_3:
                startActivity(new Intent(MainActivity.this, SelectActivity.class));
                break;
            case R.id.bt_activity_4:
                startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
                break;
        }
    }
}
