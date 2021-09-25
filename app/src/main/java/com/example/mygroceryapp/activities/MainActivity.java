package com.example.mygroceryapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mygroceryapp.R;
import com.example.mygroceryapp.activities.HomeActivity;
import com.example.mygroceryapp.activities.LogInActivity;
import com.example.mygroceryapp.model.Validate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName,editTextEmail,editTextContactNumber,editTextPassword;
    TextView textViewClickToLogin;
    Button btnRegister,btnWithoutLogin;
    String name,password,contactNumber,emailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        editTextName = findViewById(R.id.edit_text_full_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextContactNumber = findViewById(R.id.edit_text_contact_number);
        editTextPassword = findViewById(R.id.edit_text_password);
        textViewClickToLogin = findViewById(R.id.text_view_click_to_login);
        btnRegister = findViewById(R.id.button_register);
        btnWithoutLogin = findViewById(R.id.button_without_login);

        btnRegister.setOnClickListener(this);
        btnWithoutLogin.setOnClickListener(this);
        textViewClickToLogin.setOnClickListener(this);
    }

    private void getData() {
        name = editTextName.getText().toString().trim();
        emailId = editTextEmail.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        contactNumber = editTextContactNumber.getText().toString().trim();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_register:
                getData();
                if (Validate.validateData(name,password,contactNumber,emailId,this)) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
                else
                    Toast.makeText(this, "Please enter all the information", Toast.LENGTH_SHORT).show();
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