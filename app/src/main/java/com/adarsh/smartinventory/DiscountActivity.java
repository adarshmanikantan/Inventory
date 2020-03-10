package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.adarsh.smartinventory.Model.InvoiceRequestModel;
import com.adarsh.smartinventory.Model.InvoiceResponseModel;
import com.adarsh.smartinventory.Model.ShopRegistrationRequest;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscountActivity extends AppCompatActivity {

    EditText discountpercent;
    String Json;
    RequestBody requestBody=null;
    TextView total_amount,discountrupee,taxrupee;
    Spinner taxes;
    String customer_name,cusid,pro_name;
    int quantitynum;
    int staffid;
    float  rate_value,subtotal_value,totalamount_value,discountpercent_value,discountrupee_value;
    double taxrupee_value;
    String chumma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        initViews();
        SharedPreferences sp=getApplicationContext().getSharedPreferences("customer", Context.MODE_PRIVATE);
        customer_name=sp.getString("customer_name",null);
        cusid=sp.getString("customer_code",null);
        SharedPreferences sPreferences=getApplicationContext().getSharedPreferences("staffpref",MODE_PRIVATE);
        staffid=sPreferences.getInt("staffid",0);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
      quantitynum= sharedPreferences.getInt("quantity_value",0);
        rate_value=sharedPreferences.getFloat("rate_value", (float) 0.00);
        subtotal_value=sharedPreferences.getFloat("subtotal_value", (float) 0.00);
        pro_name=sharedPreferences.getString("pro_name",null);


        discountpercent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                discountpercent_value=Float.parseFloat(String.valueOf(s));
                discountrupee_value=subtotal_value*(discountpercent_value/100);
                discountrupee.setText(String.valueOf(discountrupee_value));
                total_amount.setText(String.valueOf(subtotal_value-discountrupee_value));

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });






        taxes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (taxes.getSelectedItem().equals("Exempted")) {

                }
                if (taxes.getSelectedItem().equals("GST@0.25%")) {


                    taxrupee_value = subtotal_value * (0.25 / 100);
                    taxrupee.setText(String.valueOf(taxrupee_value));
                    total_amount.setText(String.valueOf(((subtotal_value + taxrupee_value))));



                }
                if (taxes.getSelectedItem().equals("GST@3%")) {
                    taxrupee_value = subtotal_value*(3.0/ 100);
                    taxrupee.setText(String.valueOf(taxrupee_value));
                    total_amount.setText(String.valueOf(((subtotal_value + taxrupee_value))));
                }
                if (taxes.getSelectedItem().equals("GST@5%")) {

                    totalamount_value = subtotal_value;
                    taxrupee_value = totalamount_value * (5.0 / 100);
                    taxrupee.setText(String.valueOf(taxrupee_value));
                    total_amount.setText(String.valueOf(((totalamount_value + taxrupee_value))));



                }
                if (taxes.getSelectedItem().equals("GST@12%")) {

                    totalamount_value = subtotal_value;
                    taxrupee_value = totalamount_value * (12.0 / 100);
                    taxrupee.setText(String.valueOf(taxrupee_value));
                    total_amount.setText(String.valueOf(((totalamount_value + taxrupee_value))));



                }
                if (taxes.getSelectedItem().equals("GST@18%")) {

                    totalamount_value = subtotal_value;
                    taxrupee_value = totalamount_value * (18.0/ 100);
                    taxrupee.setText(String.valueOf(taxrupee_value));
                    total_amount.setText(String.valueOf(((totalamount_value + taxrupee_value))));



                }
                if (taxes.getSelectedItem().equals("GST@28%")) {


                    taxrupee_value = subtotal_value*(28.0/ 100);
                    taxrupee.setText(String.valueOf(taxrupee_value));
                    total_amount.setText(String.valueOf(((totalamount_value + taxrupee_value))));



                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void initViews()
    {
      discountpercent=findViewById(R.id.discountpercent);
        discountrupee=findViewById(R.id.discountrupee);
       taxrupee=findViewById(R.id.taxrupee);
       taxes=findViewById(R.id.taxpercentspinner);
       total_amount=findViewById(R.id.totalamount);


    }

    public void saveClick(View view) {
        Api api = Api_client.SmartInventory().create(Api.class);
        final InvoiceRequestModel invoiceRequestModel = new InvoiceRequestModel();
        invoiceRequestModel.setEmployee_id(staffid);
        invoiceRequestModel.setName(customer_name);
        invoiceRequestModel.setCustomer_code(cusid);
        invoiceRequestModel.setProduct_name(pro_name);
        invoiceRequestModel.setQuantity(quantitynum);
        invoiceRequestModel.setAmount(String.valueOf(rate_value));
        invoiceRequestModel.setSub_total(String.valueOf(subtotal_value));
        invoiceRequestModel.setDiscount_percentage(String.valueOf(discountpercent_value));
        invoiceRequestModel.setDiscount_rupees(String.valueOf(discountrupee));
        invoiceRequestModel.setTax(taxes.getSelectedItem().toString());
        invoiceRequestModel.setTotal_amount(String.valueOf(totalamount_value));



        Gson gson = new Gson();
        Json = gson.toJson(invoiceRequestModel).trim();
        try {
            requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(DiscountActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }

        api.INVOICE_RESPONSE_MODEL_CALL(requestBody).enqueue(new Callback<InvoiceResponseModel>() {
            @Override
            public void onResponse(Call<InvoiceResponseModel> call, Response<InvoiceResponseModel> response) {
                InvoiceResponseModel invoiceResponseModel=response.body();
                if(invoiceResponseModel.getStatus().equalsIgnoreCase("success"))
                {
                    Intent i=new Intent(getApplicationContext(),InvoiceGeneration.class);
                    startActivity(i);
                   // Toast.makeText(DiscountActivity.this,invoiceResponseModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i=new Intent(getApplicationContext(),InvoiceGeneration.class);
                    startActivity(i);
                  //  Toast.makeText(DiscountActivity.this,invoiceResponseModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InvoiceResponseModel> call, Throwable t) {
                Toast.makeText(DiscountActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}



