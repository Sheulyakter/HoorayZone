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
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {
    ViewFlipper v_flipper;
    Button cprofile, watchlist, feedback,availabe,special,previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        int images[] = {R.drawable.banner, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5, R.drawable.banner6};

        v_flipper = (ViewFlipper) findViewById(R.id.v_flipper);
        // for(int i=0 ; i<images.length; i++)
        //{
        //  flipperImages(images[i]);
        //  }
        for(int image: images)
        {
            flipperImages(image);
        }

        cprofile = (Button)findViewById(R.id.customerButton);
       availabe = (Button)findViewById(R.id.availabletrips);
        special = (Button)findViewById(R.id.specialoffer);
        previous = (Button)findViewById(R.id.previoustrips);
        watchlist = (Button)findViewById(R.id.watchlist);
        feedback = (Button)findViewById(R.id.feedback);


       cprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(loginintent);
            }
        });

        availabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(HomeActivity.this,AvailableTripsActivity.class);
                startActivity(loginintent);
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(HomeActivity.this,SpecialActivity.class);
                startActivity(loginintent);
            }
        });
       previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(HomeActivity.this,PreviousTripsActivity.class);
                startActivity(loginintent);
            }
        });

       watchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(HomeActivity.this,WatchlistActivity.class);
                startActivity(loginintent);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(HomeActivity.this,FeedBackActivity.class);
                startActivity(loginintent);
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bar,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id==R.id.homeId)
        {
            Intent intenthome = new Intent(HomeActivity.this,HomeActivity.class);
            startActivity(intenthome);
            return  true;
        }
        if(id==R.id.helpId)
        {
            Intent intenthelp = new Intent(HomeActivity.this,AboutActivity.class);
            startActivity(intenthelp);
            return true;
        }
        if(id==R.id.creditId)
        {
            Intent intentcredit = new Intent(HomeActivity.this,DeveloperActivity.class);
            startActivity(intentcredit);
            return  true;
        }
        if(id==R.id.exitId)
        {
            final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setMessage("Are you sure you want to exit?");
            builder.setTitle("EXIT");

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();

                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });
            AlertDialog alertdialog = builder.create();
            alertdialog.show();
        }

        return super.onOptionsItemSelected(item);
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



    public  void  flipperImages (int image)
    {
        ImageView imageView  = new ImageView( this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);

        v_flipper.setFlipInterval(2000); //2 seconds

        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

}


