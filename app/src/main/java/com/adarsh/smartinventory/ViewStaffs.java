package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewStaffs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_staffs);
    }

    public void addStaffClick(View view) {

        Intent i=new Intent(ViewStaffs.this,AddStaff.class);
        startActivity(i);
    }
}
