package com.alexvasinca.testdoople;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment implements MyAdapter.ClickListener {
    private RecyclerView recyclerView;

    public static final String PREF_FILE_NAME = "testpref";

    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;

    private MyAdapter adapter;

    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;

    private boolean mFromSavedInstanceState;

    private View containterView;

    private boolean isDrawerOpened = false;


    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));

        //if savedInstanceState is not null then the user allready accesed it.
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawer_list);

        //initialize the adapter and pass the parameters
        adapter = new MyAdapter(getActivity(), getData());
        //this indicates that the fragment is the object that implements the ClickListener

        adapter.setClickListener(this);
        //set the adapter
        recyclerView.setAdapter(adapter);
        //set the layout manager and choose the LinearLayoutManager
        //because we want the items one below each other.
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }


    /**
     * Utility class that returns dummy data to display on the NavDrawer.
     */

    public static List<Information> getData() {
        List<Information> data = new ArrayList<>();

        int[] icon = {R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next};

        String[] text = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth"};
        for (int i = 0; i < text.length && i < icon.length; i++) {
            Information current = new Information();
            current.iconId = icon[i];
            current.title = text[i];
            data.add(current);
        }
        return data;
    }


    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        //we need a reference to the fragment
        //so we pass it from MainActivity and initialize it here
        containterView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //if the user has never seen the drawer before
                //it means that this is the first access and we save that to prefs

                //mUserLearnedDrawer+"" is conversion to string
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                //invalidateOptionsMenu makes the activity to redraw the actionbar again
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //same thing as in onDrawerOpened
                getActivity().invalidateOptionsMenu();
            }


        };
        //if the user has never seen the drawer and it's the very first time that the fragment is stared
        //display the drawer
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(containterView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    private static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }

    @Override
    public void itemClicked(View view, int position) {
        startActivity(new Intent(getActivity(), SubActivity.class));
    }
}

