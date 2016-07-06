package com.example.lenovo.crazyandroid.chapter4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LENOVO on 2016/1/4.
 */
public class BookDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";

    BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(ITEM_ID)){
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.)
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
