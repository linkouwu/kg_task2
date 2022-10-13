package ru.vsu.cs.course2_Lyubchenko_kg;

import java.awt.*;
import java.util.ArrayList;

public class Transformation {
    private static ArrayList<Point> point;
    private static Point center;

    public Transformation() {
    }

    public ArrayList<Point> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Point> point) {
        this.point = point;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public static ArrayList<Point> rotation(double a) {
        return multiply(new double[][]{
                {Math.cos(a), Math.sin(a), 0},
                {-Math.sin(a), Math.cos(a), 0},
                {0, 0, 1}
        });
    }

    public static ArrayList<Point> shift(double a, double b) {
        return multiply(new double[][]{
                {1, Math.tan(a), 0},
                {Math.tan(b), 1, 0},
                {0, 0, 1}
        });
    }

    public static ArrayList<Point> move(int x, int y) {
        return multiply(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {x, y, 1}
        });
    }

    public static ArrayList<Point> scale(int x, int y) {
        return multiply(new double[][]{
                {x, 0, 0},
                {0, y, 0},
                {0, 0, 1}
        });
    }

    public static ArrayList<Point> multiply(double matrix[][]) {
        ArrayList<Point> newPoint = new ArrayList<>();

        for (int i = 0; i < point.size(); i++) {
            int[] arr = new int[3];
            for (int j = 0; j < matrix.length; j++) {
                arr[j] = (int) Math.round((point.get(i).x - center.x) * matrix[0][j] + (point.get(i).y - center.y) * matrix[1][j] + matrix[2][j]);
            }
            newPoint.add(new Point(arr[0] + center.x, arr[1] + center.y));
        }

        return newPoint;
    }
}
