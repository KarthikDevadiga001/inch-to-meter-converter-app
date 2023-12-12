package com.projects.inchconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textinput;
    private TextView textoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setuponclick_listener();


    }

    private void setuponclick_listener() {
        Button button = findview();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputvalue = textinput.getText().toString();

                if (inputvalue.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Please Enter a value", Toast.LENGTH_SHORT).show();

                } else {
                    double result = calcleninm();
                    displayresult(result);
                }


            }
        });

    }
    private Button findview() {
        textinput = findViewById(R.id.inchtext);
        Button mybutton = findViewById(R.id.convertbutton);
        textoutput = findViewById(R.id.textview);
        return mybutton;
    }


    private double calcleninm() {
        String inches = textinput.getText().toString();
        return (Integer.parseInt(inches) * 2.54) / 100;
    }

    private void displayresult(double result) {
        String resulttext = result + " meters";
        textoutput.setText(resulttext);
    }




}