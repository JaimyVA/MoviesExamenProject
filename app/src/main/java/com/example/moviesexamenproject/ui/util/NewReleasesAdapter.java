package com.example.moviesexamenproject.ui.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesexamenproject.R;
import com.example.moviesexamenproject.model.NewReleases;

import java.util.ArrayList;

public class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesAdapter.NewReleasesHolder> {

    class NewReleasesHolder extends RecyclerView.ViewHolder{

        private final TextView titleTV, bodyTV;

        public NewReleasesHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.tvTitle);
            bodyTV = itemView.findViewById(R.id.tvBody);
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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
