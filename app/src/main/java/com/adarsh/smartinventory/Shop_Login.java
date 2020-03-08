package com.adarsh.smartinventory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Shop_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__login);
    }

    public void shopRegister(View view) {
        Intent i=new Intent(Shop_Login.this,Shop_Register.class);
        startActivity(i);
    }

    public void shopLoginClick(View view) {
        Intent i=new Intent(Shop_Login.this,ShopHome.class);
        startActivity(i);
    }
}
