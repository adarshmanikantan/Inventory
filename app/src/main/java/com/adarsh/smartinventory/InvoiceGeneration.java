package com.adarsh.smartinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InvoiceGeneration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_generation);
    }

    public void InvoiceGenerationIntent(View view) {
        Intent i=new Intent(InvoiceGeneration.this,GenerateInvoiceActivity.class);
        startActivity(i);
    }

    public void qrClick(View view) {
        Intent i=new Intent(InvoiceGeneration.this,QrGeneration.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(getApplicationContext(),DiscountActivity.class);
        startActivity(intent);
    }
}
