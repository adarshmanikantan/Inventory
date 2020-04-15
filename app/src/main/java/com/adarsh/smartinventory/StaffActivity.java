package com.adarsh.smartinventory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StaffActivity extends AppCompatActivity {

    private TextView staffNameDetails;
    private TextView staffEmpcodeDetails;
    private TextView proPriceDetails;
    private TextView staffEmailDetails;
    private TextView proDealernameDetails;
    private TextView staffPhoneDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        initView();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pro", Context.MODE_PRIVATE);
        staffNameDetails.setText(sharedPreferences.getString("name",null));
        staffEmpcodeDetails.setText("Employee Code : "+sharedPreferences.getString("empcode",null));
        staffEmailDetails.setText("Email : "+sharedPreferences.getString("email",null));
        staffPhoneDetails.setText("Phone number : "+sharedPreferences.getString("contact",null));
    }

    private void initView() {
        staffNameDetails = findViewById(R.id.staff_name_details);
        staffEmpcodeDetails = findViewById(R.id.staff_empcode_details);
        staffEmailDetails = findViewById(R.id.staff_email_details);
        staffPhoneDetails = findViewById(R.id.staff_phone_details);
    }
}
