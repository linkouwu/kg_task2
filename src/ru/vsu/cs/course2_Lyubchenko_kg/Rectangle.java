package ru.vsu.cs.course2_Lyubchenko_kg;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle {
    private ArrayList<Point> point;

    public Rectangle(int x, int y, int width, int height) {
        setCoord(x, y, width, height);
    }

    public ArrayList<Point> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Point> point) {
        this.point = point;
    }

    public void setCoord(int x, int y, int width, int height) {
        point = new ArrayList<>();
        point.add(new Point(x, y));
        point.add(new Point(x + width, y));
        point.add(new Point(x + width, y + height));
        point.add(new Point(x, y + height));
    }
}
