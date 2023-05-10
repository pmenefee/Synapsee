package com.leve24.synapsee.ui;

import com.leve24.synapsee.ui.project.ProjectWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MainMenu extends Control {

    static Stage stage = null;

    public static MenuBar GetMenuBar(Stage parent){

        stage = parent;

        Menu m_root = SetLabel("File");

        // Add New
        Menu m_New = SetLabel("New");

        // Project...
        MenuItem mi_NewProject= new MenuItem("Project...");
        mi_NewProject.setAccelerator(KeyCombination.keyCombination("shortcut+P"));

        mi_NewProject.setOnAction(event -> showScene(new ProjectWindow(parent.getScene().getRoot())));

        m_New.getItems().add(mi_NewProject);

        m_root.getItems().add(m_New);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(m_root);

        return menuBar;
    }

    private static void showScene(Scene scene) {
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    /// Sets the text for the menu.
    /// This allows the text color to be managed by css.
    private static Menu SetLabel(String s){
        Menu m = new Menu();
        Label l = new Label(s);
        l.setId("label");
        m.setGraphic(l);
        return m;
    }
}
