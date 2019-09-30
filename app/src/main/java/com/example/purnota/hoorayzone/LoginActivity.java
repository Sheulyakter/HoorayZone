package com.example.purnota.hoorayzone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextviewRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername=(EditText) findViewById(R.id.username);
        mTextPassword=(EditText) findViewById(R.id.password);
        mButtonLogin=(Button) findViewById(R.id.login);
        mTextviewRegister=(TextView) findViewById(R.id.register);

        mTextviewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent= new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerintent);
            }
        });


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view){
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                boolean res = db.checkUser(user, pwd);



                if(res == true)
                {
                    Intent Homepage = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(Homepage);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Logging Error",Toast.LENGTH_SHORT).show();
                }



            }

        });


    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.exit);
        builder.setMessage(R.string.exitmessage);

        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.show();
    }

    }

