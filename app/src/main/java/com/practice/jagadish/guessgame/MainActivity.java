package com.practice.jagadish.guessgame;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGuess;
    private AppCompatButton buttonSubmit;
    private TextView textViewResult;

    private int randomNumber;
    ImageView logoImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));
        }
        editTextGuess = findViewById(R.id.editTextGuess);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);
        logoImageview = findViewById(R.id.logoImageview);

        // Generate a random number between 1 and 100
        Random random = new Random();
        randomNumber = random.nextInt(50) + 1;

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });
        logoImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Devolper.class);
                startActivity(intent);
            }
        });
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(editTextGuess.getText().toString());

            if (userGuess == randomNumber) {
                Toast.makeText(MainActivity.this,"Congratulations!",Toast.LENGTH_SHORT).show();
                textViewResult.setText("Congratulations! " +userGuess+" You guessed correctly.");

                textViewResult.setTextColor(getResources().getColor(R.color.green));
            } else if (userGuess < randomNumber) {
                Toast.makeText(MainActivity.this,"Try higher number.",Toast.LENGTH_SHORT).show();
                textViewResult.setText("Try higher number.");
                textViewResult.setTextColor(getResources().getColor(R.color.blue));

            } else if (userGuess > randomNumber){
                Toast.makeText(MainActivity.this,"Try lower number.",Toast.LENGTH_SHORT).show();
                textViewResult.setText("Try lower number.");
                textViewResult.setTextColor(getResources().getColor(R.color.blue));
            } else{
                textViewResult.setText("Please Enter Number");
            }

        } catch (NumberFormatException e) {
            textViewResult.setText("Please enter a valid number.");
            Toast.makeText(MainActivity.this,"Please enter a valid number...",Toast.LENGTH_SHORT).show();
            textViewResult.setTextColor(getResources().getColor(R.color.red));
        }
    }
}
