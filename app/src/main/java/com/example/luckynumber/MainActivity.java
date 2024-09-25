package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edite;
    Button mybton;
    TextView txt;
    CheckBox checkBox;
    RadioGroup grp;
    RadioButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt = findViewById(R.id.textview1);
        mybton = findViewById(R.id.btn);
        edite = findViewById(R.id.edite_text);

        checkBox = findViewById(R.id.checkbox1);
        grp = findViewById(R.id.radiogrp);
        Intent i = new Intent(getApplicationContext(),VolumnAreaApp.class);
        startActivity(i);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this,"You have selected "+ radioButton.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //code to excute
                    Toast.makeText(MainActivity.this,"Check box is checked",Toast.LENGTH_SHORT).show();
                }else{
                    //code to excute
                    Toast.makeText(MainActivity.this,"Check box is not checked",Toast.LENGTH_SHORT).show();

                }
            }
        });
        mybton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edite.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //passing the value
                intent.putExtra("name",userName);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.search){
            Toast.makeText(this,"You have selected Search option",Toast.LENGTH_SHORT
            ).show();
        }else if(id == R.id.home){
            Toast.makeText(this,"You have selected Home option",Toast.LENGTH_SHORT
            ).show();
        }
        return  super.onOptionsItemSelected(item);
    }
}