package com.adarsh.smartinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.smartinventory.Model.ShopRegResponse;
import com.adarsh.smartinventory.Model.ShopRegistrationRequest;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Shop_Register extends AppCompatActivity {

    EditText shopname,ownername,email,phone,licence,district,address,password;
    String Json;
    RequestBody requestBody=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__register);

        shopname=findViewById(R.id.sreg_shopname);
        ownername=findViewById(R.id.sreg_ownername);
        email=findViewById(R.id.sreg_email);
        phone=findViewById(R.id.sreg_phone);
        licence=findViewById(R.id.sreg_licence);
        district=findViewById(R.id.sreg_district);
        address=findViewById(R.id.sreg_address);
        password=findViewById(R.id.sreg_pswd);


    }

    public void signupClick(View view) {
        if (shopname.getText().toString().equals("")) {
         shopname.setError("Enter shop name");
        } else if (ownername.getText().toString().equals("")) {
            ownername.setError("Enter owner name");
        } else if (email.getText().toString().equals("")) {
            email.setError("Enter email");

        } else if (phone.getText().toString().equals("")) {
            phone.setError("Enter phone number");

        } else if (licence.getText().toString().equals("")) {
            licence.setError("Enter license number");

        }
        else if (address.getText().toString().equals("")) {
            address.setError("Enter address");

        } else if (district.getText().toString().equals("")) {
            district.setError("Enter district");

        }else if (password.getText().toString().equals("")) {
            password.setError("Enter password");

        } else {
            final Api api = Api_client.SmartInventory().create(Api.class);
            ShopRegistrationRequest shopRegistrationRequest = new ShopRegistrationRequest();
            shopRegistrationRequest.setUsername(ownername.getText().toString());
            shopRegistrationRequest.setEmail(email.getText().toString());
            shopRegistrationRequest.setPassword(password.getText().toString());


            shopRegistrationRequest.setShopName(shopname.getText().toString());
            shopRegistrationRequest.setLiscenceNumber(licence.getText().toString());
            shopRegistrationRequest.setContact(phone.getText().toString());
            shopRegistrationRequest.setDistrict(district.getText().toString());
            shopRegistrationRequest.setAddress(address.getText().toString());


            Gson gson = new Gson();
            Json = gson.toJson(shopRegistrationRequest).trim();
            try {
                requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(Shop_Register.this, "" + e, Toast.LENGTH_SHORT).show();
            }

            api.SHOP_REG_RESPONSE_CALL(requestBody).enqueue(new Callback<ShopRegResponse>() {
                @Override
                public void onResponse(Call<ShopRegResponse> call, Response<ShopRegResponse> response) {
                    ShopRegResponse shopRegResponse = response.body();
                    if (shopRegResponse.getStatus().equalsIgnoreCase("success")) {
                        Toast.makeText(Shop_Register.this, shopRegResponse.getStatus(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Shop_Register.this, Shop_Login.class);
                        startActivity(i);
                    } else if (shopRegResponse.getStatus() == null) {
                        Toast.makeText(Shop_Register.this, "failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Shop_Register.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ShopRegResponse> call, Throwable t) {
                    Toast.makeText(Shop_Register.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public void loginActivityClick(View view) {
        Intent intent=new Intent(Shop_Register.this,Shop_Login.class);
        startActivity(intent);
    }
}
