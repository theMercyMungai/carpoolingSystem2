package com.example.carpoolingsystem;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public interface DriverMapActivity extends OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    @Override
    void onMapReady(GoogleMap googleMap);

    void onLocationChanged(Location location);

    @Override
    void onConnected(Bundle bundle);
}
