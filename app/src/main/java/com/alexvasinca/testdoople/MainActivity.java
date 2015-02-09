package com.alexvasinca.testdoople;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerView object
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);

        recList.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recList.setLayoutManager(linearLayoutManager);

        InfoAdapter infoAdapter = new InfoAdapter(createList(5));
        recList.setAdapter(infoAdapter);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToRecyclerView(recList);

    }

    private List<CardInfo> createList(int size) {

        List<CardInfo> result = new ArrayList<CardInfo>();
        for (int i = 1; i <= size; i++) {
            CardInfo cardInfo = new CardInfo();
            cardInfo.name = CardInfo.NAME_PREFIX + i;
            cardInfo.surName = CardInfo.SURNAME_PREFIX + i;
            cardInfo.email = CardInfo.EMAIL_PREFIX + i;
            cardInfo.adress = CardInfo.ADRESS_PREFIX + i;

            result.add(cardInfo);
        }

        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        if (id == R.id.navigate) {
            startActivity(new Intent(this, SubActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }
}
