package com.example.luckynumber;

public class GridShape {
    int shapeImage;
    String shapeName;

    public GridShape(int shapeImage, String shapeName) {
        this.shapeImage = shapeImage;
        this.shapeName = shapeName;
    }

    public int getShapeImage() {
        return shapeImage;
    }

    public void setShapeImage(int shapeImage) {
        this.shapeImage = shapeImage;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}
