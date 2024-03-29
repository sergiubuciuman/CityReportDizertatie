package com.example.sergiu.whereiscar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This shows how to listen to some {@link GoogleMap} events.
 */
public class MapsActivity extends AppCompatActivity
        implements OnMapClickListener, OnMapLongClickListener, OnCameraIdleListener,
        OnMapReadyCallback {

    private TextView mTapTextView;
    private TextView mCameraTextView;
    private GoogleMap mMap;
    LatLng pointGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //mTapTextView = (TextView) findViewById(R.id.tap_text);
        //mCameraTextView = (TextView) findViewById(R.id.camera_text);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
        mMap.setOnCameraIdleListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        //mTapTextView.setText("tapped, point=" + point);
        System.out.println("locatia unde am apasat"+point);

        double lat = point.latitude;
        double lng = point.longitude;
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("Click"));
        Toast.makeText(MapsActivity.this, "Button log out ", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onMapLongClick(LatLng point) {
        //mTapTextView.setText("long pressed, point=" + point);
        pointGlobal=point;
        System.out.println("long pressed, point="+pointGlobal);
        double lat = point.latitude;
        double lng = point.longitude;
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("Hello world"));
        Toast.makeText(MapsActivity.this, "Button log out ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCameraIdle() {
        mCameraTextView.setText(mMap.getCameraPosition().toString());
    }
}