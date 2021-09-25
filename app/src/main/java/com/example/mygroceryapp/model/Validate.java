package com.example.mygroceryapp.model;

import android.content.Context;
import android.widget.Toast;

public class Validate {

    String name, password, contactNumber, emailId;

    public Validate(String name, String password, String contactNumber, String emailId) {
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
    }


    public static boolean validateData(String name, String password, String contactNumber,
                                String emailId, Context context) {

        if (!name.isEmpty()
                && !password.isEmpty()
                && !contactNumber.isEmpty()
                && !emailId.isEmpty()) {
            Toast.makeText(context, "Register Successfully", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
}
