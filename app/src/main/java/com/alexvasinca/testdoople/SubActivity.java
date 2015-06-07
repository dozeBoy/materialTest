package com.alexvasinca.testdoople;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class SubActivity extends ActionBarActivity {

    private Toolbar toolbar;

    static final LatLng UPTPosition = new LatLng(45.747123, 21.228181);

    static final LatLng Camin7C = new LatLng(45.746582, 21.235785);

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            }

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            googleMap.setMyLocationEnabled(true);

            googleMap.setTrafficEnabled(true);

            googleMap.setIndoorEnabled(true);

            googleMap.setBuildingsEnabled(true);

            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            Marker firstMarker = googleMap.addMarker(new MarkerOptions().position(UPTPosition).title("Poli"));

            Marker secondMarker = googleMap.addMarker(new MarkerOptions().position(Camin7C).title("Caminul 7C"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            }

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            googleMap.setMyLocationEnabled(true);

            googleMap.setTrafficEnabled(true);

            googleMap.setIndoorEnabled(true);

            googleMap.setBuildingsEnabled(true);

            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            Marker firstMarker = googleMap.addMarker(new MarkerOptions().position(UPTPosition).title("Poli"));

            Marker secondMarker = googleMap.addMarker(new MarkerOptions().position(Camin7C).title("Caminul 7C"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
