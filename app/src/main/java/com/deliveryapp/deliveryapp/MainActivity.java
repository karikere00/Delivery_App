package com.deliveryapp.deliveryapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assigns the text input layout, text input edit text, and button to variables:
        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout);
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //Checks user input
            public void onClick(View view) {
                String input = textInputEditText.getText().toString();
                if (input.length() == 6) {
                    // Proceed to next screen
                    //Intent object is created
                    Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
                    //Next activity is started
                    startActivity(intent);

                } else {
                    textInputLayout.setError("Enter a 6-digit code");
                }
            }
        });


    }
}