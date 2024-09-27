package com.example.volumeapputs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {
    private ArrayList<Shape> shapeArrayList;
    Context context;

    // constructor
    public MyCustomAdapter(ArrayList<Shape> shapeArrayList, Context context) {
        super(context, R.layout.grid_layout, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    // view holer : used to cache references to the views within an item layout
    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;
    }

    // getView() : used to create and return a view for a specific item in Grid.

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // jika recycler view(convertView) available, maka tinggal update data pd existing viewholder(reuse)
        // jika gaada maka inflate layout dan buat new viewholder

        // 1- Get the shape object for the current position
        Shape shapes = getItem(position);
        MyViewHolder myViewHolder;

        // 2- inflating layout
        if (convertView == null) {
            // no view went off screen -> create a new view
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.grid_layout, // reference to the layout
                    parent, // where the inflated view will be added
                    false // false : the inflated view should not be attached to the parent
            );

            // finding the views
            myViewHolder = new MyViewHolder();// initialize myViewHolder before use it
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textGrid);
            myViewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageGrid);
            convertView.setTag(myViewHolder);

        } else {
            // a view went off screen -> re-use it
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        // getting the data from the model class
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());

        // Adding click listener for imageView

        return convertView;

    }
}
