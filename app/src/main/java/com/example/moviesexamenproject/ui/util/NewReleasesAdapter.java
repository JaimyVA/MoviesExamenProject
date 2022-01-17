package com.example.moviesexamenproject.ui.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviesexamenproject.R;
import com.example.moviesexamenproject.model.NewReleases;
import com.example.moviesexamenproject.ui.fragments.FirstFragment;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesAdapter.NewReleasesHolder> {
    private Context mContext;
    private ArrayList<NewReleases> mData;

     class NewReleasesHolder extends RecyclerView.ViewHolder{

        private final TextView titleTV, bodyTV;
        private ImageView img;

        public NewReleasesHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.tvTitle);
            bodyTV = itemView.findViewById(R.id.tvBody);
            img = itemView.findViewById(R.id.movieImageView);
            mContext = itemView.getContext();
            titleTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    NewReleases movieToPass = data.get(position);

                    Bundle arguments = new Bundle();
                    arguments.putSerializable("movie", movieToPass);


                    Navigation.findNavController(itemView).navigate(R.id.action_FirstFragment_to_SecondFragment, arguments);
                }
            });
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    NewReleases movieToPass = data.get(position);

                    Bundle arguments = new Bundle();
                    arguments.putSerializable("movie", movieToPass);


                    Navigation.findNavController(itemView).navigate(R.id.action_FirstFragment_to_SecondFragment, arguments);
                }
            });
            bodyTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    NewReleases movieToPass = data.get(position);

                    Bundle arguments = new Bundle();
                    arguments.putSerializable("movie", movieToPass);


                    Navigation.findNavController(itemView).navigate(R.id.action_FirstFragment_to_SecondFragment, arguments);
                }
            });
        }
    }

    ArrayList<NewReleases> data;

    public NewReleasesAdapter(ArrayList<NewReleases> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NewReleasesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new NewReleasesHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull NewReleasesHolder holder, int position) {
        NewReleases newReleases = data.get(position);
        holder.titleTV.setText(newReleases.getOriginal_title());
        holder.bodyTV.setText(newReleases.getOverview());

        //img path:
        //https://themoviedb.org/t/p/w500/*Poster_Path*
        Glide.with(mContext)
                .load("https://themoviedb.org/t/p/w500"+ data.get(position).getPoster_path())
                .apply(new RequestOptions().override(250, 375))
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
