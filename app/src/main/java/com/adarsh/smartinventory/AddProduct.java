package com.adarsh.smartinventory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.smartinventory.Model.AddEmployeeRequest;
import com.adarsh.smartinventory.Model.AddEmployeeResponse;
import com.adarsh.smartinventory.Model.AddProductRequestModel;
import com.adarsh.smartinventory.Model.AddProductResponseModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProduct extends AppCompatActivity {

    private TextInputEditText productNameEdt;
    private TextInputEditText productDescEdt;
    private TextInputEditText priceEdt;
    private TextInputEditText quantityEdt;
    private TextInputEditText dealerEdt;
    private TextInputEditText dealerPhoneEdt;
    private MaterialButton addProductBtn;
    String Json;
    int shop_id;
    RequestBody requestBody=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        shop_id=sharedPreferences.getInt("key1",0);
        Toast.makeText(this,String.valueOf(shop_id), Toast.LENGTH_SHORT).show();
        initView();

    }

    private void initView() {
        productNameEdt = findViewById(R.id.product_name_edt);
        productDescEdt = findViewById(R.id.product_desc_edt);
        priceEdt = findViewById(R.id.price_edt);
        quantityEdt = findViewById(R.id.quantity_edt);
        dealerEdt = findViewById(R.id.dealer_edt);
        dealerPhoneEdt = findViewById(R.id.dealer_phone_edt);
        addProductBtn = findViewById(R.id.add_product_btn);
    }

    public void addProductClick(View view) {
        if(productNameEdt.getText().toString().equals(""))
        {
          productNameEdt.setError("Enter Product Name");
        }
        else if(productDescEdt.getText().toString().equals(""))
        {
            productDescEdt.setError("Enter Product Description");

        }
        else if(priceEdt.getText().toString().equals(""))
        {
            priceEdt.setError("Enter Price");

        }
        else if(quantityEdt.getText().toString().equals(""))
        {
            quantityEdt.setError("Enter Quantity");

        }
        else if(dealerEdt.getText().toString().equals(""))
        {
           dealerEdt.setError("Enter Dealer Name");
        }
        else if(dealerPhoneEdt.getText().toString().equals(""))
        {
            dealerPhoneEdt.setError("Enter Dealer Phone number");

        }
        else
        {


            final Api api = Api_client.SmartInventory().create(Api.class);
            AddProductRequestModel addProductRequestModel = new AddProductRequestModel();
            addProductRequestModel.setShopowner_id(shop_id);
            addProductRequestModel.setName(productNameEdt.getText().toString());
            addProductRequestModel.setDescription(productDescEdt.getText().toString());
            addProductRequestModel.setPrice(Integer.parseInt(priceEdt.getText().toString()));
            addProductRequestModel.setQuantity(Integer.parseInt(quantityEdt.getText().toString()));
            addProductRequestModel.setDealer_name(dealerEdt.getText().toString());
            addProductRequestModel.setDealer_phone(dealerPhoneEdt.getText().toString());
            Gson gson = new Gson();
            Json = gson.toJson(addProductRequestModel).trim();
            try {
                requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(AddProduct.this, "" + e, Toast.LENGTH_SHORT).show();
            }
            api.ADD_PRODUCT_RESPONSE_MODEL_CALL(requestBody).enqueue(new Callback<AddProductResponseModel>() {
                @Override
                public void onResponse(Call<AddProductResponseModel> call, Response<AddProductResponseModel> response) {
                    AddProductResponseModel addProductResponseModel = response.body();
                    if (addProductResponseModel == null) {
                        Toast.makeText(AddProduct.this, "failed", Toast.LENGTH_SHORT).show();
                    } else {
                        if (addProductResponseModel.getStatus().equalsIgnoreCase("success")) {
                            Toast.makeText(AddProduct.this, "Success", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(AddProduct.this, ViewProducts_Shop.class);
                            startActivity(i);
                        }
                    }
                }

                @Override
                public void onFailure(Call<AddProductResponseModel> call, Throwable t) {

                }
            });
        }
    }
}
