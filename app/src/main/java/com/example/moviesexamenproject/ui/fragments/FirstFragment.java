package com.example.moviesexamenproject.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesexamenproject.R;
import com.example.moviesexamenproject.databinding.FragmentFirstBinding;
import com.example.moviesexamenproject.model.NewReleases;
import com.example.moviesexamenproject.model.NewReleasesViewModel;
import com.example.moviesexamenproject.ui.util.NewReleasesAdapter;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvMovies = view.findViewById(R.id.rvMovies);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMovies.setLayoutManager(mLayoutManager);


        NewReleasesViewModel newReleasesViewModel = new ViewModelProvider(getActivity()).get(NewReleasesViewModel.class);
        newReleasesViewModel.getNewReleases().observe(getViewLifecycleOwner(), new Observer<ArrayList<NewReleases>>() {
            @Override
            public void onChanged(ArrayList<NewReleases> newReleases) {
                Log.d("TEST", newReleases.toString());
                NewReleasesAdapter mAdapter = new NewReleasesAdapter(newReleases);
                rvMovies.setAdapter(mAdapter);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}