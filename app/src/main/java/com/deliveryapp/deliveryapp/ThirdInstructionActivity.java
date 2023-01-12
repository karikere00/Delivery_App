package com.deliveryapp.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdInstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_instruction);
        Button button5 = findViewById(R.id.button5);
        Button button7 = findViewById(R.id.button7);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(ThirdInstructionActivity.this, FourthInstructionActivity.class);
                //Next activity is started
                startActivity(intent5);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(ThirdInstructionActivity.this, SecondInstructionActivity.class);
                //Next activity is started
                startActivity(intent7);
            }
        });


    }
}