package ru.vsu.cs.course2_Lyubchenko_kg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameMain extends JFrame {
    private JPanel panel1;
    private JTextField xField;
    private JTextField yField;
    private JPanel DrawPanel;
    private JButton coordButton;
    private JTextField rotationField;
    private JButton rotationButton;
    private JTextField moveXField;
    private JTextField moveYField;
    private JButton moveButton;
    private JTextField shiftXField;
    private JTextField shiftYField;
    private JButton shiftButton;
    private JTextField scaleFIeld;
    private JButton scaleButton;

    private Rectangle rectangle = new Rectangle(350, 350, 150, 50);
    private Point center = new Point(350, 350);

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        coordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                center = new Point(x, y);
            }
        });
        rotationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(rotationField.getText());
                Transformation tr = new Transformation();
                tr.setPoint(rectangle.getPoint());
                tr.setCenter(center);
                rectangle.setPoint(tr.rotation(a * Math.PI / 180));

                DrawPanel.repaint();
            }
        });
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(moveXField.getText());
                int y = Integer.parseInt(moveYField.getText());
                Transformation tr = new Transformation();
                tr.setPoint(rectangle.getPoint());
                tr.setCenter(center);
                rectangle.setPoint(tr.move(x, y));

                DrawPanel.repaint();
            }
        });
        shiftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(shiftXField.getText());
                double y = Double.parseDouble(shiftYField.getText());
                Transformation tr = new Transformation();
                tr.setPoint(rectangle.getPoint());
                tr.setCenter(center);
                rectangle.setPoint(tr.shift(x * Math.PI / 180, y * Math.PI / 180));

                DrawPanel.repaint();
            }
        });
        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(scaleFIeld.getText());
                Transformation tr = new Transformation();
                tr.setPoint(rectangle.getPoint());
                tr.setCenter(center);
                rectangle.setPoint(tr.scale(n, n));

                DrawPanel.repaint();
            }
        });
    }

    private void createUIComponents() {
        DrawPanel = new Draw();
    }

    class Draw extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            drawCoord(g2);
            drawFigure(g2, rectangle);
        }

        public void drawCoord(Graphics2D g2) {
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawLine(350, 0, 350, 700);
            g2.drawLine(0, 350, 700, 350);
        }

        public void drawFigure(Graphics2D g2, Rectangle rec) {
            g2.setColor(Color.black);
            ArrayList<Point> point = rec.getPoint();
            g2.drawLine(point.get(0).x, point.get(0).y, point.get(1).x, point.get(1).y);
            g2.drawLine(point.get(1).x, point.get(1).y, point.get(2).x, point.get(2).y);
            g2.drawLine(point.get(2).x, point.get(2).y, point.get(3).x, point.get(3).y);
            g2.drawLine(point.get(3).x, point.get(3).y, point.get(0).x, point.get(0).y);
        }
    }
}
