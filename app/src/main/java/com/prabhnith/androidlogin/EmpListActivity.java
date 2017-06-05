package com.prabhnith.androidlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by prabhjot on 05/06/2017.
 * Login and database learning
 */

public class EmpListActivity extends AppCompatActivity {
    String[] EmployeeInfoList = {"Prabh", "abc", "cds", "pdde", "Sfe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, EmployeeInfoList);

        ListView listView = (ListView) findViewById(R.id.array_list);
        listView.setAdapter(adapter);

    }
}

