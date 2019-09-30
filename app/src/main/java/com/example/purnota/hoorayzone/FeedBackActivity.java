package com.example.purnota.hoorayzone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedBackActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

       final EditText subject = (EditText) findViewById(R.id.subject);
       final EditText msg = (EditText) findViewById(R.id.msg);

       Button submit = (Button) findViewById(R.id.submit);

       submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String subS=subject.getText().toString();
                String msgS=msg.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                String[] strings = {"nusrata315@gmail.com"};
                email.putExtra(Intent.EXTRA_EMAIL, strings);

                email.putExtra(Intent.EXTRA_SUBJECT,subS);
                email.putExtra(Intent.EXTRA_TEXT,msgS);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "send email"));


            }
        });


    }
}
