package com.example.bandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText username = findViewById(R.id.regusername);
        final EditText password = findViewById(R.id.regpassword);
        final EditText email = findViewById(R.id.email);
        Button registrationBtn = findViewById(R.id.Register2);

        registrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                {
                    String username2 = username.getText().toString();
                    String password2 = password.getText().toString();
                    String email2 = email.getText().toString();
                    Toast.makeText(RegisterActivity.this, "Username: " + username2 + "\n" + "Password: " + password2 + "\n" + "Email: " + email2, Toast.LENGTH_SHORT).show();

                    username.setError(null);
                    password.setError(null);
                    email.setError(null);
                    if (Validation.isCredentialsValid(username2) && Validation.isPasswordValid(password2) && Validation.isEmailValid(email2)) {

                        Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(gotoLoginActivity);
                    } else {
                        username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                        password.setError(getResources().getString(R.string.login_invalid_credentials_password));
                        email.setError(getResources().getString(R.string.login_invalid_credentials_email));
                        username.requestFocus();
                        password.requestFocus();
                        email.requestFocus();
                    }
                }
            }
        });

    }
}
