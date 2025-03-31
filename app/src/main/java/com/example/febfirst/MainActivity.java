package com.example.febfirst;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity<locationManager> extends AppCompatActivity {

    private TextView latlon;
    String locationText = "";
    private Context mContext;
    Location location;
    LocationManager locationManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latlon = (TextView)findViewById(R.id.id_latlon);


        onRequestPermissionsResult(101, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, new int[] {PackageManager.PERMISSION_GRANTED});

       // try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                if(shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) == false){
                    requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 101);
                }
                //ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, null, null, listener);
        }
        // } catch (Exception e){
           // e.printStackTrace();
       // }

        //locationText = location.getLatitude() + ", " + location.getLongitude();
        //latlon.setText(locationText.toString());


       location = (Location) getSystemService(Context.LOCATION_SERVICE);
       locationText = location.getLatitude() + "," + location.getLongitude();
       latlon.setText(locationText.toString());


    }

    public void getLocation(View view) {

    }


    LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location var1) {
            locationText = location.getLatitude() + ", " + location.getLongitude();
            latlon.setText(locationText.toString());
        }

        @Override
        public void onStatusChanged(String var1, int var2, Bundle var3) {

        }

        @Override
        public void onProviderEnabled(String var1) {

        }

        @Override
        public void onProviderDisabled(String var1) {

        }
    };



}


//print address
//location is changing
//"fav location"
//location you spend the most amount of time - how much time

//lat/lon/location - mon
//address - wed
// ready to test, fav location, complete - fri