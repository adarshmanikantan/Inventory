package com.adarsh.smartinventory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.adarsh.smartinventory.Adapter.StaffInvoiceAdapter;
import com.adarsh.smartinventory.Model.ViewInvoiceByStaffModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffInvoice extends AppCompatActivity {
 RecyclerView recyclerView;
 int emp_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_invoice);

        recyclerView=findViewById(R.id.invoice_recycler);

        final SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffpref",MODE_PRIVATE);
        emp_id=sharedPreferences.getInt("staffid",0);

        Api api= Api_client.SmartInventory().create(Api.class);
        api.VIEW_INVOICE_BY_STAFF_MODEL_CALL(emp_id).enqueue(new Callback<ViewInvoiceByStaffModel>() {
            @Override
            public void onResponse(Call<ViewInvoiceByStaffModel> call, Response<ViewInvoiceByStaffModel> response) {
                ViewInvoiceByStaffModel viewInvoiceByStaffModel=response.body();
                if(viewInvoiceByStaffModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    StaffInvoiceAdapter adapter=new StaffInvoiceAdapter(getApplicationContext(),viewInvoiceByStaffModel);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ViewInvoiceByStaffModel> call, Throwable t) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(), StaffHome.class);
        startActivity(i);
    }
}
