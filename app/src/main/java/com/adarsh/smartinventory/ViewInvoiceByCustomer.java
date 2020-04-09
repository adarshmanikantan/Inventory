package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.adarsh.smartinventory.Adapter.CustInvoiceAdapter;
import com.adarsh.smartinventory.Adapter.StaffInvoiceAdapter;
import com.adarsh.smartinventory.Model.ViewInvoiceByCustomerModel;
import com.adarsh.smartinventory.Model.ViewInvoiceByStaffModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewInvoiceByCustomer extends AppCompatActivity {

    RecyclerView recyclerView;
    String custCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_invoice_by_customer);

        recyclerView=findViewById(R.id.invoice_custrecycler);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("customer",MODE_PRIVATE);
        custCode=sharedPreferences.getString("custcode",null);

        Api api= Api_client.SmartInventory().create(Api.class);
        api.VIEW_INVOICE_BY_CUSTOMER_MODEL_CALL(custCode).enqueue(new Callback<ViewInvoiceByCustomerModel>() {
            @Override
            public void onResponse(Call<ViewInvoiceByCustomerModel> call, Response<ViewInvoiceByCustomerModel> response) {
                ViewInvoiceByCustomerModel viewInvoiceByCustomerModel=response.body();
                if(viewInvoiceByCustomerModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    CustInvoiceAdapter adapter=new CustInvoiceAdapter(getApplicationContext(),viewInvoiceByCustomerModel);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ViewInvoiceByCustomerModel> call, Throwable t) {

            }
        });
    }
}
