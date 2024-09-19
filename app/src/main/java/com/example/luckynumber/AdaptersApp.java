package com.example.luckynumber;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaptersApp extends AppCompatActivity {

    ListView list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adapters_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Adapter view
        list = findViewById(R.id.listviewdemo);

        //data source
        String[] country = {"USA","India","Japan","Spain","UE","China","Pak","RU","UK","Dubai","Rom","njk","mfon","fowwn","fniwinf","fnjw","fnorowrn"};

        //adapter
//        ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,country);
//        list.setAdapter(arr);

        //custom adapter
        MyAdaptor arr = new MyAdaptor(this,country);
        list.setAdapter(arr);

    }
}