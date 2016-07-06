package com.example.lenovo.crazyandroid.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.lenovo.crazyandroid.R;

/**
 * Created by LENOVO on 2016/1/4.
 */
public class SelectActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Log.i("yao", "task id:" + getTaskId());
    }
    public void select(View view){
        Intent intent = new Intent(SelectActivity.this,SelectCityActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0 && resultCode == 0){
            String result = data.getStringExtra("city");
            ((EditText)findViewById(R.id.city)).setText(result);
        }
    }
}
