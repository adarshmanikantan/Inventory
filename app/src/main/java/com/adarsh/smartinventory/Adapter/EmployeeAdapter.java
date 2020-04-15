package com.adarsh.smartinventory.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.smartinventory.Model.ViewEmployeeModel;
import com.adarsh.smartinventory.Model.ViewProductsModel;
import com.adarsh.smartinventory.ProductActivity;
import com.adarsh.smartinventory.R;
import com.adarsh.smartinventory.StaffActivity;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    Context context;
    ViewEmployeeModel viewEmployeeModel;
    public EmployeeAdapter(Context context, ViewEmployeeModel viewEmployeeModel)
    {
        this.context=context;
        this.viewEmployeeModel=viewEmployeeModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row,parent,false);
        EmployeeAdapter.MyViewHolder holder=new EmployeeAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.name.setText(viewEmployeeModel.getEmployee().getResults().get(position).getName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=context.getSharedPreferences("pro",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",viewEmployeeModel.getEmployee().getResults().get(position).getName());
                editor.putString("empcode",viewEmployeeModel.getEmployee().getResults().get(position).getEmployee_Code());
                editor.putString("email",viewEmployeeModel.getEmployee().getResults().get(position).getEmail());
                editor.putString("contact",viewEmployeeModel.getEmployee().getResults().get(position).getContact());
                editor.putString("password",viewEmployeeModel.getEmployee().getResults().get(position).getPassword());
                editor.apply();
                Intent i=new Intent(context, StaffActivity.class);
                holder.itemView.getContext().startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return viewEmployeeModel.getEmployee().getResults().size();
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
