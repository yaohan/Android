package com.example.lenovo.crazyandroid.chapter4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.lenovo.crazyandroid.R;

/**
 * Created by LENOVO on 2015/12/21.
 */
public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ((Button)findViewById(R.id.bn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person();
                p.setName(((EditText) findViewById(R.id.name)).getText().toString());
                p.setPassword(((EditText) findViewById(R.id.password)).getText().toString());
                p.setGender(((RadioButton) findViewById(R.id.male)).isChecked() ? "男" : "女");
                Bundle data = new Bundle();
                data.putSerializable("person", p);
                Intent intent = new Intent(RegisterActivity.this,ShowActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}
