package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.smartinventory.Model.AddEmployeeRequest;
import com.adarsh.smartinventory.Model.AddEmployeeResponse;
import com.adarsh.smartinventory.Model.ShopRegistrationRequest;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStaff extends AppCompatActivity {
    EditText name,empcode,email,contact,password;
    String Json;
    RequestBody requestBody=null;
    int shop_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);

        name=findViewById(R.id.add_empname);
        empcode=findViewById(R.id.add_empcode);
        email=findViewById(R.id.add_empemail);
        contact=findViewById(R.id.add_empcontact);
        password=findViewById(R.id.add_emppasswd);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
        shop_id=sharedPreferences.getInt("key1",0);

        Toast.makeText(this, String.valueOf(shop_id), Toast.LENGTH_SHORT).show();
    }

    public void addStaffbtnClick(View view) {

        if (name.getText().toString().equals("")) {
          name.setError("Enter name");
        }
        else if (empcode.getText().toString().equals("")) {
          empcode.setError("Enter Employee Code");
        }
        else if (email.getText().toString().equals("")) {
          email.setError("Enter Email");
        }
        else if (contact.getText().toString().equals("")) {
           contact.setError("Enter contact number");
        }
        else if (password.getText().toString().equals("")) {
           password.setError("Enter Password");
        } else {
            final Api api = Api_client.SmartInventory().create(Api.class);
            AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest();


            addEmployeeRequest.setShopowner_id(shop_id);
            addEmployeeRequest.setName(name.getText().toString());
            addEmployeeRequest.setContact(contact.getText().toString());
            addEmployeeRequest.setEmail(email.getText().toString());
            addEmployeeRequest.setEmployee_Code(empcode.getText().toString());
            addEmployeeRequest.setPassword(password.getText().toString());

            Gson gson = new Gson();
            Json = gson.toJson(addEmployeeRequest).trim();
            try {
                requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(AddStaff.this, "" + e, Toast.LENGTH_SHORT).show();
            }

            api.ADD_EMPLOYEE_RESPONSE_CALL(requestBody).enqueue(new Callback<AddEmployeeResponse>() {
                @Override
                public void onResponse(Call<AddEmployeeResponse> call, Response<AddEmployeeResponse> response) {
                    AddEmployeeResponse addEmployeeResponse = response.body();
                    if (addEmployeeResponse == null) {
                        Toast.makeText(AddStaff.this, "failed" + shop_id, Toast.LENGTH_SHORT).show();
                    } else {
                        if (addEmployeeResponse.getStatus().equalsIgnoreCase("success")) {
                            Toast.makeText(AddStaff.this, "Success", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(AddStaff.this, ViewStaffs.class);
                            startActivity(i);

                        }
                        else
                        {
                            Toast.makeText(AddStaff.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                @Override
                public void onFailure(Call<AddEmployeeResponse> call, Throwable t) {
                    Toast.makeText(AddStaff.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
