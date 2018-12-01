package com.example.yair.configdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    LinearLayout lL;

    AlertDialog.Builder adb;
    final String [] colors = {"Red" , "Green" , "Blue"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        lL = (LinearLayout)findViewById(R.id.LL);

    }

    public void yair1 (View view) {

        final int [] color = {0,0,0};

        adb = new AlertDialog.Builder(this);


        adb = new AlertDialog.Builder(this);
        adb.setTitle("List of colors - one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                color[which] = 255;
                lL.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog ad = adb.create();
        ad.show();

    }

    public void  yair2 (View view) {

        Random rnd = new Random();

        final int R = rnd.nextInt() * 256;
        final int G = rnd.nextInt() * 256;
        final int B = rnd.nextInt() * 256;

        adb = new AlertDialog.Builder(this);
        adb.setTitle("Combine us ;)");
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lL.setBackgroundColor(Color.rgb(R, G, B));
            }
        });

        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }
    public void yair3 (View view) {
        adb = new AlertDialog.Builder(this);
        adb.setMessage("Click'reset' to white background");
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lL.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int nextActivity = item.getItemId();
        if (nextActivity == R.id.NextActivity) {
            Intent go = new Intent(this, Main2Activity.class);
            startActivity(go);
        }


        return true;


    }



    }

