package com.deliveryapp.deliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GetLocationActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private DatabaseReference myRef;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        //Initialize Firebase
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("locations");

        Button button2 = findViewById(R.id.button2);
        Button locbutton = findViewById(R.id.get_location_button);
        final TextView textView = findViewById(R.id.textView);

        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(GetLocationActivity.this, FirstInstructionActivity.class);
            //Next activity is started
            startActivity(intent2);
        });

        locbutton.setOnClickListener(view -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // Show dialog to ask for permission
                    showPermissionDialog();
                } else {
                    configureLocation();
                }
            } else {
                configureLocation();
            }
        });

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                textView.append("\n" + location.getLatitude() + " " + location.getLongitude());
                myRef.setValue(location); // send location to Firebase
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
    }

    private void configureLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }
        locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
    }

    private void showPermissionDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Location Permission");
        builder.setMessage("This app needs location permission to function properly. Please grant the permission.");
        builder.setPositiveButton("OK", (dialog, which) -> ActivityCompat.requestPermissions(GetLocationActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                LOCATION_PERMISSION_REQUEST_CODE));
        builder.setNegativeButton("Cancel", (dialog, which) -> {
            Toast.makeText(GetLocationActivity.this, "Permission denied, app will not function properly", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        builder.create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                configureLocation();
            } else {
                Toast.makeText(GetLocationActivity.this, "Permission denied, app will not function properly", Toast.LENGTH_SHORT).show();
            }
        }
    }
}



