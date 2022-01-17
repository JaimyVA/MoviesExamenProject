package com.example.moviesexamenproject.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesexamenproject.R;
import com.example.moviesexamenproject.databinding.FragmentSecondBinding;
import com.example.moviesexamenproject.model.NewReleases;
import com.example.moviesexamenproject.model.NewReleasesViewModel;
import com.example.moviesexamenproject.ui.util.NewReleasesAdapter;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NewReleases passedMovie = (getArguments() != null)? (NewReleases) getArguments().getSerializable("movie") : null;
        if(passedMovie != null){
            TextView titleTV = view.findViewById(R.id.tvTitle2);
            TextView bodyTV = view.findViewById(R.id.tvBody2);

            titleTV.setText(passedMovie.getOriginal_title());
            bodyTV.setText(passedMovie.getOverview());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}