package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.adarsh.smartinventory.Adapter.ProductAdapter;
import com.adarsh.smartinventory.Model.ViewProductsModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProducts_Shop extends AppCompatActivity {

    MaterialButton materialButton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products__shop);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        int shop_id=sharedPreferences.getInt("key1",0);

        Toast.makeText(this,String.valueOf(shop_id), Toast.LENGTH_SHORT).show();
        materialButton=findViewById(R.id.add_product);
        recyclerView=findViewById(R.id.product_recyclerView);

        Api api= Api_client.SmartInventory().create(Api.class);
        api.VIEW_PRODUCTS_MODEL_CALL(shop_id).enqueue(new Callback<ViewProductsModel>() {
            @Override
            public void onResponse(Call<ViewProductsModel> call, Response<ViewProductsModel> response) {
                ViewProductsModel viewProductsModel=response.body();
                if(viewProductsModel.getStatus().equalsIgnoreCase("Success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    ProductAdapter productAdapter=new ProductAdapter(getApplicationContext(),viewProductsModel);
                    recyclerView.setAdapter(productAdapter);
                }
            }

            @Override
            public void onFailure(Call<ViewProductsModel> call, Throwable t) {
                Toast.makeText(ViewProducts_Shop.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ViewProducts_Shop.this,AddProduct.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(ViewProducts_Shop.this,ShopHome.class);
        startActivity(i);

    }
}
