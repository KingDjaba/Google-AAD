package com.example.googleaad;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.googleaad.model.TopLearner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MyLeadAdapter extends RecyclerView.Adapter<MyLeadAdapter.PostViewHolder> {
private List<TopLearner> topLearners = new ArrayList<>();
private static final String TAG = "TopLeadAdapter";
Context context;
public MyLeadAdapter(Context context){
    this.context = context;
}


    @NonNull
    @Override
    public MyLeadAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_card, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyLeadAdapter.PostViewHolder holder, int position) {
     holder.learnnam.setText(topLearners.get(position).getName());
     holder.learnhour.setText(MessageFormat.format("{0} learning hours,"," ", topLearners.get(position).getHours() ));
     holder.learncouty.setText(topLearners.get(position).getCountry());
        Glide.with(context).load(topLearners.get(position).getBadgeUrl()).into(holder.img);
        Log.d(TAG, "ImageUrl is : " + topLearners.get(position).getBadgeUrl());
    }

    @Override
    public int getItemCount() {
        return topLearners.size();
    }

    public void setTopLearners(List<TopLearner> topLearners) {
        this.topLearners = topLearners;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView learnnam, learnhour, learncouty;
    ImageView img;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.leadimageView);
            learnnam = itemView.findViewById(R.id.leadtextView);
            learnhour = itemView.findViewById(R.id.leadnametextView);
            learncouty = itemView.findViewById(R.id.leadcotextView);
        }
    }
}
