package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.smartinventory.Model.StaffLogin;
import com.adarsh.smartinventory.Retro.PictureBarcodeActivity;

public class StaffHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
    }

    public void customersClick(View view) {
        Intent i=new Intent(StaffHome.this,ViewCustomers.class);
        startActivity(i);
    }

    public void viewproductsClick(View view) {
        Intent i=new Intent(StaffHome.this,ViewProducts.class);
        startActivity(i);
    }

    public void invoiceClick(View view) {
        Intent i=new Intent(StaffHome.this,StaffInvoice.class);
        startActivity(i);
    }

    public void scanQrClick(View view) {
        Intent i=new Intent(StaffHome.this, PictureBarcodeActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),SalesExecutive_Login.class);
        startActivity(i);
    }
}
