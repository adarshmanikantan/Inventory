package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.adarsh.smartinventory.Adapter.CustomerAdapter;
import com.adarsh.smartinventory.Model.ViewCustomerModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCustomers extends AppCompatActivity {

    RecyclerView recyclerView;
    int emp_id;
    int customer_id,phone;
    String name,email,customer_code,password;

//                "id": 4,
//                        "employee_id": 1,
//                        "Name": "sasx",
//                        "Email": "sdscsx",
//                        "Phone": 46,
//                        "Customer_code": "3r4",
//                        "Password": "fd"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customers);

        recyclerView=findViewById(R.id.customer_recyclerView);

        final SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffpref",MODE_PRIVATE);
        emp_id=sharedPreferences.getInt("staffid",0);

        Api api= Api_client.SmartInventory().create(Api.class);
        api.VIEW_CUSTOMER_MODEL_CALL(emp_id).enqueue(new Callback<ViewCustomerModel>() {
            @Override
            public void onResponse(Call<ViewCustomerModel> call, Response<ViewCustomerModel> response) {
                ViewCustomerModel viewCustomerModel=response.body();
                if(viewCustomerModel.getStatus().equalsIgnoreCase("success"))
                {
                    if(viewCustomerModel.getStatus().equalsIgnoreCase("success"))
                    {
                        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                        recyclerView.setLayoutManager(layoutManager);
                        CustomerAdapter adapter=new CustomerAdapter(getApplicationContext(),viewCustomerModel);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ViewCustomerModel> call, Throwable t) {

            }
        });

    }

    public void addCustomerClick(View view) {
        Intent i=new Intent(ViewCustomers.this,AddCustomers.class);
        startActivity(i);
    }
}
