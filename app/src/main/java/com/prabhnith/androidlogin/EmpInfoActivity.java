package com.prabhnith.androidlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by prabhjot on 05/06/2017.
 */

public class EmpInfoActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private String empname, add, city, state, mobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_emp_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText empName = (EditText) findViewById(R.id.txtEmpName);
        final EditText empAdd = (EditText) findViewById(R.id.txtEmpAdd);
        final EditText empCity = (EditText) findViewById(R.id.txtEmpCity);
        final EditText empState = (EditText) findViewById(R.id.txtEmpState);
        final EditText empMobile = (EditText) findViewById(R.id.txtEmpMobile);

        db = new DatabaseHandler(getApplicationContext());

        Button btnSave = (Button) findViewById(R.id.btnSubmit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                empname = empName.getText().toString();
                add = empAdd.getText().toString();
                city = empCity.getText().toString();
                state = empState.getText().toString();
                mobile = empMobile.getText().toString();

                long id = db.insertIntoEmpInfo(empname, add, city, state, mobile);
                if (id > 0) {
                    Toast.makeText(getApplicationContext(), "Employee Information Saved Successfuly.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, No record saved.", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btnShowList = (Button) findViewById(R.id.btnShowList);
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent empList = new Intent(EmpInfoActivity.this, EmpListActivity.class);
                startActivity(empList);

            }
        });


    }
}
