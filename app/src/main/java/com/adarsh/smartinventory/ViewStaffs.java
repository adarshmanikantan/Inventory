package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.adarsh.smartinventory.Adapter.EmployeeAdapter;
import com.adarsh.smartinventory.Adapter.ProductAdapter;
import com.adarsh.smartinventory.Model.ViewEmployeeModel;
import com.adarsh.smartinventory.Model.ViewProductsModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewStaffs extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_staffs);

        recyclerView=findViewById(R.id.view_staff_recyclerView);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        int shop_id=sharedPreferences.getInt("key1",0);
        Api api= Api_client.SmartInventory().create(Api.class);
        api.VIEW_EMPLOYEE_MODEL_CALL(shop_id).enqueue(new Callback<ViewEmployeeModel>() {
            @Override
            public void onResponse(Call<ViewEmployeeModel> call, Response<ViewEmployeeModel> response) {
                ViewEmployeeModel viewEmployeeModel=response.body();
                if(viewEmployeeModel.getStatus().equalsIgnoreCase("Success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    EmployeeAdapter employeeAdapter=new EmployeeAdapter(getApplicationContext(),viewEmployeeModel);
                    recyclerView.setAdapter(employeeAdapter);
                }
            }

            @Override
            public void onFailure(Call<ViewEmployeeModel> call, Throwable t) {
                Toast.makeText(ViewStaffs.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void addStaffClick(View view) {

        Intent i=new Intent(ViewStaffs.this,AddStaff.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(ViewStaffs.this,ShopHome.class);
        startActivity(i);

    }
}
