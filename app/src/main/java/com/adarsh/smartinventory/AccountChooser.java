package com.adarsh.smartinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AccountChooser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_chooser);
    }

    public void shopOwnerClick(View view) {
        Intent i=new Intent(AccountChooser.this,Shop_Login.class);
        startActivity(i);
    }

    public void customerClick(View view) {
        Intent i=new Intent(AccountChooser.this,CustomerLogin.class);
        startActivity(i);
    }

    public void salesExecutiveClick(View view) {
        Intent i=new Intent(AccountChooser.this,SalesExecutive_Login
                .class);
        startActivity(i);
    }
}
