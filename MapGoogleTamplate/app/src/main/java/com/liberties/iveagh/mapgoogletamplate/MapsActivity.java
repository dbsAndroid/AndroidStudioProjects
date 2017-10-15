package com.liberties.iveagh.mapgoogletamplate;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng dublin = new LatLng(53.34, -6.26);
        LatLng london = new LatLng(51.52, -0.38);
        LatLng manchester = new LatLng(53.47, -2.36);
        LatLng manhattan = new LatLng(40.69, -74.29);
        LatLng atlantis = new LatLng(35.00, -35.00);

        mMap.addMarker(new MarkerOptions().position(dublin).title("Marker in Dubh Lin"));
        mMap.addMarker(new MarkerOptions().position(london).title("London Loonies"));
        mMap.addMarker(new MarkerOptions().position(manchester).title("Manchester Mummies"));
        mMap.addMarker(new MarkerOptions().position(manhattan).title("Manhattan Mops"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlantis));
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
