package com.adarsh.smartinventory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.smartinventory.Model.StaffLogin;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesExecutive_Login extends AppCompatActivity {
    private TextInputEditText staffloginEmpcd;
    private TextInputEditText staffloginPswd;
    private MaterialButton imgLogin;
    private MaterialButton txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saleslogin_spare);

        initView();
    }

    public void staffLogin(View view) {
        Api api = Api_client.SmartInventory().create(Api.class);
        api.STAFF_LOGIN_CALL(staffloginEmpcd.getText().toString(), staffloginPswd.getText().toString()).enqueue(new Callback<StaffLogin>() {
            @Override
            public void onResponse(Call<StaffLogin> call, Response<StaffLogin> response) {
                if (response.body() == null) {

                } else {
                    StaffLogin staffLoginResponse = response.body();
                    if (staffLoginResponse.getStatus().equalsIgnoreCase("success")) {
                        int staff_id = staffLoginResponse.getEmpdata().getResults().get(0).get(0).getId();
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("staffpref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("staffid", staff_id);
                        editor.apply();
                        Toast.makeText(SalesExecutive_Login.this, staffLoginResponse.getStatus(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), StaffHome.class);
                        startActivity(i);

                    } else if (staffLoginResponse.getStatus() == null) {
                        Toast.makeText(SalesExecutive_Login.this, "Failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), staffLoginResponse.getStatus(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<StaffLogin> call, Throwable t) {

            }
        });

    }

    private void initView() {
        staffloginEmpcd = findViewById(R.id.stafflogin_empcd);
        staffloginPswd = findViewById(R.id.stafflogin_pswd);
        imgLogin = findViewById(R.id.img_login);
        txtRegister = findViewById(R.id.txt_register);
    }
}

