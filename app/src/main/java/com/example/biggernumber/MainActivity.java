package com.example.biggernumber;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int ScoreCounter;

    int R1;
    int R2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RandomGenerator();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void RandomGenerator(){

        Random Rand = new Random();

        R1 = Rand.nextInt(100) +1;
        R2 = Rand.nextInt(100) +1;

        Button Left = (Button) findViewById(R.id.Btn_1);
        Left.setText(Integer.toString(R1));
        Button Right = (Button) findViewById(R.id.Btn_2);
        Right.setText(Integer.toString(R2));

    }

    public void on_button_Click1(View view) {

        TextView Score = (TextView) findViewById(R.id.TxtScore);

        if (R1 > R2) {
            ScoreCounter++;
            Score.setText("Score: "+ ScoreCounter);
            Toast.makeText(getApplicationContext(), "Congratulations", Toast.LENGTH_SHORT).show();
            RandomGenerator();
        }else{
            Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
            ScoreCounter--;
            Score.setText("Score: "+ ScoreCounter);
        }

    }

    public void on_button_Click2(View view) {

       TextView Score = (TextView) findViewById(R.id.TxtScore);

        if (R2 > R1) {

            Toast.makeText(getApplicationContext(), "Congratulations", Toast.LENGTH_SHORT).show();
            ScoreCounter++;
            Score.setText("Score: "+ ScoreCounter);
            RandomGenerator();
        }else{
            Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
            ScoreCounter--;
            Score.setText("Score: "+ ScoreCounter);
        }

    }
}
