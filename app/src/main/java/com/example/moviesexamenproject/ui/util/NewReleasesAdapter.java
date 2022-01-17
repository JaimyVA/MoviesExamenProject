package com.example.moviesexamenproject.ui.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesexamenproject.R;
import com.example.moviesexamenproject.model.NewReleases;

import java.io.Serializable;
import java.util.ArrayList;

public class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesAdapter.NewReleasesHolder> {

    class NewReleasesHolder extends RecyclerView.ViewHolder{

        private final TextView titleTV, bodyTV;

        public NewReleasesHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.tvTitle);
            bodyTV = itemView.findViewById(R.id.tvBody);
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
