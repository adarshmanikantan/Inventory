package com.adarsh.smartinventory;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.smartinventory.Model.ShopLoginResponse;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Shop_Login extends AppCompatActivity {
    EditText email,pswd;
;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__login);

        email=findViewById(R.id.shop_email);
        pswd=findViewById(R.id.shop_pswd);
    }

    public void shopRegister(View view) {
        Intent i=new Intent(Shop_Login.this,Shop_Register.class);
        startActivity(i);
    }

    public void shopLoginClick(View view) {
        Api api= Api_client.SmartInventory().create(Api.class);
        api.SHOP_LOGIN_RESPONSE_CALL(email.getText().toString(),pswd.getText().toString()).enqueue(new Callback<ShopLoginResponse>() {
            @Override
            public void onResponse(Call<ShopLoginResponse> call, Response<ShopLoginResponse> response) {
                if (response.body() == null) {

                } else {
                    ShopLoginResponse shopLoginResponse = response.body();
                    if (shopLoginResponse.getStatus().equalsIgnoreCase("success")) {
                        Toast.makeText(Shop_Login.this, shopLoginResponse.getStatus(), Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("key1",shopLoginResponse.getUser_id());
                        editor.apply();
                       Toast.makeText(Shop_Login.this, String.valueOf(shopLoginResponse.getUser_id()), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Shop_Login.this, ShopHome.class);
                        startActivity(i);
                    } else if (shopLoginResponse.getStatus() == null) {
                        Toast.makeText(Shop_Login.this, "Failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Shop_Login.this, shopLoginResponse.getStatus(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
            @Override
            public void onFailure(Call<ShopLoginResponse> call, Throwable t) {

            }
        });

    }
}
