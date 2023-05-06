package com.leve24.synapsee.ui;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ResizableShape extends Region {

    private Shape currentShape;
    private double originalMouseX;
    private double originalMouseY;
    private double originalWidth;
    private double originalHeight;
    private Shape shape;

    public ResizableShape(Shape shape) {
        this.shape = shape;
        this.originalMouseX = 0;
        this.originalMouseY = 0;
        this.originalWidth = shape.getBoundsInParent().getWidth();
        this.originalHeight = shape.getBoundsInParent().getHeight();
        currentShape = shape;
    }

    public double getOriginalMouseX() {
        return originalMouseX;
    }

    public double getOriginalMouseY() {
        return originalMouseY;
    }

    public void highlight() {
        shape.setStroke(Color.YELLOW);
        shape.setStrokeWidth(2);
    }

    public void unhighlight() {
        shape.setStroke(null);
    }

    public void resize(double deltaX, double deltaY) {
        double newWidth = originalWidth;
        double newHeight = originalHeight;

        if (currentShape instanceof Rectangle) {
            Rectangle rect = (Rectangle) currentShape;
            if (rect.getWidth() + deltaX > 0) {
                newWidth = rect.getWidth() + deltaX;
            }
            if (rect.getHeight() + deltaY > 0) {
                newHeight = rect.getHeight() + deltaY;
            }
            rect.setWidth(newWidth);
            rect.setHeight(newHeight);
        } else if (currentShape instanceof Circle) {
            Circle circle = (Circle) currentShape;
            double radius = circle.getRadius() + Math.max(deltaX, deltaY) / 2;
            if (radius > 0) {
                circle.setRadius(radius);
            }
        }
    }
}
