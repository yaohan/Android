package com.example.lenovo.crazyandroid.chapter4;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;

import com.example.lenovo.crazyandroid.R;

import java.util.List;

/**
 * Created by LENOVO on 2015/12/21.
 */
public class PreferenceTestActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(hasHeaders()){
            Button button = new Button(this);
            button.setText("设置操作");
            setListFooter(button);
        }
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers,target);
    }


    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

    public static class Prefs1Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    public static class Prefs2Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);
        }
    }
}
