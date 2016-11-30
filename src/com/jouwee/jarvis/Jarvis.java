package com.jouwee.jarvis;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jouwee
 */
public class Jarvis extends Application {

    /** Instance of the application */
    private static Jarvis instance;
    /** Stage */
    private Stage stage;
    
    /**
     * Run the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.stage = stage;
        setupStage();

    }

    /**
     * Sets up the stage
     */
    private void setupStage() {
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(buildRootPanel(), 450, 450);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();    
    }

    /**
     * Builds the root panel
     * 
     * @return Parent
     */
    private Parent buildRootPanel() {
        
        StackPane stackPane = new StackPane();

        stackPane.getChildren().add(new Avatar());
        
        stackPane.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0.0);"
//                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
//                + "-fx-background-insets: 50;"
        );

        return stackPane;
    }

}
