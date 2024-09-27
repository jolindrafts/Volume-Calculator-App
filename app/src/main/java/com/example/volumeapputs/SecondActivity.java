package com.example.volumeapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    // 1- Adapter view
    GridView gridView;

    // 2- Data source
    ArrayList<Shape> shapeArrayList;

    // 3- Custom Adapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textTitle2);
        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();
        Shape shape1 = new Shape("Sphere", R.drawable.sphere);
        Shape shape2 = new Shape("Cube", R.drawable.cube);
        Shape shape3 = new Shape("Pyramid", R.drawable.pyramid);

        shapeArrayList.add(shape1);
        shapeArrayList.add(shape2);
        shapeArrayList.add(shape3);

        adapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());

        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Tindakan yang diambil saat item grid diklik
                Intent intent = null;
                Shape clickedShape = shapeArrayList.get(position);
                if(clickedShape != null){
                    switch (clickedShape.getShapeName()) {
                        case "Sphere":
                            intent = new Intent(getApplicationContext(), Sphere.class);
                            break;
                        case "Cube":
                            intent = new Intent(getApplicationContext(), Cube.class);
                            break;
                        case "Pyramid":
                            intent = new Intent(getApplicationContext()  , Pyramid.class);
                            break;
                    }
                    if (intent != null) {
                        startActivity(intent);
                    }
                }
            }
        });
    }
}