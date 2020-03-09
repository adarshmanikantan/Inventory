package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstCalculationActivity extends AppCompatActivity {

    EditText customer_name, product_name, quantity, rate;

    TextView subtotal;
    int quantitynum;
    float rate_value, subtotal_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_calculation);
        initViews();

       //calculations();
    }

//    public void calculations() {
//        quantity.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (!rate.getText().toString().equals("")) {
//                    rate_value = Float.parseFloat(rate.getText().toString());
//                    subtotal_value = rate_value * Float.parseFloat(String.valueOf(s));
//                    subtotal.setText(String.valueOf(subtotal_value));
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        rate.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (quantity.getText().toString().equals("")) {
//                    Toast.makeText(FirstCalculationActivity.this, "Enter quantity first", Toast.LENGTH_SHORT).show();
//                } else {
//                    quantitynum = Integer.parseInt(quantity.getText().toString());
//                    rate_value = Float.parseFloat(String.valueOf(s));
//                    subtotal_value = (quantitynum * rate_value);
//                    subtotal.setText(String.valueOf(subtotal_value));
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//
//    }

    public void nextClick(View view) {

        if (product_name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
        }
        if (quantity.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();

        }
        if (rate.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();

        }
        else {
            quantitynum=Integer.parseInt(quantity.getText().toString());
            rate_value=Float.parseFloat(rate.getText().toString());
            subtotal_value=quantitynum*rate_value;

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", customer_name.getText().toString());
            editor.putString("pro_name", product_name.getText().toString());
            editor.putInt("quantity_value",Integer.parseInt(quantity.getText().toString()));
            editor.putFloat("rate_value", Float.parseFloat(rate.getText().toString()));
            editor.putFloat("subtotal_value", subtotal_value);
            editor.apply();
            Toast.makeText(this,quantitynum+"/"+rate_value+"/"+subtotal_value, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(FirstCalculationActivity.this, DiscountActivity.class);
            startActivity(i);
        }


        }

        public void initViews () {
            customer_name = findViewById(R.id.custname);
            product_name = findViewById(R.id.productname);
            quantity = findViewById(R.id.quantityedt);
            rate = findViewById(R.id.rateedt);
            subtotal = findViewById(R.id.subtotaltextview);
        }
    }


