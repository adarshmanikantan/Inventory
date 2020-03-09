package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.smartinventory.Model.AddCustomerResponseModel;
import com.adarsh.smartinventory.Model.AddCustomersRequestModel;
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

public class AddCustomers extends AppCompatActivity {

    EditText name,email,phone,cusid,pswd;
    String Json;
    int emp_id;
    RequestBody requestBody=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customers);

        name=findViewById(R.id.add_customer_name);
        email=findViewById(R.id.add_customer_email);
        phone=findViewById(R.id.add_customer_phone);
        cusid=findViewById(R.id.add_customer_cusid);
        pswd=findViewById(R.id.add_customer_pswd);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffpref",MODE_PRIVATE);
       emp_id=sharedPreferences.getInt("staffid",0);

    }

    public void addnewCustomerClick(View view) {
        final Api api = Api_client.SmartInventory().create(Api.class);
        AddCustomersRequestModel addCustomersRequestModel = new AddCustomersRequestModel();
        addCustomersRequestModel.setCustomer_code(cusid.getText().toString());
        addCustomersRequestModel.setEmail(email.getText().toString());
        addCustomersRequestModel.setEmployee_id(emp_id);
        addCustomersRequestModel.setName(name.getText().toString());
        addCustomersRequestModel.setPhone(Integer.parseInt(phone.getText().toString()));
        addCustomersRequestModel.setPassword(pswd.getText().toString());
        Gson gson = new Gson();
        Json = gson.toJson(addCustomersRequestModel).trim();
        try {
            requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(AddCustomers.this, "" + e, Toast.LENGTH_SHORT).show();
        }

        api.ADD_CUSTOMER_RESPONSE_MODEL_CALL(requestBody).enqueue(new Callback<AddCustomerResponseModel>() {
            @Override
            public void onResponse(Call<AddCustomerResponseModel> call, Response<AddCustomerResponseModel> response) {
                AddCustomerResponseModel addCustomerResponseModel=response.body();
                if(addCustomerResponseModel.getStatus().equalsIgnoreCase("success"))
                {
                    Toast.makeText(AddCustomers.this,addCustomerResponseModel.getStatus(), Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),ViewCustomers.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(AddCustomers.this,addCustomerResponseModel.getStatus(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AddCustomerResponseModel> call, Throwable t) {
                Toast.makeText(AddCustomers.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

}
