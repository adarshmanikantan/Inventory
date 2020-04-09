package com.adarsh.smartinventory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.smartinventory.Model.CustomerLoginModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerLogin extends AppCompatActivity {


    private TextInputEditText etEmailLogin;
    private TextInputEditText etPasswordLogin;
    private MaterialButton imgLogin;
    private MaterialButton txtRegister;
    List<TextInputEditText> textInputEditTexts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerlogin_spare);



        initView();
        View rootView = findViewById(android.R.id.content);

        //conecting all TextInputEditText as list
         textInputEditTexts = Utils.findViewsWithType(
                rootView, TextInputEditText.class);
    }

    public void customerLogin(View view) {
        //checking null values for each edittesxt
        boolean noErrors = true;
        for (TextInputEditText textInputEditText : textInputEditTexts) {
            //get strings from each edittext
            String editTextString = textInputEditText.getText().toString();
            if (editTextString.isEmpty()) {
                textInputEditText.setError(("please fill this field"));
                noErrors = false;
            } else {
                textInputEditText.setError(null);
            }
        }
        if(noErrors) {
          Api api=Api_client.SmartInventory().create(Api.class);
          api.CUSTOMER_LOGIN_MODEL_CALL(etEmailLogin.getText().toString(),etPasswordLogin.getText().toString()).enqueue(new Callback<CustomerLoginModel>() {
              @Override
              public void onResponse(Call<CustomerLoginModel> call, Response<CustomerLoginModel> response) {
                  CustomerLoginModel customerLoginModel=response.body();
                  if(customerLoginModel.getStatus().equalsIgnoreCase("success"))
                  {
                      Toast.makeText(CustomerLogin.this,customerLoginModel.getStatus()

                              , Toast.LENGTH_SHORT).show();
                      int customer_id=customerLoginModel.getDetails().getResults().get(0).getId();
                      int employee_id=customerLoginModel.getDetails().getResults().get(0).getEmployee_id();
                      String name=customerLoginModel.getDetails().getResults().get(0).getName();
                      String email=customerLoginModel.getDetails().getResults().get(0).getEmail();
                      int phone=customerLoginModel.getDetails().getResults().get(0).getPhone();
                      String customercode=customerLoginModel.getDetails().getResults().get(0).getCustomer_code();
                      String password=customerLoginModel.getDetails().getResults().get(0).getPassword();
                      SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("customer",MODE_PRIVATE);
                      SharedPreferences.Editor editor=sharedPreferences.edit();
                      editor.putString("custcode",customercode);
                      editor.apply();
                      Intent i=new Intent(getApplicationContext(),CustomerHome.class);
                      startActivity(i);
                  }

              }

              @Override
              public void onFailure(Call<CustomerLoginModel> call, Throwable t) {

              }
          });

        }
        }




    public void shopRegisterClick(View view) {
        Intent i = new Intent(CustomerLogin.this, CustomerSignUp.class);
        startActivity(i);
    }

    private void initView() {

        etEmailLogin = findViewById(R.id.et_email_login);
        etPasswordLogin = findViewById(R.id.et_password_login);
        imgLogin = findViewById(R.id.img_login);
        txtRegister = findViewById(R.id.txt_register);
    }
}
