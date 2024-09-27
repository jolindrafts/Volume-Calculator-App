package com.example.volumeapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Sphere extends AppCompatActivity implements ShapeVolume{
    TextView title,result;
    EditText editText;
    Button calculateBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        title = findViewById(R.id.sphereText);
        result = findViewById(R.id.resultSphere);
        editText = findViewById(R.id.inputSphere);
        calculateBtn = findViewById(R.id.sphereButton);
        backBtn = findViewById(R.id.backSphere);

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


    public double calculateVolume() {
        String radius = editText.getText().toString();
        int r = Integer.parseInt(radius);
        double volume = (4/3) * 3.14159 * r*r*r;
        return volume;
    }

}