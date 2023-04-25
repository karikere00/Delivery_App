package com.deliveryapp.deliveryapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

//Finalized app
public class MainActivity extends AppCompatActivity {

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String mVerificationId;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigns the text input layout, text input edit text, and button to variables:
        TextInputLayout phoneNumberLayout = findViewById(R.id.phoneNumberLayout);
        TextInputEditText phoneInputEditText = findViewById(R.id.phoneInputEditText);
        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout);
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText);
        Button button9 = findViewById(R.id.button9);
        Button button = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();


        // Initialize Firebase callbacks
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
                // Sign in the user with the phone number credential
                // ...
                // Proceed to next screen
                Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
                startActivity(intent);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                // Show an error message
                phoneNumberLayout.setError(getString(R.string.verification_failed_error));
            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                // Save the verification ID so we can use it later
                mVerificationId = verificationId;
                // Show the code input field and the "Verify" button
                textInputLayout.setVisibility(View.VISIBLE);
            }
        };

        button9.setOnClickListener(view -> {
            String phoneNumber = Objects.requireNonNull(phoneInputEditText.getText()).toString();
            PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                    .setPhoneNumber(phoneNumber)   // Phone number to verify
                    .setTimeout(30L, TimeUnit.SECONDS) // Timeout and unit
                    .setActivity(this)    // Activity (for callback binding)
                    .setCallbacks(mCallbacks)
                    .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        });

        button.setOnClickListener(view -> {
            String code = Objects.requireNonNull(textInputEditText.getText()).toString();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Proceed to next screen
                            Intent intent = new Intent(MainActivity.this, GetLocationActivity.class);
                            startActivity(intent);
                        } else {
                            // Show an error message
                            textInputLayout.setError(getString(R.string.verification_failed_error));
                        }
                    });
        });

    }
}




