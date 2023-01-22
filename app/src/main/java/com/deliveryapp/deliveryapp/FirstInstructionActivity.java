package com.deliveryapp.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class FirstInstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_instruction);
        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(view -> {
            Intent intent3 = new Intent(FirstInstructionActivity.this, SecondInstructionActivity.class);
            //Next activity is started
            startActivity(intent3);
        });
    }
}