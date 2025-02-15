package com.example.ex0922_configureddialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AlertDialog;

/**
 * MainActivity class that demonstrates the use of AlertDialogs for user interaction.
 * The activity includes dialogs for changing background colors, accepting text input, and displaying messages.
 */
public class MainActivity extends AppCompatActivity
{
    /** AlertDialog.Builder instance used for constructing dialogs. */
    AlertDialog.Builder abd;

    /** LinearLayout used as the main container whose background color changes based on user selection. */
    LinearLayout ll;

    /** Array of color names for selection dialogs. */
    String[] colors = {"RED", "GREEN", "BLUE"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.main);
    }

    /**
     * Handles the click event for the first button, allowing the user to select one color.
     *
     * @param view the clicked view.
     */
    public void clickFirst(View view)
    {
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

    /**
     * Handles the click event for the second button, allowing the user to select multiple colors.
     *
     * @param view the clicked view.
     */
    public void secondbtn(View view)
    {
        abd = new AlertDialog.Builder(this);
        abd.setCancelable(false);

        int[] color = {0, 0, 0};

        abd.setTitle("change multiple colors");
        abd.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked)
            {
                if(isChecked) {
                    color[which] = 255;
                }
                else if (color[which] == 255) {
                    color[which] = 0;
                }
            }
        });

        abd.setPositiveButton("exit", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                dialog.cancel();
            }
        });

        abd.setNeutralButton("ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                ll.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }

    /**
     * Resets the background color to white when the third button is clicked.
     *
     * @param view the clicked view.
     */
    public void thirdbtn(View view) {
        ll.setBackgroundColor(Color.WHITE);
    }

    /**
     * Displays an AlertDialog with an EditText field, allowing the user to enter text.
     * The entered text is then shown as a Toast message.
     *
     * @param view the clicked view.
     */
    public void lastclick(View view) {
        abd = new AlertDialog.Builder(this);
        abd.setCancelable(false);

        abd.setTitle("text to toast");

        EditText abdEt = new EditText(this);
        abdEt.setHint("write pls");
        abd.setView(abdEt);

        abd.setPositiveButton("Exit", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        abd.setNegativeButton("finish", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String text = abdEt.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog ad = abd.create();
        ad.show();
    }

    /**
     * Inflates the menu options in the action bar.
     *
     * @param menu the menu to be inflated.
     * @return true if the menu is created successfully.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles menu item selections.
     *
     * @param item the selected menu item.
     * @return true if the menu item is handled successfully.
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menuCred) {
            Intent si = new Intent(this, CreditsActicity.class);
            startActivity(si);
        }

        return true;
    }
}
