package com.practice.jagadish.guessgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Devolper extends AppCompatActivity {

    ImageView instagram,blogger,linkedin,backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devolper);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(Devolper.this,R.color.black));
        }
        instagram = findViewById(R.id.instagram);
        blogger = findViewById(R.id.blogger);
        linkedin = findViewById(R.id.linkedin);

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://instagram.com/jagadish__mekala?utm_source=qr&igshid=ZTM4ZDRiNzUwMw==";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Intent chooser = i.createChooser(i, "Choose Browser");
                startActivity(chooser);

            }
        });
        blogger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://jagadishmekala.blogspot.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.linkedin.com/in/jagadishmekala/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Devolper.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}