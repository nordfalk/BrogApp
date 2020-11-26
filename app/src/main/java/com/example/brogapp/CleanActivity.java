package com.example.brogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CleanActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);

        tv = findViewById(R.id.textView);
        tv.setOnClickListener(this);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();



        //Initialize and assign navbar variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationbar);

        //Set home iteam as selected
        bottomNavigationView.setSelectedItemId(R.id.nav_wash);

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

    @Override
    public void onClick(View view) {


        if (view == tv){
            //For populating database
            Map<String, Object> newbrew = new HashMap<>();
            newbrew.put("brewName", "Athens");
            newbrew.put("brewDescription", "Et mildere bryg, der med mælk kan nydes af nybegyndere");
            newbrew.put("brewScore", "3.4");
            newbrew.put("imageRessource", 0);
            newbrew.put("coffeeAmount", "30");
            newbrew.put("grindSize", "medium");
            newbrew.put("waterRatio", "70");
            newbrew.put("brewTemp", "93");
            newbrew.put("bloomWater", "45");
            newbrew.put("bloomTime", "30");
            newbrew.put("brewTime", "180");
            newbrew.put("timeStamp",1605771956572l);

            Map<String, Object> newbrew1 = new HashMap<>();
            newbrew1.put("brewName", "Washington");
            newbrew1.put("brewDescription", "Er det tid til iskaffe, så er dette bryg perfekt til dig");
            newbrew1.put("brewScore", "4.3");
            newbrew1.put("imageRessource", 1);
            newbrew1.put("coffeeAmount", "20");
            newbrew1.put("grindSize", "medium");
            newbrew1.put("waterRatio", "60");
            newbrew1.put("brewTemp", "93");
            newbrew1.put("bloomWater", "45");
            newbrew1.put("bloomTime", "30");
            newbrew1.put("brewTime", "180");
            newbrew1.put("timeStamp",1606383638000l);

            Map<String, Object> newbrew2 = new HashMap<>();
            newbrew2.put("brewName", "Tokyo");
            newbrew2.put("brewDescription", "Til de kolde regnfulde dage, er denne bryg god at varme sig på");
            newbrew2.put("brewScore", "3.9");
            newbrew2.put("imageRessource", 2);
            newbrew2.put("coffeeAmount", "20");
            newbrew2.put("grindSize", "medium");
            newbrew2.put("waterRatio", "60");
            newbrew2.put("brewTemp", "93");
            newbrew2.put("bloomWater", "45");
            newbrew2.put("bloomTime", "30");
            newbrew2.put("brewTime", "180");
            newbrew2.put("timeStamp",1605112838000l);

            Map<String, Object> newbrew3 = new HashMap<>();
            newbrew3.put("brewName", "Shanghai");
            newbrew3.put("brewDescription", "En grov bønnegrind, med ekstra bloomvand, gør denne bryg kraftig, og fremhæver bønnens noter");
            newbrew3.put("brewScore", "4.3");
            newbrew3.put("imageRessource", 3);
            newbrew3.put("coffeeAmount", "20");
            newbrew3.put("grindSize", "medium");
            newbrew3.put("waterRatio", "60");
            newbrew3.put("brewTemp", "93");
            newbrew3.put("bloomWater", "45");
            newbrew3.put("bloomTime", "30");
            newbrew3.put("brewTime", "180");
            newbrew3.put("timeStamp",1606302758000l);

            fStore.collection("brews").document().set(newbrew);
            fStore.collection("brews").document().set(newbrew1);
            fStore.collection("brews").document().set(newbrew2);
            fStore.collection("brews").document().set(newbrew3);
        }
    }
}