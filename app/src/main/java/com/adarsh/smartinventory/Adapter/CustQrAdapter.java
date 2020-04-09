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

import com.adarsh.smartinventory.Model.ViewInvoiceByCustomerModel;
import com.adarsh.smartinventory.Model.ViewQrModel;
import com.adarsh.smartinventory.QRActivity;
import com.adarsh.smartinventory.R;
import com.adarsh.smartinventory.StaffInvoicePdf;

public class CustQrAdapter extends RecyclerView.Adapter<CustQrAdapter.myViewHolder> {
    Context context;
    ViewQrModel viewQrModel;
    public CustQrAdapter(Context context, ViewQrModel viewQrModel)
    {
      this.context=context;
      this.viewQrModel=viewQrModel;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_row,parent,false);
        CustQrAdapter.myViewHolder holder=new CustQrAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {



        holder.name.setText(viewQrModel.getDetails().getResults().get(position).getProduct_name());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=context.getSharedPreferences("qr",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",viewQrModel.getDetails().getResults().get(position).getProduct_name());
                editor.putString("details",viewQrModel.getDetails().getResults().get(position).getQrcode());
                editor.apply();
                Intent intent = new Intent(context, QRActivity.class);
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return viewQrModel.getDetails().getResults().size();
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
