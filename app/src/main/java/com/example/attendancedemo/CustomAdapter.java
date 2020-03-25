package com.example.attendancedemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private AttendanceInfo[] listdata;

    // RecyclerView recyclerView;
    public CustomAdapter(AttendanceInfo[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final AttendanceInfo myListData = listdata[position];
        holder.tvdate.setText("Date \n"+listdata[position].getDate());
        holder.tvin.setText("In Time \n"+listdata[position].getInTime());
        holder.tvout.setText("Out Time \n"+listdata[position].getOutTime());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getDate(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvdate,tvin,tvout;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvdate =  itemView.findViewById(R.id.tvdate);
            this.tvin = itemView.findViewById(R.id.tvin);
            this.tvout = itemView.findViewById(R.id.tvout);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}