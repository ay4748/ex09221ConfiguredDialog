package com.example.ex0922_configureddialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity
{

    AlertDialog.Builder abd;

    LinearLayout ll;

    String[] colors = {"RED", "GREEN", "BLUE"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.main);
    }


    public void clickFirst(View view) {
        abd = new AlertDialog.Builder(this);
        abd.setCancelable(false);

        int[] color = {0,0,0};
        abd.setTitle("first: change one color");
        abd.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                color[which] = 255;
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

        abd.setPositiveButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }
}