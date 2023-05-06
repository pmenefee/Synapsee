package com.leve24.synapsee.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
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
        // TOP
        HBox hb_top = new HBox();
        hb_top.getChildren().add(MainMenu());
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
        Scene scene = new Scene(border, configuration.GetMainWindowWidth(), configuration.GetMainWindowHeight());
        SetTheme(scene);
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

    /**
     * @return MenuBar
     */
    private MenuBar MainMenu(){
        Menu m_root = SetLabel("File");

        // Add New
        Menu m_New = SetLabel("New");

        // Project...
        MenuItem mi_NewProject= new MenuItem("Project...");
        mi_NewProject.setAccelerator(KeyCombination.keyCombination("shortcut+P"));
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("Clicked");
            }
        };
        mi_NewProject.setOnAction(event);
        m_New.getItems().add(mi_NewProject);

        m_root.getItems().add(m_New);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(m_root);
        return menuBar;
    }

    private TreeView ProjectsTree(){
        TreeView tv_projects = new TreeView();
        TreeItem ti_project = new TreeItem("Project");
        tv_projects.setRoot(ti_project);

        return tv_projects;
    }

    private TabPane ViewPort(){

        TabPane tp_stage = new TabPane();
        tp_stage.setPrefWidth(500);
        tp_stage.setMinHeight(500);
        Tab t_viewport = new Tab("Stage");
        ViewPortPane p_viewport = new ViewPortPane();
        p_viewport.setStyle("-fx-background-color: #FFFFFF");
        t_viewport.setContent(p_viewport);

        tp_stage.getTabs().add(t_viewport);
        return tp_stage;
    }

    /// Sets the text for the menu.
    /// This allows the text color to be managed by css.
    private Menu SetLabel(String s){
        Menu m = new Menu();
        Label l = new Label(s);
        l.setId("label");
        m.setGraphic(l);
        return m;
    }
};