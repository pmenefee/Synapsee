package com.leve24.synapsee.ui;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class ViewPortPane extends Pane {

    private double startX;
    private double startY;


    public ViewPortPane(){

        /*
        Circle circle = new Circle(25,25,25,Color.BLUE);
        Rectangle rectangle = new Rectangle(150,30,Color.RED);

        circle.setTranslateX(50);
        circle.setTranslateY(50);

        rectangle.setTranslateX(150);
        rectangle.setTranslateY(50);


        MakeDraggable(rectangle);
        getChildren().add(circle);
        getChildren().add((rectangle));


         */
        NeuralNode neuralNode = new NeuralNode();
        getChildren().addAll(MakeDraggable(neuralNode.GetNode()));

    }
    private Node MakeDraggable (Node node) {
        double x = node.getTranslateX();
        double y = node.getTranslateY();

        startX = node.getTranslateX();
        startY = node.getTranslateY();

        node.setOnMousePressed(e -> {
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();
        });

        node.setOnMouseDragged(e -> {
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });
        return node;
    }
}
