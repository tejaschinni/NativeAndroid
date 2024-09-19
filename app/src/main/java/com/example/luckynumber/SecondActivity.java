package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
//    TextView welcomeTxt,luckNumber;
    Button shareBtn;
//    Spinner sp;
//    TimePicker picker;
    DatePicker datePicker;
    ProgressBar bar;
    int cur = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
datePicker = findViewById(R.id.datePiker);
shareBtn = findViewById(R.id.share_btn);
bar = findViewById(R.id.progressBar);
shareBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String day = "Day "+ datePicker.getDayOfMonth();
        String mont = "Month "+(datePicker.getMonth()+1);
        String year = "Year "+datePicker.getYear();
        cur = cur + 10;
        bar.setProgress(cur);
        Toast.makeText(SecondActivity.this,day+""+mont+""+year,Toast.LENGTH_LONG).show();
    }
});
//        welcomeTxt = findViewById(R.id.textview2);
//        luckNumber = findViewById(R.id.textview3);
//        shareBtn = findViewById(R.id.share_btn);
//        sp = findViewById(R.id.spinerexm);
//        String[] course = {"Flutter","JAVA","C++","JavaScript"};
//        picker = findViewById(R.id.timePicker);
//
//        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                Toast.makeText(SecondActivity.this,""+"Time is "+ hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //Array adapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,course);
//        sp.setAdapter(adapter);
//
//        // Getting the data from intent
//        Intent i = getIntent();
//        String user = i.getStringExtra("name");
//        welcomeTxt.setText(user);
//        int rand = generateRandomNumber();
//        luckNumber.setText(""+rand);
//
//        shareBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                shareData(user, Integer.parseInt(luckNumber.toString()));
//            }
//        });


    }
public void shareData(String user,int number){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,user+"got Lucky today ");
        i.putExtra(Intent.EXTRA_TEXT,"His Luck number is: "+number);
        startActivity(Intent.createChooser(i,"Choose a PlatFrom"));
}
    public int generateRandomNumber(){
        Random ran = new Random();
        int upper_limit = 1000;
        int randomGen = ran.nextInt(upper_limit);
        return randomGen;
    }
}