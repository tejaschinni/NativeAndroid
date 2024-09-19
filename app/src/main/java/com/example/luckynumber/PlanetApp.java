package com.example.luckynumber;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PlanetApp extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetsList;
    private static MyCustomPlanetAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planet_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.planetList);

         planetsList  = new ArrayList<>();
         Planet planet1 = new Planet("Earth","1 Moons",R.drawable.earth);
        Planet planet2 = new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet3 = new Planet("Mars","2 Moons",R.drawable.mars);
        Planet planet4 = new Planet("Venus","0 Moons",R.drawable.venus);
        Planet planet5 = new Planet("Jupiter","79 Moons",R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn","83 Moons",R.drawable.saturn);
        Planet planet7 = new Planet("Uranus","27 Moons",R.drawable.uranus);
        Planet planet8 = new Planet("Neptune","14 Moons",R.drawable.neptune);
         planetsList.add(planet1);
        planetsList.add(planet2);
        planetsList.add(planet3);
        planetsList.add(planet4);
        planetsList.add(planet5);
        planetsList.add(planet6);
        planetsList.add(planet7);
        planetsList.add(planet8);

        adapter = new MyCustomPlanetAdapter(planetsList,getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"The Selected "+adapter.getItem(position).getPlanetName()+" "+"Has "+adapter.getItem(position).getMoonCount()+" Moons",Toast.LENGTH_LONG).show();
            }
        });

    }
}