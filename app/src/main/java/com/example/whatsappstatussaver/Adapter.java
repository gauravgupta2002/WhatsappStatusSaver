package com.example.whatsappstatussaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> filelist;

    public Adapter(Context context, ArrayList<ModelClass> filelist) {
        this.context = context;
        this.filelist = filelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_file,null,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        final ModelClass modelClass = filelist.get(position);
        if(modelClass.getUri().toString().endsWith(".mp4")){
            holder.play.setVisibility(View.VISIBLE);
        }else{
            holder.play.setVisibility(View.INVISIBLE);
        }

        Glide.with(context).load(modelClass.getUri()).into(holder.mainstatus);

    }

    @Override
    public int getItemCount() {
        return filelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainstatus,play;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mainstatus = itemView.findViewById(R.id.thumbnailofstatus);
            play = itemView.findViewById(R.id.play);
        }
    }
}
