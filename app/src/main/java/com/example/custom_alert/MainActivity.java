package com.example.custom_alert;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mes;
    AlertDialog.Builder dmes;
    Button img;
    AlertDialog.Builder dimg;
    Button war;
    AlertDialog.Builder dwar;
    Button cho;
    AlertDialog.Builder dcho;
    Button col;
    AlertDialog.Builder dcol;


    public void merraige(){
        mes = (Button) findViewById(R.id.mess);
        img = (Button) findViewById(R.id.img);
        war = (Button) findViewById(R.id.war);
        cho = (Button) findViewById(R.id.cho);
        col = (Button) findViewById(R.id.col);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        merraige();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String temp = item.getTitle().toString();
        if (temp.equals("Credints")) {
            Intent shaw = new Intent(this, MyActivityName.class);
            startActivity(shaw);
        }

        return super.onOptionsItemSelected(item);
    }


    public int random_color(){
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        return Color.rgb(r, g, b);
    }


    public void messege(View view) {
        dmes = new AlertDialog.Builder(this);
        dmes.setTitle("Messege");
        dmes.setMessage("this is a messege");

        dmes.show();
    }


    public void img(View view) {
        dimg = new AlertDialog.Builder(this);
        dimg.setTitle("Image");
        dimg.setMessage("this is an image");
        dimg.setIcon(R.drawable.img);

        dimg.show();
    }


    public void warning(View view) {
        dwar = new AlertDialog.Builder(this);
        dwar.setTitle("Warning");
        dwar.setMessage("this is a warning");
        dwar.setIcon(R.drawable.img);

        dwar.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });



        dwar.show();
    }

    public void choice(View view) {
        dcho = new AlertDialog.Builder(this);
        dcho.setTitle("Choice");
        dcho.setMessage("this is a choice");
        dcho.setPositiveButton("set color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getWindow().getDecorView().setBackgroundColor(random_color());
            }
        });

        dcho.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        dcho.show();
    }


    public void color(View view) {
        dcol = new AlertDialog.Builder(this);
        dcol.setTitle("Color");
        dcol.setMessage("this is a color");
        dcol.setPositiveButton("set color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getWindow().getDecorView().setBackgroundColor(random_color());
            }
        });

        dcol.setNeutralButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            }
        });


        dcol.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        dcol.show();
    }
}
