package com.example.purnota.hoorayzone;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mcnfPassword;
    Button mButtonRegister;
    TextView mTextviewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mTextUsername=(EditText) findViewById(R.id.username);
        mTextPassword=(EditText) findViewById(R.id.password);
        mcnfPassword=(EditText) findViewById(R.id.password2);
        mButtonRegister=(Button) findViewById(R.id.register_btn);
        mTextviewLogin=(TextView) findViewById(R.id.textview_login);

        mTextviewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(loginintent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mcnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd))
                {
                    long val = db.addUser(user, pwd);
                    if(val>0) {
                        Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
