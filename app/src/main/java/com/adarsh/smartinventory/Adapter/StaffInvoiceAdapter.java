package com.adarsh.smartinventory.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.smartinventory.FirstCalculationActivity;
import com.adarsh.smartinventory.Model.ViewInvoiceByStaffModel;
import com.adarsh.smartinventory.R;
import com.adarsh.smartinventory.StaffInvoicePdf;

public class StaffInvoiceAdapter extends RecyclerView.Adapter<StaffInvoiceAdapter.myViewHolder> {
    Context context;
    ViewInvoiceByStaffModel viewInvoiceByStaffModel;
    public StaffInvoiceAdapter(Context context, ViewInvoiceByStaffModel viewInvoiceByStaffModel)
    {
      this.context=context;
      this.viewInvoiceByStaffModel=viewInvoiceByStaffModel;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_row,parent,false);
        StaffInvoiceAdapter.myViewHolder holder=new StaffInvoiceAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {



        holder.name.setText(viewInvoiceByStaffModel.getCustomer().getResults().get(position).getName());
        holder.code.setText(viewInvoiceByStaffModel.getCustomer().getResults().get(position).getCustomer_code());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                int invoice_id=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getId();
                int employee_id=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getEmployee_id();
                String name=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getName();
                String cust_code=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getCustomer_code();
                String pro_name=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getProduct_name();
                int quantity=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getQuantity();
                String amount=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getAmount();
                String subtotal=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getSub_total();
                String discountpercentage=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getDiscount_percentage();
                String discountrupees=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getDiscount_rupees();
                String tax=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getTax();
                String total_amount=viewInvoiceByStaffModel.getCustomer().getResults().get(position).getTotal_amount();

                SharedPreferences sharedPreferences=context.getSharedPreferences("invoice",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("invoiceid",invoice_id);
                editor.putInt("employeeid",employee_id);
                editor.putString("name",name);
                editor.putString("cust_code",cust_code);
                editor.putString("pro_name",pro_name);
                editor.putInt("quantity",quantity);
                editor.putString("amount",amount);
                editor.putString("subtotal",subtotal);
                editor.putString("discountpercentage",discountpercentage);
                editor.putString("discountrupees",discountrupees);
                editor.putString("tax",tax);
                editor.putString("total_amount",total_amount);
                editor.apply();
                Intent intent = new Intent(context, StaffInvoicePdf.class);
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return viewInvoiceByStaffModel.getCustomer().getResults().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,code,invoiceid;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.incustomer_name);
            code=itemView.findViewById(R.id.inproduct_name);
        }
    }
}
