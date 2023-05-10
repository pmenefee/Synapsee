package com.leve24.synapsee.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import com.leve24.synapsee.util.Configuration;

public class MainWindow extends Application {

    ImageView imageView=new ImageView();
    ScrollPane scrollPane=new ScrollPane();
    AnchorPane anchorPaneRef=new AnchorPane ();

    private static Stage _stage;

    @Override
    public void start(Stage stage) throws Exception {

        Configuration configuration = new Configuration();
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, configuration.GetMainWindowWidth(), configuration.GetMainWindowHeight());
        SetTheme(scene);

        // TOP
        HBox hb_top = new HBox();
        hb_top.getChildren().add(MainMenu.GetMenuBar(stage));
        border.setTop(hb_top);

        // LEFT
        VBox vb_Left = new VBox();
        vb_Left.getChildren().add(ProjectsTree());
        border.setLeft(vb_Left);

        // BOTTOM

        // RIGHT

        // CENTER

        border.setCenter(ViewPort());

        _stage = stage;
        _stage.setTitle("Ketle");

        _stage.setScene(scene);
        _stage.show();
    }

    private void SetTheme(Scene scene) {
        try {
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
        }catch(NullPointerException ex)
        {
            System.out.println("Theme not found.  Using system theme.");
            // Default to normal theme.
            throw ex;
        }
    }

    private TreeView ProjectsTree(){
        TreeView tv_projects = new TreeView();
        TreeItem ti_project = new TreeItem("Project");
        tv_projects.setRoot(ti_project);

        return tv_projects;
    }

    private TabPane ViewPort(){

        TabPane tp_stage = new TabPane();
        Tab t_viewport = new Tab("ViewPort");
        ViewPortPane p_viewport = new ViewPortPane();
        p_viewport.setStyle("-fx-background-color: #FFFFFF");
        t_viewport.setContent(p_viewport);

        tp_stage.getTabs().add(t_viewport);
        return tp_stage;
    }


};