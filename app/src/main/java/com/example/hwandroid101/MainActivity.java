package com.example.hwandroid101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String, String>> contentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        String[] values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private SimpleAdapter createAdapter(String[] stringsTxt) {
        contentList = new ArrayList<>();
        prepareAdapterContetn(stringsTxt);

        return new SimpleAdapter(this, contentList,
                R.layout.list_with_content,
                new String[]{"text", "length"},
                new int[]{R.id.firstText, R.id.secondText});
    }

    @NonNull
    private List<Map<String, String>> prepareAdapterContetn(String[] stringsTxt) {
        Map<String, String> mapForList;
        for (String value : stringsTxt) {
            mapForList = new HashMap<>();
            mapForList.put("text", value);
            mapForList.put("length", Integer.toString(value.length()));
            contentList.add(mapForList);
        }
        return contentList;
    }

    @NonNull
    private String[] prepareContent() {

        return getString(R.string.large_text).split("\n\n");
    }
}
