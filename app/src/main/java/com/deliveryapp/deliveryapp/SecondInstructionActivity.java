package com.deliveryapp.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondInstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_instruction);
        Button button4 = findViewById(R.id.button4);
        Button button6 = findViewById(R.id.button6);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(SecondInstructionActivity.this, ThirdInstructionActivity.class);
                //Next activity is started
                startActivity(intent4);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(SecondInstructionActivity.this, FirstInstructionActivity.class);
                //Next activity is started
                startActivity(intent6);
            }
        });
    }
}