package com.example.luckynumber;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class VolumnAreaApp extends AppCompatActivity {

    GridView gridView;

    ArrayList<GridShape> arrayList;

    MyCustomAdapterGrid adapterGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volumn_area_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);

        arrayList = new ArrayList<>();

        GridShape s1 = new GridShape(R.drawable.sphere,"Sphere");
        GridShape s2 = new GridShape(R.drawable.cylinder,"Cylinder");
        GridShape s3 = new GridShape(R.drawable.cube,"Cube");
        GridShape s4 = new GridShape(R.drawable.prism,"Prism");

        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);

        adapterGrid = new MyCustomAdapterGrid(arrayList,getApplicationContext());

        gridView.setAdapter(adapterGrid);
        gridView.setNumColumns(2);





    }
}