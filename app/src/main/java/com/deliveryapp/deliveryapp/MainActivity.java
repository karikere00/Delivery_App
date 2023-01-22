package com.deliveryapp.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assigns the text input layout, text input edit text, and button to variables:
        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout);
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText);
        Button button = findViewById(R.id.button);

        //Checks user input
        button.setOnClickListener(view -> {
            String input = Objects.requireNonNull(textInputEditText.getText()).toString();
            if (StringSet.isInSet(input)) {
                // Proceed to next screen
                //Intent object is created
                Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
                //Next activity is started
                startActivity(intent);

            } else {
                textInputLayout.setError("Enter 6-digit order number");
            }
        });


    }
}