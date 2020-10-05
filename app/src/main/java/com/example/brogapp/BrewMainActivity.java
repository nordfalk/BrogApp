package com.example.brogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BrewMainActivity extends AppCompatActivity {

    RecyclerView faveRecyclerView;
    RecyclerView.Adapter faveAdapter;
    RecyclerView.LayoutManager faveLayoutManager;

    RecyclerView flereForslagRecyclerView;
    RecyclerView.Adapter flereForslagAdapter;
    RecyclerView.LayoutManager flereForslagLayoutManager;

    // When pushing the "nyt bryg" button
    public void newBrewButtonPushed(View view){
        ArrayList<String> brewValues = new ArrayList<>();
        brewValues.add("20");       // Grams of coffee
        brewValues.add("60");       // grams of coffee per liter of water
        brewValues.add("Medium");   // Coffee ground coarseness
        brewValues.add("92");       // Water temperature
        brewValues.add("40");       // Bloom water
        brewValues.add("120");      // Brew Time
        brewValues.add("30");       // Bloom time
        Toast.makeText(this, brewValues.toString(), Toast.LENGTH_SHORT).show();
        Log.i("Button","New brew button pushed");

        Intent intent = new Intent(BrewMainActivity.this,EnterGramsActivity.class);
        intent.putExtra("brewValues",brewValues);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brew_main);

        //Fill out recyclerView Favoritter
        ArrayList<BrewItem> listOfFaves = new ArrayList<>();
        listOfFaves.add(new BrewItem(R.drawable.coffee_pic,"Manhatten", "None","4.6","none"));
        listOfFaves.add(new BrewItem(R.drawable.coffee_pic,"New York", "None","4.6","none"));
        listOfFaves.add(new BrewItem(R.drawable.coffee_pic,"Torronto", "None","4.6","none"));
        listOfFaves.add(new BrewItem(R.drawable.coffee_pic,"Skagen", "None","4.6","none"));
        listOfFaves.add(new BrewItem(R.drawable.coffee_pic,"San Francisco", "None","4.6","none"));
        listOfFaves.add(new BrewItem(R.drawable.coffee_pic,"Malmø", "None","4.6","none"));

        faveRecyclerView = findViewById(R.id.favesRV);
        faveRecyclerView.setHasFixedSize(true);

        faveLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        faveAdapter = new BrewFaveAdapter(listOfFaves);

        faveRecyclerView.setLayoutManager(faveLayoutManager);
        faveRecyclerView.setAdapter(faveAdapter);



        //Fill out recyclerView Flere Forslag
        ArrayList<BrewItem> listOfFlereForslag = new ArrayList<>();
        listOfFlereForslag.add(new BrewItem(R.drawable.coffeetwo_pic,"Manhatten", "None","4.6","none"));
        listOfFlereForslag.add(new BrewItem(R.drawable.coffeetwo_pic,"yo yo yo", "None","4.6","none"));
        listOfFlereForslag.add(new BrewItem(R.drawable.coffeetwo_pic,"Torronto", "None","4.6","none"));
        listOfFlereForslag.add(new BrewItem(R.drawable.coffeetwo_pic,"Skagen", "None","4.6","none"));
        listOfFlereForslag.add(new BrewItem(R.drawable.coffeetwo_pic,"San Francisco", "None","4.6","none"));
        listOfFlereForslag.add(new BrewItem(R.drawable.coffeetwo_pic,"Malmø", "None","4.6","none"));

        flereForslagRecyclerView = findViewById(R.id.flereForslagRV);
        flereForslagRecyclerView.setHasFixedSize(true);

        flereForslagLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        flereForslagAdapter = new BrewForslagAdapter(listOfFlereForslag);

        flereForslagRecyclerView.setLayoutManager(flereForslagLayoutManager);
        flereForslagRecyclerView.setAdapter(flereForslagAdapter);


        //Initialize and assign navbar variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationbar);

        //Set home iteam as selected
        bottomNavigationView.setSelectedItemId(R.id.nav_brew);

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