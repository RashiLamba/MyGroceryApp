package com.example.mygroceryapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mygroceryapp.R;
import com.example.mygroceryapp.activities.HomeActivity;
import com.example.mygroceryapp.activities.LogInActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewName,textViewEmail,textViewContactNumber,textViewPassword,textViewClickToLogin;
    Button btnRegister,btnWithoutLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        textViewName = findViewById(R.id.text_view_full_name);
        textViewEmail = findViewById(R.id.text_view_email);
        textViewContactNumber = findViewById(R.id.text_view_contact_number);
        textViewPassword = findViewById(R.id.text_view_password);
        textViewClickToLogin = findViewById(R.id.text_view_click_to_login);
        btnRegister = findViewById(R.id.button_register);
        btnWithoutLogin = findViewById(R.id.button_without_login);

        btnRegister.setOnClickListener(this);
        btnWithoutLogin.setOnClickListener(this);
        textViewClickToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_register:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                break;
            case R.id.text_view_click_to_login:
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                break;
            case R.id.button_without_login:
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                break;

        }
    }
}