package com.leve24.synapsee.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.List;

public class NeuralNode extends Region {

    static Logger logger = Logger.getLogger(NeuralNode.class.getName());

    private Rectangle currentShape;
    private double originalMouseX;
    private double originalMouseY;
    private double originalWidth;
    private double originalHeight;

    public NeuralNode(){
        Rectangle rect = new Rectangle(50, 50, 100, 100);
        rect.setFill(Color.GRAY);
        rect.setOnMouseClicked(event -> setCurrentShape(new ResizableShape(rect)));

        this.originalMouseX = 0;
        this.originalMouseY = 0;
        this.originalWidth = getBoundsInParent().getWidth();
        this.originalHeight = getBoundsInParent().getHeight();

        rect.setOnDragDetected(event -> {
            Dragboard db = currentShape.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("Node source text");
            db.setContent(content);
            logger.log(Level.INFO, db.toString());
        });

        rect.setOnMouseDragged(event -> {
            if (currentShape != null) {
                double deltaX = event.getX() - getOriginalMouseX();
                double deltaY = event.getY() - getOriginalMouseY();
                currentShape.resize(deltaX, deltaY);
                logger.log(Level.INFO, "Clicked");
            }
        });

        currentShape = rect;


    }

    public Rectangle GetNode(){
        return currentShape;
    }

    private void setCurrentShape(ResizableShape resizableShape) {

        if (currentShape != null) {
            unhighlight();
        }

        highlight();
    }

    private void unhighlight() {
        currentShape.setStroke(null);
    }

    public void highlight() {
        currentShape.setStroke(Color.BLACK);
        currentShape.setStrokeWidth(2);
    }

    public double getOriginalMouseX() {
        return originalMouseX;
    }

    public double getOriginalMouseY() {
        return originalMouseY;
    }

}
