package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.smartinventory.Model.StaffLogin;

public class ShopHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_home);
    }

    public void staffClick(View view) {
        Intent i=new Intent(ShopHome.this,ViewStaffs.class);
        startActivity(i);
    }

    public void productsClick(View view) {
        Intent i=new Intent(ShopHome.this,ViewProducts_Shop.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(), Shop_Login.class);
        startActivity(i);
    }
}
