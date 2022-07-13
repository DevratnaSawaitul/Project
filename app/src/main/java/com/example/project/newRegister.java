package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newRegister extends AppCompatActivity {

    EditText username, password, repassword;
    Button register;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);
        getSupportActionBar().hide();
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        register = (Button) findViewById(R.id.btnregister);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else if (user.length() < 8) {
                    username.setText("");
                    username.setHint("enter username more than 8 character");
                } else if (pass.length() < 8) {
                    password.setText("");
                    password.setHint("enter password more than 8 character");
                } else if (repass.length() < 8) {
                    repassword.setText("");
                    repassword.setHint("enter password more than 8 character");
                } else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (!checkuser) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert) {
                                Toast.makeText(getApplicationContext(), "Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Registration failed! Try Again", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            username.setText("");
                            password.setText("");
                            repassword.setText("");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password not match", Toast.LENGTH_SHORT).show();
                        repassword.setText("");
                    }
                }
            }
        });
    }
}
