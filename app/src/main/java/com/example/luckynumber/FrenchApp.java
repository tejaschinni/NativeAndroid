package com.example.luckynumber;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrenchApp extends AppCompatActivity implements  View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_french_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.black);
//                mediaPlayer.start();
//            }
//        });

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int clickevent = v.getId();

        if(clickevent == R.id.btn1){
            playsound(R.raw.black);
        }else if(clickevent == R.id.btn2){
            playsound(R.raw.green);
        }else if(clickevent == R.id.btn3) {
            playsound(R.raw.purple);
        }else if(clickevent == R.id.btn4) {
            playsound(R.raw.red);
        }else if(clickevent == R.id.btn5) {
            playsound(R.raw.yellow);
        }
    }

    public void playsound(int d){
        MediaPlayer media = MediaPlayer.create(this,d);
        media.start();
    }
}