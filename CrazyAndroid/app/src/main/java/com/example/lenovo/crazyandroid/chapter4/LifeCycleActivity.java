package com.example.lenovo.crazyandroid.chapter4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.crazyandroid.MainActivity;
import com.example.lenovo.crazyandroid.R;

/**
 * Created by LENOVO on 2016/1/4.
 */
public class LifeCycleActivity extends Activity {
    final String TAG = "lifeCycle";
    Button finish,startActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("yao", "task id:" + getTaskId());
        Log.i(TAG, "================onCreate");
        setContentView(R.layout.activity_life_cycle);
        finish = (Button)findViewById(R.id.finish);
        startActivity = (Button)findViewById(R.id.start);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.lenovo.crazyandroid.CRAZY_ACTION");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "================onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "================onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "================onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "================onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "================onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "================onDestroy");
    }
}
