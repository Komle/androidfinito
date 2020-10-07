package com.example.bandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final CheckBox rememberMe = findViewById(R.id.remember_me);
        Button loginBtn = findViewById(R.id.Login_btn);
        Button registerBtn = findViewById(R.id.Register);

        final User user = new User(LoginActivity.this);

        rememberMe.setChecked(user.isRememberedForLogin());

        if (rememberMe.isChecked()){
            username.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE);
            password.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
        } else {
            username.setText("", TextView.BufferType.EDITABLE);
            password.setText("", TextView.BufferType.EDITABLE);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username2 = username.getText().toString();
                String password2 = password.getText().toString();
                Toast.makeText(LoginActivity.this, "Username: " + username2 + "\n" + "Password: " + password2, Toast.LENGTH_SHORT).show();

                username.setError(null);
                password.setError(null);
                if (Validation.isCredentialsValid(username2) && Validation.isCredentialsValid(password2)) {
                        user.setUsernameForLogin(username2);
                        user.setPasswordForLogin(password2);
                        if(rememberMe.isChecked()){
                            user.setRemembermeKeyForLogin(true);
                        } else {
                            user.setRemembermeKeyForLogin(false);
                        }

                    Intent gotoPirkimas = new Intent(LoginActivity.this, PirkimasActivity.class);
                    startActivity(gotoPirkimas);
                } else {
                    username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    username.requestFocus();
                    password.setError(getResources().getString(R.string.login_invalid_credentials_password));
                    password.requestFocus();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view) {
        Intent gotoRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(gotoRegisterActivity);
    }
});

    }
}
