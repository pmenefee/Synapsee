package com.leve24.synapsee.ui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Collection;

public class ViewPortPane extends Pane {



    public ViewPortPane(){

        NeuralNode neuralNode = new NeuralNode();
        getChildren().addAll(neuralNode.GetNode());

    }
}
