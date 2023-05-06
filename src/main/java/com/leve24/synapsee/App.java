package com.leve24.synapsee;

import com.leve24.synapsee.ui.MainWindow;
import com.leve24.synapsee.util.Configuration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    Stage s_MainWindow = new Stage();
    @Override
    public void start(Stage stage)  {
        try {
            s_MainWindow = stage;
            //stage.initStyle(StageStyle.UNDECORATED); Removes the title bar also can't drag the window.
            MainWindow mainWindow = new MainWindow();
            Configuration configuration = new Configuration();
            stage.setWidth(configuration.GetMainWindowWidth());
            stage.setHeight(configuration.GetMainWindowHeight());
            mainWindow.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop(){
        Configuration configuration = new Configuration();
        configuration.SetMainWindowWidth(s_MainWindow.getWidth());
        configuration.SetMainWindowHeight(s_MainWindow.getHeight());
    }

    public static void main(String[] args) {
        launch();
    }
}