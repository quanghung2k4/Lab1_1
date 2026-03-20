package com.learn.lab1_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.lab1_1.R;
import com.learn.lab1_1.model.Cat;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Cat> mList;

    private Context context;
    private OnItemListener listener;
    public Adapter(Context context,List<Cat> mList) {
        this.context = context;
        this.mList = mList;
    }

    public void setListener(OnItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Cat cat = mList.get(position);
        holder.circleImageView.setImageResource(cat.getImage());
        holder.txtName.setText(cat.getName());
        holder.txtDesc.setText(cat.getDescription());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView txtName,txtDesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.image);
            txtName = itemView.findViewById(R.id.txtName);
            txtDesc =itemView.findViewById(R.id.txtDescription);
            itemView.setOnClickListener( v->{
                if(listener != null){
                    listener.onCick(getLayoutPosition());
                }
            });
        }
    }
}
