package com.adarsh.smartinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
    }

    public void customerLogin(View view) {
//        Intent i=new Intent(CustomerLogin.this,CustomerHome.class);
//        startActivity(i);
    }

    public void shopRegisterClick(View view) {
        Intent i=new Intent(CustomerLogin.this,CustomerSignUp.class);
       startActivity(i);
    }
}
