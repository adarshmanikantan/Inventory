package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
    }

    public void viewInvoiceClick(View view) {
        Intent intent=new Intent(getApplicationContext(),ViewInvoiceByCustomer.class);
        startActivity(intent);
    }

    public void qrActivityClick(View view) {
        Intent intent=new Intent(getApplicationContext(),ViewQrByCustomer.class);
        startActivity(intent);
    }
}
