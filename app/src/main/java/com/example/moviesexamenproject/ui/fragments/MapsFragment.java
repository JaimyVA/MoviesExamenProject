package com.example.moviesexamenproject.ui.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviesexamenproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng kinepolisAntwerpen = new LatLng(51.245908,4.416209);
            LatLng kinepolisBraine = new LatLng(50.668609,4.378692);
            LatLng kinepolisBrugge = new LatLng(51.179722,3.201944);
            LatLng kinepolisBrussel = new LatLng(50.8956083,4.3378853);
            LatLng kinepolisGent = new LatLng(51.040549,3.729985);
            LatLng kinepolisHasselt = new LatLng(50.929638,5.36883);
            LatLng kinepolisKortrijk = new LatLng(50.805621,3.27526);
            LatLng kinepolisLeuven = new LatLng(50.880815,4.712168);
            LatLng kinepolisLiege = new LatLng(50.670278,5.554722);
            LatLng kinepolisOostende = new LatLng(51.222993,2.896775);

            googleMap.addMarker(new MarkerOptions().position(kinepolisAntwerpen).title("Kinepolis Antwerpen"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisBraine).title("Kinepolis Braine"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisBrugge).title("Kinepolis Brugge"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisBrussel).title("Kinepolis Brussel"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisGent).title("Kinepolis Gent"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisHasselt).title("Kinepolis Hasselt"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisKortrijk).title("Kinepolis Kortrijk"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisLeuven).title("Kinepolis Leuven"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisLiege).title("Kinepolis Liège"));
            googleMap.addMarker(new MarkerOptions().position(kinepolisOostende).title("Kinepolis Oostende"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kinepolisBrussel, 8));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}