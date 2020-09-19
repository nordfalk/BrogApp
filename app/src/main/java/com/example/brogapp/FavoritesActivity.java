package com.example.brogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

    //Fill out recyclerView
        ArrayList<BrewItem> listOfFaves = new ArrayList<>();
        listOfFaves.add(new BrewItem(R.drawable.ic_android,"Manhatten", "Dette er bare en tester, bare rolig","4.6"));
        listOfFaves.add(new BrewItem(R.drawable.ic_android,"Manhatten", "Dette er bare en tester, bare rolig","4.6"));
        listOfFaves.add(new BrewItem(R.drawable.ic_android,"Manhatten", "Dette er bare en tester, bare rolig","4.6"));
        listOfFaves.add(new BrewItem(R.drawable.ic_android,"Manhatten", "Dette er bare en tester, bare rolig","4.6"));
        listOfFaves.add(new BrewItem(R.drawable.ic_android,"Manhatten", "Dette er bare en tester, bare rolig","4.6"));
        listOfFaves.add(new BrewItem(R.drawable.ic_android,"Manhatten", "Dette er bare en tester, bare rolig","4.6"));

        mRecyclerView = findViewById(R.id.favesHolderRV);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BrewListAdapter(listOfFaves);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        //Initialize and assign navbar variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationbar);

        //Set home iteam as selected
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);

        //Set up listener, for determine if other icon is pressed
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0); //Dont know what this does
                        return true;

                    case R.id.nav_scan:
                        startActivity(new Intent(getApplicationContext(),ScanActivity.class));
                        overridePendingTransition(0,0); //Dont know what this does
                        return true;

                    case R.id.nav_brew:
                        startActivity(new Intent(getApplicationContext(),BrewMainActivity.class));
                        overridePendingTransition(0,0); //Dont know what this does
                        return true;

                    case R.id.nav_wash:
                        startActivity(new Intent(getApplicationContext(),CleanActivity.class));
                        overridePendingTransition(0,0); //Dont know what this does
                        return true;

                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(),ProfilePage.class));
                        overridePendingTransition(0,0); //Dont know what this does
                        return true;
                }

                return false;
            }
        });


    }

}