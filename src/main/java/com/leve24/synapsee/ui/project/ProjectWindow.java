package com.leve24.synapsee.ui.project;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class ProjectWindow extends Scene {

    public ProjectWindow(Parent parent) {
        super(parent);
    }

    private void CreateWindow() {

        StackPane stackPane = new StackPane();
        Button button =  new Button("This is page 1");
        button.setMinWidth(100);
        stackPane.getChildren().add(button);

        System.out.println(button.getText());
    }
}
