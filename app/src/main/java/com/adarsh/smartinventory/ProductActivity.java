package com.adarsh.smartinventory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    private TextView proNameDetails;
    private TextView proDescDetails;
    private TextView proPriceDetails;
    private TextView proQuantityDetails;
    private TextView proDealernameDetails;
    private TextView proDealernumberDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pro", Context.MODE_PRIVATE);
        proNameDetails.setText(sharedPreferences.getString("name", null));
        proDescDetails.setText(sharedPreferences.getString("desc", null));
        proPriceDetails.setText("Price : "+sharedPreferences.getInt("price", 0));
        proQuantityDetails.setText("Quantity : "+sharedPreferences.getInt("quantity", 0));
        proDealernameDetails.setText("Dealer Name : "+sharedPreferences.getString("dealer_name", null));
        proDealernumberDetails.setText("Dealer's Number : "+sharedPreferences.getString("dealer_phone", null));
    }

    private void initView() {
        proNameDetails = findViewById(R.id.pro_name_details);
        proDescDetails = findViewById(R.id.pro_desc_details);
        proPriceDetails = findViewById(R.id.pro_price_details);
        proQuantityDetails = findViewById(R.id.pro_quantity_details);
        proDealernameDetails = findViewById(R.id.pro_dealername_details);
        proDealernumberDetails = findViewById(R.id.pro_dealernumber_details);
    }
}
