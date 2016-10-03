package com.example.cohen.guessgame;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends ActionBarActivity {

    int rnd;
    int guessCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rnd=createRandom();
    }



    public void GuessNumber (View view){


        EditText edtx=(EditText) findViewById(R.id.editText2);
        if (edtx.getText().toString().matches("")){
            Toast toast=Toast.makeText(this, "לא הכנסת מספר", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

            return;
        }else {

            guessCount=guessCount+1;
            int i = Integer.parseInt(edtx.getText().toString());
            String guess;
            if (i == rnd) {
                guess = "ניחשת נכון תוך "+guessCount+" ניחושים!";
                guessCount=0;
            } else if (i > rnd) {
                guess = "גדול מידי";

            } else guess = "קטן מידי";

            displayResult(guess);
            edtx.setText("");

        }


    }

    public void displayResult (String message) {
        TextView txt=(TextView) findViewById(R.id.textView2);
        txt.setText(message);

    }

    private int createRandom(){
        Random rnd=new Random();
        int i=rnd.nextInt(100);
        return i;
    }

    public void genRandom(View view){
        rnd=createRandom();




    }


}
