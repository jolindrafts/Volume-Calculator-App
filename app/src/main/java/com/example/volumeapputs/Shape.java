package com.example.volumeapputs;

public class Shape {
    // attributes
    String shapeName;
    int shapeImg;

    // constructor
    public Shape(String shapeName, int shapeImg) {
        this.shapeName = shapeName;
        this.shapeImg = shapeImg;
    }

    // setter & getter

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }
}
