package com.samansepahvand.changefontrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samansepahvand.changefontrecyclerview.R;
import com.samansepahvand.changefontrecyclerview.model.DataModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {




    private ArrayList<DataModel>  dataModels=new ArrayList<>();

    private Context context;


    public MyAdapter(ArrayList<DataModel> dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclverview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        DataModel dataModel=dataModels.get(position);

        holder.txtBody.setText(dataModel.getTitle());
        holder.txtId.setText(String.valueOf(dataModel.getId()));
        holder.txtUserId.setText(String.valueOf(dataModel.getUserId()));
        holder.txtBody.setText(dataModel.getBody());


    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtId,txtUserId,txtBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBody=itemView.findViewById(R.id.body);
            txtUserId=itemView.findViewById(R.id.userId);
            txtId=itemView.findViewById(R.id.id);
            txtTitle=itemView.findViewById(R.id.title);

        }
    }
}
