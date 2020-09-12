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
import com.example.googleaad.model.Skill_IQ;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PostViewHolder> {
private List<Skill_IQ> skill_iqList = new ArrayList<>();
private static final String TAG = "SkillIQAdapter";
Context context;
public  MyAdapter(Context context){
    this.context = context;
}


    @NonNull
    @Override
    public MyAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.skillcontent_card, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.PostViewHolder holder, int position) {
     holder.skillnam.setText(skill_iqList.get(position).getName());
     holder.skillsco.setText(MessageFormat.format("{0} Skill IQ Score","", skill_iqList.get(position).getScore() ));
     holder.skillcouty.setText(skill_iqList.get(position).getCountry());
        Glide.with(context).load(skill_iqList.get(position).getBadgeUrl()).into(holder.img);
        Log.d(TAG, "ImageUrl is : " + skill_iqList.get(position).getBadgeUrl());
    }

    @Override
    public int getItemCount() {
        return skill_iqList.size();
    }

    public void setSkill_iqList(List<Skill_IQ> list){
    this.skill_iqList = list;
    notifyDataSetChanged();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView skillnam, skillsco, skillcouty;
    ImageView img;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.leadimageView);
            skillnam = itemView.findViewById(R.id.leadtextView);
            skillsco = itemView.findViewById(R.id.leadnametextView);
            skillcouty = itemView.findViewById(R.id.skillcotextView);
        }
    }
}
