package com.biplav.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView register, login;
    EditText user, pass;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.textViewRegister);
        login = findViewById(R.id.textViewLogin);
        user = findViewById(R.id.editTextUser);
        pass = findViewById(R.id.editTextPass);

        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.textViewRegister:

                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.textViewLogin:
                if (TextUtils.isEmpty(user.getText().toString())) {
                    user.setError("Please enter Username");
                    return;
                } else if (TextUtils.isEmpty(pass.getText().toString())) {
                    pass.setError("Please enter Password");
                    return;
                }

                username = user.getText().toString();
                password = pass.getText().toString();

                if (username.equals("admin") && password.equals("admin")) {
                    intent=new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Username or Password error !!!!!!!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }


    }
}
