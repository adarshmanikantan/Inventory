package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.adarsh.smartinventory.Adapter.CustInvoiceAdapter;
import com.adarsh.smartinventory.Adapter.CustQrAdapter;
import com.adarsh.smartinventory.Model.ViewInvoiceByCustomerModel;
import com.adarsh.smartinventory.Model.ViewQrModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewQrByCustomer extends AppCompatActivity {
    RecyclerView recyclerView;
    String custCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_qr_by_customer);

        recyclerView=findViewById(R.id.qr_custrecycler);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("customer",MODE_PRIVATE);
        custCode=sharedPreferences.getString("custcode",null);

        Api api= Api_client.SmartInventory().create(Api.class);
        api.VIEW_QR_MODEL_CALL(custCode).enqueue(new Callback<ViewQrModel>() {
            @Override
            public void onResponse(Call<ViewQrModel> call, Response<ViewQrModel> response) {
                ViewQrModel viewQrModel=response.body();
                if(viewQrModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    CustQrAdapter adapter=new CustQrAdapter(getApplicationContext(),viewQrModel);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ViewQrModel> call, Throwable t) {

            }
        });
    }
}
