package com.example.volumeapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pyramid extends AppCompatActivity implements ShapeVolume{
    TextView title, result;
    EditText editText1, editText2;
    Button calculateBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyramid);

        title = findViewById(R.id.pyramidText);
        result = findViewById(R.id.resultPyramid);
        editText1 = findViewById(R.id.input1Pyramid);
        editText2 = findViewById(R.id.input2Pyramid);
        calculateBtn = findViewById(R.id.PyramidButton);
        backBtn = findViewById(R.id.backPyramid);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double volume = calculateVolume();
                result.setText("V = " + volume + " m^3");
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);
            }
        });
    }

    public double calculateVolume(){
        String height = editText1.getText().toString();
        String baseArea = editText2.getText().toString();
        int h = Integer.parseInt(height);
        int a = Integer.parseInt(baseArea);
        double volume = (1.0/3.0) * h * a;
        return volume;
    }
}