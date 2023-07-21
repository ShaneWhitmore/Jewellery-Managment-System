package com.example.jewellerystore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageApplication extends Application
{
    public static DisplayCase firstCase;
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException  //MAIN PAGE
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("jewelleryStoreManagmentSystemMainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage = stage;// stage.getIcons().add(new Image("Image/Diamond.png"));   ##SETTING AN ICON FOR THE STAGE
        stage.setTitle("Whitmore Jewellers");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}

