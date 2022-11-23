package com.example.carpoolingsystem;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.carpoolingsystem.databinding.ActivityCustomerMapBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

public class DriverMapActivity2 extends FragmentActivity implements
         DriverMapActivity {

    private GoogleMap mMap;
    private ActivityCustomerMapBinding binding;
    GoogleApiClient inGoogleApiClient;
    Location inLastLocation;
    LocationRequest inLocationRequest;

    private Button inLogout;
    private String customerId = "";
    private Object List;
    private java.lang.Object Object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        inLogout = findViewById(R.id.logout);
        inLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(DriverMapActivity2.this, customerdriver.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        getAssignedCustomer();
    }

    private void getAssignedCustomer(){
        String driverId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference assignedCustomerRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(driverId);
        assignedCustomerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    if(map.get("customerRideId") != null){
                        customerId = snapshot.getValue().toString();
//                        getAssignedCustomerPickupLocation();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

//    private void getAssignedCustomerPickupLocation(){
//        DatabaseReference assignedCustomerPickupLocationRef = FirebaseDatabase.getInstance().getReference().child("customerRequest").child(customerId).child("1");
//        ValueEventListener valueEventListener = assignedCustomerPickupLocationRef.addValueEventListener(new ValueEventListener()); {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    List<Object> map = List < Object> snapshot.getValue();
//                    double locationLat = 0;
//                    double locationLng = 0;
//
//                    if (map.get(0) != null) {
//                        locationLat = Double.parseDouble(map.get(0).toString());
//                    }
//                    if (map.get(0) != null) {
//                        locationLng = Double.parseDouble(map.get(1).toString());
//                    }
//                    LatLng driverLatLng = new LatLng(locationLat, locationLng);
//
//                }
//                LatLng driverLatLng = null;
//                mMap.addMarker(new MarkerOptions().position(driverLatLng).title("Pickup Location"));
//
//
//            }
//
//    });
//
//}



    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        buildGoogleApiClient();
        mMap.setMyLocationEnabled(true);
    }

    protected synchronized void buildGoogleApiClient() {
        inGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        inGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
    if (getApplicationContext()!= null) {
        inLastLocation = location;

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference refWorking  = FirebaseDatabase.getInstance().getReference("Driver Available");
        DatabaseReference refAvailable = FirebaseDatabase.getInstance().getReference("Driver Working");
        GeoFire geoFireAvailable = new GeoFire(refAvailable );
        GeoFire geoFireWorking = new GeoFire(refWorking );

        switch (customerId) {
            case "":
                geoFireWorking.removeLocation(userId);
                geoFireAvailable.setLocation(userId, new GeoLocation(location.getLatitude(), location.getLongitude()));
                break;

            default:
                geoFireAvailable.removeLocation(userId);
                geoFireWorking.setLocation(userId, new GeoLocation(location.getLatitude(), location.getLongitude()));
                break;
        }
    }


    }

    @Override
    public void onConnected(Bundle bundle) {
        
    }

//    @Override
//    public void onConnected(Bundle bundle) {
//        inLocationRequest = new LocationRequest();
//        inLocationRequest.setInterval(1000);
//        inLocationRequest.setFastestInterval(1000);
//        inLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            return;
//        }
//        LocationServices.FusedLocationApi.requestLocationUpdates(inGoogleApiClient, inLocationRequest, this);
//
//
//    }

    @Override
    public void onConnectionSuspended(int i) {
        
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    protected void onStop() {
        super.onStop();
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Driver Available");

        GeoFire geoFire = new GeoFire(ref);
        geoFire.removeLocation(userId);
    }
}