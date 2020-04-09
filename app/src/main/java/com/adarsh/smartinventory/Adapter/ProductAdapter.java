package com.adarsh.smartinventory.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.smartinventory.FirstCalculationActivity;
import com.adarsh.smartinventory.Model.ViewCustomerModel;
import com.adarsh.smartinventory.Model.ViewProductsModel;
import com.adarsh.smartinventory.ProductActivity;
import com.adarsh.smartinventory.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    Context context;
    ViewProductsModel viewProductsModel;
    public ProductAdapter(Context context, ViewProductsModel viewProductsModel)
    {
        this.context=context;
        this.viewProductsModel=viewProductsModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row,parent,false);
        ProductAdapter.MyViewHolder holder=new ProductAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.name.setText(viewProductsModel.getProduct().getResults().get(0).get(position).getName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=context.getSharedPreferences("pro",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",viewProductsModel.getProduct().getResults().get(position).get(position).getName());
                editor.putString("desc",viewProductsModel.getProduct().getResults().get(position).get(position).getDescription());
                editor.putInt("price",viewProductsModel.getProduct().getResults().get(position).get(position).getPrice());
                editor.putInt("quantity",viewProductsModel.getProduct().getResults().get(position).get(position).getQuantity());
                editor.putString("dealer_name",viewProductsModel.getProduct().getResults().get(position).get(position).getDealer_name());
                editor.putString("dealer_phone",viewProductsModel.getProduct().getResults().get(position).get(position).getDealer_phone());
                editor.apply();
                Intent i=new Intent(context, ProductActivity.class);
                holder.itemView.getContext().startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return viewProductsModel.getProduct().getResults().get(0).size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout;
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.pro_layout);
            name=itemView.findViewById(R.id.pro_name);

        }
    }
}
