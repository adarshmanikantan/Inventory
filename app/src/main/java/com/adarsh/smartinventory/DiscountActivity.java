package com.adarsh.smartinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DiscountActivity extends AppCompatActivity {

    EditText discountpercent;

    TextView total_amount,discountrupee,taxrupee;
    Spinner taxes;
    int quantitynum;

    float  rate_value,subtotal_value,totalamount_value,discountpercent_value,discountrupee_value;
    double taxrupee_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        initViews();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
      quantitynum= sharedPreferences.getInt("quantity_value",0);
        rate_value=sharedPreferences.getFloat("rate_value", (float) 0.00);
        subtotal_value=sharedPreferences.getFloat("subtotal_value", (float) 0.00);

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
}



