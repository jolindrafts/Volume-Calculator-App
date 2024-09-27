package com.example.volumeapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cube extends AppCompatActivity implements ShapeVolume{
    TextView title, result;
    EditText editText;
    Button calculateBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        title = findViewById(R.id.cubeText);
        result = findViewById(R.id.resultCube);
        editText = findViewById(R.id.inputCube);
        calculateBtn = findViewById(R.id.CubeButton);
        backBtn = findViewById(R.id.backCube);

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
        String sideLength = editText.getText().toString();
        int s = Integer.parseInt(sideLength);
        double volume = (s*s*s);
        return volume;
    }
}