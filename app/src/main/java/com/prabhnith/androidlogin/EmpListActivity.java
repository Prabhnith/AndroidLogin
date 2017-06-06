package com.prabhnith.androidlogin;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by prabhjot on 05/06/2017.
 * Login and database learning
 */

public class EmpListActivity extends AppCompatActivity {
//    String[] EmployeeInfoList = {"Prabh", "abc", "cds", "pdde", "Sfe"};

    private DatabaseHandler db;
    private EmpListAdapter empListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);

//        DatabaseHandler db;
        db = DatabaseHandler.getmInstance(getApplicationContext());

        ListView mListView = (ListView) findViewById(R.id.array_list);
        Cursor cursor = db.getEmpList();
        if(cursor!=null){
            empListAdapter = new EmpListAdapter(getApplicationContext(), cursor,0);
            mListView.setAdapter(empListAdapter);
        }
        //ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, EmployeeInfoList);
        //ListView listView = (ListView) findViewById(R.id.array_list);
        //listView.setAdapter(adapter);

    }

    public class EmpListAdapter extends CursorAdapter{

        public EmpListAdapter(Context context, Cursor cursor,int flag) {
            super(context, cursor,0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.listitems,parent,false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView txtEmpName = (TextView) view.findViewById(R.id.txtEmpName);
            String EmpName = cursor.getString(cursor.getColumnIndex("EmpName"));
            txtEmpName.setText(EmpName);
        }
    }


}

