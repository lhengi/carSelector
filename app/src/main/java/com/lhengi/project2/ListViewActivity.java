package com.lhengi.project2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {
    private String[] dealers;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        Intent intent = getIntent();
        dealers = intent.getStringArrayExtra("dealers");

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item,dealers);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

    }
}
